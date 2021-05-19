package com.house.controller.instruction;

import com.house.entity.instruction.Instruction;
import com.house.service.instruction.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The rest controller that provide an entrypoint for interaction with instructions
 */
@RestController
@RequestMapping(value = "/house-api/instructions")
public class InstructionController {

    /**
     * The field of the service layer bean
     */
    private InstructionService service;

    @Autowired
    public InstructionController(InstructionService service) {
        this.service = service;
    }

    /**
     * A method for receiving the collection of Instructions from DB
     * @return Response entity with OK status and the list of all Instructions
     */
    @GetMapping
    public ResponseEntity<List<Instruction>> getAll() {
        /**
         * @see InstructionService#getAll()
         */
        List<Instruction> instructions = service.getAll();

        return new ResponseEntity<>(instructions, HttpStatus.OK);
    }

    /**
     * A method to save provided @param Instruction entity to database
     * @param instruction the body of an instruction, send by a client
     * @return Response entity with CREATED status and received from DB Instruction
     */
    @PostMapping(value = "/instruction")
    public ResponseEntity<Instruction> save(@RequestBody Instruction instruction) {
        /**
         * @see InstructionService#save(Instruction)
         */
        Instruction savedInstruction = service.save(instruction);

        return new ResponseEntity<>(savedInstruction, HttpStatus.CREATED);
    }
    /**
     * A method for receiving an Instruction from DB by @param id
     * @param id of the the Instruction, must be not NULL
     * @return Response entity with OK status and the Instruction from DB
     * @throws IllegalAccessException in case when the Instruction with @param id doesn't exist or @param id is NULL
     */
    @GetMapping(value = "/instruction/{id}")
    public ResponseEntity<Instruction> get(@PathVariable("id") String id) throws IllegalAccessException {
        /**
         * @see InstructionService#get(String)
         */
        Instruction instruction = service.get(id);

        return new ResponseEntity<>(instruction, HttpStatus.OK);
    }

    /**
     * A method for updating an Instruction that already stored in DB
     * @param id of the Instruction that must be updated
     * @param instruction a new body for the Instruction
     * @return Response entity with OK status and a new Instruction
     * @throws IllegalAccessException in case when the Instruction with @param id don't exist or @param id is NULL
     */
    @PutMapping(value = "/instruction/{id}")
    public ResponseEntity<Instruction> update(@PathVariable("id") String id, @RequestBody Instruction instruction) throws IllegalAccessException {
        /**
         * @see InstructionService#update(String, Instruction)
         */
        Instruction updated = service.update(id, instruction);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    /**
     * A method for removing an Instruction with @param id from DB
     * @param id of the Instruction that must be deleted
     * @return Response entity with OK status and info message
     * @throws IllegalAccessException in case when the Instruction with @param id don't exist or @param id is NULL
     */
    @DeleteMapping(value = "/instruction/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) throws IllegalAccessException {
        service.delete(id);

        return new ResponseEntity<>(String.format("The Instruction with id=%s was successfully delete", id), HttpStatus.OK);
    }
}
