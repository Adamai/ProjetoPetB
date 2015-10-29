package ufrpe.petbuddy.negocio;

import java.util.ArrayList;
public interface ICadastroC {// interface de CadastroAdocao

	void cadastrar(Adocao a);
	ArrayList<Adocao> busca();
	Adocao busca(long numid);
	
}
