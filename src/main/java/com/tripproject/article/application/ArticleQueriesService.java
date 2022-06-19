package com.tripproject.article.application;


import com.tripproject.article.application.port.in.ArticleQueriesUseCase;
import com.tripproject.article.application.port.ArticleRepositoryPort;
import com.tripproject.article.domain.Article;
import com.tripproject.study.application.StudyDtoCardBox;
import com.tripproject.study.application.StudyDtoMapper;
import com.tripproject.user.application.NotFoundUserExcepton;
import com.tripproject.user.application.port.in.UserQueriesUseCase;
import com.tripproject.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleQueriesService implements ArticleQueriesUseCase {

    private final ArticleRepositoryPort articleRepositoryPort;
    private final ArticleDtoMapper articleDtoMapper;
    private final UserQueriesUseCase userQueriesUseCase;
    private final StudyDtoMapper studyDtoMapper;


    public Page<ArticleDtoCardBox> findByOrderByIdDesc(Integer page){
        return   articleRepositoryPort.findByOrderByIdDesc(PageRequest.of(pageResolve(page),10))
                .map(articleDtoMapper::cardBox);
    }



    private int pageResolve(Integer rawPage) {
        if (rawPage == null || rawPage == 1) {
            return 0;
        } else return rawPage - 1;
    }



    public ArticleResponseForDetail findById(Long id){
        Article article = articleRepositoryPort.findById(id).orElseThrow(NotFoundUserExcepton::new);
        ArticleResponseForDetail simple = articleDtoMapper.simple(article);
        return simple;

    }


    public Page<ArticleDtoCardBox> findByOrderByIdAsc(Integer page){
        return   articleRepositoryPort.findByOrderByIdAsc(PageRequest.of(pageResolve(page),5))
                .map(articleDtoMapper::cardBox);
    }


    public List<ArticleDtoCardBox> findTop5ByIdOrderByDesc(){
        return articleRepositoryPort.findTop5ByOrderByIdDesc()
                .stream().map(articleDtoMapper::cardBox)
                .collect(Collectors.toList());

    }


    public List<ArticleDtoCardBox> edit(Long id){


        User user = userQueriesUseCase.findId(id);
        return user.getArticles()
                .stream().map(articleDtoMapper::cardBox)
                .collect(Collectors.toList());
    }

    public List<StudyDtoCardBox> edit2(Long id){
        User user = userQueriesUseCase.findId(id);
        return user.getStudies()
                .stream().map(studyDtoMapper::cardBox)
                .collect(Collectors.toList());
    }


    @Override
    public ArticleDtoCardBox getArticleEdit(Long articleId) {
        Article articlebyId = articleRepositoryPort.findArticleById(articleId);
        ArticleDtoCardBox articleDtoCardBox = articleDtoMapper.cardBox(articlebyId);
        return articleDtoCardBox;
    }

    @Override
    @Transactional
    public void findId(Long articleId, ArticleDtoCardBox articleDtoCardBox) {
        Article article = articleRepositoryPort.findById(articleId).orElseThrow();
        article.edit(articleDtoCardBox.getContent(),articleDtoCardBox.getTitle());

    }
}
