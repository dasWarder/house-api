package com.house.repository.instruction;


import com.house.entity.instruction.Instruction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends MongoRepository<Instruction, String> {

}
