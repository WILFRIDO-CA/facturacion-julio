package com.facturacion.talent.models.DAO;

import java.util.List;

import com.facturacion.talent.models.entity.Factura;

public interface IFacturaDAO {

    public List<Factura> findAll();
    public void save(Factura factura);
    public Factura findOne(Long id);
    public void delete(Long id);

}
