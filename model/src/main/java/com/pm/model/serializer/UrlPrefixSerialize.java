package com.pm.model.serializer;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

/**
 * <p>
 * 图片浏览前缀序列化
 * </p>
 *
 * @author yejx
 * @date 2018/10/25 12:05
 */
@Slf4j
public class UrlPrefixSerialize extends JsonSerializer<String> {

    @Value("${aliyun-oss.domain-url}")
    private String domainUrl;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (StrUtil.isNotEmpty(value)) {
            String startPrefix = "http";
            if (!StrUtil.startWithIgnoreCase(value, startPrefix)) {
                gen.writeString(domainUrl + value);
                return;
            }
        }
        gen.writeString(value);
    }
}
