package com.tripproject.article.adapter.in;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ArticleForm {
    /**
     *  articleDTO
     */

    @NotBlank(message = "제목을 입력해주세요")
    private String title;

    @NotBlank(message = "내용을 입력해주세요")
    private String content;

    private String thumbnailUrl;

    @NotNull(message = "여행날짜를 입력해주세요")
    private String dateTrip;

    @NotNull(message = "여행날짜를 입력해주세요")
    private String preDate;

    @NotBlank(message = "예상비용을 입력해주세요")
    private String costMoney;

    @NotNull(message = "모집인원을 입력해주세요")
    private Long countHuman;



}
