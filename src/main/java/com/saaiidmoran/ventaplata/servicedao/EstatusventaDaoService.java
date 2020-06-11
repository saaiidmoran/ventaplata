package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.repo.IEstatusventaRepo;
import com.saaiidmoran.ventaplata.model.Estatusventa;

@Service
public class EstatusventaDaoService {
	
	@Autowired
	IEstatusventaRepo evRepo;
	
	public List<Estatusventa> selectAll() {
		return evRepo.findAll();
	}
	
	public Estatusventa selectById(Integer idestatusventa) {
		return evRepo.findByIdestatusventa(idestatusventa);
	}
	
	public Estatusventa selectByEstatusventa(String estatusventa) {
		return evRepo.findByEstatusventa(estatusventa);
	}
	
	public Estatusventa insert(Estatusventa ev) {
		return evRepo.save(ev);
	}
	
	public void insertDefautlEstatusVenta() {
		Estatusventa[] ev = new Estatusventa[2];
		if(selectByEstatusventa("Concretada")==null) {			
			ev[0] = new Estatusventa();
			ev[0].setEstatusventa("Concretada");
			if(evRepo.save(ev[0]) == null) {
				System.out.println("El estatus de venta \"Concretada\" no fué creado correctamente");
			}else {
				System.out.println("El estatus de venta \"Concretada\" fué creado correctamente");
			}
		}else {
			System.out.println("El estatus de venta \"Concretada\" ya fué creado anteriormente");
		}
		
		if(selectByEstatusventa("Pendiente")==null) {
			ev[1] = new Estatusventa();
			ev[1].setEstatusventa("Pendiente");
			if(evRepo.save(ev[1]) == null) {
				System.out.println("El estatus de venta \"Pendiente\" no fué creado correctamente");
			}else {
				System.out.println("El estatus de venta \"Pendiente\" fué creado correctamente");
			}
		}else {
			System.out.println("El estatus de venta \"Pendiente\" ya fué creada anteriormente");
		}
		
	}
	
	public Estatusventa update(Estatusventa ev, Integer idestatusventa) {
		ev.setIdestatusventa(idestatusventa);
		return evRepo.save(ev);
	}
	
	public void delete(Integer idestatusventa) {
		evRepo.deleteById(idestatusventa);
	}

}
