package ufrpe.petbuddy.negocio;

public abstract class Animal {

	private String nome; 
	private String raca;
	private double peso;
	private int idade;
	private String saude;
	private String temperamento;
	private boolean adotado;
	private long numid;
	private static long proximo = 1;
	//LIGAR O ANIMAL COM UM VETERINARIO NA HORA DE CRIA-LO
	public Animal(String nome, String raca, double peso, int idade, String saude, String temperamento){
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
		this.idade = idade;
		this.saude = saude;
		this.temperamento = temperamento;
		this.adotado = false;
		this.numid = proximo;
		Animal.AumentarProximo();
		}
	public static void AumentarProximo(){
		proximo = proximo + 1;
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
		return "Id: " +this.numid + "\n" +"Nome: " +this.nome + "\nPeso: "+ this.peso+" kg\nEspécie/Raça: " 
					+ this.raca +"\nIdade: "+ this.idade +" anos\nEstado de saúde: " 
					+ this.saude + "\nTemperamento: " +this.temperamento +"\n\n";
		 	}

	public boolean isAdotado() {
		return adotado;
	}

	public void setAdotado(boolean adotado) {
		this.adotado = adotado;
	}

	public long getNumid() {
		return numid;
	}
		
	}
