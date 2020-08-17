package com.pm.model.serializer;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 图片浏览多个前缀序列化
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/10/25 12:05
 */
@Slf4j
public class MultiUrlPrefixSerialize extends JsonSerializer<String> {

    @Value("${aliyun-oss.domain-url}")
    private String domainUrl;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (StrUtil.isNotEmpty(value)) {
            List<String> prefixUrls = StrUtil.splitTrim(value, ',');
            List<String> filterUrls = CollUtil.newArrayList();
            for(String str : prefixUrls) {
                if (!str.startsWith("http")) {
                    str = domainUrl + str;
                }
                filterUrls.add(str);
            }
            String result = CollUtil.join(filterUrls, ",");
            gen.writeString(result);
            return;
        }
        gen.writeString(value);
    }
}
