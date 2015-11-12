package ufrpe.petbuddy.negocio;

public abstract class Animal {

	private String nome; 
	private String raca;
	private double peso;
	private String idade;
	private String saude;
	private String temperamento;
	private boolean adotado;
	private long numid;
	private String sexo;
	private static long proximo = 1;
	private Veterinario veterinario;
	//LIGAR O ANIMAL COM UM VETERINARIO NA HORA DE CRIA-LO
	public Animal(String nome, String raca,String sexo, double peso, String idade, String saude, String temperamento, Veterinario veterinario){
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.peso = peso;
		this.idade = idade;
		this.saude = saude;
		this.temperamento = temperamento;
		this.adotado = false;
		this.numid = proximo;
		this.veterinario = veterinario;
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

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getIdade() {
		return this.idade;
	}

	public void setIdade(String idade) {
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
		  return "Id: " +this.numid + "\n" +"Sexo: "+ this.sexo +"\nNome: " +this.nome + "\nPeso: "+ this.peso+" kg\nRaça: " 
		     + this.raca +"\nIdade: "+ this.idade +"\nEstado de saúde: " 
		     + this.saude + "\nTemperamento: " +this.temperamento +"\n\n";
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
		
	}
