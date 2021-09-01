package com.video.application;

import java.util.ArrayList;
import java.util.List;


import com.video.domain.StatusReproduccio;
import com.video.domain.Video;

public class ReproductorController {
	
	protected List<Video> videos = new ArrayList<Video>();
		

	public void playVideo(List<Video> videos, int selectedIndex) {	// Mètode en pulsar el botó play
		
		Video v = videos.get(selectedIndex);
		StatusReproduccio statusRep = v.getStatusReproduccio();
		
		// Canviem l'estat de reproduccio en funció dels botons que premem al reproductor
		
		if(StatusReproduccio.REPRODUCCIO.equals(statusRep)) {
			
			System.out.println("El vídeo ja s'està reproduint...");
		
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

	
	public void pauseVideo(List<Video> videos, int selectedIndex) {		// Mètode en pulsar el botó pause
		
		Video v = videos.get(selectedIndex);
		StatusReproduccio statusRep = v.getStatusReproduccio();
		
		// Canviem l'estat de reproduccio en funció dels botons que premem al reproductor

		if(StatusReproduccio.REPRODUCCIO.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.PAUSAT);
		
		} else if (StatusReproduccio.PAUSAT.equals(statusRep)) {
			
			System.out.println("Ja està en pausa...");
		
		} else if (StatusReproduccio.PARAT.equals(statusRep)) {
			
			System.out.println("No hi ha cap vídeo en reproducció...");
		
		} else if (StatusReproduccio.NO_INICIAT.equals(statusRep)) {
			
			System.out.println("No hi ha cap vídeo en reproducció...");

		}
		
	}

	
	public void stopVideo(List<Video> videos, int selectedIndex) {		// Mètode en pulsar el botó stop
		
		Video v = videos.get(selectedIndex);
		StatusReproduccio statusRep = v.getStatusReproduccio();
		
		// Canviem l'estat de reproduccio en funció dels botons que premem al reproductor

		if(StatusReproduccio.REPRODUCCIO.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.PARAT);
		
		} else if (StatusReproduccio.PAUSAT.equals(statusRep)) {
			
			v.setStatusReproduccio(StatusReproduccio.PARAT);
		
		} else if (StatusReproduccio.PARAT.equals(statusRep)) {
			
			System.out.println("El vídeo ja està parat...");
		
		} else if (StatusReproduccio.NO_INICIAT.equals(statusRep)) {
			
			System.out.println("No hi ha cap vídeo en reproducció...");

		}
	}
	
}
