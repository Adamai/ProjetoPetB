package ufrpe.petbuddy.dados;


import ufrpe.petbuddy.negocio.beans.Adm;
import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.exceptions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioUsuarios implements IRepositorioUsuarios, Serializable {

	private ArrayList<Usuario>usuarios;
	
	
	public RepositorioUsuarios() {
		this.usuarios = new ArrayList<Usuario>();
		
	}
	
	public void cadastrar(Usuario p){
		loadRepo();
		this.usuarios.add(p);
		overwriteRepo(usuarios);
	}
	
	public Pessoa busca(String nome) throws RepoException{ // ADD NULL EXCEPTION
		loadRepo();
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
		loadRepo();
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
		loadRepo();
		this.usuarios.remove(this.busca(nome));
		overwriteRepo(usuarios);
	}
	
	public void overwriteRepo(ArrayList<Usuario> usuarios){ //usado para deletar e recriar   -    FUNCIONANDO
		File data = new File("DatabaseUsers.rp");
		data.delete();
		ObjectOutputStream save = null;
		try{
		FileOutputStream fos = new FileOutputStream(data);
		save = new ObjectOutputStream(fos);
		save.writeObject(usuarios);
		fos.close();
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
	public void loadRepo(){
	File data = new File("DatabaseUsers.rp");
	ObjectInputStream readob = null;
	if (data.exists()){
		try{
		FileInputStream read = new FileInputStream(data);
		readob = new ObjectInputStream(read);
		this.usuarios = (ArrayList<Usuario>) readob.readObject();
		readob.close();
	} catch (Exception e){
		e.printStackTrace();
	}

		}
	}
	
	public boolean VerificarLogin( String login){
		loadRepo();
		boolean resultado = true;
		for(int i = 0; i<usuarios.size(); i++){
			if(usuarios.get(i) instanceof Pessoa){
				Pessoa p =(Pessoa) usuarios.get(i);
				if(p.getLogin().equals(login)){
					resultado = false;
				}
			}
		}
		return resultado;
	}
	
	public ArrayList<Usuario> listarUsuarios() throws HistException{
		loadRepo();
		if(usuarios.size()>0){
			return this.usuarios;
		}
		else
			throw new HistException();	}
	
	
}
