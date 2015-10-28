package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
public class CadastroPessoa {

	private RepositorioPessoas repositorio;
	
	public CadastroPessoa(){
		this.repositorio = new RepositorioPessoas();
	}
	
	public void cadastrar(Pessoa p){
		this.repositorio.cadastrar(p);
	}
	
	public void descadastrar(String nome){
		this.repositorio.remover(nome);
	}
	
}
