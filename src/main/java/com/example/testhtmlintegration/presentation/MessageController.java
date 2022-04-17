package com.example.testhtmlintegration.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("messages")
public class MessageController {
    
    @GetMapping("form")
    String get() {
        return "messages/form";
    }

    @PostMapping
    String post() {
        return "redirect:/messages/123";
    }
}
