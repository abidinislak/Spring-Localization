package com.restApiLocalization.localization.controller;

import com.restApiLocalization.localization.config.MyLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {


    @Autowired
    MessageSource messageConfig;

    @Autowired
    MyLocaleResolver myLocaleResolver;

    @GetMapping("/greeting")
    public String greeting(HttpServletRequest request){



        return   messageConfig.getMessage("greeting",null,myLocaleResolver.resolveLocale(request)) ;

    }
}
