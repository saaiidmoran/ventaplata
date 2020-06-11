package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.model.Modalidadventa;
import com.saaiidmoran.ventaplata.repo.IModalidadventaRepo;

@Service
public class ModalidadventaDaoService {
	
	@Autowired
	private IModalidadventaRepo mvrepo;
	
	public List<Modalidadventa> selectAll() {
		return mvrepo.findAll();
	}
	
	public Modalidadventa selectById(Integer id) {
		return mvrepo.findByIdmodalidadventa(id);
	}
	
	public Modalidadventa selectByModalidadventa(String modalidad){
		return mvrepo.findByModalidadventa(modalidad);
	}
	
	public Modalidadventa insert(Modalidadventa mv) {
		return mvrepo.save(mv);
	}
	
	public void insertDefaultModalidadesVenta() {
		Modalidadventa [] mv = new Modalidadventa[2];
		if(selectByModalidadventa("En pagos") == null) {
			mv[0] = new Modalidadventa();
			mv[0].setModalidadventa("En pagos");
			if(mvrepo.save(mv[0]) == null) {
				System.out.println("La modalidad de venta \"En pagos\" no fué creada correctamente");
			}else {
				System.out.println("La modalidad de venta \"En pagos\" fué creada correctamente");				
			}
		}else {
			System.out.println("La modalidad de venta \"En pagos\" ya fué creada anteriormente");
		}
		if(selectByModalidadventa("De contado") == null) {
			mv[1] = new Modalidadventa();
			mv[1].setModalidadventa("De contado");
			if(mvrepo.save(mv[1]) == null) {
				System.out.println("La modalidad de venta \"De contado\" no fué creada correctamente");
			}else {
				System.out.println("La modalidad de venta \"De contado\" fué creada correctamente");
			}
		}else {
			System.out.println("La modalidad de venta \"De contado\" ya fué creada anteriormente");
		}
	}
	
	public Modalidadventa update(Modalidadventa mv, Integer id) {
		mv.setIdmodalidadventa(id);
		return mvrepo.save(mv);
	}
	
	public void delete(Integer id) {
		mvrepo.deleteById(id);
	}

}
