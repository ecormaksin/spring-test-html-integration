package com.example.testhtmlintegration.presentation;

import java.net.URI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("messages")
public class MessageController {

    private static final String FORM_NAME = "messageForm";
    
    @GetMapping("form")
    String get(Model model) {
        model.addAttribute(FORM_NAME, new MessageForm());
        return "messages/form";
    }

    @PostMapping
    String post(Model model, 
                    @Validated @ModelAttribute(FORM_NAME) MessageForm messageForm,
                    RedirectAttributes attributes,
                    UriComponentsBuilder builder) {

        attributes.addFlashAttribute(FORM_NAME, messageForm);

        URI uri = builder.path("/messages/"  + messageForm.getId()).build().toUri();
        return "redirect:" + uri.toString();
    }

    @GetMapping("{id}")
    String edit(Model model, 
                    @ModelAttribute(FORM_NAME) MessageForm messageForm) {

        model.addAttribute(FORM_NAME, messageForm);
        return "messages/form";
    }
}
