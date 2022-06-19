package com.tripproject.study.application;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudyResponseForDetail {

    private Long id;

    private String title;

    private String content;

    private Long memberId;

    private String thumbnailUrl;

    private LocalDateTime createdDate;

    private Long hit;
    private Long bad;


}
