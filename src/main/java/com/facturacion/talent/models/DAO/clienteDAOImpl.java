package com.facturacion.talent.models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.talent.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class clienteDAOImpl implements IclienteDAO {

    @PersistenceContext 
    private EntityManager el;

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            el.remove(this.findOne(id));
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return el.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return  el.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId() > 0){
            el.merge(cliente);
        }else{
            el.persist(cliente);
        }
        
    }

}
