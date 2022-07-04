package com.tripproject.article.application.port.in;

import com.tripproject.article.application.ArticleDtoCardBox;
import com.tripproject.article.application.ArticleResponseForDetail;
import com.tripproject.article.domain.Article;
import com.tripproject.study.application.StudyDtoCardBox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleQueriesUseCase {


    public Page<ArticleDtoCardBox> findByOrderByIdDesc(Integer page);
    public Page<ArticleDtoCardBox> findByOrderByIdAsc(Integer page);
    public ArticleResponseForDetail findById(Long id);
    public List<ArticleDtoCardBox> findTop5ByIdOrderByDesc();
    public List<ArticleDtoCardBox> edit(Long id);
    public List<StudyDtoCardBox> edit2(Long id);

    ArticleDtoCardBox getArticleEdit(Long articleId);

    void findId(Long articleId, ArticleDtoCardBox articleDtoCardBox);

    Page<ArticleDtoCardBox> getArticleSearchByKeyword(Pageable pageable, String keyword);
}
