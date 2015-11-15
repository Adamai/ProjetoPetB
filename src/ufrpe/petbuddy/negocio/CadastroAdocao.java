package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Adocao;

public class CadastroAdocao implements ICadastroAdocao{

	private IRepositorioAdocoes repositorio;
	
	public CadastroAdocao(){
		this.repositorio = new RepositorioAdocoes();
	}
	
	public void cadastrar(Adocao a){
		this.repositorio.cadastrar(a);
	}
	
	public ArrayList<Adocao> busca() throws HistException{ // ADD NULL EXCEPTION 
		return this.repositorio.busca();
	}
	
	public Adocao busca(long numid) throws IDException{ // ADD NULL EXCEPTION
		return this.repositorio.busca(numid);
	}
}
