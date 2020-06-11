package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.model.Cliente;
import com.saaiidmoran.ventaplata.repo.IClienteRepo;

@Service
public class ClienteDaoService {

	@Autowired
	private IClienteRepo clienteRepo;
	
	public List<Cliente> selectAll(){
		return clienteRepo.findAll();
	}
	
	public Cliente selectById(Integer id) {
		return clienteRepo.findByIdcliente(id);
	}
	
	public Cliente selectByNombre(String nombre) {
		return clienteRepo.findByNombre(nombre);
	}
	
	public Cliente selectByNotelefonico(String noTelefonico){
		return clienteRepo.findByNotelefonico(noTelefonico);
	}
	
	public Cliente selectByCorreo(String correo){
		return clienteRepo.findByCorreo(correo);
	}
	
	public Cliente selectByDomicilio(String domicilio){
		return clienteRepo.findByDomicilio(domicilio);
	}
	
	public List<Cliente> filtrar(Integer id, String nombre){
		return clienteRepo.findAll().stream()
				.filter((cliente) -> 
				(cliente.getIdcliente() == id ||
				 cliente.getNombre().equals(nombre) //||
				 //cliente.getNotelefonico().equals(datosCliente.getNotelefonico()) ||
				 //cliente.getCorreo().equals(datosCliente.getCorreo()) ||
				 //cliente.getDomicilio().equals(datosCliente.getDomicilio())
				 )).collect(Collectors.toList());
	}
	
	public Cliente insert (Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public Cliente update (Cliente cliente, Integer id) {
		cliente.setIdcliente(id);
		return clienteRepo.save(cliente);
	}
	
	public void delete (Integer id) {
		clienteRepo.deleteById(id);
	}
	
}
