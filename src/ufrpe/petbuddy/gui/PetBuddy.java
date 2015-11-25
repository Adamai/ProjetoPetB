package ufrpe.petbuddy.gui;

import ufrpe.petbuddy.facade.*;

public class PetBuddy {

	public static void main (String [] args){
		
		
		IFachada fachada = Fachada.getInstance();
		
		
		TelaPrincipal tela = new TelaPrincipal(fachada);
		tela.setVisible(true);
		
		
	}
}
