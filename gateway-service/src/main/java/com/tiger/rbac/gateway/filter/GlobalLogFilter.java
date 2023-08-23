package com.tiger.rbac.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;


/**
 * @Author Zenghu
 * @Date 2023年08月17日 20:32
 * @Description
 * @Version: 1.0
 **/
@Component
@Slf4j
public class GlobalLogFilter implements GlobalFilter, Ordered {
    private static final String START_TIME = "startTime";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final ServerHttpRequest request = exchange.getRequest();
        String path = getOriginalRequestUrl(exchange);
        String url = request.getMethod().name() + " " + path;
        String header = request.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE);
        boolean flag = StringUtils.startsWithIgnoreCase(header, MediaType.APPLICATION_JSON_VALUE);
        if (flag) {
            // 从缓存中读取body
            Object obj = exchange.getAttributes().get(ServerWebExchangeUtils.CACHED_REQUEST_BODY_ATTR);
            String jsonParam = null;
            if (!ObjectUtils.isEmpty(obj)) {
                DataBuffer buffer = (DataBuffer) obj;
                CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
                jsonParam = charBuffer.toString();
            }
            log.debug("开始请求 => URL[{}],参数类型[json],参数:[{}]", url, jsonParam);
        } else {
            MultiValueMap<String, String> parameterMap = request.getQueryParams();
            if (!ObjectUtils.isEmpty(parameterMap)) {
                log.debug("开始请求 => URL[{}],参数类型[param],参数:[{}]", url, parameterMap);
            } else {
                log.debug("[开始请求 => URL[{}],无参数", url);
            }
        }
        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(START_TIME);
            if (startTime != null) {
                long executeTime = (System.currentTimeMillis() - startTime);
                log.debug("结束请求 => URL[{}],耗时:[{}]毫秒", url, executeTime);
            }
        }));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }


    /**
     * 获取原始请求路径
     */
    public static String getOriginalRequestUrl(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        LinkedHashSet<URI> uris = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        URI requestUri = uris.stream().findFirst().orElse(request.getURI());
        return UriComponentsBuilder.fromPath(requestUri.getRawPath()).build().toUriString();
    }
}
