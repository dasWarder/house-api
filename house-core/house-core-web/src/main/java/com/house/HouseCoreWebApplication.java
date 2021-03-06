package com.house;

import com.house.repository.faq.FAQRepository;
import com.house.repository.instruction.InstructionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Main class and endpoint for the application
 * @author dasWarder
 * @version 0.3.0
 */
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {FAQRepository.class, InstructionRepository.class})
@PropertySource("classpath:application.yaml")
public class HouseCoreWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseCoreWebApplication.class, args);
    }
}
