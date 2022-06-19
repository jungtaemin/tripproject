package com.tripproject.study.adapter.in;


import com.tripproject.article.adapter.in.PagingBoxHandler;
import com.tripproject.study.application.StudyDtoCardBox;
import com.tripproject.study.application.port.in.StudyQueriesUseCase;
import com.tripproject.study.application.port.in.StudyUseCase;
import com.tripproject.user.application.port.in.UserQueriesUseCase;
import com.tripproject.user.application.port.in.response.PrincipalDetails;
import com.tripproject.user.domain.User;
import lombok.RequiredArgsConstructor;
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

@Slf4j
@RequiredArgsConstructor
@Controller
public class StudyController {

    private final StudyUseCase studyUseCase;
    private final StudyQueriesUseCase studyQueriesUseCase;
    private final UserQueriesUseCase userQueriesUseCase;

    @GetMapping("/study/write")
    public String writeForm(Model model){

        model.addAttribute("studyForm",new StudyForm());
        return "study/StudyWrite";
    }



    @PostMapping("/study/write")
    public String write(@Validated StudyForm studyForm, BindingResult bindingResult,
                        @AuthenticationPrincipal PrincipalDetails principal, Model model){
        log.info(studyForm.toString());


        if(bindingResult.hasErrors()){
            log.info(bindingResult.toString());
            return "study/studyWrite";
        }

        var command = StudyCreateCommand.form(studyForm, principal.getId());
        log.info(String.valueOf(principal.getId()));
        var studyId =studyUseCase.write(command);

        log.info(command.toString());

        return "redirect:/study/view?studyId=" + studyId;
    }

    @GetMapping("/study/list/new")
    public String newList(@RequestParam Integer page, Model model){

       var studyList = studyQueriesUseCase.findByOrderByIdDesc(page);
        var pagingBoxHandler = PagingBoxHandler.createOf(page, (int)studyList.getTotalElements());
       model.addAttribute("studyList",studyList);
       model.addAttribute("pagingBoxHandler",pagingBoxHandler);


       return "study/studyList";
    }


    @GetMapping("/study/view")
    public String StudyView(@RequestParam Long studyId,
                              @AuthenticationPrincipal PrincipalDetails principal,
                              Model model){
        log.info(studyId.toString());
        if (principal != null) {
            model.addAttribute("user", principal.getUser());
        } else {
            model.addAttribute("user", null);
        }
       var viewList =studyQueriesUseCase.findById(studyId);
        User user = userQueriesUseCase.findId(viewList.getMemberId());

        model.addAttribute("viewList",viewList);
        model.addAttribute("writer",user);



    return "study/studyView";
    }


    @GetMapping("/study/list/last")
    public String newListLast(@RequestParam Integer page, Model model){

        var StudyList = studyQueriesUseCase.findByOrderByIdAsc(page);
        var pagingBoxHandler = PagingBoxHandler.createOf(page, (int)StudyList.getTotalElements());
        model.addAttribute("StudyList",StudyList);
        model.addAttribute("pagingBoxHandler",pagingBoxHandler);


        return "study/studyListLast";
    }

//    @GetMapping("/article/edit/edit")
//    public String edit2(@RequestParam Long articleId,Model model){
//
//    }

    @GetMapping("/study/edit/form")
    public String edit2(@RequestParam Long studyId,Model model){
        StudyDtoCardBox studyEdit = studyQueriesUseCase.getStudyEdit(studyId);

        model.addAttribute("studyEdit", studyEdit);

        return "study/studyEditForm";
    }

    @PostMapping("/study/edit/edit")
    public String edit3(@RequestParam Long studyId,
                        @ModelAttribute StudyDtoCardBox studyDtoCardBox){
        studyQueriesUseCase.findId(studyId,studyDtoCardBox);


        return "redirect:/article/edit";
    }

    @GetMapping("/study/edit/delete")
    public String edit2(@RequestParam Long studyId){
        var id = studyUseCase.delete(studyId);


        return "redirect:/article/edit";
    }



//    public String MyStudy(@AuthenticationPrincipal PrincipalDetails principalDetails){
//
//
//
//    }
}


