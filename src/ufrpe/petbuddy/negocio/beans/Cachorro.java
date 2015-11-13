package ufrpe.petbuddy.negocio.beans;



public class Cachorro extends Animal{
	
	public Cachorro(String nome, String raca,String sexo, double peso, String idade, String saude, String temperamento,Veterinario vet){
		super(nome,raca,sexo,peso,idade,saude,temperamento, vet);
	}

}
