package com.example.TestSecurity.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String mainP(Model model) {
        // id 정보 얻기
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        // role정보 얻기
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = ((org.springframework.security.core.Authentication) authentication).getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();
        
        model.addAttribute("id", id);
        model.addAttribute("role",role);

        return "main";
    }
}
