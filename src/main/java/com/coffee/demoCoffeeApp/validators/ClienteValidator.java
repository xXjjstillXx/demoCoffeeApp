package com.coffee.demoCoffeeApp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.coffee.demoCoffeeApp.exceptions.ClienteException;
import com.coffee.demoCoffeeApp.model.ClienteModel;
// import com.coffee.demoCoffeeApp.repository.ClienteRepository;
// import org.springframework.beans.factory.annotation.Autowired;

public class ClienteValidator {

    // @Autowired
    // ClienteRepository clienteRepository;
    
    public void validarCliente (ClienteModel cliente) throws ClienteException{
        if(cliente.getNombre().isBlank()){
            throw new ClienteException("Nombre no válido");
        }
        if(cliente.getCorreo().isBlank() || validarEmail(cliente.getCorreo()) == false){
            throw new ClienteException("Correo no válido");
        }
        if(cliente.getContrasena().isBlank()){
            throw new ClienteException("Contraseña no válida");
        }

    }

    // Trate de hacerlo aca pero me sale un error de que this.clienteRepository es null y no me dio tiempo a resolverlo
    // public void validarExistencia(Long id) throws ClienteException{
    //     if(!this.clienteRepository.existsById(id)){
    //         throw new ClienteException("El cliente no existe en base de datos");
    //     }
    // }

    private static boolean validarEmail(String correo) {
        // Patrón para validar el email
        String patron = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(patron);

        // Crear un objeto Matcher
        Matcher matcher = pattern.matcher(correo);

        // Verificar si coincide con el patrón
        return matcher.matches();
    }
}
