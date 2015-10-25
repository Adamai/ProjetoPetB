package ufrpe.projetos.canil.dados;

import ufrpe.projetos.canil.negocio.*;
import java.util.ArrayList;

public class RepositorioAnimais {


	private ArrayList<Animal> animais;
	
	
	public RepositorioAnimais(){
		this.animais = new ArrayList<Animal>();
	}
	
	
	public void cadastrar(Animal animal ){
		this.animais.add(animal);
	}
	
	
	public int buscaNumero(String raca){// BUSCA O NÚMERO DE CACHORROS DE UMA RAÇA
		int indice = 0;
		int i = 0;
		
		while(indice<this.animais.size()){
			
			String procurado = this.animais.get(indice).getRaca();
			
			if(procurado.contains(raca)){
				i++;
				indice++;
			}
			else{
				indice++;
				}
			}
		
		return i;
		
	} 
	
	
	public int buscaIndice(String nome){// BUSCA O INDICE DE UM ANIMAL ESPECÍFICO ATRAVÉS DO NOME
		
		int indice = 0;
		boolean achou = false;
		
		while(indice<this.animais.size() && !achou){
			
			String procurado = this.animais.get(indice).getNome();
			
			if(procurado.contains(nome)){
				achou = true;
			}
			else{
				indice++;
				}
			}
		
		return indice;
		
	}
	
	
	public int[] buscaIndices(String raca){ // BUSCA UM CONJUNTO DE ANIMAIS DE UMA MESMA RAÇA
		int numeroAnimal = this.buscaNumero(raca);
		int indices[] = new int[numeroAnimal];
		int indice = 0;
		int i = 0;
		
		while(indice<this.animais.size()){
			
			String procurado = this.animais.get(indice).getRaca();
			
			if(procurado.contains(raca)){
				indices[i] = indice;
				i++;
				indice++;
			}
			else{
				indice++;
				}
			}
		
		return indices;
	}
	
	
	public ArrayList<Animal> buscaCachorro(String raca){ // RETORNA TODOS OS CACHORROS DE DETERMINADA RAÇA
		ArrayList<Animal>cachorros = new ArrayList<Animal>();
		
		int indices[] = this.buscaIndices(raca);
			for(int i =0;i<indices.length;i++){
				if(animais.get(indices[i]) instanceof Cachorro){
					cachorros.add((Cachorro)animais.get(indices[i]));
				}
			}
			return cachorros;
		}
	
	
	public ArrayList<Animal> buscaGato(String raca){ // RETORNA TODOS OS GATOS DE DETERMINADA RAÇA
		ArrayList<Animal>gatos = new ArrayList<Animal>();
		
		int indices[] = this.buscaIndices(raca);
		for(int i =0;i<indices.length;i++){
			if(animais.get(indices[i]) instanceof Cachorro){
				gatos.add((Gato)animais.get(indices[i]));
			}
		}
		return gatos;
	}
	
	
	public Animal buscaAdocao(String nome){
		int indice = this.buscaIndice(nome);
		Animal a = animais.get(indice);
		this.remover(a);
		return a;
		
	}
	
	public void remover(Animal a){ // REMOVE UM CACHORRO ESPECÍFICO ATRAVÉS DO NOME
		for(int i = 0;i<animais.size();i++){
			if(animais.get(i).equals(a)){
				animais.remove(i);
			}
		}
	}
}