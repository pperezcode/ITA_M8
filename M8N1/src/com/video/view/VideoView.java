package com.video.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.video.application.CampsBuits;
import com.video.application.VideoController;
import com.video.domain.Tag;

public class VideoView {
		
	public String demanaURL() {
		
		String url = JOptionPane.showInputDialog("VÍDEO:\n\nIntrodueix la URL:");
		return url;
	}
	
	public String demanaTitol() {
		
		String titol = JOptionPane.showInputDialog("VÍDEO:\n\nTítol:");
		return titol;
	}
	
	public List<Tag> llistaEtiquetes() {
		
		int mesEtiquetes = 1;
		String nomEtiqueta;
		Tag etiqueta = null;
		
		List<Tag> etiquetes = new ArrayList<Tag>();
		
		VideoController vc = new VideoController();
		
		do {
			nomEtiqueta = JOptionPane.showInputDialog("VÍDEO:\n\nIntrodueix una etiqueta:").toUpperCase();
	
			try {
				etiqueta = vc.creaTag(nomEtiqueta);
				System.out.println("Etiqueta " + etiqueta.getEtiqueta() + " afegida al vídeo.");
				etiquetes.add(etiqueta);
			} catch (CampsBuits e) {
				System.out.println(e.getMessage());
			}
			
			mesEtiquetes = Integer.parseInt(JOptionPane.showInputDialog("Vols afegir una altra etiqueta?\n 1. Sí\n 2. No"));
			
		} while (mesEtiquetes != 2);
		
		return etiquetes;
		
	}
		
 }
