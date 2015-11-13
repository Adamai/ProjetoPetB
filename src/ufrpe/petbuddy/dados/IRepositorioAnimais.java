package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Animal;

public interface IRepositorioAnimais {

	void cadastrar(Animal animal);
	ArrayList<Animal> busca(String nome, int num) throws RepoException;
	Animal busca(long numid) throws IDException;
	void adotar(long numid)throws IDException;
	void remover(Animal a);
}
