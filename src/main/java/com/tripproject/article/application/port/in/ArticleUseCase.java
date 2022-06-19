package com.tripproject.article.application.port.in;

import com.tripproject.article.adapter.in.ArticleCreateCommand;
import com.tripproject.article.application.ArticleDtoCardBox;

public interface ArticleUseCase {
    public Long write(ArticleCreateCommand articleCreateCommand);
    public Long delete(Long id);
    public Long edit(ArticleDtoCardBox articleDtoCardBox);
}
