package ufrpe.petbuddy.negocio;

import java.util.ArrayList;
import ufrpe.petbuddy.dados.*;

public class CadastroAdocao implements ICadastroC{

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
	
	public Adocao busca(long numid){
		return this.repositorio.busca(numid);
	}
}
