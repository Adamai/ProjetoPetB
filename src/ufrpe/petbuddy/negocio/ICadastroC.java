package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.exceptions.IDException;
public interface ICadastroC {// interface de CadastroAdocao

	void cadastrar(Adocao a);
	ArrayList<Adocao> busca();
	Adocao busca(long numid) throws IDException;
	
}
