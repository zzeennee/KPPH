package com.kpph.api.practice.controller;

import com.kpph.api.practice.request.PracticeCreate;
import com.kpph.api.practice.request.PracticeRequest;
import com.kpph.api.practice.response.PracticeResponse;
import com.kpph.api.practice.service.PracticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class PracticeController {

    private final PracticeService practiceService;

    @GetMapping("/helloWorld")
    public String test () {

        log.info("/api/helloWorld 호출");

        return "hello, World!";
    }

    @PostMapping("/practice")
    public void insert(@RequestBody PracticeCreate practiceCreate) {
        practiceService.insert(practiceCreate);
    }

    @GetMapping("/selectOne")
    public PracticeResponse selectOne() {
        return practiceService.selectOne(1);
    }

    @GetMapping("/selectList")
    public List<PracticeResponse> selectList() {
        return practiceService.selectList();
    }

    @GetMapping("/update")
    public void update() {
        PracticeRequest practiceRequest = PracticeRequest.builder()
                .practiceIntegerData(111)
                .practiceTextData("텍스트업데이트데이터")
                .practiceLongTextData("롱텍스트업데이트데이터").build();

        practiceService.update(1, practiceRequest);
    }

    @GetMapping("/delete")
    public void delete() {
        practiceService.delete();
    }


}
