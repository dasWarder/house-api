package com.house.entity.instruction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Step {

    @Field(value = "point")
    private List<String> point;

    public Step(List<String> point) {
        this.point = point;
    }
}
