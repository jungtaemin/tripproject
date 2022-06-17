package com.tripproject.article.application;


import com.tripproject.article.application.port.in.ArticleQueriesUseCase;
import com.tripproject.article.application.port.ArticleRepositoryPort;
import com.tripproject.article.domain.Article;
import com.tripproject.user.application.NotFoundUserExcepton;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleQueriesService implements ArticleQueriesUseCase {

    private final ArticleRepositoryPort articleRepositoryPort;
    private final ArticleDtoMapper articleDtoMapper;


    public Page<ArticleDtoCardBox> findByOrderByIdDesc(Integer page){
        return   articleRepositoryPort.findByOrderByIdDesc(PageRequest.of(pageResolve(page),5))
                .map(articleDtoMapper::cardBox);
    }



    private int pageResolve(Integer rawPage) {
        if (rawPage == null || rawPage == 1) {
            return 0;
        } else return rawPage - 1;
    }



    public ArticleResponseForDetail findById(Long id){
        Article article = articleRepositoryPort.findById(id).orElseThrow(NotFoundUserExcepton::new);
        ArticleResponseForDetail detail = articleDtoMapper.detail(article);
        return detail;

    }


    public Page<ArticleDtoCardBox> findByOrderByIdAsc(Integer page){
        return   articleRepositoryPort.findByOrderByIdAsc(PageRequest.of(pageResolve(page),5))
                .map(articleDtoMapper::cardBox);
    }


}
