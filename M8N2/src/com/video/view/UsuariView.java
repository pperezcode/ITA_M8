package com.video.view;

import javax.swing.JOptionPane;

public class UsuariView {
	
	public String demanaNom() {
		String nom = JOptionPane.showInputDialog("USUARI:\n\nNom:").toUpperCase();
		return nom;
	}
	
	public String demanaCognom() {
		String cognom = JOptionPane.showInputDialog("USUARI:\n\nCognom:").toUpperCase();
		return cognom;
	}
	
	public String demanaPassword() {
		String password = JOptionPane.showInputDialog("USUARI:\n\nIntrodueix una contrasenya:");
		return password;
	}

 }
