package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;

public interface ICadastroPessoa {// interface de CadastroPessoa

	void cadastrarpessoa(Pessoa p);
	Pessoa buscanome(String nome);
	Usuario buscausuario(String login,String senha);
	void descadastrar(String nome);
}
