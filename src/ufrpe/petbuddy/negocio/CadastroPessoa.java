package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
public class CadastroPessoa implements ICadastroB{

	private RepositorioPessoas repositorio;
	
	public CadastroPessoa(){
		this.repositorio = new RepositorioPessoas();
	}
	
	public void cadastrar(Pessoa p){
		this.repositorio.cadastrar(p);
	}
	
	public Pessoa busca(String nome){
		return this.repositorio.busca(nome);
	}
	
	public void descadastrar(String nome){
		this.repositorio.remover(nome);
	}
	
}
