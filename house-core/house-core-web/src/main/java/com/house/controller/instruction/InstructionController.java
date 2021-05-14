package com.house.controller.instruction;


import com.house.entity.instruction.Instruction;
import com.house.service.instruction.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/house-api")
public class InstructionController {

    private final InstructionService instructionService;

    @Autowired
    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }


    @GetMapping(value = "/instructions")
    public List<Instruction> getInstructions() {
        return instructionService.getInstructions();
    }
}
