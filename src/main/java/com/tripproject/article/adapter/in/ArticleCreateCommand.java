package com.tripproject.article.adapter.in;

import com.tripproject.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class ArticleCreateCommand {


    private String title;


    private String content;

    private String thumbnailUrl;


    private String DateTrip;


    private String preDate;


    private String costMoney;


    private Long countHuman;

    private Long id;


    public static ArticleCreateCommand form(ArticleForm articleForm, Long id) {
        return new ArticleCreateCommand(articleForm.getTitle(),articleForm.getContent(), articleForm.getThumbnailUrl(),articleForm.getDateTrip(), articleForm.getPreDate(),
                articleForm.getCostMoney(), articleForm.getCountHuman(),id);
    }
}
