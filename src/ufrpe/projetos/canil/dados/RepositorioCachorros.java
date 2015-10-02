package ufrpe.projetos.canil.dados;

import ufrpe.projetos.canil.negocio.Cachorro;

public class RepositorioCachorros {
//testando o github
	private Cachorro[] cachorros;
	private int proximo;
	
	public RepositorioCachorros(){
		this.cachorros = new Cachorro[100];
		this.proximo = 0;
	}
	
	public void cadastrar(Cachorro cachorro){
		this.cachorros[this.proximo] = cachorro;
		this.proximo = this.proximo + 1;
	}
	
	public int buscaNumero(String raca){// BUSCA O NÚMERO DE CACHORROS DE UMA RAÇA
		int indice = 0;
		int i = 0;
		
		while(indice<this.proximo){
			
			String procurado = this.cachorros[indice].getRaca();
			
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
			
			String procurado = this.cachorros[indice].getNome();
			
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
		int numeroDogs = this.buscaNumero(raca);
		int indices[] = new int[numeroDogs];
		int indice = 0;
		int i = 0;
		
		while(indice<this.proximo){
			
			String procurado = this.cachorros[indice].getRaca();
			
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
	
	public Cachorro[] buscaPorIndices(int indices[]){ // CRIA UM ARRAY COM OS CACHORROS PROCURADOS
		
		Cachorro c[] = new Cachorro[indices.length];
		for(int i = 0;i<indices.length;i++){
			c[i] = this.cachorros[indices[i]];
		}
		
		return c;
	}
	
	public Cachorro[] buscaCachorro(String raca){ // RETORNA TODOS OS CACHORROS DE DETERMINADA RAÇA
		
		if(this.buscaPorIndices(this.buscaIndices(raca)) != null){
			Cachorro c[] = this.buscaPorIndices(this.buscaIndices(raca));
			return c;
		}
		else
			return null;
	}
	
	public void remover(String nome){ // REMOVE UM CACHORRO ESPECÍFICO ATRAVÉS DO NOME
		int indice = this.buscaIndice(nome);
		if(indice != this.proximo){
			this.cachorros[indice] = this.cachorros[this.proximo -1];
			this.cachorros[this.proximo - 1] = null;
			this.proximo = this.proximo - 1;
		}
		
	}
	
	
}
