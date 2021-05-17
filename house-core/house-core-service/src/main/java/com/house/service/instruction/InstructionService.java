package com.house.service.instruction;

import com.house.entity.faq.FAQ;
import com.house.entity.instruction.Instruction;

import java.util.List;

public interface InstructionService {

    List<Instruction> getAll();

    Instruction save(Instruction instruction);

    Instruction get(String id) throws IllegalAccessException;

    void delete(String id) throws IllegalAccessException;

    Instruction update(String id, Instruction instruction) throws IllegalAccessException;
}
