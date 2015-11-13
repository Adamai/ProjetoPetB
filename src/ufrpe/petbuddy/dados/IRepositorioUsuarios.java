package ufrpe.petbuddy.dados;

import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.Usuario;
public interface IRepositorioUsuarios {

	void cadastrar(Usuario u);
	Usuario busca(String nome);
	Usuario buscaLogin(String login,String senha) throws NullPointerException;
	void remover(String nome);
}
