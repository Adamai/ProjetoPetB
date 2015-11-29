package ufrpe.petbuddy.facade;

import java.util.ArrayList;
import ufrpe.petbuddy.dados.*;
import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.*;
import ufrpe.petbuddy.negocio.beans.*;
public class Fachada implements IFachada{

	private ICadastroAdocao cadastroadocao;
	private ICadastroAnimal cadastroanimal;
	private ICadastroVet cadastrovet;
	private ICadastroUsuario cadastrousuario;
	private ILogin controlelogin;
	public static Fachada instance;


	private Fachada(){
		this.cadastroadocao = new CadastroAdocao();
		this.cadastroanimal = new CadastroAnimal();
		this.cadastrovet = new CadastroVet();
		this.cadastrousuario = new CadastroUsuario();
		this.controlelogin = new ControleLogin((CadastroUsuario)this.cadastrousuario);
	}

	public static Fachada getInstance(){
		if(instance==null)
			instance = new Fachada();
		return instance;
	}

	public void cadastrarAdocao(Adocao a) {
		cadastroadocao.cadastrar(a);
	}
	
	public void atualizar(Animal c){
		cadastroanimal.atualizar(c);
	}


	public ArrayList<Adocao> buscaHistoricoAdocoes() throws HistException {
		return cadastroadocao.busca();
	}


	public Adocao buscaAdocao(long numid) throws IDException {
		return cadastroadocao.busca(numid);
	}


	public void cadastrarAnimal(Animal a) {
		cadastroanimal.cadastrar(a);
	}


	public ArrayList<Animal> buscaAnimais(String raca, AnimalEspecie especie)
			throws RepoException {
		return cadastroanimal.busca(raca, especie);
	}


	public Animal buscaAnimalID(long numid) throws IDException {
		return cadastroanimal.busca(numid);
	}


	public void cadastrarPessoa(Usuario p) {
		cadastrousuario.cadastrar(p);
	}


	public Pessoa buscaNome(String nome) throws RepoException {
		return cadastrousuario.busca(nome);
	}


	public Usuario buscaLogin(String login, String senha) throws RepoException  {
		return cadastrousuario.busca(login, senha);
	}


	public void descadastrar(String nome) throws RepoException{
		cadastrousuario.descadastrar(nome);
	}


	public void cadastrarVet(Veterinario vet) {
		cadastrovet.cadastrar(vet);
	}


	public Veterinario buscaVetID(long numid) throws IDException {
		return cadastrovet.busca(numid);
	}


	public ArrayList<Veterinario> ListarVet() throws HistException{
		return cadastrovet.busca();
	}
	
	public Usuario EfetuarLogin(String login, String senha) throws RepoException{
		return this.controlelogin.EfetuarLogin(login, senha);
		
	}
	
	
	
}
