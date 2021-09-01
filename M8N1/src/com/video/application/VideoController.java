package com.video.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.video.domain.Video;
import com.video.view.UsuariView;
import com.video.domain.Tag;
import com.video.domain.Usuari;

import com.video.application.CampsBuits;

public class VideoController {
	
	protected Usuari nouUsuari;
	protected List<Video> videos = new ArrayList<Video>();
	protected Tag etiqueta;

	UsuariView uv = new UsuariView();
	
	
	public VideoController() {}		// Constructor per defecte
	

	public String creaUsuari(String nom, String cognom, String password, LocalDate registre) throws CampsBuits {
		if(nom.equals("") || cognom.equals("") || password.equals(""))
			throw new CampsBuits("L'usuari no pot tenir camps buits!");
		
		nouUsuari = new Usuari(nom, cognom, password, registre);
		return "Usuari " + nom + " " + cognom + ", creat amb èxit.";
			
	}
	
	
	public Tag creaTag(String nomEtiqueta) throws CampsBuits{
		if(nomEtiqueta.equals("")) 
			throw new CampsBuits("L'etiqueta no pot estar buida! Escriu almenys una etiqueta...");
		
		etiqueta = new Tag(nomEtiqueta);
		return etiqueta;
	}
	
	
	public String creaVideo(String url, String titol,  List<Tag> etiquetes) throws CampsBuits  {
		if(url.equals("") || titol.equals("") || etiquetes == null)
			throw new CampsBuits("No poden haver-hi camps buits en la creació d'un vídeo!");
		
		Video nouVideo = new Video(url, titol, etiquetes);
		videos.add(nouVideo);

		return "Vídeo '" + titol + "' carregat amb èxit.";
	}
	
	public String recuperaLlista() {
		
		String textLlista = "\nEls vídeos que tens a la llista són: \n";
		for(Video v: videos) {
			textLlista += v.toString() + "\n";
		}	
		
		return textLlista;	
	}
	
}
