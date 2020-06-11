package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Estatusproducto;

public interface IEstatusproductoRepo extends JpaRepository<Estatusproducto, Integer>{

	Estatusproducto findByEstatusproducto(String estatusproducto);
	Estatusproducto findByIdestatusProducto(Integer idestatusproducto);
	
}
