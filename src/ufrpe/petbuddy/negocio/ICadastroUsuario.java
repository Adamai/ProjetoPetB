package ufrpe.petbuddy.negocio;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.exceptions.*;

public interface ICadastroUsuario {// interface de CadastroPessoa

	void cadastrar(Usuario u);
	Pessoa busca(String nome)throws RepoException;
	Usuario busca(String login,String senha)throws RepoException;
	void descadastrar(String nome)throws RepoException;
	public boolean VerificarLogin( String login);
	ArrayList<Usuario> listarUsuarios() throws HistException;
}
