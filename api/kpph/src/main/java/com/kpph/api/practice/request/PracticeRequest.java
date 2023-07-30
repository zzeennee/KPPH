package com.kpph.api.practice.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PracticeRequest {

    private Integer practiceIntegerData;
    private String practiceTextData;
    private String practiceLongTextData;

    @Builder
    public PracticeRequest(Integer practiceIntegerData, String practiceTextData, String practiceLongTextData) {
        this.practiceIntegerData = practiceIntegerData;
        this.practiceTextData = practiceTextData;
        this.practiceLongTextData = practiceLongTextData;
    }
}
