package com.video.application;

import java.util.ArrayList;
import java.util.List;


import com.video.domain.StatusReproduccio;
import com.video.domain.Video;

public class ReproductorController {
	
	protected List<Video> videos = new ArrayList<Video>();
		

	public void playVideo(List<Video> videos, int selectedIndex) {	// M�tode en pulsar el bot� play
		
		Video v = videos.get(selectedIndex);
		StatusReproduccio statusRep = v.getStatusReproduccio();
		
		// Canviem l'estat de reproduccio en funci� dels botons que premem al reproductor
		
		if(StatusReproduccio.REPRODUCCIO.equals(statusRep)) {
			
			System.out.println("El v�deo ja s'est� reproduint...");
		
		} else if (StatusReproduccio.PAUSAT.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.REPRODUCCIO);
	
		} else if (StatusReproduccio.PARAT.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.REPRODUCCIO);
		
		} else if (StatusReproduccio.NO_INICIAT.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.REPRODUCCIO);
			Thread t = new Thread(v);
			t.start();
		}
	}

	
	public void pauseVideo(List<Video> videos, int selectedIndex) {		// M�tode en pulsar el bot� pause
		
		Video v = videos.get(selectedIndex);
		StatusReproduccio statusRep = v.getStatusReproduccio();
		
		// Canviem l'estat de reproduccio en funci� dels botons que premem al reproductor

		if(StatusReproduccio.REPRODUCCIO.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.PAUSAT);
		
		} else if (StatusReproduccio.PAUSAT.equals(statusRep)) {
			
			System.out.println("Ja est� en pausa...");
		
		} else if (StatusReproduccio.PARAT.equals(statusRep)) {
			
			System.out.println("No hi ha cap v�deo en reproducci�...");
		
		} else if (StatusReproduccio.NO_INICIAT.equals(statusRep)) {
			
			System.out.println("No hi ha cap v�deo en reproducci�...");

		}
		
	}

	
	public void stopVideo(List<Video> videos, int selectedIndex) {		// M�tode en pulsar el bot� stop
		
		Video v = videos.get(selectedIndex);
		StatusReproduccio statusRep = v.getStatusReproduccio();
		
		// Canviem l'estat de reproduccio en funci� dels botons que premem al reproductor

		if(StatusReproduccio.REPRODUCCIO.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.PARAT);
		
		} else if (StatusReproduccio.PAUSAT.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.PARAT);
		
		} else if (StatusReproduccio.PARAT.equals(statusRep)) {
			
			System.out.println("El v�deo ja est� parat...");
		
		} else if (StatusReproduccio.NO_INICIAT.equals(statusRep)) {
			
			System.out.println("No hi ha cap v�deo en reproducci�...");

		}
	}
	
}
