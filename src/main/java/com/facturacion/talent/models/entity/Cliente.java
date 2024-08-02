package com.facturacion.talent.models.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "clientes")
public class Cliente {

    private static final long serialVersionUID = 2990602918676380780L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    
    @Column(name = "numero_telefono", unique = true)
    private String numeroTelefono;
    @Column(name = "dia_creacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date diaCreacion;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setNumeroTelelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    public Date getDiaCreacion() {
        return diaCreacion;
    }
    public void setDiaCreacion(Date diaCreacion) {
        this.diaCreacion = diaCreacion;
    }
}