package com.house.entity.instruction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "id")
@Document(collection = "instruction")
public class Instruction {

    @Id
    private String id;

    @Field(value = "problem_name")
    private String problemName;

    @Field(value = "video_link")
    private String videoLink;

    @Field(value = "step")
    private List<Step> steps;

    public Instruction(String problemName, String videoLink, List<Step> steps) {
        this.problemName = problemName;
        this.videoLink = videoLink;
        this.steps = steps;
    }
}
