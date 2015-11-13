package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Animal;
public interface ICadastroAnimal {//interface de CadastroAnimal

	void cadastraranimal(Animal a);
	ArrayList<Animal> buscaAnimais(String raca, int num) throws RepoException;
	Animal buscaid(long numid) throws IDException;
}
