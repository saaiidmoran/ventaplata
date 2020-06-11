package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Estatusventa;

public interface IEstatusventaRepo extends JpaRepository<Estatusventa, Integer>{
	
	Estatusventa findByIdestatusventa(Integer idestatusventa);
	Estatusventa findByEstatusventa(String estatusventa);

}
