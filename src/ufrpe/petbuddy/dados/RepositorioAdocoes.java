package ufrpe.petbuddy.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Adocao;

public class RepositorioAdocoes implements IRepositorioAdocoes{

	private ArrayList<Adocao>adocoes;
	
	public RepositorioAdocoes(){
		this.adocoes = new ArrayList<Adocao>();
	}
	
	public void cadastrar(Adocao a){
		loadRepo();
		this.adocoes.add(a);
		overwriteRepo(adocoes);
	}
	
	public ArrayList<Adocao> busca() throws HistException{  // ADD NULL EXCEPTION
		loadRepo();
		if(adocoes.size()>0)
			return this.adocoes;
		else
			throw new HistException();
	}
	
	public Adocao busca(long numid) throws IDException{ // ADD NULL EXCEPTION
		loadRepo();
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
	
	
	public void overwriteRepo(ArrayList<Adocao> adocoes){ //usado para deletar e recriar   -    FUNCIONANDO
		File data = new File("DatabaseAdopt.rp");
		data.delete();
		ObjectOutputStream save = null;
		try{
		FileOutputStream fos = new FileOutputStream(data);
		save = new ObjectOutputStream(fos);
		save.writeObject(adocoes);
		fos.close();
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
	public void loadRepo(){
	File data = new File("DatabaseAdopt.rp");
	ObjectInputStream readob = null;
	if (data.exists()){
		try{
		FileInputStream read = new FileInputStream(data);
		readob = new ObjectInputStream(read);
		this.adocoes = (ArrayList<Adocao>) readob.readObject();
		readob.close();
	} catch (Exception e){
		e.printStackTrace();
	}

		}
	}
	
}
