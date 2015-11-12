package ufrpe.petbuddy.negocio;

public class ControleLogin implements ILogin {
	

	private CadastroPessoa cadastrop;
	
	public ControleLogin(CadastroPessoa cadastrop){
		this.cadastrop = cadastrop;
	}
	
	public Usuario EfetuarLogin(String login, String senha){
		return this.cadastrop.busca(login, senha);
		
	}
	
	
	

}
