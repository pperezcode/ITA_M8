package com.video.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Video {

	protected String url;
	protected String titol;	
	protected List<Tag> etiquetes;
	protected LocalDateTime pujada;

	// Constructor

	public Video(String url, String titol, List<Tag> etiquetes, LocalDateTime pujada) {
		this.url = url;
		this.titol = titol;
		this.etiquetes = etiquetes;
		this.pujada = pujada;
	}

	
	// Getter
	
	public LocalDateTime getPujada() {
		return pujada;
	}


	// 	Sobreescrivim el mètode toString() per mostrar els vídeos a la llista

	@Override
	public String toString() {
		String textEtiquetes = "";
		
		for (Tag t: etiquetes) {
			textEtiquetes += t.getEtiqueta() + " "; 
		}
		
		return "-- Video --\n" +
				"  · URL: " + url + "\n" +  
				"  · Títol: " + titol + "\n" +
				"  · Etiquetes = " + textEtiquetes + "\n" +
				"  · Data pujada = " + pujada;
	}
	
}
