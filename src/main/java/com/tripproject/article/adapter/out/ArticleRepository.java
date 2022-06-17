package com.tripproject.article.adapter.out;

import com.tripproject.article.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    //최신순 글 정렬
    Page<Article>findByOrderByIdDesc(Pageable pageable);


    //과거순 글 정렬
    Page<Article>findByOrderByIdAsc(Pageable pageable);
}
