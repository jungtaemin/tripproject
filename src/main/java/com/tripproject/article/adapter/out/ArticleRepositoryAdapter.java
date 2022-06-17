package com.tripproject.article.adapter.out;

import com.tripproject.article.application.port.ArticleRepositoryPort;
import com.tripproject.article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ArticleRepositoryAdapter implements ArticleRepositoryPort {

    private final ArticleRepository articleRepository;


    public Article save(Article article){
        return articleRepository.save(article);
    }
    public Optional<Article> findById(Long id){
        return articleRepository.findById(id);
    }



    public Page<Article> findByOrderByIdDesc(Pageable pageable){
        return articleRepository.findByOrderByIdDesc(pageable);
    }

    public Page<Article> findByOrderByIdAsc(Pageable pageable){
        return articleRepository.findByOrderByIdAsc(pageable);
    }
}
