package com.saaiidmoran.ventaplata.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saaiidmoran.ventaplata.servicedao.ClienteDaoService;
import com.saaiidmoran.ventaplata.model.Cliente;;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/clienteVPRest")
public class RestClienteController {
	
	@Autowired
	ClienteDaoService cds;
	
	@GetMapping
	public List<Cliente> selectAll() {
		return cds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public Cliente selectById(@PathVariable("id") Integer id) {
		return cds.selectById(id);
	}
	
	@GetMapping(value = "/buscarPorNombre/{nombre}")
	public Cliente selectByNombre(@PathVariable("nombre") String nombre) {
		return cds.selectByNombre(nombre);
	}
	
	@GetMapping(value = "/buscarPorCorreo/{correo}")
	public Cliente selectByCorreo(@PathVariable("correo") String correo) {
		return cds.selectByCorreo(correo);
	}
	
	@GetMapping(value = "/buscarPorDomicilio/{domicilio}")
	public Cliente selectByDomicilio(@PathVariable("domicilio") String domicilio) {
		return cds.selectByDomicilio(domicilio);
	}
	
	@GetMapping(value = "/buscarPorNotelefonico/{notelefonico}")
	public Cliente selectByNotelefonico(@PathVariable("notelefonico") String noTelefonico) {
		return cds.selectByNotelefonico(noTelefonico);
	}
	
	@PostMapping
	public Cliente insert(@RequestBody Cliente c) {
		return cds.insert(c);
	}
	
	@PutMapping(value = "/{id}")
	public Cliente update(@RequestBody Cliente c, @PathVariable("id") Integer id) {
		return cds.update(c, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		cds.delete(id);
	}
	
}
