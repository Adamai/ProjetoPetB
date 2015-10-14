package ufrpe.projetos.canil.negocio;

public class Cachorro {
	
		private String nome; 
		private String raca;
		private double peso;
		private int idade;
		private String saude;
		private String temperamento;
		private Boolean adotado;
		
		public Cachorro(String nome, String raca, double peso, int idade, String saude, String temperamento, Boolean adotado){
			this.nome = nome;
			this.raca = raca;
			this.peso = peso;
			this.idade = idade;
			this.saude = saude;
			this.temperamento = temperamento;
			this.adotado = adotado;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getRaca() {
			return raca;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		public String getSaude() {
			return saude;
		}

		public void setSaude(String saude) {
			this.saude = saude;
		}

		public String getTemperamento() {
			return temperamento;
		}
		
		public Boolean getAdotado(){
			return adotado;
		}
		
		public void setAdotado(Boolean adotado){
			this.adotado = adotado;
		}

		public String toString(){
			return this.nome + ", "+ this.peso+" kg, " + this.raca +", "+ this.idade +" anos, " + this.saude + ", " +this.temperamento;
		}
		
		
	}

