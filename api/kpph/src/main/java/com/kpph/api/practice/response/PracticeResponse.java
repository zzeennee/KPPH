package com.kpph.api.practice.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class PracticeResponse {

    private final Integer practiceIdx;
    private final Integer practiceIntegerData;
    private final String practiceTextData;
    private final String practiceLongTextData;
    private final Date practiceInsertDate;
    private final Date practiceUpdateDate;

    @Builder
    public PracticeResponse(Integer practiceIdx, Integer practiceIntegerData, String practiceTextData, String practiceLongTextData, Date practiceInsertDate, Date practiceUpdateDate) {
        this.practiceIdx = practiceIdx;
        this.practiceIntegerData = practiceIntegerData;
        this.practiceTextData = practiceTextData;
        this.practiceLongTextData = practiceLongTextData;
        this.practiceInsertDate = practiceInsertDate;
        this.practiceUpdateDate = practiceUpdateDate;
    }
}
