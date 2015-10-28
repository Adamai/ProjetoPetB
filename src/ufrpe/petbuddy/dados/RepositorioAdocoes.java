package ufrpe.petbuddy.dados;

import java.util.ArrayList;
import ufrpe.petbuddy.negocio.*;

public class RepositorioAdocoes {

	private ArrayList<Adocao>adocoes;
	
	public RepositorioAdocoes(){
		this.adocoes = new ArrayList<Adocao>();
	}
	
	public void cadastrar(Adocao a){
		this.adocoes.add(a);
	}
	
	public ArrayList<Adocao> busca(){
		return this.adocoes;
	}
	
	
}
