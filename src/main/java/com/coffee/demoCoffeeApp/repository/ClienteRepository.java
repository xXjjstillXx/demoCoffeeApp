package com.coffee.demoCoffeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.demoCoffeeApp.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
    
}
