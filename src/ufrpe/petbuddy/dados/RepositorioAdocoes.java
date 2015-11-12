package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.negocio.*;

public class RepositorioAdocoes implements IRepositorioC{

	private ArrayList<Adocao>adocoes;
	
	public RepositorioAdocoes(){
		this.adocoes = new ArrayList<Adocao>();
	}
	
	public void cadastrar(Adocao a){
		this.adocoes.add(a);
	}
	
	public ArrayList<Adocao> busca() throws NullPointerException{  // ADD NULL EXCEPTION
		if(adocoes.size()>0)
			return this.adocoes;
		else
			throw new NullPointerException("Nada encontrado");
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
