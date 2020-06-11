package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{
	
	Cliente findByIdcliente(Integer idcliente);
	Cliente findByNombre(String nombre);
	Cliente findByNotelefonico(String noTelefonico);
	Cliente findByCorreo(String correo);
	Cliente findByDomicilio(String domicilio);

}
