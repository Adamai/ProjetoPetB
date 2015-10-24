package ufrpe.projetos.canil.negocio;

public class Gato extends Animal{

	public Gato(String nome, String raca, double peso, int idade, String saude, String temperamento){
		super(nome,raca,peso,idade,saude,temperamento);
	}

	/*	public String getNome() {
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

		public String toString(){
			return this.nome + ", "+ this.peso+" kg, " + this.raca +", "+ this.idade +" anos, " + this.saude + ", " +this.temperamento;
		}
		*/
}
