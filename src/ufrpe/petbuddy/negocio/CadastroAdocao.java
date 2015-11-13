package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Adocao;

public class CadastroAdocao implements ICadastroAdocao{

	private RepositorioAdocoes repositorio;
	
	public CadastroAdocao(){
		this.repositorio = new RepositorioAdocoes();
	}
	
	public void cadastrar(Adocao a){
		this.repositorio.cadastrar(a);
	}
	
	public ArrayList<Adocao> buscahistoricoadocoes(){ // ADD NULL EXCEPTION 
		return this.repositorio.busca();
	}
	
	public Adocao buscaporid(long numid) throws IDException{ // ADD NULL EXCEPTION
		return this.repositorio.busca(numid);
	}
}
