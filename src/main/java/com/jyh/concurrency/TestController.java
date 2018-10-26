package com.jyh.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JYH
 * 2018/10/26 19:20
 */
@RestController
@Slf4j
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
