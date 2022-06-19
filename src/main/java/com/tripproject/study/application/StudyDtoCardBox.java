package com.tripproject.study.application;


import com.tripproject.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class StudyDtoCardBox {

    private Long id;


    private String title;


    private String content;

    private String thumbnailUrl;

    private LocalDateTime createdDate;

    private User user;

    private Long hit;

    private Long bad;

    private String userName;

}
