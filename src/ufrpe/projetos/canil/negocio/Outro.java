package ufrpe.projetos.canil.negocio;

public class Outro extends Animal{
	private String especie;
		
	public Outro(String nome, String raca, double peso, int idade, String saude, String temperamento, String especie, long numid){
		super(nome,raca,peso,idade,saude,temperamento,numid);
		this.especie = especie;
		
	}
		public String getEspecie() {
			return especie;
		}
}