package com.coffee.demoCoffeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.demoCoffeeApp.model.DetallesFacturacionModel;

public interface  DetallesFacturacionRepository extends JpaRepository<DetallesFacturacionModel,Long> {
    
}
