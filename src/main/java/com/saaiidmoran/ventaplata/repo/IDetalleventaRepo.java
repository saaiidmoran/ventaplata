package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Detalleventa;

public interface IDetalleventaRepo extends JpaRepository<Detalleventa, Integer>{
	
	public Detalleventa findByIddetalleventa(Integer iddetalleventa);
	public Detalleventa findByFecha(String fecha);
	public Detalleventa findByTotal(double total);
	public Detalleventa findByAbono(double abono);

}
