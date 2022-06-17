package com.tripproject.article.application;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
public class ArticleDtoCardBox {

    private Long id;


    private String title;


    private String content;

    private String thumbnailUrl;


    private String DateTrip;


    private String preDate;


    private String costMoney;


    private Long countHuman;

    private LocalDateTime createdDate;


}
