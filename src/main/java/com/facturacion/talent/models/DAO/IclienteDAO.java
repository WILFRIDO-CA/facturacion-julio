package com.facturacion.talent.models.DAO;

import java.util.List;

import com.facturacion.talent.models.entity.Cliente;

public interface IclienteDAO {
    
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);

    

}
