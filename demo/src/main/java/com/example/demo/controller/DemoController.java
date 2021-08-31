package com.example.demo.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {


    @GetMapping(value = "/test")
    public String test(@RequestParam String param1) {
        return "test " + param1;
    }

    @PostMapping(value = "/test")
    public Body testPost(@RequestParam String x, @RequestParam String y, @RequestBody Body body) {
        body.setX(x);
        body.setY(y);
        return body;
    }

    @DeleteMapping(value = "/test")
    public String delete(@RequestParam String param1) {
        return "test " + param1;
    }


    @Data
    public static class Body {
        private String x;
        private String y;

    }

}
