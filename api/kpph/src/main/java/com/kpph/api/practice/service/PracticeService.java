package com.kpph.api.practice.service;

import com.kpph.api.practice.entity.Practice;
import com.kpph.api.practice.repository.PracticeRepository;
import com.kpph.api.practice.request.PracticeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public Practice selectOne(Integer practiceIdx) { // 엔티티 리턴
        Practice practice = practiceRepository.findById(practiceIdx).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        return practice;
    }



  /*  public PracticeResponse selectOne2(Integer practiceIdx) {  // VO리턴
        // practiceRepository == 엔티티
        // 엔티티 -> VO
        Practice practice =  practiceRepository.findById(practiceIdx).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
        PracticeResponse practiceResponse = new PracticeResponse(practice);

        return practiceResponse;
    }*/

   /* public PracticeResponse selectOne3(Integer practiceIdx) {
        Practice practice = practiceRepository.findById(practiceIdx).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다.")); // 엔티티

        PracticeResponse practiceResponse = PracticeResponse.builder()
                .practiceIdx(practice.getPracticeIdx())
                .practiceInsertDate(practice.getPracticeInsertDate())
                .practiceUpdateDate(practice.getPracticeUpdateDate())
                .practiceTextData(practice.getPracticeTextData())
                .practiceIntegerData(practice.getPracticeIntegerData())
                .practiceLongTextData(practice.getPracticeLongTextData())
                .build();

        // 빌더를 통해서 엔티티를 VO로 변환
        return practiceResponse;
    }*/

   /* public List<PracticeResponse> selectList() {
        practiceRepository.findAll();



        return practiceResponseList.stream().map();
    }*/

    public void update() {

    }

    @Transactional //230806 pjh 해당 메소드에서 일어나는 로직이 모두 정상적으로 수행이 되어야만 최종적으로 DB에 commit
    public void delete(Integer practiceIdx) {
        Practice practice = practiceRepository.findById(practiceIdx).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
        practiceRepository.delete(practice);
    }

}
