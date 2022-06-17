package com.tripproject.article.adapter.in;

import com.tripproject.user.application.port.in.response.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {


    @RequestMapping("/")
    public String main(){

        return "index";
    }
}
