package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.negocio.*;
public interface IRepositorioC {

	void cadastrar(Adocao a);
	ArrayList<Adocao> busca();
	Adocao busca(long numid)throws IDException;
}
