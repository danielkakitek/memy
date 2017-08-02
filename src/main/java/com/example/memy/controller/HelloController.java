package com.example.memy.controller;


import com.example.memy.DAO.GifDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

    GifDao gifDao = new GifDao();

    @GetMapping("/")
    public String hello( ModelMap modelMap){
        modelMap.addAttribute("gifs", gifDao.showAll() );
        return "home";
    }
    @GetMapping("/articles")
    public String articles(){
        return "articles";
    }
    @GetMapping("/favorites")
    public String favorites( ModelMap modelMap){
        modelMap.addAttribute("gifs", gifDao.isLike() );
        return "isLike";
    }
    @GetMapping("/mem/{name}")
    public String displayMem(@PathVariable String name, ModelMap modelMap) {
        System.out.println(name);
        modelMap.addAttribute("gifs", gifDao.findOne(name));
        return "displayOne";
    }

}
