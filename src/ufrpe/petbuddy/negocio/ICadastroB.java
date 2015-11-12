package ufrpe.petbuddy.negocio;

public interface ICadastroB {// interface de CadastroPessoa

	void cadastrar(Pessoa p);
	Pessoa busca(String nome);
	Usuario busca(String login,String senha);
	void descadastrar(String nome);
}
