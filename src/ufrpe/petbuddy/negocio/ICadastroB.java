package ufrpe.petbuddy.negocio;

public interface ICadastroB {// interface de CadastroPessoa

	void cadastrar(Pessoa p);
	Pessoa busca(String nome);
	void descadastrar(String nome);
}
