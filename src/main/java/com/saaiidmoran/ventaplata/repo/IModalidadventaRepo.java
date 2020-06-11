package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Modalidadventa;

public interface IModalidadventaRepo extends JpaRepository<Modalidadventa, Integer>{
	
	Modalidadventa findByIdmodalidadventa(Integer id);
	Modalidadventa findByModalidadventa(String modalidad);

}
