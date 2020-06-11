package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.model.Estatusproducto;
import com.saaiidmoran.ventaplata.repo.IEstatusproductoRepo;

@Service
public class EstatusproductoDaoService {
	
	@Autowired
	IEstatusproductoRepo epRepo;
	
	public List<Estatusproducto> selectAll() {
		return epRepo.findAll();
	}
	
	public Estatusproducto selectById(Integer idestatusproducto) {
		return epRepo.findByIdestatusProducto(idestatusproducto);
	}
	
	public Estatusproducto selectByEstatusproducto(String estatusproducto) {
		return epRepo.findByEstatusproducto(estatusproducto);
	}
	
	public Estatusproducto insert(Estatusproducto ep) {
		return epRepo.save(ep);
	}
	
	public void insertDefaultEstatusProducto() {
		Estatusproducto[] ep = new Estatusproducto[2];
		if(selectByEstatusproducto("En venta") == null) {
			ep[0] = new Estatusproducto();
			ep[0].setEstatusproducto("En venta");
			if(epRepo.save(ep[0]) == null) {
				System.out.println("El estatus de producto \"En venta\" no fué creado correctamente");
			}else {
				System.out.println("El estatus de producto \"En venta\" fué creado correctamente");
			}
		}else {
			System.out.println("El estatus de producto \"En venta\" ya fué creado anteriormente");
		}
		
		if(selectByEstatusproducto("Vendido") == null) {
			ep[1] = new Estatusproducto();
			ep[1].setEstatusproducto("Vendido");
			if(epRepo.save(ep[1]) == null) {
				System.out.println("El estatus de producto \"Vendido\" no fué creado correctamente");
			}else {
				System.out.println("El estatus de producto \"Vendido\" fué creado correctamente");
			}
		}else {
			System.out.println("El estatus de producto \"Vendido\" ya fué creado anteriormente");
		}
	}
	
	public Estatusproducto update(Estatusproducto ep, Integer idestatusproducto) {
		ep.setIdestatusProducto(idestatusproducto);
		return epRepo.save(ep);
	}
	
	public void delete(Integer id) {
		epRepo.deleteById(id);
	}
	
}
