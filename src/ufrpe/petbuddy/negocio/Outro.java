package ufrpe.petbuddy.negocio;



public class Outro extends Animal{
	private String especie;
		
	public Outro(String nome, String raca,String sexo, double peso, String idade, String saude, String temperamento, String especie,Veterinario vet){
		super(nome,raca,sexo,peso,idade,saude,temperamento,vet);
		this.especie = especie;
		
	}
		public String getEspecie() {
			return especie;
		}
		@Override
		  public String toString(){
		   return "Id: " +this.getNumid() + "\n" +"Sexo: "+ this.getSexo() +"\nNome: " +this.getNome() + "\nPeso: "+ this.getPeso()+" kg\nRaça: " 
		      + this.getRaca() +"\nEspecie: " +this.especie + "\nIdade: "+ this.getIdade() +"\nEstado de saúde: " 
		      + this.getSaude() + "\nTemperamento: " +this.getTemperamento() +"\n\n";
		}
}