package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.*;
public interface ICadastroAnimal {//interface de CadastroAnimal

	void cadastrar(Animal a);
	ArrayList<Animal> busca(String raca, AnimalEspecie especie) throws RepoException;
	ArrayList<Animal> listarAnimais();
	ArrayList<Animal> buscaEspecie(AnimalEspecie especie);
	Animal busca(long numid) throws IDException;
	void atualizar(Animal c);
}
