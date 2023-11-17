package com.coffee.demoCoffeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.demoCoffeeApp.model.ProductoModel;

public interface ProductoRepository extends JpaRepository<ProductoModel,Integer>{
    
}
