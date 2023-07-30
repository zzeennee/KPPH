package com.kpph.api.practice.controller;

import com.kpph.api.practice.request.PracticeRequest;
import com.kpph.api.practice.response.PracticeResponse;
import com.kpph.api.practice.service.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PracticeController {

    private final PracticeService practiceService;

    @GetMapping("/helloWorld")
    public String test () {
        return "hello, World!";
    }

    @GetMapping("/insert")
    public void insert() {
        PracticeRequest practiceRequest = PracticeRequest.builder()
                .practiceIntegerData(0413)
                .practiceTextData("텍스트데이터")
                .practiceLongTextData("롱텍스트데이터")
                .build();
        practiceService.insert(practiceRequest);
    }

    @GetMapping("/selectOne")
    public PracticeResponse selectOne() {
        return practiceService.selectOne(2);
    }

    @GetMapping("/selectList")
    public List<PracticeResponse> selectList() {
        return practiceService.selectList();
    }

    @PutMapping("/update/{}")
    public void update() {

    }

    @DeleteMapping("/delete/{}")
    public void delete() {

    }


}
