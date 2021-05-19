package com.house.service.instruction;

import com.house.entity.instruction.Instruction;

import java.util.List;

/**
 * Interface that describe methods forInstruction service
 */
public interface InstructionService {

    /**
     * Service method for delegating the Instruction dao layer to get all Instructions from database
     * @return a collection of all Instructions from the database
     */
    List<Instruction> getAll();

    /**
     * Service method for delegating the Instruction dao layer to store @param instruction to the database
     * @param instruction for storing
     * @return the Instruction stored to the database
     */
    Instruction save(Instruction instruction);

    /**
     * Service method for delegating the Instruction dao layer to get an Instruction by @param id from the database
     * @param id of the Instruction, that must be received
     * @return the Instruction received from the database
     * @throws IllegalAccessException in case when an Instruction with @param id don't exist or @param id is NULL
     */
    Instruction get(String id) throws IllegalAccessException;

    /**
     * Service method for delegating the Instruction dao layer to delete an Instruction with @param id form database
     * @param id of the Instruction, that must be removed
     * @throws IllegalAccessException in case when an Instruction with @param id don't exist or @param id is NULL
     */
    void delete(String id) throws IllegalAccessException;

    /**
     * Service method for delegating the Instruction dao layer to update a database's Instruction with @param id
     * @param id of the Instruction, that must be updated
     * @param instruction a new body for the database's Instruction
     * @return a new updated Instruction
     * @throws IllegalAccessException in case when an Instruction with @param id don't exist or @param id is NULL
     */
    Instruction update(String id, Instruction instruction) throws IllegalAccessException;
}
