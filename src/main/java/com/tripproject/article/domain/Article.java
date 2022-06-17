package com.tripproject.article.domain;

import com.tripproject.shared.domain.BaseEntity;
import com.tripproject.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
public class Article extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "article_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 10000)
    private String content;

    private String thumbnailUrl;

    @Column(nullable = false)
    private String DateTrip;

    @Column(nullable = false)
    private String preDate;


    private String costMoney;

    @Column(nullable = false)
    private Long countHuman;

    private Long hit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Article() {
    }

    @Builder
    public Article(String title, String content, String thumbnailUrl, String dateTrip, String preDate, String costMoney, Long countHuman,User user) {
        this.title = title;
        this.content = content;
        this.thumbnailUrl = thumbnailUrl;
        DateTrip = dateTrip;
        this.preDate = preDate;
        this.costMoney = costMoney;
        this.countHuman = countHuman;
        this.user =user;
        this.hit = 0L;


        if (this.thumbnailUrl == null){
            this.thumbnailUrl = "/img/기본이미지.png";
        }
    }

}
