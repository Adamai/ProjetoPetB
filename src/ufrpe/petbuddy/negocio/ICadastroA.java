package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
public interface ICadastroA {//interface de CadastroAnimal

	void cadastrar(Animal a);
	ArrayList<Animal> buscaAnimais(String raca, int num) throws RepoException;
	Animal busca(long numid) throws IDException;
}