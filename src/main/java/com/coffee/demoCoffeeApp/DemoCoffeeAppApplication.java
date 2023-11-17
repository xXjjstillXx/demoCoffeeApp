package com.coffee.demoCoffeeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coffee.demoCoffeeApp.repository.ClienteRepository;
import com.coffee.demoCoffeeApp.repository.DetallesFacturacionRepository;
import com.coffee.demoCoffeeApp.repository.FacturacionRepository;
import com.coffee.demoCoffeeApp.repository.ProductoRepository;

@SpringBootApplication
public class DemoCoffeeAppApplication {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	DetallesFacturacionRepository detallesFacturacionRepository;

	@Autowired
	FacturacionRepository facturacionRepository;

	@Autowired
 	ProductoRepository productosRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoCoffeeAppApplication.class, args);
	}

}
