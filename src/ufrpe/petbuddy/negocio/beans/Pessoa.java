package ufrpe.petbuddy.negocio.beans;

import ufrpe.petbuddy.exceptions.DadosException;



public class Pessoa extends Usuario {
private String login;
private String senha;
private String endereco;
private String email;
	
	public Pessoa(String nome, int idade, long contato,String email, String endereco,String login,String senha) throws DadosException{
		super(nome, idade, contato);
		this.setLogin(login);
		this.setSenha(senha);
		this.setEmail(email);
		this.setEndereco(endereco);
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setEmail(String email) throws DadosException {
		if(email != ""){
			this.email = email;
		}
		else
			throw new DadosException();
	}


	public void setEndereco(String endereco) throws DadosException {
		if(endereco != ""){
			this.endereco = endereco;
		}
		else
			throw new DadosException();
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return  "Nome: " + nome+ "\nidade: " + idade + "\nendereco: " + endereco + "\ncontato: " + contato ;
	}

	public void setLogin(String login) throws DadosException{
		if(login != "" && login.length()>5){
			this.login = login;
		}
		else 
			throw new DadosException("login inv�lido");
	}

	public void setSenha(String senha) throws DadosException{
		if(senha != "" && senha.length()>5){
			this.senha = senha;
		}
		else
			throw new DadosException("senha inv�lida");
	}

	
}
