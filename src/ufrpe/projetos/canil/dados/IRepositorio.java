package ufrpe.projetos.canil.dados;

import ufrpe.projetos.canil.negocio.*;

public interface IRepositorio {

	public abstract void cadastrar(Animal animal);
	public abstract int buscaIndice(String nome);
	public abstract void remover(Animal animal);
}
