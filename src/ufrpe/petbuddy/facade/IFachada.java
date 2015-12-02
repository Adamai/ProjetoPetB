package ufrpe.petbuddy.facade;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.HistException;
import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.negocio.beans.*;

public interface IFachada {


	void cadastrarAdocao(Adocao a);
	ArrayList<Adocao> buscaHistoricoAdocoes() throws HistException;
	Adocao buscaAdocao(long numid) throws IDException;
	void cadastrarAnimal(Animal a);
	ArrayList<Animal> buscaAnimais(String raca, AnimalEspecie especie) throws RepoException;
	Animal buscaAnimalID(long numid) throws IDException;
	void cadastrarPessoa(Usuario p);
	Pessoa buscaNome(String nome) throws RepoException;
	Usuario buscaLogin(String login, String senha) throws RepoException; 
	void descadastrar(String nome) throws RepoException;
	void cadastrarVet(Veterinario vet);
	Veterinario buscaVetID(long numid) throws IDException;
	ArrayList<Veterinario> ListarVet() throws HistException;
	Usuario EfetuarLogin(String login, String senha) throws RepoException;
	void atualizar(Animal c);
	ArrayList<Animal> listarAnimais() throws HistException;
	ArrayList<Animal> buscaEspecie(AnimalEspecie especie)throws RepoException;
	public void removerAnimal(Animal a);
	public boolean VerificarLogin( String login);
	public void atualizarVeterinario(Veterinario v);
	public void removerVeterinario(Veterinario v);
	ArrayList<Usuario> listarUsuarios() throws HistException;
}
