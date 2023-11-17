package com.coffee.demoCoffeeApp.repository;

import com.coffee.demoCoffeeApp.model.FacturacionModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface FacturacionRepository extends JpaRepository<FacturacionModel,Integer> {

    @Override
    Optional<FacturacionModel> findById(Integer id_ventas);
}
