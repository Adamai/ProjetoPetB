package ufrpe.projetos.canil.negocio;

import ufrpe.projetos.canil.dados.*;
import java.util.ArrayList;

public class CadastroAnimal {

private RepositorioAnimais repositorio;
	
	public CadastroAnimal(){
		this.repositorio = new RepositorioAnimais();
	
	}
	
	public void cadastrar(Animal a){
		if(a != null ){ // incluir condição de existencia
			this.repositorio.cadastrar(a);
		}
	}
	
public ArrayList<Animal> buscaCachorro(String raca){
		
		if((this.repositorio.buscaCachorro(raca)) !=null){
			 ArrayList<Animal>cachorros= this.repositorio.buscaCachorro(raca);
			return cachorros;
		}
		else 
			return null;
	}
public ArrayList<Animal> buscaGato(String raca){
	
	if((this.repositorio.buscaGato(raca)) !=null){
		 ArrayList<Animal>gatos= this.repositorio.buscaGato(raca);
		return gatos;
	}
	else 
		return null;
}
}
