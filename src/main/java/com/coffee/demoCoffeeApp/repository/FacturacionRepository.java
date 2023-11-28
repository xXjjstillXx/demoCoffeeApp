package com.coffee.demoCoffeeApp.repository;

import com.coffee.demoCoffeeApp.model.FacturacionModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface FacturacionRepository extends JpaRepository<FacturacionModel,Long> {

    @Override
    Optional<FacturacionModel> findById(Long id_ventas);
}
