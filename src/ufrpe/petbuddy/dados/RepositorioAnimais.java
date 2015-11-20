package ufrpe.petbuddy.dados;


import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.*;

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
		
	public ArrayList<Animal> busca(String raca, AnimalEspecie especie) throws RepoException{ // ADD NULL EXCEPTION EM TODOS OS CASOS
		ArrayList<Animal>buscados = new ArrayList<Animal>();
		loadRepo();
		if(especie.equals(AnimalEspecie.CACHORRO)){//CACHORROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().toLowerCase().contains(raca.toLowerCase())&& a.getEspecie().equals(AnimalEspecie.CACHORRO)){
					buscados.add(a);
				}
			}
				
		}//FIM IF 1
		
		else if(especie.equals(AnimalEspecie.GATO)){//GATOS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().toLowerCase().contains(raca.toLowerCase())&& a.getEspecie().equals(AnimalEspecie.GATO)){
					buscados.add(a);
				}
			}
			
		}
		
		else if(especie.equals(AnimalEspecie.AVE)){//OUTROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
					if(a.getRaca().toLowerCase().contains(raca.toLowerCase())&& a.getEspecie().equals(AnimalEspecie.AVE)){
					buscados.add(a);
				}
			}
			
		}
		else if(especie.equals(AnimalEspecie.ROEDOR)){//OUTROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
					if(a.getRaca().toLowerCase().contains(raca.toLowerCase())&& a.getEspecie().equals(AnimalEspecie.ROEDOR)){
					buscados.add(a);
				}
			}
		}
		else if(especie.equals(AnimalEspecie.REPTIL)){//OUTROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
					if(a.getRaca().toLowerCase().contains(raca.toLowerCase())&& a.getEspecie().equals(AnimalEspecie.REPTIL)){
					buscados.add(a);
				}
			}
			
		}
		if(buscados.size() > 0)
			return buscados;
			else
				throw new RepoException(raca, especie);
		
		
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
		loadRepo();
		Animal a = this.busca(numid);
		this.adotados.add(a);
		this.remover(this.busca(numid));
	}
	
	
	public void remover(Animal a){ 
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
		data.delete();
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