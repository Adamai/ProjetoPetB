package ufrpe.projetos.canil.dados;

import ufrpe.projetos.canil.negocio.*;
import java.util.ArrayList;

public class RepositorioPessoas {

	private ArrayList<Pessoa>pessoas;
	
	
	public RepositorioPessoas(){
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public void cadastrar(Pessoa p){
		pessoas.add(p);
	}
	
	public int busca(Pessoa p){
		
		for(int i=0;i<this.pessoas.size();i++){
			if(this.pessoas.get(i).equals(p)){
				return i;
			}
		}
		return -1;
	}
	
	public int busca(String login, String senha){
		for(int i=0;i<this.pessoas.size();i++){
			if(this.pessoas.get(i).getLogin()== login && this.pessoas.get(i).getSenha() == senha){
				return i;
			}
		}
		return -1;
	}
	
	
	
	public void remover(Pessoa p){
		int indice = this.busca(p);
		
		if(indice != -1){
			this.pessoas.remove(indice);
		}
	}
	
	public Pessoa buscaLogin(String login,String senha){
		int indice = this.busca(login, senha);
		
		if(indice != -1){
			return this.pessoas.get(indice);
		}
		else
			return null;
	}
	
}
