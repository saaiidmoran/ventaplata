package com.saaiidmoran.ventaplata.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saaiidmoran.ventaplata.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{
	
	Producto findByIdproducto(Integer idproducto);
	Producto findByNombre(String nombre);
	Producto findByPrecioinv(double precioinv);
	Producto findByPreciovent(double preciovent);
	Producto findByFecharegistro(String fecharegistro);

}
