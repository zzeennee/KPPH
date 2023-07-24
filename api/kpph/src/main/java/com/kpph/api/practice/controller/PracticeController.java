package com.kpph.api.practice.controller;

import com.kpph.api.practice.service.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PracticeController {

    private final PracticeService practiceService;

    @GetMapping("/helloWorld")
    public String test () {
        return "hello, World!";
    }

    @PostMapping("/insert")
    public void insert() {

    }

    @GetMapping("/selectOne/{}")
    public void selectOne() {

    }

    @GetMapping("/selectList")
    public void selectList() {

    }

    @PutMapping("/update/{}")
    public void update() {

    }

    @DeleteMapping("/delete/{}")
    public void delete() {

    }


}
