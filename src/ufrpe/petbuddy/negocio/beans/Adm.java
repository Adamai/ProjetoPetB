package ufrpe.petbuddy.negocio.beans;

public class Adm extends Usuario {
	
	private String login = "petbuddy";
	private String senha = "adoroanimais";
	
	public Adm(){
		super("adm",30,5617467);
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	
}
