package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.dados.exceptions.*;
public interface ICadastroC {// interface de CadastroAdocao

	void cadastrar(Adocao a);
	ArrayList<Adocao> busca();
	Adocao busca(long numid) throws IDException;
	
}
