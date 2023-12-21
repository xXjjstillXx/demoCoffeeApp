package com.coffee.demoCoffeeApp.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coffee.demoCoffeeApp.dto.ComprobanteDTO;
import com.coffee.demoCoffeeApp.dto.LineaDTO;
import com.coffee.demoCoffeeApp.model.ClienteModel;
import com.coffee.demoCoffeeApp.model.ComprobanteModel;
import com.coffee.demoCoffeeApp.model.LineaModel;
import com.coffee.demoCoffeeApp.model.ProductoModel;
import com.coffee.demoCoffeeApp.model.WorldClock;
import com.coffee.demoCoffeeApp.repository.ClienteRepository;
import com.coffee.demoCoffeeApp.repository.ComprobanteRepository;
import com.coffee.demoCoffeeApp.repository.ProductoRepository;

@Service
public class ComprobanteService {
    
    @Autowired
    private ComprobanteRepository comprobanteRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private RestTemplate restTemplate;


    public List<ComprobanteDTO> findAll(){
        return crearComprobantesDTO(this.comprobanteRepository.findAll());
    }

    public ComprobanteDTO create(ComprobanteModel comprobante) {
        Boolean existeCliente = existeCliente(comprobante.getCliente());
		
		Boolean existenProductos = existenProductos(comprobante.getLineas());
		
		Boolean existeStock = existeStock(comprobante.getLineas());
		
		if (existeCliente && existenProductos && existeStock) {
			
			var comprobanteAGuardar = armarComprobante(comprobante);
			
			actualizarStock(comprobanteAGuardar.getLineas());
			
			return crearComprobanteDTO(this.comprobanteRepository.save(comprobanteAGuardar));
		} else {
			return new ComprobanteDTO();
		}
    }

    private void actualizarStock(Set<LineaModel> lineas) {
		for (LineaModel linea : lineas) {
			
			var cantidadVendida = linea.getCantidad();
			var producto = linea.getProducto();
			
			var productoDB = this.productoRepository.getReferenceById(producto.getId());
			var stock = productoDB.getCantidad();
			var nuevoStock = stock - cantidadVendida;
			productoDB.setCantidad(nuevoStock);
			
			this.productoRepository.save(productoDB);
		}
		
	}

     public ComprobanteDTO findById(Long id){
        var opCliente =  this.comprobanteRepository.findById(id);
		if (opCliente.isPresent()) {
			return crearComprobanteDTO(opCliente.get());
		} else {
			return new ComprobanteDTO();
		}
    }

    private List<ComprobanteDTO> crearComprobantesDTO(List<ComprobanteModel> comprobantes) {
		List<ComprobanteDTO> comprobantesDTOs = new ArrayList<ComprobanteDTO>();
		for (ComprobanteModel comprobante : comprobantes) {
			comprobantesDTOs.add(this.crearComprobanteDTO(comprobante));
		}
		
		return comprobantesDTOs;
	}

    private ComprobanteDTO crearComprobanteDTO(ComprobanteModel comprobante) {
		ComprobanteDTO dto = new ComprobanteDTO();
		
		dto.setComprobanteid(comprobante.getId());

		dto.setCantidad(comprobante.getCantidad());

		dto.setFecha(comprobante.getFechaCreacion());

		dto.setTotal(comprobante.getValorTotal());

		dto.setCliente(comprobante.getCliente());

		dto.setLineas(crearLineasDTO(comprobante.getLineas()));
		
		return dto;
	}

    private Set<LineaDTO> crearLineasDTO(Set<LineaModel> lineas) {
		Set<LineaDTO> dtos = new HashSet<LineaDTO>();
		
		for (LineaModel linea : lineas) {
			
			LineaDTO dto = new LineaDTO();
			
			dto.setLineaid(linea.getId());

			dto.setCantidad(linea.getCantidad());

			dto.setDescripcion(linea.getDescripcion());

			dto.setPrecio(linea.getTotal());
			
			dtos.add(dto);
			
		}
		
		return dtos;
	}

    private ComprobanteModel armarComprobante(ComprobanteModel comprobante) {
        var comprobanteAGuardar = new ComprobanteModel();
        
        comprobanteAGuardar.setCliente(this.clienteRepository.findById(comprobante.getCliente().getId()).get());
        
        WorldClock worldClock = this.restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", WorldClock.class);
        String currentDateTime = worldClock.getCurrentDateTime();
        try {
            Date date1=new SimpleDateFormat("yyyy-MM-dd'T'mm:ss'Z'").parse(currentDateTime);
            comprobanteAGuardar.setFechaCreacion(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            comprobanteAGuardar.setFechaCreacion(new Date());
        } 
        
        comprobanteAGuardar.setLineas(new HashSet<LineaModel>());
        for (LineaModel linea : comprobante.getLineas()) {
            comprobanteAGuardar.addLinea(crearLinea(linea));
        }

		comprobanteAGuardar.setValorTotal(calcularTotal(comprobanteAGuardar.getLineas()));
		comprobanteAGuardar.setCantidad(comprobante.getLineas().size());
		
		return comprobanteAGuardar;
	}

    private BigDecimal calcularTotal(Set<LineaModel> lineas) {
		BigDecimal total = new BigDecimal("0");
		
		for (LineaModel linea : lineas) {
			total = total.add(new BigDecimal(linea.getTotal().toString()));
		}
		
		return total;
	}

    private LineaModel crearLinea(LineaModel linea) {
		LineaModel lineaAGuardar = new LineaModel();
		
		ProductoModel productoDB = this.productoRepository.findById(linea.getProducto().getId()).get();
		lineaAGuardar.setCantidad(linea.getCantidad());
		lineaAGuardar.setDescripcion(productoDB.getDescripcion());
		lineaAGuardar.setTotal(productoDB.getPrecio());
		lineaAGuardar.setProducto(productoDB);
		
		return lineaAGuardar;
	}

    private Boolean existeStock(Set<LineaModel> lineas) {
            for (LineaModel linea : lineas) {
                var productoid = linea.getProducto().getId();
                var opProducto = this.productoRepository.findById(productoid);
                if (opProducto.isEmpty()) {
                    return false;
                }
                if (linea.getCantidad() < opProducto.get().getCantidad()) {
                    return true;
                }
            }
            return false;
        }
    
    private Boolean existenProductos(Set<LineaModel> lineas) {
        for (LineaModel linea : lineas) {
            var productoId = linea.getProducto().getId();
            var opProducto = this.productoRepository.findById(productoId);
            if (opProducto.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    private Boolean existeCliente(ClienteModel cliente) {
        var opCliente = this.clienteRepository.findById(cliente.getId());
        return !opCliente.isEmpty();
    }

    public void delete(Long id){
        this.comprobanteRepository.deleteById(id);
    }
    
}
