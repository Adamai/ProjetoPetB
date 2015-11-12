package ufrpe.petbuddy.dados;

import ufrpe.petbuddy.negocio.*;

import java.util.ArrayList;

public class RepositorioUsuarios implements IRepositorioB {

	private ArrayList<Usuario>usuarios;
	
	
	public RepositorioUsuarios(){
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void cadastrar(Usuario p){
		this.usuarios.add(p);
	}
	
	public Pessoa busca(String nome){ // ADD NULL EXCEPTION
		for(int i = 0;i<this.usuarios.size();i++){
			if(this.usuarios.get(i).getNome().equalsIgnoreCase(nome))
				return (Pessoa)this.usuarios.get(i);
		}
		return null;
	}
	
	public Usuario buscaLogin(String login, String senha)throws NullPointerException{ // ADD NULL EXCEPTION 
		Usuario aux = null;
		for(int i = 0;i<this.usuarios.size();i++){
			aux = this.usuarios.get(i);
			if(aux instanceof Pessoa){
				Pessoa p = (Pessoa)aux;
				if(p.getLogin().equals(login) && p.getSenha().equals(senha)){
					return aux;
				}
			}
			
			else if(aux instanceof Adm){
				Adm a = (Adm) aux;
				if(a.getLogin().equals(login) && a.getSenha().equals(senha)){
					return aux;
				}
			}
		}
		throw new NullPointerException("Login ou senha incorretos");
		
	}
	
	public void remover(String nome){ // EXCEPTION?
		this.usuarios.remove(this.busca(nome));
	}
	
	
	
}
