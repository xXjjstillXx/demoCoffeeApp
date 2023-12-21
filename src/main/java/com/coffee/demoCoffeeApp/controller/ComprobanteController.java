package com.coffee.demoCoffeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.demoCoffeeApp.dto.ComprobanteDTO;
import com.coffee.demoCoffeeApp.model.ComprobanteModel;
import com.coffee.demoCoffeeApp.services.ComprobanteService;




@RequestMapping(path = "api/comprobante")
@RestController
public class ComprobanteController {
    
    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/findAll")
    public List<ComprobanteDTO> findAll() {
        return this.comprobanteService.findAll();
    }
    

    @PostMapping
	public ComprobanteDTO newEntity(@RequestBody ComprobanteModel comprobante) {
		return this.comprobanteService.create(comprobante);
	}

    @GetMapping("/{id}")
	public ComprobanteDTO one(@PathVariable Long id) {
		
		return this.comprobanteService.findById(id);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> findById(@PathVariable Long id){
    //     return new ResponseEntity<>(this.comprobanteService.findById(id),HttpStatus.OK);
    // }
}
