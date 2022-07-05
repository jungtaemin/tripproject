package com.tripproject.article.adapter.out;

import com.tripproject.article.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    //최신순 글 정렬
    Page<Article>findByOrderByIdDesc(Pageable pageable);


    //과거순 글 정렬
    Page<Article>findByOrderByIdAsc(Pageable pageable);



    List<Article>findTop5ByOrderByIdDesc();


    Article findArticleById(Long articleId);
    
     @Query("select a from Article a where a.title like %:keyword% or a.content like %:keyword% order by a.id desc")
    Page<Article> findAllByKeywordOrderById(Pageable pageable, @Param("keyword") String keyword);



}
