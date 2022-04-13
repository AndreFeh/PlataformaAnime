package com.touchtech.programa.anime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
//  Definindo em SECURITY, Retorna esse Index
    @RequestMapping("/")
    public String index(){
    return "index";
    }
}

