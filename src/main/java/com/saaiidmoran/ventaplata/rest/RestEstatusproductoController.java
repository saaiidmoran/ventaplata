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

import com.saaiidmoran.ventaplata.model.Estatusproducto;
import com.saaiidmoran.ventaplata.servicedao.EstatusproductoDaoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/estatusproductoVPRest")
public class RestEstatusproductoController {
	
	@Autowired
	private EstatusproductoDaoService epds;
	
	@GetMapping
	public List<Estatusproducto> selectAll() {
		return epds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public Estatusproducto selectById(@PathVariable("id") Integer id) {
		return epds.selectById(id);
	}
	
	@GetMapping(value = "/buscarPorEstatusproducto/{ep}")
	public Estatusproducto selectByEstatusproducto(@PathVariable("ep") String ep) {
		return epds.selectByEstatusproducto(ep);
	}
	
	@PostMapping
	public Estatusproducto insert(@RequestBody Estatusproducto ep) {
		return epds.insert(ep);
	}
	
	@PutMapping(value = "/{id}")
	public Estatusproducto update(@RequestBody Estatusproducto ep, @PathVariable("id") Integer id) {
		return epds.update(ep, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		epds.delete(id);
	}
	

}
