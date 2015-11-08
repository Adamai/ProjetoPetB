package ufrpe.petbuddy.dados;

import java.util.ArrayList;
import ufrpe.petbuddy.negocio.*;

public class RepositorioAdocoes implements IRepositorioC{

	private ArrayList<Adocao>adocoes;
	
	public RepositorioAdocoes(){
		this.adocoes = new ArrayList<Adocao>();
	}
	
	public void cadastrar(Adocao a){
		this.adocoes.add(a);
	}
	
	public ArrayList<Adocao> busca(){ // ADD NULL EXCEPTION
		return this.adocoes;
	}
	
	public Adocao busca(long numid){  // ADD NULL EXCEPTION
		for(int i = 0;i<this.adocoes.size();i++){
			if(this.adocoes.get(i).getNumid() == numid)
				return this.adocoes.get(i);
		}
		return null; // REMOVER
	}
	
}
