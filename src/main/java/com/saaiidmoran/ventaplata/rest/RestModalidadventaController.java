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

import com.saaiidmoran.ventaplata.model.Modalidadventa;
import com.saaiidmoran.ventaplata.servicedao.ModalidadventaDaoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/modalidadventaVPRest")
public class RestModalidadventaController {
	
	@Autowired
	private ModalidadventaDaoService mvds;
	
	@GetMapping
	public List<Modalidadventa> selectAll() {
		return mvds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{idmv}")
	public Modalidadventa selectById(@PathVariable("idmv") Integer idmv) {
		return mvds.selectById(idmv);
	}
	
	@GetMapping(value = "/buscarPorModalidadventa/{mv}")
	public Modalidadventa selectByModalidadventa(@PathVariable("mv") String mv) {
		return mvds.selectByModalidadventa(mv);
	}
	
	@PostMapping
	public Modalidadventa insert(@RequestBody Modalidadventa mv) {
		return mvds.insert(mv);
	}
	
	@PutMapping(value = "/{id}")
	public Modalidadventa update(@RequestBody Modalidadventa mv, @PathVariable("id") Integer id) {
		return mvds.update(mv, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		mvds.delete(id);
	}
	
}
