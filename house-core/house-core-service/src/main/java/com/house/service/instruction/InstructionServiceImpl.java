package com.house.service.instruction;

import com.house.entity.instruction.Instruction;
import com.house.repository.faq.FAQRepository;
import com.house.repository.instruction.InstructionRepository;
import com.house.service.faq.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

/**
 * Service layer that implement Instruction Service interface.
 * The layer between controller and dao layers for checking correctness of a data
 */
@Service
public class InstructionServiceImpl implements InstructionService{

    /**
     * The field of dao layer bean
     */
    private InstructionRepository repository;

    @Autowired
    public InstructionServiceImpl(InstructionRepository repository) {
        this.repository = repository;
    }

    /**
     * The method for validation of correctness a data during the <b>getAll</b> operation
     * @see InstructionService#getAll() description
     * @return a collection of all Instructions
     */
    @Override
    public List<Instruction> getAll() {
        /**
         * A default MongoRepository method
         * @see InstructionRepository#findAll()
         */
        List<Instruction> instructions = repository.findAll();
        notNull(instructions, "The collection couldn't be null");

        return instructions;
    }

    /**
     * The method for validation of correctness a data during the <b>save</b> operation
     * @see InstructionService#save description
     * @param instruction for storing
     * @return a stored Instruction object
     */
    @Override
    public Instruction save(Instruction instruction) {
        notNull(instruction, "The Instruction couldn't be null");

        /**
         * A default MongoRepository method
         * @see InstructionRepository#save(Object) ()
         */
        return repository.save(instruction);
    }

    /**
     * The method for validation of correctness a data during the <b>get</b> operation
     * @param id of the Instruction, that must be received
     * @return an Instruction from database
     * @throws IllegalAccessException in case when an Instruction with @param id don't exist or @param id is NULL
     */
    @Override
    public Instruction get(String id) throws IllegalAccessException {

        /**
         * A default MongoRepository method
         * @see InstructionRepository#findById(Object) ()
         */
        Optional<Instruction> possibleInstruction = repository.findById(id);

        if(!possibleInstruction.isPresent()) {
            throw new IllegalAccessException("Getting Instruction couldn't be null");
        }

        return possibleInstruction.get();
    }

    /**
     * The method for validation of correctness a data during the <b>delete</b> operation
     * @param id of the Instruction, that must be removed
     * @throws IllegalAccessException in case when an Instruction with @param id don't exist or @param id is NULL
     */
    @Override
    public void delete(String id) throws IllegalAccessException {
            notNull(get(id), "The Instruction couldn't be null");

        /**
         * A default MongoRepository method
         * @see InstructionRepository#deleteById(Object)  ()
         */
            repository.deleteById(id);
    }

    /**
     * The method for validation of correctness a data during the <b>update</b> operation
     * @param id of the Instruction, that must be updated
     * @param instruction a new body for the database's Instruction
     * @return the updated Instruction from the database
     * @throws IllegalAccessException in case when an Instruction with @param id don't exist or @param id is NULL
     */
    @Override
    public Instruction update(String id, Instruction instruction) throws IllegalAccessException {
        notNull(get(id), "Entity for updating can't be null");

        return repository.save(instruction);
    }
}
