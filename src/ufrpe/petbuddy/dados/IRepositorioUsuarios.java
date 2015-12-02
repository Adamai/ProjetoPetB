package ufrpe.petbuddy.dados;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.exceptions.*;

public interface IRepositorioUsuarios {

	void cadastrar(Usuario u);
	Pessoa busca(String nome)throws RepoException;
	Usuario buscaLogin(String login,String senha) throws RepoException;
	void remover(String nome) throws RepoException;
	public boolean VerificarLogin( String login);
	ArrayList<Usuario> listarUsuarios() throws HistException;
}
