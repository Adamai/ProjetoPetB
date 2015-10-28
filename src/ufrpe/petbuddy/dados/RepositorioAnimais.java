package ufrpe.petbuddy.dados;


import ufrpe.petbuddy.negocio.*;

import java.util.ArrayList;

public class RepositorioAnimais implements IRepositorio {

	private ArrayList<Animal> animais;
	
	
	public RepositorioAnimais(){
		this.animais = new ArrayList<Animal>();
	}
	
	
	public void cadastrar(Animal animal ){
		this.animais.add(animal);
	}
		
	public ArrayList<Animal> busca(String raca, int num){
		ArrayList<Animal>buscados = new ArrayList<Animal>();
		
		if(num ==1){//CACHORROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().toLowerCase().contains(raca.toLowerCase()) && a instanceof Cachorro){
					buscados.add(a);
				}
			}
				return buscados;
		}//FIM IF 1
		
		else if(num == 2){//GATOS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().toLowerCase().contains(raca.toLowerCase()) && a instanceof Gato){
					buscados.add(a);
				}
			}
			return buscados;
		}
		
		else if(num == 3){//OUTROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a instanceof Outro){
					Outro outro = (Outro)a;
					if(outro.getEspecie().toLowerCase().contains(raca.toLowerCase()))
					buscados.add(outro);
				}
			}
			return buscados;
		}
		else
			return null;
		
	}
	
	public Animal busca(long numid){//BUSCA UM ANIMAL ESPECIFICO POR ID
		
		for(int i = 0;i<this.animais.size();i++){
			if(this.animais.get(i).getNumid() == numid)
				return this.animais.get(i);
		}
		return null;
	}
	
	public void remover(long numid){ // REMOVE UM ANIMAL ESPECÍFICO ATRAVÉS DO ID
		this.animais.remove(this.busca(numid));
	}
}