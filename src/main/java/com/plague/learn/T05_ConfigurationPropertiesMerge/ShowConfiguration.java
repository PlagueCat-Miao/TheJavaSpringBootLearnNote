package com.plague.learn.T05_ConfigurationPropertiesMerge;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.plague.learn.T05_ConfigurationPropertiesMerge.config.MyConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class ShowConfiguration {

    @Resource
    private MyConfiguration myConfiguration;

    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    @RequestMapping("/ShowConf")
    public String ShowConf() {
        Map ans =  myConfiguration.getConfmap();
        return gson.toJson(ans);
    }




}
