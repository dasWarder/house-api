package com.house.entity.faq;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Question {

    @Field(value = "text")
    private String text;

    @Field(value = "solution")
    private String solution;

    public Question(String text, String solution) {
        this.text = text;
        this.solution = solution;
    }
}
