package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.exceptions.*;

public class CadastroPessoa implements ICadastroPessoa{

	private IRepositorioUsuarios repositorio;
	
	public CadastroPessoa(){
		this.repositorio = new RepositorioUsuarios();
	}
	
	public void cadastrar(Pessoa p){
		this.repositorio.cadastrar(p);
	}
	
	public Pessoa busca(String nome) throws RepoException{// ADD EXCEPTION
		return  this.repositorio.busca(nome);
	}
	
	public void descadastrar(String nome) throws RepoException{// ADD EXCEPTION
		this.repositorio.remover(nome);
	}
	
	public Usuario busca(String login, String senha) throws RepoException{
		return this.repositorio.buscaLogin(login, senha);
	}
}
