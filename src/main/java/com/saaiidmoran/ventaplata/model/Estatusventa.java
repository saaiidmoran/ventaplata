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
@Table(name = "estatusventa")
public class Estatusventa implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestatusventa")
    private int idestatusventa;
    
    @Column(name = "estatusventa", length = 45)
    @Basic(optional = false)
    private String estatusventa;
    
    @JsonManagedReference(value = "estatusventa-detalleventa") 
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Detalleventa.class, mappedBy = "idestatusventa")
    private List<Detalleventa> detallesVenta;

    public Estatusventa() {
    }

    public Estatusventa(int idestatusVenta) {
        this.idestatusventa = idestatusVenta;
    }

    public Estatusventa(int idestatusVenta, String estatusVenta) {
        this.idestatusventa = idestatusVenta;
        this.estatusventa = estatusVenta;
    }

	public int getIdestatusventa() {
		return idestatusventa;
	}

	public void setIdestatusventa(int idestatusventa) {
		this.idestatusventa = idestatusventa;
	}

	public String getEstatusventa() {
		return estatusventa;
	}

	public void setEstatusventa(String estatusventa) {
		this.estatusventa = estatusventa;
	}

	public List<Detalleventa> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<Detalleventa> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}
    
}
