package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;
public class CadastroPessoa implements ICadastroPessoa{

	private RepositorioUsuarios repositorio;
	
	public CadastroPessoa(){
		this.repositorio = new RepositorioUsuarios();
	}
	
	public void cadastrarpessoa(Pessoa p){
		this.repositorio.cadastrar(p);
	}
	
	public Pessoa buscanome(String nome){// ADD EXCEPTION
		return this.repositorio.busca(nome);
	}
	
	public void descadastrar(String nome){// ADD EXCEPTION
		this.repositorio.remover(nome);
	}
	
	public Usuario buscausuario(String login, String senha) throws NullPointerException{
		return this.buscausuario(login, senha);
	}
}
