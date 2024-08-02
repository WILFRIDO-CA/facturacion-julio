package com.facturacion.talent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.talent.DTO.FacturaDTO;
import com.facturacion.talent.models.DAO.IFacturaDAO;
import com.facturacion.talent.models.DAO.IclienteDAO;
import com.facturacion.talent.models.entity.Cliente;
import com.facturacion.talent.models.entity.Factura;


@RestController
public class FacturaController {

    @Autowired
    private IFacturaDAO facturaDAO;

    @Autowired
    private IclienteDAO clienteDAO;
    
    @RequestMapping(path="/factura", method=RequestMethod.GET)
    public List<Factura> FacturaList(){
        return facturaDAO.findAll();
    }

    @GetMapping("/factura/{id}")
    public Factura getClienteByID(@PathVariable( name = "id") Long id){
        return facturaDAO.findOne(id);
    }

    @DeleteMapping("/factura/{id}")
    public void deleteFactura(@PathVariable( name = "id",required=true) Long id){
        try {
            facturaDAO.delete(id);
        } catch (final IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @PostMapping("/guardar-factura")
    public ResponseEntity<?> createFactura(@RequestBody FacturaDTO facturaDTO){
        Factura facturaAux = new Factura();
        Cliente clienteAux = new Cliente();

        try {
            facturaAux.setFecha(facturaDTO.getFecha());
            facturaAux.setMonto(facturaDTO.getMonto());
            facturaAux.setDetalle(facturaDTO.getDetalle());


            clienteAux = clienteDAO.findOne(facturaDTO.getCliente());

            facturaAux.setCliente(clienteAux);
            facturaDAO.save(facturaAux);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Comuniquse con el administradosr");
        }

            return ResponseEntity.status(HttpStatus.CREATED).body("Factura creada exitosamente: ");
    }

}
