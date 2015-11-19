package ufrpe.petbuddy.dados;


import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.Animal;
import ufrpe.petbuddy.negocio.beans.Cachorro;
import ufrpe.petbuddy.negocio.beans.Gato;
import ufrpe.petbuddy.negocio.beans.Outro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RepositorioAnimais implements IRepositorioAnimais, Serializable {

	private ArrayList<Animal> animais;
	private ArrayList<Animal> adotados;
	
	
	public RepositorioAnimais(){
		this.animais = new ArrayList<Animal>();
		this.adotados = new ArrayList<Animal>();
	}
	
	
	public void cadastrar(Animal animal ){
		loadRepo();
		this.animais.add(animal);
		overwriteRepo(this.animais);
	}
		
	public ArrayList<Animal> busca(String raca, int num) throws RepoException{ // ADD NULL EXCEPTION EM TODOS OS CASOS
		ArrayList<Animal>buscados = new ArrayList<Animal>();
		loadRepo();
		if(num ==1){//CACHORROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().toLowerCase().contains(raca.toLowerCase())&& a instanceof Cachorro ){
					buscados.add(a);
				}
			}
				
		}//FIM IF 1
		
		else if(num == 2){//GATOS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().toLowerCase().contains(raca.toLowerCase())&& a instanceof Gato){
					buscados.add(a);
				}
			}
			
		}
		
		else if(num == 3){//OUTROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a instanceof Outro){
					Outro outro = (Outro)a;
					if(outro.getEspecie().toLowerCase().contains(raca.toLowerCase()) && outro instanceof Outro)
					buscados.add(outro);
				}
			}
			
		}
		if(buscados.size() > 0)
			return buscados;
			else
				throw new RepoException(raca, num);
		
		
	}
	
	public Animal busca(long numid)throws IDException{//BUSCA UM ANIMAL ESPECIFICO POR ID // ADD NULL EXCEPTION
		loadRepo();
		Animal a = null;
		for(int i = 0;i<this.animais.size();i++){
			if(this.animais.get(i).getNumid() == numid){
				this.animais.get(i).setAdotado(true);
				a= this.animais.get(i);
			}
		}
		if(a != null)
			return a;
		else
			throw new IDException(numid);
	}
	
	public void adotar(long numid) throws IDException{ // EXCEPTION?
		Animal a = this.busca(numid);
		this.adotados.add(a);
		this.remover(this.busca(numid));
	}
	
	
	public void remover(Animal a){ 
		loadRepo();
		this.animais.remove(a);
		overwriteRepo(this.animais);
	}
	@Override
	public void loadRepo(){
	File data = new File("DatabaseAnimal.rp");
	ObjectInputStream readob = null;
	if (data.exists()){
		try{
		FileInputStream read = new FileInputStream(data);
		readob = new ObjectInputStream(read);
		this.animais = (ArrayList<Animal>) readob.readObject();
		readob.close();
	} catch (Exception e){
		e.printStackTrace();
	}

		}
	}
	@Override
	public void saveRepo(){ //inutil
		File data = new File("DatabaseAnimal.rp");
		ObjectInputStream readob = null;
		if (data.exists()){
			try{
			FileInputStream read = new FileInputStream(data);
			readob = new ObjectInputStream(read);
			this.animais = (ArrayList<Animal>) readob.readObject();
			readob.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		}
		ObjectOutputStream save = null;
		try{
		FileOutputStream fos = new FileOutputStream(data);
		save = new ObjectOutputStream(fos);
		save.writeObject(this.animais);
		fos.close();
		} catch (Exception e){
			e.printStackTrace();
		}		
		
	}
	@Override
	public void overwriteRepo(ArrayList<Animal> animais){ //usado para deletar   NÃO FUNCIONANDO
		//inserir método para deletar o arquivo existente
		File data = new File("DatabaseAnimal.rp");
		ObjectOutputStream save = null;
		try{
		FileOutputStream fos = new FileOutputStream(data);
		save = new ObjectOutputStream(fos);
		save.writeObject(animais);
		fos.close();
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	

	
	
}