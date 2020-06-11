package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.model.Usuario;
import com.saaiidmoran.ventaplata.repo.IUsuarioRepo;

@Service
public class UsuarioDaoService {
	
	@Autowired
	private IUsuarioRepo usrRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public List<Usuario> selectAll(){
		return usrRepo.findAll();
	}
	
	public Usuario selectById(Integer id){
		return usrRepo.findByIdusuario(id);
	}
	
	public Usuario selectByName(String name){
		return usrRepo.findByUsrnombre(name);
	}
	
	public List<Usuario> filter(Integer idusr, String usrnombre){
		return usrRepo.findAll()
				.stream()
				.filter((usuario) -> (usuario.getUsrnombre().equals(usrnombre) || usuario.getIdusuario() == idusr))
				.collect(Collectors.toList());
	}
	
	public Usuario insert(Usuario usr){
		usr.setClave(encoder.encode(usr.getClave()));
		return usrRepo.save(usr);
	}
	
	public void insertDefaultUser() {		
		if(selectByName("root") == null) {
			Usuario u = new Usuario();
			u.setUsrnombre("root");
			u.setClave(encoder.encode("12345"));
			if(usrRepo.save(u) == null) {
				System.out.println("El usuario por default del sistema no fué creado correctamente");
			}else {
				System.out.println("El usuario por default del sistema fué creado correctamente");
			}
		}else {
			System.out.println("El usuario por default del sistema ya fué creado anteriormente");
		}
	}
	
	public Usuario update(Usuario usr, Integer id) {
		usr.setIdusuario(id);
		usr.setClave(encoder.encode(usr.getClave()));
		return usrRepo.save(usr);
	}
	
	public void delete(Integer id) {
		usrRepo.deleteById(id);
	}

}
