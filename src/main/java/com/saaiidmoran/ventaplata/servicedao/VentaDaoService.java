package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.model.Venta;
import com.saaiidmoran.ventaplata.repo.IVentaRepo;

@Service
public class VentaDaoService {
	
	@Autowired
	IVentaRepo ivr;
	
	@Autowired
	ProductoDaoService pds;
	
	@Autowired
	DetalleventaDaoService dvds;
	
	public List<Venta> selectAll() {
		return ivr.findAll();
	}
	
	public Venta selectById(Integer id) {
		return ivr.findByIdventa(id);
	}
	
	public Venta insert(Venta v, Integer idproducto, Integer iddetalleventa) {
		v.setIdproducto(pds.selectById(idproducto));
		v.setIddetalleventa(dvds.selectById(iddetalleventa));
		return ivr.save(v);
	}
	
	public Venta update(Venta v, Integer idventa, Integer idproducto, Integer iddetalleventa) {
		v.setIdventa(idventa);
		v.setIdproducto(pds.selectById(idproducto));
		v.setIddetalleventa(dvds.selectById(iddetalleventa));
		return ivr.save(v);
	}
	
	public void delete(Integer id) {
		ivr.deleteById(id);
	}

}
