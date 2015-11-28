package ufrpe.petbuddy.gui;
import ufrpe.petbuddy.facade.*;

public class GerenciadorTelas {

	private TelaPrincipal principal;
	private TelaLogin login;
	private TelaLogado logado;
	private TelaAdm adm;
	private TelaBuscaAnimais buscaANimais;
	private TelaCadastroAnimal cadastroAnimal;
	private TelaCadastroUsuario cadastroUsuario;
	private TelaCadastroVeterinario cadastroVeterinario;
	private TelaResultadoBusca resultadoBusca;
	private IFachada fachada;
	
	private static GerenciadorTelas instance;
	
	private GerenciadorTelas(IFachada fachada){
		this.principal = new TelaPrincipal(fachada);
		this.login = new TelaLogin(fachada);
		this.adm = new TelaAdm(fachada);
		this.cadastroAnimal = new TelaCadastroAnimal(fachada);
		this.cadastroVeterinario = new TelaCadastroVeterinario(fachada);
	}
	
	public static GerenciadorTelas getInstance(){
		if(instance ==null){
			instance = new GerenciadorTelas(Fachada.getInstance());
		}
		return instance;
	}
	
	public void mostrarTelaPrincipal(){
		principal.setVisible(true);
	}
	
	public void mostrarTelaLogin(){
		login.setVisible(true);
	}
}
