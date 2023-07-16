package com.kpph.api.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
    @GetMapping("/get")
    public String test () {

        return "hello, World!";
    }
}
