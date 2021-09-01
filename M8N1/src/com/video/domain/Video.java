package com.video.domain;

import java.util.List;

public class Video {

	protected String url;
	protected String titol;	
	protected List<Tag> etiquetes;

	public Video(String url, String titol, List<Tag> etiquetes) {
		this.url = url;
		this.titol = titol;
		this.etiquetes = etiquetes;
	}

	@Override
	public String toString() {
		String textEtiquetes = "";
		
		for (Tag t: etiquetes) {
			textEtiquetes += t.getEtiqueta() + " "; 
		}
		
		return "-- Video --\n" +
				"  · URL: " + url + "\n" +  
				"  · Títol: " + titol + "\n" +
				"  · Etiquetes = " + textEtiquetes;
	}
	
}
