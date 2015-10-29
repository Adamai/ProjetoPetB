package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.Animal;

public interface IRepositorioA {

	void cadastrar(Animal animal);
	ArrayList<Animal> busca(String nome, int num);
	Animal busca(long numid);
	void adotar(long numid);
	void remover(Animal a);
}
