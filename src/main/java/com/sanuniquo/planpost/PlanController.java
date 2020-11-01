package com.sanuniquo.planpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PlanController {

    @Autowired
    private PlanRepository repo;

    @GetMapping("/home")
    public String hello(Model model){
//        model.addAttribute("plans", new PlanModel());
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        PlanModel planModel = new PlanModel();
        model.addAttribute("plans", planModel);
        return "register";
    }

    @PostMapping("/register")
    public String postform(PlanModel planModel){
        repo.save(planModel);
        return "redirect:/";
    }
}
