package com.tripproject.article.application.port.in;

import com.tripproject.article.adapter.in.ArticleCreateCommand;

public interface ArticleUseCase {
    public Long write(ArticleCreateCommand articleCreateCommand);

}
