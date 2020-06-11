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
@Table(name = "usuario")
public class Usuario implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idusuario;
    
    @Column(name = "usrnombre", length = 45)
    @Basic(optional = false)
    private String usrnombre;    
    @Column(name = "clave")
    @Basic(optional = false)
    private String clave;
    
    @JsonManagedReference(value = "usuario-detalleventa") 
    @OneToMany(fetch = FetchType.EAGER,targetEntity = Detalleventa.class, mappedBy = "idusuario")
    private List<Detalleventa> detallesVenta;

    public Usuario() {
    }

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(int idusuario, String usrnombre, String clave) {
        this.idusuario = idusuario;
        this.usrnombre = usrnombre;
        this.clave = clave;
    }

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsrnombre() {
		return usrnombre;
	}

	public void setUsrnombre(String usrnombre) {
		this.usrnombre = usrnombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Detalleventa> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<Detalleventa> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}  
    
}
