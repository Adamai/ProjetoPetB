package ufrpe.petbuddy.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import ufrpe.petbuddy.negocio.beans.Veterinario;
import ufrpe.petbuddy.exceptions.*;

public class RepositorioVet implements IRepositorioVet, Serializable {

	private ArrayList<Veterinario>veterinarios;
	
	public RepositorioVet(){
		this.veterinarios = new ArrayList<Veterinario>();
	}
	
	public void cadastrar(Veterinario vet){
		loadRepo();
		this.veterinarios.add(vet);
		overwriteRepo(veterinarios);
	}
	
	public Veterinario busca(long numid) throws IDException{
		loadRepo();
		Veterinario vet = null;
		for(int i = 0; i<veterinarios.size();i++){
			if(veterinarios.get(i).getNumid() == numid)
				vet = veterinarios.get(i);
		}
		if(vet != null)
			return vet;
		else
			throw new IDException(numid);
		
	}
	
	public ArrayList<Veterinario> busca() throws HistException{
		loadRepo();
		if(this.veterinarios.size()>0)
			return this.veterinarios;
		else
			throw new HistException();
	}
	
	
	public void remover(long numid) throws IDException{
		loadRepo();
		veterinarios.remove(this.busca(numid));
		overwriteRepo(veterinarios);
	}
	
	public void overwriteRepo(ArrayList<Veterinario> veterinarios){ //usado para deletar e recriar   -    FUNCIONANDO
		File data = new File("DatabaseVet.rp");
		data.delete();
		ObjectOutputStream save = null;
		try{
		FileOutputStream fos = new FileOutputStream(data);
		save = new ObjectOutputStream(fos);
		save.writeObject(veterinarios);
		fos.close();
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
	public void loadRepo(){
	File data = new File("DatabaseVet.rp");
	ObjectInputStream readob = null;
	if (data.exists()){
		try{
		FileInputStream read = new FileInputStream(data);
		readob = new ObjectInputStream(read);
		this.veterinarios = (ArrayList<Veterinario>) readob.readObject();
		readob.close();
	} catch (Exception e){
		e.printStackTrace();
	}

		}
	
	}
	public void atualizarVeterinario(Veterinario v){
		loadRepo();
		for(int i = 0;i<this.veterinarios.size();i++){
			if(this.veterinarios.get(i).getNumid() == v.getNumid()){
				this.removerVeterinario(this.veterinarios.get(i));
				this.cadastrar(v);
				break;
						}
				}
		}
	public void removerVeterinario(Veterinario v){ 
		loadRepo();
		for(int index = 0; index < veterinarios.size(); index++)
			if(veterinarios.get(index).getNumid() == v.getNumid()){
				this.veterinarios.remove(index);
			}
		overwriteRepo(this.veterinarios);
	}
	
}
