package ufrpe.petbuddy.gui;

import javax.swing.JOptionPane;

import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.exceptions.*;

public class PetBuddy {

	public static void main (String [] args){
		
		
		IFachada fachada = Fachada.getInstance();
		//GerenciadorTelas gerenciador = GerenciadorTelas.getInstance();
		try{
			Usuario adm = new Adm();
			fachada.cadastrarPessoa(adm);
			
		}
		catch(DadosException d){
			JOptionPane.showMessageDialog(null, "não foi possivel inicializar o programa pois não existe adm cadastrado");
		}

		TelaPrincipal principal = new TelaPrincipal(fachada);
		principal.setVisible(true);
		
		//gerenciador.mostrarTelaPrincipal();
		
		
	}
}
