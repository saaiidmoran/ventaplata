package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer>{
	
	public Venta findByIdventa(Integer idventa);

}
