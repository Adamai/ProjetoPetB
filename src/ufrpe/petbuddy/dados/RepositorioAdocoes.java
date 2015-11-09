package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.dados.exceptions.IDException;
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
	
	public Adocao busca(long numid) throws IDException{ // ADD NULL EXCEPTION
		Adocao a = null;
		for(int i = 0;i<this.adocoes.size();i++){
			if(this.adocoes.get(i).getNumid() == numid)
				a= this.adocoes.get(i);
		}
		if(a!=null)
			return a;
		else
			throw new IDException(numid);
		
	}
	
}
