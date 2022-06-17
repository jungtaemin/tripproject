package com.tripproject.article.application;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ArticleResponseForDetail {

    private Long id;
    private String title;
    private String content;
    private Long memberId;
    private String thumbnailUrl;

    private LocalDateTime createdDate;


    private String dateTrip;


    private String preDate;


    private String costMoney;


    private Long countHuman;


}
