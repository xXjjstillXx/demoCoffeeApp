package com.coffee.demoCoffeeApp.repository;

import com.coffee.demoCoffeeApp.model.ComprobanteModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface ComprobanteRepository extends JpaRepository<ComprobanteModel,Long> {

    @Override
    Optional<ComprobanteModel> findById(Long id_ventas);
}
