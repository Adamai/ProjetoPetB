package ufrpe.petbuddy.dados;

import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.Adm;
import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.exceptions.*;

import java.util.ArrayList;

public class RepositorioUsuarios implements IRepositorioUsuarios {

	private ArrayList<Usuario>usuarios;
	
	
	public RepositorioUsuarios(){
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void cadastrar(Usuario p){
		this.usuarios.add(p);
	}
	
	public Pessoa busca(String nome) throws RepoException{ // ADD NULL EXCEPTION
		Pessoa p = null;
		for(int i = 0;i<this.usuarios.size();i++){
			if(this.usuarios.get(i).getNome().equalsIgnoreCase(nome))
				p= (Pessoa)this.usuarios.get(i);
		}
		if(p != null)
			return p;
		else
			throw new RepoException(nome);
	}
	
	public Usuario buscaLogin(String login, String senha)throws RepoException{ // ADD NULL EXCEPTION 
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
		throw new RepoException(login,senha);
		
	}
	
	public void remover(String nome) throws RepoException{ // EXCEPTION?
		this.usuarios.remove(this.busca(nome));
	}
	
	
	
}
