package ufrpe.petbuddy.negocio;

import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.exceptions.*;

public interface ILogin {
	public boolean VerificarLogin( String login);
	Usuario EfetuarLogin(String login, String senha) throws RepoException;
	

}
