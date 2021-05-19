package com.house.service.faq;

import com.house.entity.faq.FAQ;

import java.util.List;

/**
 * Interface that describe methods for FAQ service
 */
public interface FAQService {
    /**
     * Service method for delegating the FAQ dao layer to get all FAQ's from database
     * @return a collection of all FAQ's from the database
     */
    List<FAQ> getAll();

    /**
     * Service method for delegating the FAQ dao layer to store @param faq to database
     * @param faq for storing
     * @return the FAQ stored to the database
     */
    FAQ save(FAQ faq);

    /**
     * Service method for delegating the FAQ dao layer to get a FAQ by @param id from the database
     * @param id of the FAQ, that must be received
     * @return the FAQ received from the database
     * @throws IllegalAccessException in case when a FAQ with @param id don't exist or @param id is NULL
     */
    FAQ get(String id) throws IllegalAccessException;

    /**
     * Service method for delegating the FAQ dao layer to delete a FAQ with @param id form database
     * @param id of the FAQ, that must be removed
     * @throws IllegalAccessException in case when a FAQ with @param id don't exist or @param id is NULL
     */
    void delete(String id) throws IllegalAccessException;

    /**
     * Service method for delegating the FAQ dao layer to update a database's FAQ with @param id
     * @param id of the FAQ, that must be updated
     * @param faq a new body for the database's FAQ
     * @return a new updated FAQ
     * @throws IllegalAccessException in case when a FAQ with @param id don't exist or @param id is NULL
     */
    FAQ update(String id, FAQ faq) throws IllegalAccessException;
}
