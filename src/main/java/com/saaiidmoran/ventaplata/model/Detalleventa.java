package com.saaiidmoran.ventaplata.model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "detalleventa")
public class Detalleventa implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalleventa")
    private int iddetalleventa;
    
    @Column(name = "fecha", length = 10)
    @Basic(optional = false)
    private String fecha;    
    @Column(name = "total")
    @Basic(optional = false)
    private double total;    
    @Column(name = "abono")
    @Basic(optional = false)
    private double abono;
    
    @JsonManagedReference(value = "detalleventa-venta")
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Venta.class, mappedBy = "iddetalleventa")
    private Collection<Venta> ventas;
    
    @JsonBackReference(value = "cliente-detalleventa")    
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_idcliente"), name = "idcliente")
    private Cliente idcliente;
    
    @JsonBackReference(value = "estatusventa-detalleventa") 
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_idestatusventa"), name = "idestatusventa")
    private Estatusventa idestatusventa;
    
    @JsonBackReference(value = "modalidadventa-detalleventa") 
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_idmodalidadventa"), name = "idmodalidadventa")
    private Modalidadventa idmodalidadventa;
    
    @JsonBackReference(value = "usuario-detalleventa") 
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_idusuario"), name = "idusuario")    
    private Usuario idusuario;

    public Detalleventa() {
    }

    public Detalleventa(int iddetalleVenta) {
        this.iddetalleventa = iddetalleVenta;
    }

    public Detalleventa(int iddetalleVenta, String fecha, double total, double abono) {
        this.iddetalleventa = iddetalleVenta;
        this.fecha = fecha;
        this.total = total;
        this.abono = abono;
    }

	public int getIddetalleventa() {
		return iddetalleventa;
	}

	public void setIddetalleventa(int iddetalleventa) {
		this.iddetalleventa = iddetalleventa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getAbono() {
		return abono;
	}

	public void setAbono(double abono) {
		this.abono = abono;
	}

	public Collection<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Collection<Venta> ventas) {
		this.ventas = ventas;
	}

	public Cliente getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}

	public Estatusventa getIdestatusventa() {
		return idestatusventa;
	}

	public void setIdestatusventa(Estatusventa idestatusventa) {
		this.idestatusventa = idestatusventa;
	}

	public Modalidadventa getIdmodalidadventa() {
		return idmodalidadventa;
	}

	public void setIdmodalidadventa(Modalidadventa idmodalidadventa) {
		this.idmodalidadventa = idmodalidadventa;
	}

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}
    
}
