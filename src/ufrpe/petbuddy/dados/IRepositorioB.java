package ufrpe.petbuddy.dados;

import ufrpe.petbuddy.negocio.*;
public interface IRepositorioB {

	void cadastrar(Pessoa p);
	Pessoa busca(String nome);
	void remover(String nome);
}
