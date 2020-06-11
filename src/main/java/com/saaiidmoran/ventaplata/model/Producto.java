package com.saaiidmoran.ventaplata.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private int idproducto;
    
    @Column(name = "nombre", length = 100)
    @Basic(optional = false)
    private String nombre;    
    @Column(name = "precioinv")
    @Basic(optional = false)
    private double precioinv;    
    @Column(name = "preciovent")
    @Basic(optional = false)
    private double preciovent;    
    @Column(name = "fecharegistro", length = 10)
    @Basic(optional = false)
    private String fecharegistro;
    
    @JsonManagedReference(value = "venta-producto")
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Venta.class, mappedBy = "idproducto")
    private List<Venta> ventas;
    
    @JsonBackReference(value = "estatusproducto-producto")
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_idestatusproducto"), name = "idestatusproducto")
    private Estatusproducto idestatusproducto;

    public Producto() {
    }

    public Producto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(int idproducto, String nombre, double precioInv, double precioVent, String fechaRegistro) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.precioinv = precioInv;
        this.preciovent = precioVent;
        this.fecharegistro = fechaRegistro;
    }

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioinv() {
		return precioinv;
	}

	public void setPrecioinv(double precioinv) {
		this.precioinv = precioinv;
	}

	public double getPreciovent() {
		return preciovent;
	}

	public void setPreciovent(double preciovent) {
		this.preciovent = preciovent;
	}

	public String getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}


	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Estatusproducto getIdestatusproducto() {
		return idestatusproducto;
	}

	public void setIdestatusproducto(Estatusproducto idestatusproducto) {
		this.idestatusproducto = idestatusproducto;
	}
    
}
