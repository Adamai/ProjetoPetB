package ufrpe.petbuddy.dados;


import ufrpe.petbuddy.negocio.*;

import java.util.ArrayList;

public class RepositorioPessoas implements IRepositorioB {

	private ArrayList<Pessoa>pessoas;
	
	
	public RepositorioPessoas(){
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public void cadastrar(Pessoa p){
		this.pessoas.add(p);
	}
	
	public Pessoa busca(String nome){ // ADD NULL EXCEPTION
		for(int i = 0;i<this.pessoas.size();i++){
			if(this.pessoas.get(i).getNome().equalsIgnoreCase(nome))
				return this.pessoas.get(i);
		}
		return null;
	}
	
	//public Pessoa busca(String login, String senha){ // ADD NULL EXCEPTION 
	//	for(int i = 0;i<this.pessoas.size();i++){
	//		if(this.pessoas.get(i).getLogin().equals(login) && this.pessoas.get(i).getSenha().equals(senha))
	//			return this.pessoas.get(i);
	//	}
	//	return null;
	//}
	
	public void remover(String nome){ // EXCEPTION?
		this.pessoas.remove(this.busca(nome));
	}
	
	
	
}
