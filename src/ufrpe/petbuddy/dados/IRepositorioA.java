package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.negocio.Animal;

public interface IRepositorioA {

	void cadastrar(Animal animal);
	ArrayList<Animal> busca(String nome, int num) throws RepoException;
	Animal busca(long numid) throws IDException;
	void adotar(long numid)throws IDException;
	void remover(Animal a);
}
