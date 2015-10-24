package ufrpe.projetos.canil.negocio;

public class Animal {

	private String nome; 
	private String raca;
	private double peso;
	private int idade;
	private String saude;
	private String temperamento;
	
	public Animal(String nome, String raca, double peso, int idade, String saude, String temperamento){
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
		this.idade = idade;
		this.saude = saude;
		this.temperamento = temperamento;
		}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return this.raca;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSaude() {
		return this.saude;
	}

	public void setSaude(String saude) {
		this.saude = saude;
	}

	public String getTemperamento() {
		return this.temperamento;
	}

	public String toString(){
		return this.nome + ", "+ this.peso+" kg, " + this.raca +", "+ this.idade +" anos, " + this.saude + ", " +this.temperamento;
	}
	
	
	}
