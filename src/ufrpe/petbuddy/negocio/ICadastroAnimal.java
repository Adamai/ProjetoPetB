package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Animal;
public interface ICadastroAnimal {//interface de CadastroAnimal

	void cadastrar(Animal a);
	ArrayList<Animal> busca(String raca, int num) throws RepoException;
	Animal busca(long numid) throws IDException;
}
