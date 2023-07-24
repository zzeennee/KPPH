package com.kpph.api.practice;

import com.kpph.api.entity.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PracticeController {
    @GetMapping("/get")
    public String test () {

        return "hello, World!";
    }

    @Autowired
    private PracticeRepository practiceRepository;

    @GetMapping("/test2")
    public Optional<Test2> test2 () {

        return practiceRepository.findById(1);
    }
}
