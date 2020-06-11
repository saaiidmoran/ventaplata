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
@Table(name = "cliente")
public class Cliente implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private int idcliente;
    
    @Column(name = "nombre", length = 45)
    @Basic(optional = false)
    private String nombre;    
    @Column(name = "notelefonico", length = 10)
    @Basic(optional = false)
    private String notelefonico;    
    @Column(name = "correo", length = 45)
    @Basic(optional = false)
    private String correo;    
    @Column(name = "domicilio", length = 100)
    @Basic(optional = false)
    private String domicilio;
    
    @JsonManagedReference(value = "cliente-detalleventa")
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Detalleventa.class, mappedBy = "idcliente")
    private List<Detalleventa> detallesVenta;

    public Cliente() {
    }

    public Cliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(int idcliente, String nombre, String noTelefonico, String correo, String domicilio) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.notelefonico = noTelefonico;
        this.correo = correo;
        this.domicilio = domicilio;
    }

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNotelefonico() {
		return notelefonico;
	}

	public void setNotelefonico(String notelefonico) {
		this.notelefonico = notelefonico;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<Detalleventa> getDetalleventaCollection() {
		return detallesVenta;
	}

	public void setDetalleventaCollection(List<Detalleventa> detalleventaCollection) {
		this.detallesVenta = detalleventaCollection;
	}
    
}
