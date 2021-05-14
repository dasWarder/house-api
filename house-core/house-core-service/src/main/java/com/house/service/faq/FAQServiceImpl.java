package com.house.service.faq;

import com.house.entity.faq.FAQ;
import com.house.repository.faq.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
public class FAQServiceImpl implements FAQService {

    private final FAQRepository repository;

    @Autowired
    public FAQServiceImpl(FAQRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<FAQ> getFAQs() {
        List<FAQ> faqs = repository.findAll();
        notNull(faqs, "Collection couldn't be null");

        return faqs;
    }
}
