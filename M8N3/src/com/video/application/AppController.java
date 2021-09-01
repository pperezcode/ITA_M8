package com.video.application;


import javax.swing.JOptionPane;


public class AppController {

	public void iniciaApp() {
		int opcio = 1;		// Per validar les accions a fer amb els vídeos de l'usuari.
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
		System.out.println("Creant vídeo...");
		try {
			vc.creaVideo();
		} catch (CampsBuits e) {
			System.out.println(e.getMessage());
		}
		
		do {
			
			opcio = Integer.parseInt(JOptionPane.showInputDialog("ESCULL UNA OPCIÓ\n 0. Sortir del programa\n 1. Crear un vídeo" +
					"\n 2. Veure el llistat de vídeos\n 3. Reproductor de vídeos"));
			
			switch (opcio) {
			case 0:
				// Sortir
				opcio = 0;
				break;
				
			case 1:
				// Crear vídeo
				System.out.println("Creant vídeo...");
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
				System.out.println("El valor introduit no és correcte. Escull de nou una opció...");
				break;
			}
			
		} while(opcio != 0); 
	}
}
