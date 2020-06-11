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

import com.saaiidmoran.ventaplata.model.Estatusventa;
import com.saaiidmoran.ventaplata.servicedao.EstatusventaDaoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/estatusventaVPRest")
public class RestEstatusventaController {
	
	@Autowired
	private EstatusventaDaoService evds;
	
	@GetMapping
	public List<Estatusventa> selectAll() {
		return evds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public Estatusventa selectById(@PathVariable("id") Integer id) {
		return evds.selectById(id);
	}
	
	@GetMapping(value = "/buscarPorEstatusventa/{ev}")
	public Estatusventa selectByEstatusventa(@PathVariable("ev")String ev) {
		return evds.selectByEstatusventa(ev);
	}
	
	@PostMapping
	public Estatusventa insert(@RequestBody Estatusventa ev) {
		return evds.insert(ev);
	}
	
	@PutMapping(value = "/{id}")
	public Estatusventa update(@RequestBody Estatusventa ev, @PathVariable("id") Integer id) {
		return evds.update(ev, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("/{id}") Integer id) {
		evds.delete(id);
	}
	
}
