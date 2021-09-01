package com.video.domain;

import java.time.LocalDate;

public class Usuari {
		
	protected String nom;
	protected String cognom;
	protected String password;
	protected LocalDate registre;
	
	public Usuari(String nom, String cognom, String password, LocalDate registre)  {
		this.nom = nom;
		this.cognom = cognom;
		this.password = password;
		this.registre = registre;
	}

	@Override
	public String toString() {
		return nom + " " + cognom;
	}
	
	

}
