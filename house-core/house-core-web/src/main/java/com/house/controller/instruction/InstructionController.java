package com.house.controller.instruction;


import com.house.entity.faq.FAQ;
import com.house.entity.instruction.Instruction;
import com.house.service.instruction.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/house-api/instructions")
public class InstructionController {

    private InstructionService service;

    @Autowired
    public InstructionController(InstructionService service) {
        this.service = service;
    }


    @GetMapping
    public List<Instruction> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/instruction")
    public ResponseEntity<Instruction> save(@RequestBody Instruction instruction) {
        Instruction savedInstruction = service.save(instruction);

        return new ResponseEntity<>(savedInstruction, HttpStatus.CREATED);
    }

    @GetMapping(value = "/instruction/{id}")
    public ResponseEntity<Instruction> get(@PathVariable("id") String id) throws IllegalAccessException {
        Instruction instruction = service.get(id);

        return new ResponseEntity<>(instruction, HttpStatus.OK);
    }

    @PutMapping(value = "/instruction/{id}")
    public ResponseEntity<Instruction> update(@PathVariable("id") String id, @RequestBody Instruction instruction) throws IllegalAccessException {
        Instruction updated = service.update(id, instruction);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping(value = "/instruction/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) throws IllegalAccessException {
        service.delete(id);

        return new ResponseEntity<>(String.format("The Instruction with id=%s was successfully delete", id), HttpStatus.OK);
    }
}
