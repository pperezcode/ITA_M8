package com.video.application;

import java.time.LocalDate;

import com.video.domain.Usuari;
import com.video.view.UsuariView;

public class UsuariController {
	
	protected Usuari nouUsuari;

	UsuariView uv = new UsuariView();

	
	public UsuariController() {}		// Constructor per defecte

	
	public void creaUsuari() throws CampsBuits {
		
		String nom = uv.demanaNom();
		String cognom = uv.demanaCognom();
		String password = uv.demanaPassword();
		LocalDate registre = LocalDate.now();
		
		if(nom.equals("") || cognom.equals("") || password.equals(""))
			throw new CampsBuits("L'usuari no pot tenir camps buits!");
		
		nouUsuari = new Usuari(nom, cognom, password, registre);
		System.out.println("Usuari " + nom + " " + cognom + ", creat amb èxit.");
			
	}

}
