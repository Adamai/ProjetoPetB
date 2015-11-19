package ufrpe.petbuddy.facade;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.HistException;
import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.negocio.beans.Adocao;
import ufrpe.petbuddy.negocio.beans.Animal;
import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;
import ufrpe.petbuddy.negocio.beans.Veterinario;

public interface IFachada {


	void cadastrarAdocao(Adocao a);
	ArrayList<Adocao> buscaHistoricoAdocoes() throws HistException;
	Adocao buscaAdocao(long numid) throws IDException;
	void cadastrarAnimal(Animal a);
	ArrayList<Animal> buscaAnimais(String raca, int num) throws RepoException;
	Animal buscaAnimalID(long numid) throws IDException;
	void cadastrarPessoa(Pessoa p);
	Pessoa buscaNome(String nome) throws RepoException;
	Usuario buscaLogin(String login, String senha) throws RepoException; 
	void descadastrar(String nome) throws RepoException;
	void cadastrarVet(Veterinario vet);
	Veterinario buscaVetID(long numid) throws IDException;
	ArrayList<Veterinario> ListarVet() throws HistException;
	Usuario EfetuarLogin(String login, String senha) throws RepoException;
}