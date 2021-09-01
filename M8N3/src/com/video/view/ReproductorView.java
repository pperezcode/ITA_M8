package com.video.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.video.application.ReproductorController;
import com.video.domain.Video;

@SuppressWarnings("serial")
public class ReproductorView extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JComboBox<String> comboV;
	private JButton bPlay;
	private JButton bPause;
	private JButton bStop;
	
	protected List<Video> videos = new ArrayList<Video>();
	
	ReproductorController rc = new ReproductorController();
	
	
	public ReproductorView(List<Video> videos) {	// Crea la finestra del reproductor
		
		setSize(500, 200);
		setTitle("Reproductor");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		this.videos = videos;

		iniciarComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	private void iniciarComponents() {		// Afegeix components a la finestra del reproductor
		
		afegirPanel();
		afegirBotons();
		afegirComboBox();
		
	}
	
	
	private void afegirPanel() {		// Afegeix JPanel al reproductor

		panel = new JPanel();
		setContentPane(panel);
		this.setVisible(true);
	}

	
	private void afegirBotons() {		// Botons del reproductor
		
		bPlay = new JButton("PLAY");
		bPlay.setBounds(100, 200, 75, 30);
		panel.add(bPlay);
		bPlay.addActionListener(this);
		
		bPause = new JButton("PAUSE");
		bPause.setBounds(200, 200, 75, 30);
		panel.add(bPause);
		bPause.addActionListener(this);
		
		bStop = new JButton("STOP");
		bStop.setBounds(300, 200, 75, 30);
		panel.add(bStop);
		bStop.addActionListener(this);
		
	}
	
	
	private void afegirComboBox() {		// Afegir el llistat de vídeos en un desplegable al reproductor
		
		comboV = new JComboBox<String>();
		
		comboV.setBounds(200,  200,  150, 50);
		
		for(Video v: videos) {
			comboV.addItem(v.getTitol());
		}
		
		panel.add(comboV);		
		
	}

	// Sobreescrivim el mètode actionPerformed per a indicar les accions a fer quan es premen els botos del reproductor
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == bPlay) {
			
			System.out.println("PLAY: " + comboV.getSelectedItem());
			
			rc.playVideo(videos, comboV.getSelectedIndex());
		
		} else if (e.getSource() == bPause) {
			
			System.out.println("PAUSE: " + comboV.getSelectedItem());
						
			rc.pauseVideo(videos, comboV.getSelectedIndex());
		
		} else if (e.getSource() == bStop) {
			
			System.out.println("STOP: " + comboV.getSelectedItem());
		
			rc.stopVideo(videos, comboV.getSelectedIndex());
		}
		
	}
		
}	

   
