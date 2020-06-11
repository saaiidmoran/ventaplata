package com.saaiidmoran.ventaplata.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "estatusproducto")
public class Estatusproducto implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestatusproducto")
    private int idestatusProducto;
    
    @Column(name = "estatusproducto", length = 45)
    @Basic(optional = false)
    private String estatusproducto;
    
    @JsonManagedReference(value = "estatusproducto-producto")
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Producto.class, mappedBy = "idestatusproducto")
    private List<Producto> productos;

    public Estatusproducto() {
    }

    public Estatusproducto(int idestatusProducto) {
        this.idestatusProducto = idestatusProducto;
    }

    public Estatusproducto(int idestatusProducto, String estatusProducto) {
        this.idestatusProducto = idestatusProducto;
        this.estatusproducto = estatusProducto;
    }

	public int getIdestatusProducto() {
		return idestatusProducto;
	}

	public void setIdestatusProducto(int idestatusProducto) {
		this.idestatusProducto = idestatusProducto;
	}

	public String getEstatusproducto() {
		return estatusproducto;
	}

	public void setEstatusproducto(String estatusproducto) {
		this.estatusproducto = estatusproducto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
    
    
}
