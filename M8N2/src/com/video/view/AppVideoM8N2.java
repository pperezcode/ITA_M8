package com.video.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.video.application.VideoController;
import com.video.application.CampsBuits;
import com.video.domain.Tag;

public class AppVideoM8N2 {

	public static void main(String[] args) {	
		
		int valida = 0;		// Per validar accions.
		int opcio = 1;		// Per validar les accions a fer amb els v�deos de l'usuari.
		
		LocalDateTime pujada = null;
		
		VideoController vc = new VideoController();
		
		// Crear usuari.
		
		UsuariView uv = new UsuariView();
		
		do {
			try {
	 			System.out.println(vc.creaUsuari(uv.demanaNom(), uv.demanaCognom(), uv.demanaPassword(), LocalDate.now()));
	 			valida = 1;
			} catch (CampsBuits e) {
				System.out.println(e.getMessage());
				valida = 0;
			}		
		} while (valida != 1);
		
		
		// Crear v�deo o veure llistat de v�deos. A la primera entrada del bucle crear� v�deo perqu� la llista est� buida (opcio = 1);
		
		VideoView vv = new VideoView();
		
		valida = 0;
		
		do {
			
			switch (opcio) {
			case 1:
				// Crear v�deo
				do {
					try {
						System.out.println("Creant v�deo...");
						pujada = LocalDateTime.now();
						System.out.println(vc.creaVideo(vv.demanaURL(), vv.demanaTitol(), vv.llistaEtiquetes(), pujada));
						valida = 1;
					} catch (CampsBuits e) {
						System.out.println(e.getMessage());
						valida = 0;
					}
				} while (valida != 1);
				
				break;
				
			case 2:
				// Veure llistat de videos
				System.out.println(vc.recuperaLlista());	
				break;
				
			default:
				System.out.println("El valor introduit no �s correcte. Escull de nou una opci�...");
				break;
			}
			
			opcio = Integer.parseInt(JOptionPane.showInputDialog("Qu� vols fer?\n 0. Sortir del programa\n 1. Crear un video\n 2. Veure el llistat de videos"));

		} while(opcio != 0); 
				
	}
	
}