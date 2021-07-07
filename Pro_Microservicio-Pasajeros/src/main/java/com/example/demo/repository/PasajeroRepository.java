package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Pasajero;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Integer> {

}
