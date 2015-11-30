package ufrpe.petbuddy.negocio.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ufrpe.petbuddy.exceptions.*;


public  class Animal implements Serializable {

	private String nome; 
	private String raca;
	private double peso;
	private int idade;
	private String saude;
	private String temperamento;
	private boolean adotado;
	private long numid;
	private String sexo;
	private static long proximo = 1;
	private Veterinario veterinario;
	private AnimalEspecie especie;
	private String data;
	//LIGAR O ANIMAL COM UM VETERINARIO NA HORA DE CRIA-LO
	public Animal(String nome, String raca,String sexo, double peso, int idade, String saude, String temperamento, 
			Veterinario veterinario, AnimalEspecie especie) throws DadosException{
		this.setNome(nome);
		this.setRaca(raca);
		this.setSexo(sexo);
		this.setPeso(peso);
		this.data = this.setData();
		this.setIdade(idade);
		this.setSaude(saude);
		this.temperamento = temperamento;
		this.adotado = false;
		loadProx();
		this.numid = proximo;
		this.setVeterinario(veterinario);
		this.setEspecie(especie);
		Animal.AumentarProximo();
		}
	
	public void setRaca(String raca)  throws DadosException {
		if(raca != ""){
			this.raca = raca;
		}
		else
			throw new DadosException();
	}

	public void setTemperamento(String temperamento) throws DadosException {
		if(temperamento != ""){
			this.temperamento = temperamento;
		}
		else
			throw new DadosException();
	}

	public void setVeterinario(Veterinario veterinario)  throws DadosException{
		if(veterinario != null){
			this.veterinario = veterinario;
		}
		else
			throw new DadosException();
	}

	public static void loadProx(){
		File data = new File("IdSetter.rp");
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
	
	public static void AumentarProximo(){
		File data = new File("IdSetter.rp");
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
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome)  throws DadosException{
		if(nome != ""){
			this.nome = nome;
		}
		else
			throw new DadosException();
	}

	public String getRaca() {
		return this.raca;
	}

	public double getPeso() {
		return this.peso;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo)  throws DadosException{
		if(sexo != ""){
			this.sexo = sexo;
		}
		else
			throw new DadosException();
	}
	public void setPeso(double peso)  throws DadosException{
		if(peso != 0 && peso>0){
			this.peso = peso;
		}
		else 
			throw new DadosException();
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade)  throws DadosException{
		if(idade>=0){
			this.idade = idade;
		}
	}

	public String getSaude() {
		return this.saude;
	}

	public void setSaude(String saude) throws DadosException {
		if(saude != ""){
			this.saude = saude;
		}
		else
			throw new DadosException();
	}

	public String getTemperamento() {
		return this.temperamento;
	}

	 public String toString(){
		  return this.nome;
		 	}
	
	 public String exibirDados(){
		 return "Id: " +this.numid + "\n" +"Sexo: "+ this.sexo +"\nNome: " +this.nome + "\nPeso: "+ this.peso+" kg\nRaça: " 
			     + this.raca +"\nIdade: "+ this.idade +"\nEstado de saúde: " 
			     + this.saude + "\nTemperamento: " +this.temperamento +"\n"+"Veterinário: "+this.veterinario.getNome();
	 }

	public boolean isAdotado() {
		return this.adotado;
	}

	public void setAdotado(boolean adotado) {
		this.adotado = adotado;
	}

	public long getNumid() {
		return this.numid;
	}

	public AnimalEspecie getEspecie() {
		return especie;
	}

	public void setEspecie(AnimalEspecie especie)  throws DadosException{
		if(especie != null){
			this.especie = especie;
		}
		else
			throw new DadosException();
	}
	public String setData() {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(d).toString();
		return data;
	}
	public String getData() {
		return this.data;
	}
		
	}
