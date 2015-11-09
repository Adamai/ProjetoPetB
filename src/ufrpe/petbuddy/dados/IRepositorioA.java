package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.dados.exceptions.RepoException;
import ufrpe.petbuddy.negocio.Animal;

public interface IRepositorioA {

	void cadastrar(Animal animal);
	ArrayList<Animal> busca(String nome, int num) throws RepoException;
	Animal busca(long numid) throws RepoException;
	void adotar(long numid);
	void remover(Animal a);
}
