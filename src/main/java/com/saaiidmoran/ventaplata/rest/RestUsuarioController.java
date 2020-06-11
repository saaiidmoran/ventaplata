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

import com.saaiidmoran.ventaplata.model.Usuario;
import com.saaiidmoran.ventaplata.servicedao.UsuarioDaoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/usuarioVPRest")
public class RestUsuarioController {
	
	@Autowired
	private UsuarioDaoService uds;
	
	@GetMapping
	public List<Usuario> selectAll(){
		return uds.selectAll();
	}
	
	@GetMapping(value = "/buscarPorId/{idusr}")
	public Usuario selectById(@PathVariable("idusr") Integer id) {
		return uds.selectById(id);
	}
	
	@GetMapping(value = "/buscarPorNombre/{nombre}")
	public Usuario selectByNombre(@PathVariable("nombre") String nombre) {
		return uds.selectByName(nombre);
	}
	
	@PostMapping
	public Usuario insert(@RequestBody Usuario u) {
		return uds.insert(u);
	}
	
	@PutMapping(value = "/{id}")
	public Usuario update(@RequestBody Usuario u, @PathVariable("id") Integer id) {
		return uds.update(u, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		uds.delete(id);
	}
	
 
}
