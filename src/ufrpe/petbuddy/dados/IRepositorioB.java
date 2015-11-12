package ufrpe.petbuddy.dados;

import ufrpe.petbuddy.negocio.*;
public interface IRepositorioB {

	void cadastrar(Usuario u);
	Usuario busca(String nome);
	Usuario buscaLogin(String login,String senha) throws NullPointerException;
	void remover(String nome);
}
