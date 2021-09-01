package com.video.application;


import javax.swing.JOptionPane;


public class AppController {

	public void iniciaApp() {
		int opcio = 1;		// Per validar les accions a fer amb els v�deos de l'usuari.
		UsuariController uc = new UsuariController();
		VideoController vc = new VideoController();
		
		// Crear usuari.
		System.out.println("Creant usuari...");
		try {
			uc.creaUsuari();
		} catch (CampsBuits e) {
			System.out.println(e.getMessage());
		}
		
		// Crea video
		System.out.println("Creant v�deo...");
		try {
			vc.creaVideo();
		} catch (CampsBuits e) {
			System.out.println(e.getMessage());
		}
		
		do {
			
			opcio = Integer.parseInt(JOptionPane.showInputDialog("ESCULL UNA OPCI�\n 0. Sortir del programa\n 1. Crear un v�deo" +
					"\n 2. Veure el llistat de v�deos\n 3. Reproductor de v�deos"));
			
			switch (opcio) {
			case 0:
				// Sortir
				opcio = 0;
				break;
				
			case 1:
				// Crear v�deo
				System.out.println("Creant v�deo...");
				try {
					vc.creaVideo();
				} catch (CampsBuits e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 2:
				// Veure llistat de videos
				System.out.println("Recuperant llista...");
				vc.recuperaLlista();
				break;
				
			case 3:
				// Reproductor
				System.out.println("Accedint al reproductor...");
				vc.reproductorVideos();
				opcio = 0;
				break;
				
			default:
				System.out.println("El valor introduit no �s correcte. Escull de nou una opci�...");
				break;
			}
			
		} while(opcio != 0); 
	}
}
