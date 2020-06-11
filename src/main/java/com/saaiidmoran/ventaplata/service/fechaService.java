package com.saaiidmoran.ventaplata.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

@Service
public class fechaService {

	public String fechaFormToBackend(String fechaForm) {
		String formateada;
		try {
			formateada = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(fechaForm));
		}catch(ParseException e) {
			System.out.println("Ocurrió un error mientras se formateaba la fecha");
			formateada = "";
		}		
		return formateada;
	}
	
	public String fechaBackendToForm(String fechaBackend) {
		String formateada;
		try {
			formateada = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd/MM/yyyy").parse(fechaBackend));
		}catch(ParseException e) {
			System.out.println("Ocurrió un error mientras se formateaba la fecha");
			formateada = "";
		}		
		return formateada;
	}
	
}
