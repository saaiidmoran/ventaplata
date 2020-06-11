package com.saaiidmoran.ventaplata.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "venta")
public class Venta implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    private int idventa;
    
    @JsonBackReference(value = "detalleventa-venta")
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_iddetalleventa"), name = "iddetalleventa")    
    private Detalleventa iddetalleventa;
    
    @JsonBackReference(value = "venta-producto")
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_idproducto"), name = "idproducto")    
    private Producto idproducto;

    public Venta() {
    }

    public Venta(int idventa) {
        this.idventa = idventa;
    }

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public Detalleventa getIddetalleventa() {
		return iddetalleventa;
	}

	public void setIddetalleventa(Detalleventa iddetalleventa) {
		this.iddetalleventa = iddetalleventa;
	}

	public Producto getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}
    
}
