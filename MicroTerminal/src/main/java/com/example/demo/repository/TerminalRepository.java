package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Terminal;

public interface TerminalRepository extends MongoRepository<Terminal, Integer> {

}
