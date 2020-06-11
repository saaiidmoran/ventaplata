package com.saaiidmoran.ventaplata.servicedao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saaiidmoran.ventaplata.model.Detalleventa;
import com.saaiidmoran.ventaplata.repo.IDetalleventaRepo;

@Service
public class DetalleventaDaoService {
	
	@Autowired
	IDetalleventaRepo dvr;
	
	@Autowired
	ClienteDaoService cds;
	
	@Autowired
	ModalidadventaDaoService mvds;
	
	@Autowired
	EstatusventaDaoService evds;
	
	@Autowired
	UsuarioDaoService uds;
	
	public List<Detalleventa> selectAll() {
		return dvr.findAll();
	}
	
	public Detalleventa selectById(Integer id) {
		return dvr.findByIddetalleventa(id);
	}
	
	public Detalleventa selectByFecha(String fecha) {
		return dvr.findByFecha(fecha);
	}
	
	public Detalleventa selectByTotal(double total) {
		return dvr.findByTotal(total);
	}
	
	public Detalleventa selectByAbono(double abono) {
		return dvr.findByAbono(abono);
	}
	
	public Detalleventa insert(Detalleventa dv, String cliente,
							   String estatusventa, String modalidadventa,
							   String usuario) {
		dv.setIdcliente(cds.selectByNombre(cliente));
		dv.setIdestatusventa(evds.selectByEstatusventa(estatusventa));
		dv.setIdmodalidadventa(mvds.selectByModalidadventa(modalidadventa));
		dv.setIdusuario(uds.selectByName(usuario));
		return dvr.save(dv);		
	}
	
	public Detalleventa update(Detalleventa dv, Integer iddetalleventa,
							   String cliente,
							   String estatusventa, String modalidadventa,
							   String usuario) {
		dv.setIddetalleventa(iddetalleventa);
		dv.setIdcliente(cds.selectByNombre(cliente));
		dv.setIdestatusventa(evds.selectByEstatusventa(estatusventa));
		dv.setIdmodalidadventa(mvds.selectByModalidadventa(modalidadventa));
		dv.setIdusuario(uds.selectByName(usuario));
		return dvr.save(dv);
	}
	
	public void delete(Integer id) {
		dvr.deleteById(id);
	}
	

}
