package com.video.application;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.video.domain.Video;
import com.video.view.ReproductorView;
import com.video.view.UsuariView;
import com.video.view.VideoView;
import com.video.domain.EstatPujada;
import com.video.domain.Tag;

public class VideoController {
	
	protected List<Video> videos = new ArrayList<Video>();
	protected Tag etiqueta;
	
	UsuariView uv = new UsuariView();
	VideoView vv = new VideoView();
	
	
	public VideoController() {}		// Constructor per defecte

	
	public Tag creaTag(String nomEtiqueta) throws CampsBuits{
		if(nomEtiqueta.equals("")) 
			throw new CampsBuits("L'etiqueta no pot estar buida! Escriu almenys una etiqueta...");
		
		etiqueta = new Tag(nomEtiqueta);
		return etiqueta;
	}
	
	
	public void creaVideo() throws CampsBuits  {
		
		// Demanem les dades del v�deo a crear
		
		String url = vv.demanaURL();
		String titol = vv.demanaTitol();
		List<Tag> etiquetes = vv.llistaEtiquetes();
		LocalDateTime pujada = LocalDateTime.now();
		long durada = vv.demanaDurada();
				
		// Validem que no hi hagi camps buits
		
		if(url.equals("") || titol.equals("") || durada <= 0)
			throw new CampsBuits("No poden haver-hi camps buits en la creaci� d'un v�deo!");
		
		// Creaci� del v�deo
		
		Video nouVideo = new Video(url, titol, etiquetes, pujada, durada);
		videos.add(nouVideo);

		System.out.println("V�deo '" + titol + "' carregat amb �xit.");
	}
	
	
	public void recuperaLlista() {
		
		String textLlista = "\nEls v�deos que tens a la llista s�n: \n";
		
		// Bucle per imprimir les dades dels v�deos creats
		
		for(Video v: videos) {
			
			textLlista += v.toString() + "\n  � Estat v�deo = " + validaEstatPujada(v.getPujada()) + "\n";		
			
		}	
		
		System.out.println(textLlista);
	}
	
	
	public EstatPujada validaEstatPujada(LocalDateTime pujada) {
		
		EstatPujada estatVideo;
		
		// Calculem el temps que fa que s'ha pujat el v�deo
		
		Duration d = Duration.between(pujada, LocalDateTime.now());
		
		int seconds = (int) d.get(ChronoUnit.SECONDS);
		
		// Validem l'estat de pujada en funci� de quan fa que s'ha pujat
		
		if (seconds < 60) {
			estatVideo = EstatPujada.UPLOADING;		// El v�deo fa menys d'1 minut que s'ha creat
			
		} else if (seconds < 180) {
			estatVideo = EstatPujada.VERIFYING;		// El v�deo s'ha creat fa d'1 a 3 minuts
			
		} else {
			estatVideo = EstatPujada.PUBLIC;			// El v�deo s'ha creat fa m�s de 3 minuts
		}
		
		return estatVideo;
		
		
		// Aquestes l�nies comentades s�n per fer proves de funcionament del reproductor
		
//		if (seconds < 5) {
//			estatVideo = EstatPujada.UPLOADING;			// El v�deo s'ha creat fa menys de 5 segons
//			
//		} else if (seconds < 10) {
//			estatVideo = EstatPujada.VERIFYING;			// El v�deo s'ha creat fa menys de 10 segons
//			
//		} else {
//			estatVideo = EstatPujada.PUBLIC;			// El v�deo s'ha creat fa m�s de 10 segons
//		}
//		
//		return estatVideo;
		
	}
	
	public void reproductorVideos() {		// Fa visible el reproductor de v�deos
		ReproductorView rv = new ReproductorView(videos);
		rv.setVisible(true);
		
	}
	
}
