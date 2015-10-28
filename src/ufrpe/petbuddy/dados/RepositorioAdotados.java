package ufrpe.petbuddy.dados;

import java.util.ArrayList;


import ufrpe.petbuddy.negocio.*;

public class RepositorioAdotados implements IRepositorio{

	private ArrayList<Animal> adotados;
	
	public RepositorioAdotados(){
		this.adotados = new ArrayList<Animal>();
	}
	
	public void cadastrar(Animal a){
		this.adotados.add(a);
	}
	
	public ArrayList<Animal> busca(String raca, int num){
		ArrayList<Animal>buscados = new ArrayList<Animal>();
		
		if(num ==1){//CACHORROS
			for(int i = 0; i<this.adotados.size();i++){
				Animal a = this.adotados.get(i);
				if(a.getRaca().contains(raca) && a instanceof Cachorro){
					buscados.add(a);
				}
			}
				return buscados;
		}//FIM IF 1
		
		else if(num == 2){//GATOS
			for(int i = 0; i<this.adotados.size();i++){
				Animal a = this.adotados.get(i);
				if(a.getRaca().contains(raca) && a instanceof Gato){
					buscados.add(a);
				}
			}
			return buscados;
		}
		
		else if(num == 3){//OUTROS
			for(int i = 0; i<this.adotados.size();i++){
				Animal a = this.adotados.get(i);
				if(a instanceof Outro){
					Outro outro = (Outro)a;
					if(outro.getEspecie().contains(raca))
					buscados.add(outro);
				}
			}
			return buscados;
		}
		else
			return null;
		
	}
	
	public Animal busca(long numid){
		for(int i = 0;i<this.adotados.size();i++){
			if(this.adotados.get(i).getNumid() == numid)
				return this.adotados.get(i);
		}
		return null;
	}
	
	public void remover(long numid){ // REMOVE UM ANIMAL ESPEC�FICO ATRAV�S DO NUMERO
		this.adotados.remove(this.busca(numid));
	}

	
	
	
}