package com.tripproject.study.domain;

import com.tripproject.shared.domain.BaseEntity;
import com.tripproject.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
public class Study extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "Study_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 10000)
    private String content;

    private String thumbnailUrl;


    private Long hit;
    private Long bad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Study() {
    }

    @Builder
    public Study(String title, String content, User user) {
        this.title = title;
        this.content = content;

        this.user = user;
        this.hit = 0L;
        this.bad = 0L;


    }

    public void edit(String content, String title) {
        this.content = content;
        this.title = title;

    }
}