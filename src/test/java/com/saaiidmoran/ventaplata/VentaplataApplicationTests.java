package com.saaiidmoran.ventaplata;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.saaiidmoran.ventaplata.model.Usuario;
import com.saaiidmoran.ventaplata.repo.IUsuarioRepo;

@SpringBootTest
class VentaplataApplicationTests {
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {
		//Creación de un usuario
		Usuario us = new Usuario();
		us.setUsrnombre("roboguerrero");
		us.setClave(encoder.encode("1234"));
		
		//Se asigna a una nueva variable usuario lo que devuelva el metodo save
		Usuario retorno = repo.save(us);
		
		
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
