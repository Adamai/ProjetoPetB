package ufrpe.petbuddy.negocio.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import ufrpe.petbuddy.exceptions.*;
import java.util.Date;


public class Adocao implements Serializable {
	private Animal animal;
	private Pessoa pessoa;
	private String data;
	private long numid;
	private static long proximo = 1;

	public Adocao(Animal animal, Pessoa pessoa) throws DadosException {
		this.animal = animal;
		this.pessoa = pessoa;
		this.data = this.setData();
		loadProx();
		this.numid = proximo;
		animal.setAdotado(true);
		Adocao.AumentarProximo();
	}

	public String setData() {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(d).toString();
		return data;
	}
	
	public static void AumentarProximo(){
		File data = new File("IdSetAdopt.rp");
		loadProx();
		data.delete();
		proximo = proximo + 1;
		ObjectOutputStream save = null;
		try{
		FileOutputStream fos = new FileOutputStream(data);
		save = new ObjectOutputStream(fos);
		save.writeObject(proximo);
		fos.close();
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
	
	public String getData() {
		return data;
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public long getNumid() {
		return numid;
	}

	public void setAnimal(Animal animal)throws DadosException {
		if( animal!= null){
			this.animal = animal;
		}else 
			throw new DadosException();
	}

	public void setPessoa(Pessoa pessoa) throws DadosException{
		if( pessoa!= null){
		this.pessoa = pessoa;
	}else 
		throw new DadosException();

}
	public static void loadProx(){
		File data = new File("IdSetAdopt.rp");
		ObjectInputStream readob = null;
		if (data.exists()){
			try{
			FileInputStream read = new FileInputStream(data);
			readob = new ObjectInputStream(read);
			proximo = (long) readob.readObject();
			readob.close();
		} catch (Exception e){
			e.printStackTrace();
		}
			}
	}
	
	



}
