package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Adocao;
public interface ICadastroAdocao {// interface de CadastroAdocao

	void cadastrar(Adocao a);
	ArrayList<Adocao> buscahistoricoadocoes();
	Adocao buscaporid(long numid) throws IDException;
	
}
