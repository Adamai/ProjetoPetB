package ufrpe.projetos.canil.dados;

import ufrpe.projetos.canil.negocio.*;
import java.util.ArrayList;

public class RepositorioAnimais {


	private Animal[] animais;
	private int proximo;
	
	public RepositorioAnimais(){
		this.animais = new Animal[100];
		this.proximo = 0;
	}
	
	public void cadastrar(Animal animal ){
		this.animais[this.proximo] = animal;
		this.proximo = this.proximo + 1;
	}
	
	public int buscaNumero(String raca){// BUSCA O NÚMERO DE CACHORROS DE UMA RAÇA
		int indice = 0;
		int i = 0;
		
		while(indice<this.proximo){
			
			String procurado = this.animais[indice].getRaca();
			
			if(procurado.contains(raca)){
				i++;
				indice++;
				//achou = true;
			}
			else{
				indice++;
				}
			}
		
		return i;
		
	} 
	
	public int buscaIndice(String nome){// BUSCA O INDICE DE UM CACHORRO ESPECÍFICO ATRAVÉS DO NOME
		
		int indice = 0;
		boolean achou = false;
		
		while(indice<this.proximo){
			
			String procurado = this.animais[indice].getNome();
			
			if(procurado.contains(nome)){
				achou = true;
			}
			else{
				indice++;
				}
			}
		
		return indice;
		
	}
	
	public int[] buscaIndices(String raca){ // BUSCA UM CONJUNTO DE CACHORROS DE UMA MESMA RAÇA
		int numeroAnimal = this.buscaNumero(raca);
		int indices[] = new int[numeroAnimal];
		int indice = 0;
		int i = 0;
		
		while(indice<this.proximo){
			
			String procurado = this.animais[indice].getRaca();
			
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
	
	public Animal[] buscaPorIndices(int indices[]){ // CRIA UM ARRAY COM OS CACHORROS PROCURADOS
		
		Animal a[] = new Animal[indices.length];
		for(int i = 0;i<indices.length;i++){
			a[i] = this.animais[indices[i]];
		}
		
		return a;
	}
	
	/*public Animal[] buscaAnimal(String raca){ // RETORNA TODOS OS CACHORROS DE DETERMINADA RAÇA
		
		if(this.buscaPorIndices(this.buscaIndices(raca)) != null){
			Animal a[] = this.buscaPorIndices(this.buscaIndices(raca));
			return a;
		}
		else
			return null;
	}*/
	
	public ArrayList<Animal> buscaCachorro(String raca){ // RETORNA TODOS OS CACHORROS DE DETERMINADA RAÇA
		ArrayList<Animal>cachorros = new ArrayList<Animal>();
		
		if(this.buscaPorIndices(this.buscaIndices(raca)) != null){
			Animal a[] = this.buscaPorIndices(this.buscaIndices(raca));
			for(int i =0;i<a.length;i++){
				if(a[i] instanceof Cachorro){
					cachorros.add((Cachorro)a[i]);
				}
			}
			
			return cachorros;
		}
		else
			return null;
	}
	public ArrayList<Animal> buscaGato(String raca){ // RETORNA TODOS OS GATOS DE DETERMINADA RAÇA
		ArrayList<Animal>gatos = new ArrayList<Animal>();
		
		if(this.buscaPorIndices(this.buscaIndices(raca)) != null){
			Animal a[] = this.buscaPorIndices(this.buscaIndices(raca));
			for(int i =0;i<a.length;i++){
				if(a[i] instanceof Gato){
					gatos.add((Gato)a[i]);
				}
			}
			
			return gatos;
		}
		else
			return null;
	}
	
	public void remover(String nome){ // REMOVE UM CACHORRO ESPECÍFICO ATRAVÉS DO NOME
		int indice = this.buscaIndice(nome);
		if(indice != this.proximo){
			this.animais[indice] = this.animais[this.proximo -1];
			this.animais[this.proximo - 1] = null;
			this.proximo = this.proximo - 1;
		}
	}
}