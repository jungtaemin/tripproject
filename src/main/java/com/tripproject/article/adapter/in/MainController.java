package com.tripproject.article.adapter.in;

import com.tripproject.article.application.port.in.ArticleQueriesUseCase;
import com.tripproject.study.application.port.in.StudyQueriesUseCase;
import com.tripproject.user.application.port.in.response.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
public class MainController {


    private final ArticleQueriesUseCase articleQueriesUseCase;
    private final StudyQueriesUseCase studyQueriesUseCase;

    @RequestMapping("/")
    public String main(Model model){



        var articleList = articleQueriesUseCase.findTop5ByIdOrderByDesc();
        var studyList = studyQueriesUseCase.findTop5ByOrderByIdDesc();
        model.addAttribute("articleList",articleList);

        model.addAttribute("studyList",studyList);



        return "index";
    }
}
