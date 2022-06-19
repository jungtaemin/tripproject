package com.tripproject.article.application;

import com.tripproject.article.domain.Article;
import com.tripproject.user.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-20T01:39:05+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Oracle Corporation)"
)
@Component
public class ArticleDtoMapperImpl implements ArticleDtoMapper {

    @Override
    public ArticleDtoCardBox cardBox(Article article) {
        if ( article == null ) {
            return null;
        }

        ArticleDtoCardBox articleDtoCardBox = new ArticleDtoCardBox();

        articleDtoCardBox.setUserName( articleUserUserName( article ) );
        articleDtoCardBox.setId( article.getId() );
        articleDtoCardBox.setTitle( article.getTitle() );
        articleDtoCardBox.setContent( article.getContent() );
        articleDtoCardBox.setThumbnailUrl( article.getThumbnailUrl() );
        articleDtoCardBox.setCreatedDate( article.getCreatedDate() );
        articleDtoCardBox.setUser( article.getUser() );
        articleDtoCardBox.setHit( article.getHit() );
        articleDtoCardBox.setBad( article.getBad() );

        return articleDtoCardBox;
    }

    @Override
    public ArticleResponseForDetail simple(Article article) {
        if ( article == null ) {
            return null;
        }

        ArticleResponseForDetail articleResponseForDetail = new ArticleResponseForDetail();

        articleResponseForDetail.setMemberId( articleUserId( article ) );
        articleResponseForDetail.setId( article.getId() );
        articleResponseForDetail.setTitle( article.getTitle() );
        articleResponseForDetail.setContent( article.getContent() );
        articleResponseForDetail.setThumbnailUrl( article.getThumbnailUrl() );
        articleResponseForDetail.setCreatedDate( article.getCreatedDate() );
        articleResponseForDetail.setHit( article.getHit() );
        articleResponseForDetail.setBad( article.getBad() );

        return articleResponseForDetail;
    }

    private String articleUserUserName(Article article) {
        if ( article == null ) {
            return null;
        }
        User user = article.getUser();
        if ( user == null ) {
            return null;
        }
        String userName = user.getUserName();
        if ( userName == null ) {
            return null;
        }
        return userName;
    }

    private Long articleUserId(Article article) {
        if ( article == null ) {
            return null;
        }
        User user = article.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
