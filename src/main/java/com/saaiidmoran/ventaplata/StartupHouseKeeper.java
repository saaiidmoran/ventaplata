package com.saaiidmoran.ventaplata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.saaiidmoran.ventaplata.servicedao.EstatusproductoDaoService;
import com.saaiidmoran.ventaplata.servicedao.EstatusventaDaoService;
import com.saaiidmoran.ventaplata.servicedao.ModalidadventaDaoService;
import com.saaiidmoran.ventaplata.servicedao.UsuarioDaoService;

@Component
public class StartupHouseKeeper {
	
	@Autowired
	private UsuarioDaoService uds;
	
	@Autowired
	private ModalidadventaDaoService mvds;
	
	@Autowired
	private EstatusproductoDaoService epds;
	
	@Autowired
	private EstatusventaDaoService evds;
	
	@EventListener(ApplicationReadyEvent.class)
	public void realizarRegistrosPrevios() {
	    uds.insertDefaultUser();
	    mvds.insertDefaultModalidadesVenta();
	    evds.insertDefautlEstatusVenta();
	    epds.insertDefaultEstatusProducto();
	}

}
