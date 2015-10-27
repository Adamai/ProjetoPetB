package ufrpe.projetos.canil.dados;

import java.util.ArrayList;
import ufrpe.projetos.canil.negocio.*;

public interface IRepositorio {

	public abstract void cadastrar(Animal animal);
	public abstract ArrayList<Animal> busca(String nome, int num);
	public abstract void remover(Animal a);
}
