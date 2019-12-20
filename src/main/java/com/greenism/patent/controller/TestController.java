package com.greenism.patent.controller;

import com.greenism.patent.constant.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public Map<String,Object> test(){
        Map<String,Object> map = new HashMap<>();
        map.put(Constants.ERROR, "错误");
        return map;
    }

    @GetMapping("/jhj")
    public Map<String,Object> jhj(){
        Map<String,Object> map = new HashMap<>();
        map.put(Constants.SUCCESS, "成功");
        return map;
    }

}
