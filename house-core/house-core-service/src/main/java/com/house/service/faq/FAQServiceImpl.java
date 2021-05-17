package com.house.service.faq;

import com.house.entity.faq.FAQ;
import com.house.repository.faq.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class FAQServiceImpl implements FAQService {

    private FAQRepository repository;

    @Autowired
    public FAQServiceImpl(FAQRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<FAQ> getAll() {
        List<FAQ> faqs = repository.findAll();
        notNull(faqs, "The collection couldn't be null");

        return faqs;
    }

    @Override
    public FAQ save(FAQ faq) {
        notNull(faq, "The FAQ couldn't be null");

        return repository.save(faq);
    }

    @Override
    public FAQ get(String id) throws IllegalAccessException {
        Optional<FAQ> possibleFaq = repository.findById(id);

        if(!possibleFaq.isPresent()) {
            throw new IllegalAccessException("Getting FAQ couldn't be null");
        }

        return possibleFaq.get();
    }

    @Override
    public void delete(String id) throws IllegalAccessException {
        notNull(get(id), "The FAQ couldn't be null");

        repository.deleteById(id);
    }

    @Override
    public FAQ update(String id, FAQ faq) throws IllegalAccessException {
        notNull(get(id), "Entity for updating can't be null");

        return repository.save(faq);
    }
}
