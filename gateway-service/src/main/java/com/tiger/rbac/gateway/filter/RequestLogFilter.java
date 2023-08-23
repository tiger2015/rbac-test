package com.tiger.rbac.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Zenghu
 * @Date 2023年08月02日 22:38
 * @Description
 * @Version: 1.0
 **/
@Slf4j
//@Component
public class RequestLogFilter implements GlobalFilter, Ordered {


    private final List<HttpMessageReader<?>> messageReaders = HandlerStrategies.withDefaults().messageReaders();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        long startTime = System.currentTimeMillis();
        ServerHttpRequest request = exchange.getRequest();
        String requestPath = request.getPath().pathWithinApplication().value();

        MediaType mediaType = request.getHeaders().getContentType();
        // 请求类型为application/x-www-form-urlencoded或者application/json
        if (mediaType != null && (MediaType.APPLICATION_FORM_URLENCODED.isCompatibleWith(mediaType) || MediaType.APPLICATION_JSON.isCompatibleWith(mediaType))) {
            return writeBodyLog(exchange, chain);
        } else {
            return writeBasicLog(exchange, chain);
        }
    }

    @Override
    public int getOrder() {
        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER - 20;
    }


    private Mono<Void> writeBasicLog(ServerWebExchange exchange, GatewayFilterChain chain) {
        StringBuilder builder = new StringBuilder();
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        for (Map.Entry<String, List<String>> entry : queryParams.entrySet()) {
            builder.append(entry.getKey()).append("=").append(StringUtils.join(entry.getValue(), ","));
        }
        //获取响应体
        ServerHttpResponseDecorator decoratedResponse = recordResponseLog(exchange);
        return chain.filter(exchange.mutate().response(decoratedResponse).build())
                .then(Mono.fromRunnable(() -> {
                    // 打印日志
                }));
    }


    private Mono<Void> writeBodyLog(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerRequest serverRequest = ServerRequest.create(exchange, messageReaders);
        // 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.putAll(exchange.getRequest().getHeaders());
        CachedBodyOutputMessage outputMessage = new CachedBodyOutputMessage(exchange, headers);
        return Mono.defer(() -> {
            ServerHttpRequest decoratedRequest = requestDecorate(exchange, headers, outputMessage);
            ServerHttpResponseDecorator responseDecorator = recordResponseLog(exchange);
            return chain.filter(exchange.mutate().request(decoratedRequest).response(responseDecorator).build())
                    .then(Mono.fromRunnable(() -> {
                        // 打印日志

                    }));
        });
    }


    private ServerHttpRequestDecorator requestDecorate(ServerWebExchange exchange, HttpHeaders headers, CachedBodyOutputMessage outputMessage) {
        return new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public HttpHeaders getHeaders() {
                long contentLength = headers.getContentLength();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.putAll(super.getHeaders());
                if (contentLength > 0) {
                    httpHeaders.setContentLength(contentLength);
                } else {
                    // TODO: this causes a 'HTTP/1.1 411 Length Required' // on
                    // httpbin.org
                    httpHeaders.set(HttpHeaders.TRANSFER_ENCODING, "chunked");
                }
                return httpHeaders;
            }

            @Override
            public Flux<DataBuffer> getBody() {
                return outputMessage.getBody();
            }
        };
    }


    private ServerHttpResponseDecorator recordResponseLog(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        DataBufferFactory bufferFactory = response.bufferFactory();
        return new ServerHttpResponseDecorator(response) {

            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    // 响应类型
                    String originalResponseType = exchange.getAttribute(ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR);
                    // 响应数据为json格式
                    if (Objects.equals(this.getStatusCode(), HttpStatus.OK)
                            && StringUtils.isNotBlank(originalResponseType)
                            && originalResponseType.contains("application/json")) {
                        Flux<? extends DataBuffer> fluxBody = Flux.from(body);
                        return super.writeWith(fluxBody.buffer().map(dataBuffers -> {
                            DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                            DataBuffer join = dataBufferFactory.join(dataBuffers);
                            // 返回的内容
                            byte[] content = new byte[join.readableByteCount()];
                            join.read(content);
                            // 释放掉内存
                            DataBufferUtils.release(join);
                            return bufferFactory.wrap(content);
                        }));
                    }
                }
                return super.writeWith(body);
            }
        };
    }
}
