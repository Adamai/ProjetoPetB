package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.*;

public interface IRepositorio {

	void cadastrar(Animal animal);
	ArrayList<Animal> busca(String nome, int num);
	Animal busca(long numid);
	void remover(long numid);
}
