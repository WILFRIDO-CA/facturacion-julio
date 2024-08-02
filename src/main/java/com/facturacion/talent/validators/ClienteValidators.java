package com.facturacion.talent.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.facturacion.talent.models.entity.Cliente;

@Component
public class ClienteValidators implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
            return Cliente.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Cliente cliente =(Cliente) target;
        ValidationUtils.rejectIfEmpty(errors, "nombre", "El nombre no puede ser vacio");

        if(!cliente.getNombre().matches("[a-z,A-Z]{1,15}?[ ]?[a-z,A-Z]{1,15}")){
            errors.rejectValue("nombre", "El nombre no es valido");
        }
        if(!cliente.getNumeroTelefono().matches("[0-9]{10}")){
            errors.rejectValue("numeroTelefono", "El numero de telefono debe de ser de 10 Digitos");
        }

        if(cliente.getDiaCreacion() == null){
            errors.rejectValue("DiaCreacion", "El dia de creacion tiene que ser valido");
        }
        
        
    }
    
}
