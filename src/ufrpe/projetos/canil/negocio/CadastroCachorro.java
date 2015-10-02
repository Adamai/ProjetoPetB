package ufrpe.projetos.canil.negocio;

import ufrpe.projetos.canil.dados.*;

public class CadastroCachorro {

	private RepositorioCachorros repositorio;
	
	public CadastroCachorro(){
		this.repositorio = new RepositorioCachorros();
		
	}
	
	public void cadastrar(Cachorro c){
		if(c != null ){ // incluir condição de existencia
			this.repositorio.cadastrar(c);
		}
		//else
			//alguma coisa
	}
	
	/*public void adotar(String nome){
		Cachorro c = this.repositorio.buscaCachorro(nome);
		if(c != null){
			this.repositorio.remover(nome);
		}
		//else //caso o cahorro n exista
			//alguma coisa
	}*/
	
	public Cachorro[] busca(String raca){
		
		if((this.repositorio.buscaCachorro(raca)) !=null){
			Cachorro c[] = this.repositorio.buscaCachorro(raca);
			return c;
		}
		else
			return null;
	}
	
}
