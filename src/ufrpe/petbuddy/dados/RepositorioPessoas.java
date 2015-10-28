package ufrpe.petbuddy.dados;


import ufrpe.petbuddy.negocio.*;

import java.util.ArrayList;

public class RepositorioPessoas {

	private ArrayList<Pessoa>pessoas;
	
	
	public RepositorioPessoas(){
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public void cadastrar(Pessoa p){
		this.pessoas.add(p);
	}
	
	public Pessoa busca(String nome){
		for(int i = 0;i<this.pessoas.size();i++){
			if(this.pessoas.get(i).getNome().equalsIgnoreCase(nome))
				return this.pessoas.get(i);
		}
		return null;
	}
	
	public void remover(String nome){
		this.pessoas.remove(this.busca(nome));
	}
	
	
	
}
