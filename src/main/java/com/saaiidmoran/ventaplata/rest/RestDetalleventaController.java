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

import com.saaiidmoran.ventaplata.model.Detalleventa;
import com.saaiidmoran.ventaplata.servicedao.DetalleventaDaoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/detalleventaVPRest")
public class RestDetalleventaController {
	
	@Autowired
	private DetalleventaDaoService dvds;
	
	@GetMapping
	public List<Detalleventa> selectAll() {
		return dvds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{iddv}")
	public Detalleventa selectById(@PathVariable("iddv") Integer iddv) {
		return dvds.selectById(iddv);
	}
	
	@GetMapping(value = "/buscarPorFecha/{fecha}")
	public Detalleventa selectByFecha(@PathVariable("fecha") String fecha) {
		return dvds.selectByFecha(fecha);
	}
	
	@GetMapping(value = "/buscarPorTotal/{total}")
	public Detalleventa selectByTotal(@PathVariable("total") double total) {
		return dvds.selectByTotal(total);
	}
	
	@GetMapping(value = "/buscarPorAbono/{abono}")
	public Detalleventa selectByAbono(@PathVariable("abono") double abono) {
		return dvds.selectByAbono(abono);
	}
	
	@PostMapping(value = "/{cliente}/{estatusventa}/{modalidadventa}/{usuario}")
	public Detalleventa insert(
			
									@RequestBody Detalleventa dv,
									@PathVariable("cliente") String cliente,
									@PathVariable("estatusventa") String estatusventa,
									@PathVariable("modalidadventa") String modalidadventa,
									@PathVariable("usuario") String usuario
									
								) {
		return dvds.insert(dv, cliente, estatusventa, modalidadventa, usuario);
	}
	
	@PutMapping(value = "/{iddetalleventa}/{cliente}/{estatusventa}/{modalidadventa}/{usuario}")
	public Detalleventa update(
			
									@RequestBody Detalleventa dv,
									@PathVariable("iddetalleventa") Integer iddetalleventa,
									@PathVariable("cliente") String cliente,
									@PathVariable("estatusventa") String estatusventa,
									@PathVariable("modalidadventa") String modalidadventa,
									@PathVariable("usuario") String usuario
									
								) {
		return dvds.update(dv, iddetalleventa, cliente, estatusventa, modalidadventa, usuario);
	}
	
	@DeleteMapping(value = "/{iddv}")
	public void delete(@PathVariable("iddv") Integer iddv) {
		dvds.delete(iddv);
	}
	
}
