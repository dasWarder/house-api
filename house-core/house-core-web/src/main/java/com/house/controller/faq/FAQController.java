package com.house.controller.faq;


import com.house.entity.faq.FAQ;
import com.house.service.faq.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/house-api/faqs")
public class FAQController {

    private FAQService service;

    @Autowired
    public FAQController(FAQService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FAQ>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/faq")
    public ResponseEntity<FAQ> save(@RequestBody FAQ faq) {
        FAQ savedFAQ = service.save(faq);

        return new ResponseEntity<>(savedFAQ, HttpStatus.CREATED);
    }

    @GetMapping(value = "/faq/{id}")
    public ResponseEntity<FAQ> get(@PathVariable("id") String id) throws IllegalAccessException {
        FAQ faq = service.get(id);

        return new ResponseEntity<>(faq, HttpStatus.OK);
    }

    @PutMapping(value = "/faq/{id}")
    public ResponseEntity<FAQ> update(@PathVariable("id") String id, @RequestBody FAQ faq) throws IllegalAccessException {
        FAQ updated = service.update(id, faq);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(value = "/faq/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) throws IllegalAccessException {
        service.delete(id);

        return new ResponseEntity<>(String.format("The FAQ with id=%s was successfully delete", id), HttpStatus.OK);
    }
}
