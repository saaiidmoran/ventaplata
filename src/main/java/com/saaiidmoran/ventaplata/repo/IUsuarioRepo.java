package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	Usuario findByUsrnombre(String usrnombre);
	Usuario findByIdusuario(Integer id);
	
}
