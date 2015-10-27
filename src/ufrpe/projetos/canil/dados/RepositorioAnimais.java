package ufrpe.projetos.canil.dados;
import ufrpe.projetos.canil.negocio.*;
import java.util.ArrayList;

public class RepositorioAnimais {

	private ArrayList<Animal> animais;
	
	
	public RepositorioAnimais(){
		this.animais = new ArrayList<Animal>();
	}
	
	
	public void cadastrar(Animal animal ){
		this.animais.add(animal);
	}
		
	public ArrayList<Animal> buscaCachorro(String raca){ // RETORNA TODOS OS CACHORROS DE DETERMINADA RAÇA
		ArrayList<Animal>cachorros = new ArrayList<Animal>();
		
		for(int i = 0; i<this.animais.size();i++){
			Animal a = this.animais.get(i);
			if(a.getRaca().toLowerCase().contains(raca.toLowerCase()) && a instanceof Cachorro){
				cachorros.add(a);
			}
		}
			return cachorros;
		}
	
	public ArrayList<Animal> buscaGato(String raca){ // RETORNA TODOS OS GATOS DE DETERMINADA RAÇA
		ArrayList<Animal>gatos = new ArrayList<Animal>();
		
		for(int i = 0; i<this.animais.size();i++){
			Animal a = this.animais.get(i);
			if(a.getRaca().toLowerCase().contains(raca.toLowerCase()) && a instanceof Gato){
				gatos.add(a);
			}
		}
		return gatos;
	}
	
	public ArrayList<Animal> buscaOutro(String especie){ //RETORNA TODOS OS OUTROS DE DETERMINADA ESPECIE
		ArrayList<Animal>outros = new ArrayList<Animal>();
		
		for(int i = 0; i<this.animais.size();i++){
			Animal a = this.animais.get(i);
			if(a instanceof Outro){
				Outro outro = (Outro)a;
				if(outro.getEspecie().toLowerCase().contains(especie.toLowerCase()))
				outros.add(outro);
			}
		}
		
		return outros;
	}
	
	public Animal buscaAdocao(String nome){//ADOTA UM ANIMAL ESPECIFICO POR NOME 
		
		for(int i = 0;i<this.animais.size();i++){
			if(this.animais.get(i).getNome().contains(nome)){
				Animal a = this.animais.get(i);
				this.remover(a);
				return a;
			}
		}
		return null;
	}
	
	public void remover(Animal a){ // REMOVE UM ANIMAL ESPECÍFICO ATRAVÉS DO NOME
		for(int i = 0;i<animais.size();i++){
			if(animais.get(i).equals(a)){
				animais.remove(i);
			}
		}
	}
}