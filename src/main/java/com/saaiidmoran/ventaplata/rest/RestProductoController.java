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

import com.saaiidmoran.ventaplata.model.Producto;
import com.saaiidmoran.ventaplata.servicedao.ProductoDaoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/productoVPRest")
public class RestProductoController {
	
	@Autowired
	private ProductoDaoService pds;
	
	@GetMapping
	public List<Producto> selectAll(){
		return pds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public Producto selectById(@PathVariable("id") Integer id) {
		return pds.selectById(id);
	}
	
	@GetMapping(value = "/buscarPorNombre/{nombre}")
	public Producto selectByNombre(@PathVariable("nombre") String nombre) {
		return pds.selectByNombre(nombre);
	}
	
	@GetMapping(value = "/buscarPorFecharegistro/{fecha}")
	public Producto selectByFecharegistro(@PathVariable("fecha") String fecha) {
		return pds.selectByFecharegistro(fecha);
	}
	
	@GetMapping(value = "/buscarPorPrecioinv/{precioinv}")
	public Producto selectByPrecioinv(@PathVariable("precioinv") double precioinv) {
		return pds.selectByPrecioinv(precioinv);
	}
	
	@GetMapping(value = "/buscarPorPreciovent/{preciovent}")
	public Producto selectByPreciovent(@PathVariable("preciovent") double preciovent) {
		return pds.selectByPreciovent(preciovent);
	}
	
	@PostMapping(value = "/{ep}")	
	public Producto insert(@RequestBody Producto p, @PathVariable("ep") String ep) {
		return pds.insert(p, ep);
	}
	
	@PutMapping(value = "/{ep}/{idp}")
	public Producto update(@RequestBody Producto p,@PathVariable("ep") String ep, @PathVariable("idp") Integer idp) {
		return pds.update(p, idp, ep);
	}
	
	@DeleteMapping(value = "/{idp}")
	public void delete(@PathVariable("idp") Integer idp) {
		pds.delete(idp);
	}
	
}
