package ufrpe.projetos.canil.dados;
import ufrpe.projetos.canil.negocio.*;
import java.util.ArrayList;

public class RepositorioAnimais implements IRepositorio {

	private ArrayList<Animal> animais;
	
	
	public RepositorioAnimais(){
		this.animais = new ArrayList<Animal>();
	}
	
	
	public void cadastrar(Animal animal ){
		this.animais.add(animal);
	}
		
	public ArrayList<Animal> busca(String raca, int num){
		ArrayList<Animal>buscados = new ArrayList<Animal>();
		
		if(num ==1){//CACHORROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().contains(raca) && a instanceof Cachorro){
					buscados.add(a);
				}
			}
				return buscados;
		}//FIM IF 1
		
		else if(num == 2){//GATOS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a.getRaca().contains(raca) && a instanceof Gato){
					buscados.add(a);
				}
			}
			return buscados;
		}
		
		else if(num == 3){//OUTROS
			for(int i = 0; i<this.animais.size();i++){
				Animal a = this.animais.get(i);
				if(a instanceof Outro){
					Outro outro = (Outro)a;
					if(outro.getEspecie().contains(raca))
					buscados.add(outro);
				}
			}
			return buscados;
		}
		else
			return null;
		
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