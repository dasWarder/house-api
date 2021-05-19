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
 * The rest controller that provide an entrypoint for interaction with FAQ's
 */
@RestController
@RequestMapping("/house-api/faqs")
public class FAQController {

    /**
     * The field of the service layer bean
     */
    private FAQService service;

    @Autowired
    public FAQController(FAQService service) {
        this.service = service;
    }

    /**
     * A method for receiving the collection of FAQ's from DB
     * @return Response entity with OK status and the list of all FAQ's
     */
    @GetMapping
    public ResponseEntity<List<FAQ>> getAll() {

        /**
         * @see FAQService#getAll()
         */
        List<FAQ> faqs = service.getAll();

        return new ResponseEntity<>(faqs, HttpStatus.OK);
    }

    /**
     * A method to save provided @param FAQ entity to database
     * @param faq the body of tge FAQ, send by a client
     * @return Response entity with CREATED status and received from DB entity
     */
    @PostMapping(value = "/faq")
    public ResponseEntity<FAQ> save(@RequestBody FAQ faq) {
        /**
         * @see FAQService#save(FAQ)
         */
        FAQ savedFAQ = service.save(faq);

        return new ResponseEntity<>(savedFAQ, HttpStatus.CREATED);
    }

    /**
     * A method for getting a FAQ from DB by @param id
     * @param id of the the FAQ, must be not NULL
     * @return Response entity with OK status and the FAQ from DB
     * @throws IllegalAccessException in case when the FAQ with @param id doesn't exist or @param id is NULL
     */
    @GetMapping(value = "/faq/{id}")
    public ResponseEntity<FAQ> get(@PathVariable("id") String id) throws IllegalAccessException {
        /**
         * @see FAQService#get(String)
         */
        FAQ faq = service.get(id);

        return new ResponseEntity<>(faq, HttpStatus.OK);
    }

    /**
     * A method for updating a FAQ that already stored in DB
     * @param id of the FAQ that must be updated
     * @param faq a new body for the FAQ
     * @return Response entity with OK status and a new FAQ
     * @throws IllegalAccessException in case when the FAQ with @param id don't exist or @param id is NULL
     */
    @PutMapping(value = "/faq/{id}")
    public ResponseEntity<FAQ> update(@PathVariable("id") String id, @RequestBody FAQ faq) throws IllegalAccessException {
        /**
         * @see FAQService#update(String, FAQ)
         */
        FAQ updated = service.update(id, faq);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    /**
     * A method for removing a FAQ with @param id from DB
     * @param id of the FAQ that must be deleted
     * @return Response entity with OK status and info message
     * @throws IllegalAccessException in case when the FAQ with @param id don't exist or @param id is NULL
     */
    @DeleteMapping(value = "/faq/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) throws IllegalAccessException {
        /**
         * @see FAQService#delete(String)
         */
        service.delete(id);

        return new ResponseEntity<>(String.format("The FAQ with id=%s was successfully delete", id), HttpStatus.OK);
    }
}
