package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.exceptions.IDException;

public class CadastroAdocao implements ICadastroC{

	private RepositorioAdocoes repositorio;
	
	public CadastroAdocao(){
		this.repositorio = new RepositorioAdocoes();
	}
	
	public void cadastrar(Adocao a){
		this.repositorio.cadastrar(a);
	}
	
	public ArrayList<Adocao> busca(){ // ADD NULL EXCEPTION 
		return this.repositorio.busca();
	}
	
	public Adocao busca(long numid) throws IDException{ // ADD NULL EXCEPTION
		return this.repositorio.busca(numid);
	}
}
