package ufrpe.projetos.canil.negocio;

import ufrpe.projetos.canil.dados.*;
public class CadastroLogins {
	
	private RepositorioPessoas repositorio;
	
	public Pessoa efetuarLogin(String login, String senha){
		
		if(this.repositorio.buscaLogin(login, senha) != null){
			Pessoa p = this.repositorio.buscaLogin(login, senha);
			return p;
		}
		return null;
	}
}
