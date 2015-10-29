package ufrpe.petbuddy.negocio;

import java.util.ArrayList;
public interface ICadastroA {//interface de CadastroAnimal

	void cadastrar(Animal a);
	ArrayList<Animal> buscaAnimais(String raca, int num);
	Animal busca(long numid);
}
