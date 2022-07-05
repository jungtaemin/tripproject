package com.tripproject.article.application.port;

import com.tripproject.article.adapter.out.ArticleRepository;
import com.tripproject.article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ArticleRepositoryPort {



    public Article save(Article article);

    public Optional<Article> findById(Long id);
    public Page<Article> findByOrderByIdDesc(Pageable pageable);

    public Page<Article> findByOrderByIdAsc(Pageable pageable);
    public List<Article> findTop5ByOrderByIdDesc();
    public void deleteById(Long id);
    public Article findArticleById(Long id);
    public  Page<Article> findAllByKeywordOrderById(Pageable pageable, String keyword);


}
