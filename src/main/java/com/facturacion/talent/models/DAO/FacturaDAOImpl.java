package com.facturacion.talent.models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.talent.models.entity.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class FacturaDAOImpl implements  IFacturaDAO{

    @PersistenceContext
    private EntityManager em;

    
    @Override
    @Transactional
    public void delete(Long id) {
        try {
            em.remove(this.findOne(id));;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }


    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Factura> findAll() {
        return em.createQuery("from Factura").getResultList();
        
    }

    @Transactional(readOnly = true)
    @Override
    public Factura findOne(Long id) {
        return em.find(Factura.class, id);
    }

    @Override
    @Transactional
    public void save(Factura factura) {
        if(factura.getId() != null && factura.getId() > 0){
            try {
                em.merge(factura);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                em.persist(factura);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    

}
