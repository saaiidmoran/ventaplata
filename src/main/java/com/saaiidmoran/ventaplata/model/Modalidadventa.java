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
@Table(name = "modalidadventa")
public class Modalidadventa implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmodalidadventa")
    private int idmodalidadventa;    
    
    @Column(name = "modalidadventa", length = 45)
    @Basic(optional = false)
    private String modalidadventa;
    
    @JsonManagedReference(value = "modalidadventa-detalleventa") 
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Detalleventa.class, mappedBy = "idmodalidadventa")
    private List<Detalleventa> detallesVenta;

    public Modalidadventa() {
    }

    public Modalidadventa(int idmodalidadVenta) {
        this.idmodalidadventa = idmodalidadVenta;
    }

    public Modalidadventa(int idmodalidadVenta, String modalidad) {
        this.idmodalidadventa = idmodalidadVenta;
        this.modalidadventa = modalidad;
    }

	public int getIdmodalidadventa() {
		return idmodalidadventa;
	}

	public void setIdmodalidadventa(int idmodalidadventa) {
		this.idmodalidadventa = idmodalidadventa;
	}

	public String getModalidadventa() {
		return modalidadventa;
	}

	public void setModalidadventa(String modalidadventa) {
		this.modalidadventa = modalidadventa;
	}

	public List<Detalleventa> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<Detalleventa> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}    
    
}
