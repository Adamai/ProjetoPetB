package ufrpe.petbuddy.negocio.beans;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import ufrpe.petbuddy.dados.*;

public class Adocao {
	private Animal animal;
	private Pessoa pessoa;
	private String data;
	private long numid;
	private static long proximo = 1;

	public Adocao(Animal animal, Pessoa pessoa) {
		this.animal = animal;
		this.pessoa = pessoa;
		this.data = this.setData();
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
		proximo = proximo + 1;
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

	
}
