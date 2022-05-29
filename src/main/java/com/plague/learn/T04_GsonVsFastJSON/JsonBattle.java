package com.plague.learn.T04_GsonVsFastJSON;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class JsonBattle {
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    private static LinkedHashMap<String,Object> hashMap01 = new LinkedHashMap<String,Object>(){
        {
            put("A","0");
            put("B","1");
            put("C","2");
            put("D","3");
            put("E","4");
        }
    };

    List<String> testList = Arrays.asList("aaaa","bbbb","cccc","dddd");


    @RequestMapping("/GoGson")
    public String goGson() {
        LinkedHashMap<String,String> ans  = new LinkedHashMap<>();
        ans.put("test0",gson.toJson(hashMap01));
        ans.put("test1",gson.toJson(getHashMap()));
        ans.put("test2",gson.toJson(testList));
        return gson.toJson(ans);
    }


    @RequestMapping("/GoFastJson")
    public String goFastJSON() {
        LinkedHashMap<String,String> ans = new LinkedHashMap<>();
        ans.put("test0",JSON.toJSONString(hashMap01));
        ans.put("test1",JSON.toJSONString(getHashMap()));
        ans.put("test2",JSON.toJSONString(testList));
        return JSON.toJSONString(ans);
    }

    private  LinkedHashMap<String,String> getHashMap(){
        LinkedHashMap<String,String> hashMap02  = new LinkedHashMap<>();
        hashMap02.put("miao","A");
        hashMap02.put("p_l_a_g_u_e","B");
        hashMap02.put("Cat","C");
        hashMap02.put("NYA","D");
        hashMap02.put("p_l_a_g_u_e","b");
        return hashMap02;
    }

}
