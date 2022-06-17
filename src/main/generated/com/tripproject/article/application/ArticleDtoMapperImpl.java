package com.tripproject.article.application;

import com.tripproject.article.domain.Article;
import com.tripproject.user.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T06:42:52+0900",
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

        articleDtoCardBox.setId( article.getId() );
        articleDtoCardBox.setTitle( article.getTitle() );
        articleDtoCardBox.setContent( article.getContent() );
        articleDtoCardBox.setThumbnailUrl( article.getThumbnailUrl() );
        articleDtoCardBox.setDateTrip( article.getDateTrip() );
        articleDtoCardBox.setPreDate( article.getPreDate() );
        articleDtoCardBox.setCostMoney( article.getCostMoney() );
        articleDtoCardBox.setCountHuman( article.getCountHuman() );
        articleDtoCardBox.setCreatedDate( article.getCreatedDate() );

        return articleDtoCardBox;
    }

    @Override
    public ArticleResponseForDetail detail(Article article) {
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
        articleResponseForDetail.setDateTrip( article.getDateTrip() );
        articleResponseForDetail.setPreDate( article.getPreDate() );
        articleResponseForDetail.setCostMoney( article.getCostMoney() );
        articleResponseForDetail.setCountHuman( article.getCountHuman() );

        return articleResponseForDetail;
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
