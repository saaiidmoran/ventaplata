package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.model.Producto;
import com.saaiidmoran.ventaplata.repo.IProductoRepo;

@Service
public class ProductoDaoService {

	@Autowired
	private IProductoRepo pRepo;
	
	@Autowired
	private EstatusproductoDaoService epdaos;
	
	public List<Producto> selectAll(){
		return pRepo.findAll();
	}
	
	public Producto selectById(Integer idproducto) {
		return pRepo.findByIdproducto(idproducto);
	}
	
	public Producto selectByNombre(String nombre) {
		return pRepo.findByNombre(nombre);
	}
	
	public Producto selectByPrecioinv(double precioinv) {
		return pRepo.findByPrecioinv(precioinv);
	}
	
	public Producto selectByPreciovent(double preciovent) {
		return pRepo.findByPreciovent(preciovent);
	}
	
	public Producto selectByFecharegistro(String fecharegistro) {
		return pRepo.findByFecharegistro(fecharegistro);
	}
		
	public Producto insert(Producto p, String estatusproducto) {
		p.setIdestatusproducto(epdaos.selectByEstatusproducto(estatusproducto));
		return pRepo.save(p);
	}
	
	public Producto update(Producto p, Integer idprodcuto, String estatusproducto) {
		p.setIdproducto(idprodcuto);
		p.setIdestatusproducto(epdaos.selectByEstatusproducto(estatusproducto));
		return pRepo.save(p);		
	}
	
	public void delete(Integer idproducto) {
		pRepo.deleteById(idproducto);
	}
	
}
