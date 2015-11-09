package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.dados.exceptions.*;
import ufrpe.petbuddy.negocio.*;
public interface IRepositorioC {

	void cadastrar(Adocao a);
	ArrayList<Adocao> busca() throws RepoException;
	Adocao busca(long numid)throws IDException;
}
