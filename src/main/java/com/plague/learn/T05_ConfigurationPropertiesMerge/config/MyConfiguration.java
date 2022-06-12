package com.plague.learn.T05_ConfigurationPropertiesMerge.config;


import com.plague.learn.infrastructure.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "myconf" )
@PropertySource(value = {"classpath:myConf.yml","classpath:myConf2.yml","classpath:config/myConf3.yml"},factory = YamlPropertySourceFactory.class)
public class MyConfiguration {

    private Map<String,Object> confmap;

    public Map<String, Object> getConfmap() {
        return confmap;
    }

    public void setConfmap(Map<String, Object> confmap) {
        if (this.confmap == null) {
            this.confmap = confmap;
        } else {
            this.confmap.putAll(confmap);
        }
    }
}
