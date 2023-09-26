package com.example.demo_spring_security_session.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class BaseController {
    @GetMapping
    public String getHomePage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", "johnny");
        session.setAttribute("password", "deep");

        return "/home";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

        if ("utilisateur".equals(username) && "mot_de_passe".equals(password)) {

            session.setAttribute("utilisateurConnecte", true);


            return "redirect:/private/secrets";
        } else {

            return "/form";
        }
    }

}
