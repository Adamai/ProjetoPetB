package ufrpe.petbuddy.dados;


import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.negocio.*;

import java.util.ArrayList;

public class RepositorioAnimais implements IRepositorioA {

	private ArrayList<Animal> animais;
	private ArrayList<Animal> adotados;
	
	
	public RepositorioAnimais(){
		this.animais = new ArrayList<Animal>();
		this.adotados = new ArrayList<Animal>();
	}
	
	
	public void cadastrar(Animal animal ){
		this.animais.add(animal);
	}
		
	public ArrayList<Animal> busca(String raca, int num) throws RepoException{ // ADD NULL EXCEPTION EM TODOS OS CASOS
		ArrayList<Animal>buscados = new ArrayList<Animal>();
		
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
	
	
	public void remover(Animal a){ // REMOVE UM ANIMAL ESPECÍFICO ATRAVÉS DO ID
		this.animais.remove(a);
	}
}