package com.video.application;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.video.domain.Video;
import com.video.view.UsuariView;
import com.video.domain.EstatPujada;
import com.video.domain.Tag;
import com.video.domain.Usuari;

public class VideoController {
	
	protected Usuari nouUsuari;
	protected List<Video> videos = new ArrayList<Video>();
	protected Tag etiqueta;

	UsuariView uv = new UsuariView();
	
	public VideoController() {} 	// Constructor per defecte

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
	
	
	public String creaVideo(String url, String titol,  List<Tag> etiquetes, LocalDateTime pujada) throws CampsBuits  {
		if(url.equals("") || titol.equals("") || etiquetes == null)		// Validem que no hi hagi camps buits
			throw new CampsBuits("No poden haver-hi camps buits en la creació d'un vídeo!");
		
		Video nouVideo = new Video(url, titol, etiquetes, pujada);
		videos.add(nouVideo);

		return "Vídeo '" + titol + "' carregat amb èxit.";
	}
	
	public String recuperaLlista() {
		
		String textLlista = "\nEls vídeos que tens a la llista són: \n";
		
		// Bucle per imprimir les dades dels vídeos creats

		for(Video v: videos) {
			textLlista += v.toString() + "\n  · Estat vídeo = " + validaEstatPujada(v.getPujada()) + "\n";		
			
		}	
		
		return textLlista;	
	}
	
	
	
	public EstatPujada validaEstatPujada(LocalDateTime pujada) {
		
		EstatPujada estatVideo;
		
		// Calculem el temps que fa que s'ha pujat el vídeo

		Duration d = Duration.between(pujada, LocalDateTime.now());
		
		int seconds = (int) d.get(ChronoUnit.SECONDS);
		
		// Validem l'estat de pujada en funció de quan fa que s'ha pujat

		if (seconds < 60) {
			estatVideo = EstatPujada.UPLOADING;		// El vídeo fa menys d'1 minut que s'ha creat
			
		} else if (seconds < 180) {
			estatVideo = EstatPujada.VERIFYING;		// El vídeo s'ha creat fa d'1 a 3 minuts
			
		} else {
			estatVideo = EstatPujada.PUBLIC;			// El vídeo s'ha creat fa més de 3 minuts
		}
		
		return estatVideo;
		
	}
	
}
