package ufrpe.projetos.canil.dados;

import java.util.ArrayList;
import ufrpe.projetos.canil.negocio.*;

public class RepositorioAdotados {

	private ArrayList<Animal> adotados;
	
	public RepositorioAdotados(){
		this.adotados = new ArrayList<Animal>();
	}
	
	public void cadastrar(Animal a){
		this.adotados.add(a);
	}
	
	
}
