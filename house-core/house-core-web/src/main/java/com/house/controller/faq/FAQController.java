package com.house.controller.faq;


import com.house.entity.faq.FAQ;
import com.house.service.faq.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/house-api")
public class FAQController {

    private final FAQService service;

    @Autowired
    public FAQController(FAQService service) {
        this.service = service;
    }

    @GetMapping(value = "/faqs")
    public List<FAQ> getFAQs() {
        return service.getFAQs();
    }
}
