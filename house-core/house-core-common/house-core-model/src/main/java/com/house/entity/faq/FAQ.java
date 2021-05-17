package com.house.entity.faq;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "id")
@Document(collection = "faq")
public class FAQ {

    @Id
    private String id;

    @Field(value = "position")
    @Indexed
    private String position;

    @Field(value = "question")
    private List<Question> questions;

    public FAQ(String position, List<Question> questions) {
        this.position = position;
        this.questions = questions;
    }
}
