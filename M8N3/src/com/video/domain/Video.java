package com.video.domain;

import java.time.LocalDateTime;

import java.util.List;

import com.video.application.VideoController;

public class Video implements Runnable {

	protected String url;
	protected String titol;	
	protected List<Tag> etiquetes;
	protected LocalDateTime pujada;
	protected long durada;	// temps en minuts
	protected EstatPujada estatP;
	protected StatusReproduccio statusRep;

	// Constructor
	
	public Video(String url, String titol, List<Tag> etiquetes, LocalDateTime pujada, long durada) {
		this.url = url;
		this.titol = titol;
		this.etiquetes = etiquetes;
		this.pujada = pujada;
		this.durada = durada;
		statusRep = StatusReproduccio.NO_INICIAT;	// El v�deo es carregar� per defecte amb l'StatusReproduccio NO_INICIAT
	}

	// Getters i Setters
	
	public String getTitol() {
		return titol;
	}
	
	public LocalDateTime getPujada() {
		return pujada;
	}
	
	public long getDurada() {
		return durada;
	}
	
	public StatusReproduccio getStatusReproduccio() {
		return statusRep;
	}

	public void setStatusReproduccio(StatusReproduccio statusRep) {
		this.statusRep = statusRep;
	}

	
	// Sobreescrivim el m�tode toString() per mostrar els v�deos a la llista
	
	@Override
	public String toString() {
		String textEtiquetes = "";
		
		for (Tag t: etiquetes) {
			textEtiquetes += t.getEtiqueta() + " "; 
		}
		
		
		return "-- Video --\n" +
				"  � URL: " + url + "\n" +  
				"  � T�tol: " + titol + "\n" +
				"  � Etiquetes = " + textEtiquetes + "\n" +
				"  � Data pujada = " + pujada + "\n" +
				"  � Durada = " + durada + " minuts";
	}

	
	// Sobreescrivim el m�tode run per al funcionament dels fils
	
	@Override
	public void run() {			
						
		VideoController vc = new VideoController();
		
		// Inicialitzem la variable sp amb l'EstatPujada, per veure si el v�deo �s PUBLIC per a reproduir-se
		
		EstatPujada sp = vc.validaEstatPujada(pujada);		
		
		// Mostrem av�s mentre el v�deo passa d'estat UPLOADING, VERIFYING i PUBLIC
		
		while (!EstatPujada.PUBLIC.equals(sp)) {
			try {
				System.out.println("Carregant v�deo... " + sp);
				Thread.sleep(1000);
				sp = vc.validaEstatPujada(pujada);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// V�deo disponible per a la reproducci�. 
		
		int comptador = 0;		// Per comptabilitzar els segons que porta el v�deo en reproducci�
		int duradaSegons = (int) durada * 60;	// La durada l'usuari la registre en minuts, la passem a segons per comptabilitzar temps de reproducci�

		while (comptador <= duradaSegons) {
			
			statusRep = getStatusReproduccio();
			
			try {
				
				if (StatusReproduccio.REPRODUCCIO.equals(statusRep)) {
					
					System.out.println("V�deo '" + titol + "' " + statusRep + " (" + comptador + "/" + duradaSegons + " segons. Durada en minuts: " + durada + ")");
					Thread.sleep(1000);
					comptador++;	// Va augmentant el temps de reproducci� en 1 segon amb cada sleep del Thread
					
				} else if (StatusReproduccio.PAUSAT.equals(statusRep)) {
										
				} else if (StatusReproduccio.PARAT.equals(statusRep)) {
					
					comptador = 0;	// Marquem el comptador de temps a 0 per a quan es torni a iniciar el v�deo
					
				} 
							
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
			
		System.out.println("V�deo finalitzat.");

		// Set StatusReproduccio a NO_INICIAT per a que pugui tornar a reproduir-se
		
		statusRep = StatusReproduccio.NO_INICIAT;	
		
	}
	
}
