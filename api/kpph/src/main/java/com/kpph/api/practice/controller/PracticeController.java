package com.kpph.api.practice.controller;

import com.kpph.api.practice.entity.Practice;
import com.kpph.api.practice.request.PracticeRequest;
import com.kpph.api.practice.response.PracticeResponse;
import com.kpph.api.practice.service.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    /*@GetMapping("/selectOne")
    public PracticeResponse selectOne() {
        return practiceService.selectOne();
    }*/

    /*@GetMapping("/selectList")
    public List<PracticeResponse> selectList() {
        return practiceService.selectList();
    }*/

    @PutMapping("/update/{}")
    public void update() {

    }

    //230806 pjh 삭제 기능 추가
    @GetMapping("/delete/{practiceIdx}")
    public void delete(@PathVariable("practiceIdx") Integer practiceIdx) {
        practiceService.delete(practiceIdx);
    }


}
