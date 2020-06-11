package com.saaiidmoran.ventaplata.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saaiidmoran.ventaplata.model.Venta;
import com.saaiidmoran.ventaplata.servicedao.VentaDaoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/ventaVPRest")
public class RestVentaController {
	
	@Autowired
	private VentaDaoService vds;
	
	@GetMapping
	public List<Venta> selectAll() {
		return vds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public Venta selectById(@PathVariable("id") Integer id) {
		return vds.selectById(id);
	}
	
	@PostMapping(value = "/{idproducto}/{iddetalleventa}")
	public Venta insert(
							@RequestBody Venta v,
							@PathVariable("idproducto") Integer idproducto,
							@PathVariable("iddetalleventa") Integer iddetalleventa
						) {
		return vds.insert(v, idproducto, iddetalleventa);
	}
	
	@PostMapping(value = "/{idventa}/{idproducto}/{iddetalleventa}")
	public Venta update(
							@RequestBody Venta v,
							@PathVariable("idventa") Integer idventa,
							@PathVariable("idproducto") Integer idproducto,
							@PathVariable("iddetalleventa") Integer iddetalleventa
						) {
		return vds.update(v, idventa, idproducto, iddetalleventa);
	
	}
	
	@DeleteMapping(value = "/{idventa}")
	public void delete(@PathVariable("idventa") Integer idventa) {
		vds.delete(idventa);
	}
	
}
