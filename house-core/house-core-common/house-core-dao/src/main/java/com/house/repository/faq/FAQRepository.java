package com.house.repository.faq;

import com.house.entity.faq.FAQ;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends MongoRepository<FAQ, String> {
}
