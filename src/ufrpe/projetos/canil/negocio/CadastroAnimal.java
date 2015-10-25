package ufrpe.projetos.canil.negocio;

import ufrpe.projetos.canil.dados.*;
import java.util.ArrayList;

public class CadastroAnimal {

private RepositorioAnimais repositorio;
private RepositorioAdotados adotados;
	
	public CadastroAnimal(){
		this.repositorio = new RepositorioAnimais();
		this.adotados = new RepositorioAdotados();
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
public ArrayList<Animal> buscaOutro(String especie){
	
	if((this.repositorio.buscaOutro(especie)) !=null){
		 ArrayList<Animal>outros= this.repositorio.buscaOutro(especie);
		return outros;
	}
	else 
		return null;
}


public Animal adotar(String nome){
	Animal a = this.repositorio.buscaAdocao(nome);
	this.adotados.cadastrar(a);
	return a;
			}
}
