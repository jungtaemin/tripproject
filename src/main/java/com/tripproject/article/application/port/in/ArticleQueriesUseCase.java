package com.tripproject.article.application.port.in;

import com.tripproject.article.application.ArticleDtoCardBox;
import com.tripproject.article.application.ArticleResponseForDetail;
import org.springframework.data.domain.Page;

public interface ArticleQueriesUseCase {


    public Page<ArticleDtoCardBox> findByOrderByIdDesc(Integer page);
    public Page<ArticleDtoCardBox> findByOrderByIdAsc(Integer page);
    public ArticleResponseForDetail findById(Long id);

}
