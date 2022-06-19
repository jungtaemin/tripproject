package com.tripproject.article.application;

import com.tripproject.article.adapter.in.ArticleCreateCommand;
import com.tripproject.article.application.port.in.ArticleUseCase;
import com.tripproject.article.application.port.ArticleRepositoryPort;
import com.tripproject.article.domain.Article;
import com.tripproject.user.application.port.in.UserQueriesUseCase;
import com.tripproject.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService implements ArticleUseCase {

    private final ArticleRepositoryPort articleRepositoryPort;
    private final UserQueriesUseCase userQueriesUseCase;



    public Long write(ArticleCreateCommand articleCreateCommand){

            var user = userQueriesUseCase.findId(articleCreateCommand.getId());
            log.info(user.toString());

            var article = new Article(articleCreateCommand.getTitle(), articleCreateCommand.getContent(), articleCreateCommand.getThumbnailUrl(),user);

            articleRepositoryPort.save(article);

            return article.getId();


    }

    public Long delete(Long id){

        articleRepositoryPort.deleteById(id);
        return id;

    }

    public Long edit(ArticleDtoCardBox articleDtoCardBox){

        Article build = Article.builder()
                .title(articleDtoCardBox.getTitle())
                .content(articleDtoCardBox.getContent())
                .user(articleDtoCardBox.getUser())
                .build();
        articleRepositoryPort.save(build);
        return build.getId();
    }



}
