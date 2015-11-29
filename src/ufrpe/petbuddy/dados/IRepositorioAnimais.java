package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.*;

public interface IRepositorioAnimais {

	void cadastrar(Animal animal);
	ArrayList<Animal> busca(String nome, AnimalEspecie especie) throws RepoException;
	Animal busca(long numid) throws IDException;
	void adotar(long numid)throws IDException;
	void remover(Animal a);
	void saveRepo();
	void loadRepo();
	void overwriteRepo(ArrayList<Animal> animais);
	void atualizar(Animal c);
}
