package com.house.service.instruction;

import com.house.entity.instruction.Instruction;
import com.house.repository.instruction.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
public class InstructionServiceImpl implements InstructionService{

    private final InstructionRepository repository;

    @Autowired
    public InstructionServiceImpl(InstructionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Instruction> getInstructions() {
        List<Instruction> instructions = repository.findAll();
        notNull(instructions, "Collection couldn't be null");

        return instructions;
    }
}
