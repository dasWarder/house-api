package com.house.service.instruction;

import com.house.entity.instruction.Instruction;
import com.house.repository.instruction.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class InstructionServiceImpl implements InstructionService{

    private InstructionRepository repository;

    @Autowired
    public InstructionServiceImpl(InstructionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Instruction> getAll() {
        List<Instruction> instructions = repository.findAll();
        notNull(instructions, "The collection couldn't be null");

        return instructions;
    }

    @Override
    public Instruction save(Instruction instruction) {
        notNull(instruction, "The Instruction couldn't be null");
        return repository.save(instruction);
    }

    @Override
    public Instruction get(String id) throws IllegalAccessException {
        Optional<Instruction> possibleInstruction = repository.findById(id);

        if(!possibleInstruction.isPresent()) {
            throw new IllegalAccessException("Getting Instruction couldn't be null");
        }

        return possibleInstruction.get();
    }

    @Override
    public void delete(String id) throws IllegalAccessException {
            notNull(get(id), "The Instruction couldn't be null");

            repository.deleteById(id);
    }

    @Override
    public Instruction update(String id, Instruction instruction) throws IllegalAccessException {
        notNull(get(id), "Entity for updating can't be null");

        return repository.save(instruction);
    }
}
