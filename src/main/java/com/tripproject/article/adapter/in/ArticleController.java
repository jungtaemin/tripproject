package com.tripproject.article.adapter.in;

import com.tripproject.article.application.ArticleDtoCardBox;
import com.tripproject.article.application.port.in.ArticleQueriesUseCase;
import com.tripproject.article.application.port.in.ArticleUseCase;
import com.tripproject.user.application.port.in.UserQueriesUseCase;
import com.tripproject.user.application.port.in.response.PrincipalDetails;
import com.tripproject.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleUseCase articleUseCase;
    private final ArticleQueriesUseCase articleQueriesUseCase;
    private final UserQueriesUseCase userQueriesUseCase;

    @GetMapping("/article/write")
    public String writeForm(Model model){

        model.addAttribute("articleForm",new ArticleForm());
        return "article/articleWrite";
    }



    @PostMapping("/article/write")
    public String write(@Validated ArticleForm articleForm, BindingResult bindingResult,
                            @AuthenticationPrincipal PrincipalDetails principal,Model model){
        log.info(articleForm.toString());


        if(bindingResult.hasErrors()){
            log.info(bindingResult.toString());
            return "article/articleWrite";
        }

        var command =ArticleCreateCommand.form(articleForm, principal.getId());
        log.info(String.valueOf(principal.getId()));
        var articeId =articleUseCase.write(command);

        log.info(command.toString());

        return "redirect:/article/view?articleId=" + articeId;
    }

    @GetMapping("/article/list/new")
    public String newList(@RequestParam Integer page, Model model){

       var articleList = articleQueriesUseCase.findByOrderByIdDesc(page);
        var pagingBoxHandler = PagingBoxHandler.createOf(page, (int)articleList.getTotalElements());
       model.addAttribute("articleList",articleList);
       model.addAttribute("pagingBoxHandler",pagingBoxHandler);


       return "article/articleList";
    }


    @GetMapping("/article/view")
    public String articleView(@RequestParam Long articleId,
                              @AuthenticationPrincipal PrincipalDetails principal,
                              Model model){
        log.info(articleId.toString());
        if (principal != null) {
            model.addAttribute("user", principal.getUser());
        } else {
            model.addAttribute("user", null);
        }
       var viewList =articleQueriesUseCase.findById(articleId);
        User user = userQueriesUseCase.findId(viewList.getMemberId());

        model.addAttribute("viewList",viewList);
        model.addAttribute("writer",user);



    return "article/articleView";
    }


    @GetMapping("/article/list/last")
    public String newListLast(@RequestParam Integer page, Model model){

        var articleList = articleQueriesUseCase.findByOrderByIdAsc(page);
        var pagingBoxHandler = PagingBoxHandler.createOf(page, (int)articleList.getTotalElements());
        model.addAttribute("articleList",articleList);
        model.addAttribute("pagingBoxHandler",pagingBoxHandler);


        return "article/articleListLast";
    }


    @GetMapping("/article/edit")
    public String edit(@AuthenticationPrincipal PrincipalDetails principal,Model model) {
        var edit = articleQueriesUseCase.edit(principal.getId());
        var edit2 = articleQueriesUseCase.edit2(principal.getId());
        model.addAttribute("edit", edit);
        model.addAttribute("edit2", edit2);
        return "article/articleEdit";

    }

    @GetMapping("/article/edit/form")
    public String edit2(@RequestParam Long articleId,Model model){
        ArticleDtoCardBox articleEdit = articleQueriesUseCase.getArticleEdit(articleId);

        model.addAttribute("articleEdit", articleEdit);

        return "article/articleEditForm";
    }

    @PostMapping("/article/edit/edit")
    public String edit3(@RequestParam Long articleId,
            @ModelAttribute ArticleDtoCardBox articleDtoCardBox){
        articleQueriesUseCase.findId(articleId,articleDtoCardBox);


        return "redirect:/article/edit";
    }

    @GetMapping("/article/edit/delete")
    public String edit2(@RequestParam Long articleId){
        var id = articleUseCase.delete(articleId);


        return "redirect:/article/edit";
    }
    
     @GetMapping("/article/list/search")
    public String getArticleList(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                 @RequestParam String keyword, Model model){

        var articleList = articleQueriesUseCase.getArticleSearchByKeyword(pageable,keyword);

        model.addAttribute("articleList", articleList);


        return "article/articleListSearch";
    }


}
