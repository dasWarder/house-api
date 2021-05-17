package com.house.service.faq;

import com.house.entity.faq.FAQ;

import java.util.List;

public interface FAQService {

    List<FAQ> getAll();

    FAQ save(FAQ faq);

    FAQ get(String id) throws IllegalAccessException;

    void delete(String id) throws IllegalAccessException;

    FAQ update(String id, FAQ faq) throws IllegalAccessException;
}
