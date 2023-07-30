package com.kpph.api.practice.service;

import com.kpph.api.practice.entity.Practice;
import com.kpph.api.practice.entity.PracticeEditor;
import com.kpph.api.practice.repository.PracticeRepository;
import com.kpph.api.practice.request.PracticeRequest;
import com.kpph.api.practice.response.PracticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PracticeService {
    private final PracticeRepository practiceRepository;

    public void insert(PracticeRequest practiceRequest) {
        Practice practice = Practice.builder()
                .practiceIntegerData(practiceRequest.getPracticeIntegerData())
                .practiceTextData(practiceRequest.getPracticeTextData())
                .practiceLongTextData(practiceRequest.getPracticeLongTextData())
                .build();

        practiceRepository.save(practice);
    }

    public PracticeResponse selectOne(Integer practiceIdx) {
        Practice practice = practiceRepository.findById(practiceIdx).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        return PracticeResponse.builder()
                .practiceIdx(practice.getPracticeIdx())
                .practiceInsertDate(practice.getPracticeInsertDate())
                .practiceUpdateDate(practice.getPracticeUpdateDate())
                .practiceTextData(practice.getPracticeTextData())
                .practiceIntegerData(practice.getPracticeIntegerData())
                .practiceLongTextData(practice.getPracticeLongTextData())
                .build();
    }

   public List<PracticeResponse> selectList() {
        return practiceRepository.findAll().stream().map(PracticeResponse :: new).collect(Collectors.toList());
    }

    @Transactional
    public void update(Integer practiceIdx, PracticeRequest practiceRequest) {
        Practice practice = practiceRepository.findById(practiceIdx).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        PracticeEditor.PracticeEditorBuilder editorBuilder = practice.toEditor();

        PracticeEditor practiceEditor = editorBuilder.practiceIntegerData(practiceRequest.getPracticeIntegerData())
                .practiceTextData(practiceRequest.getPracticeTextData())
                .practiceLongTextData(practiceRequest.getPracticeLongTextData())
                .build();

        practice.edit(practiceEditor);
    }

    public void delete() {
        practiceRepository.deleteAll();
    }

}
