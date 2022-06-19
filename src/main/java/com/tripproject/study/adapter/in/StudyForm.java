package com.tripproject.study.adapter.in;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudyForm {
    /**
     *  StudyDTO
     */

    @NotBlank(message = "제목을 입력해주세요")
    private String title;

    @NotBlank(message = "내용을 입력해주세요")
    private String content;
    



}
