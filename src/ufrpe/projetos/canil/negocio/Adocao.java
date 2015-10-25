package ufrpe.projetos.canil.negocio;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import ufrpe.projetos.canil.dados.*;

public class Adocao {
	private Animal animal;
	private Pessoa pessoa;
	private String data;

	public Adocao(Animal animal, Pessoa pessoa) {
		this.animal = animal;
		this.pessoa = pessoa;
		this.data = this.setData();
		animal.setAdotado(true);
	}

	public String setData() {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(d).toString();
		return data;
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

}
