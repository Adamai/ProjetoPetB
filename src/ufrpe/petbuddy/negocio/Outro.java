package ufrpe.petbuddy.negocio;



public class Outro extends Animal{
	private String especie;
		
	public Outro(String nome, String raca, double peso, String idade, String saude, String temperamento, String especie){
		super(nome,raca,peso,idade,saude,temperamento);
		this.especie = especie;
		
	}
		public String getEspecie() {
			return especie;
		}
}