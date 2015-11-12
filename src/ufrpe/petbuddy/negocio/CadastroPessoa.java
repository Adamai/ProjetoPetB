package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
public class CadastroPessoa implements ICadastroB{

	private RepositorioUsuarios repositorio;
	
	public CadastroPessoa(){
		this.repositorio = new RepositorioUsuarios();
	}
	
	public void cadastrar(Pessoa p){
		this.repositorio.cadastrar(p);
	}
	
	public Pessoa busca(String nome){// ADD EXCEPTION
		return this.repositorio.busca(nome);
	}
	
	public void descadastrar(String nome){// ADD EXCEPTION
		this.repositorio.remover(nome);
	}
	
	public Usuario busca(String login, String senha) throws NullPointerException{
		return this.busca(login, senha);
	}
}
