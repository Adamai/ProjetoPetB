package ufrpe.petbuddy.negocio;

import java.util.ArrayList;
import ufrpe.petbuddy.dados.*;

public class CadastroAdocao {

	private RepositorioAdocoes repositorio;
	
	public CadastroAdocao(){
		this.repositorio = new RepositorioAdocoes();
	}
	
	public void cadastrar(Adocao a){
		this.repositorio.cadastrar(a);
	}
	
	public ArrayList<Adocao> busca(){
		return this.repositorio.busca();
	}
}
