package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.Adocao;
public interface IRepositorioAdocoes {

	void cadastrar(Adocao a);
	ArrayList<Adocao> busca() throws HistException;
	Adocao busca(long numid)throws IDException;
}
