package com.tiger.rbac.config;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @Author Zenghu
 * @Date 2023年11月06日 21:26
 * @Description
 * @Version: 1.0
 **/
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    public JSONWriter.Feature[] features = new JSONWriter.Feature[]{
            JSONWriter.Feature.WriteClassName,
            JSONWriter.Feature.FieldBased,
            JSONWriter.Feature.ReferenceDetection,
            JSONWriter.Feature.NotWriteDefaultValue,
            JSONWriter.Feature.WriteNameAsSymbol,
            JSONWriter.Feature.WriteEnumsUsingName
    };
    private static final Filter autoTypeFilter;
    private Class<T> clazz;

    static {
        autoTypeFilter = JSONReader.autoTypeFilter(
                // 按需加上需要支持自动类型的类名前缀，范围越小越安全
                "com.tiger.rbac.",
                "org.springframework.security.authentication."
        );
    }

    public FastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null)
            return new byte[0];
        return JSON.toJSONBytes(t, features);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) return null;
        return (T) JSON.parseObject(bytes, clazz, autoTypeFilter, JSONReader.Feature.UseDefaultConstructorAsPossible,
                JSONReader.Feature.UseNativeObject,
                JSONReader.Feature.FieldBased);
    }
}
