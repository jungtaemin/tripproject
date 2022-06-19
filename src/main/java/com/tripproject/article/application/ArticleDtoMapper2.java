package com.tripproject.article.application;


import com.tripproject.article.domain.Article;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ArticleDtoMapper2 {

    @Mappings({
            @Mapping(source = "article.user.userName", target = "userName"),
    })
    ArticleDtoCardBox cardBox(Article article);


    @Mappings({
            @Mapping(source = "article.user.id", target = "memberId"),
    })
    ArticleResponseForDetail simple(Article article);

}
