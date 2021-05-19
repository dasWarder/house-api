package com.house.service.faq;

import com.house.entity.faq.FAQ;
import com.house.repository.faq.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

/**
 * Service layer that implement FAQ Service interface.
 * The layer between controller and dao layers for checking correctness of a data
 */
@Service
public class FAQServiceImpl implements FAQService {

    /**
     * The field of dao layer bean
     */
    private FAQRepository repository;

    @Autowired
    public FAQServiceImpl(FAQRepository repository) {
        this.repository = repository;
    }

    /**
     * The method for validation of correctness a data during the <b>getAll</b> operation
     * @see FAQService#getAll() description
     * @return a collection of all FAQ's
     */
    @Override
    public List<FAQ> getAll() {
        /**
         * A default MongoRepository method
         * @see FAQRepository#findAll()
         */
        List<FAQ> faqs = repository.findAll();
        notNull(faqs, "The collection couldn't be null");

        return faqs;
    }

    /**
     * The method for validation of correctness a data during the <b>save</b> operation
     * @see FAQService#save description
     * @param faq for storing
     * @return a stored FAQ object
     */
    @Override
    public FAQ save(FAQ faq) {
        notNull(faq, "The FAQ couldn't be null");
        /**
         * A default MongoRepository method
         * @see FAQRepository#save(Object) ()
         */
        return repository.save(faq);
    }

    /**
     * The method for validation of correctness a data during the <b>get</b> operation
     * @param id of the FAQ, that must be received
     * @return a FAQ from database
     * @throws IllegalAccessException in case when a FAQ with @param id don't exist or @param id is NULL
     */
    @Override
    public FAQ get(String id) throws IllegalAccessException {

        /**
         * A default MongoRepository method
         * @see FAQRepository#findById(Object) ()
         */
        Optional<FAQ> possibleFaq = repository.findById(id);

        if(!possibleFaq.isPresent()) {
            throw new IllegalAccessException("Getting FAQ couldn't be null");
        }

        return possibleFaq.get();
    }

    /**
     * The method for validation of correctness a data during the <b>delete</b> operation
     * @param id of the FAQ, that must be removed
     * @throws IllegalAccessException in case when a FAQ with @param id don't exist or @param id is NULL
     */
    @Override
    public void delete(String id) throws IllegalAccessException {
        notNull(get(id), "The FAQ couldn't be null");

        /**
         * A default MongoRepository method
         * @see FAQRepository#deleteById(Object)  ()
         */
        repository.deleteById(id);
    }

    /**
     * The method for validation of correctness a data during the <b>update</b> operation
     * @param id of the FAQ, that must be updated
     * @param faq a new body for the database's FAQ
     * @return the updated FAQ from the database
     * @throws IllegalAccessException in case when a FAQ with @param id don't exist or @param id is NULL
     */
    @Override
    public FAQ update(String id, FAQ faq) throws IllegalAccessException {
        notNull(get(id), "Entity for updating can't be null");

        return repository.save(faq);
    }
}
