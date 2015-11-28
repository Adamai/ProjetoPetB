package ufrpe.petbuddy.negocio.beans;

import java.io.Serializable;

import ufrpe.petbuddy.exceptions.DadosException;


public abstract class Usuario  implements Serializable {
	protected long contato;
	protected String nome;
	protected int idade;

	
	public Usuario(String nome, int idade, long contato)throws DadosException{
		this.setNome(nome);
		this.setIdade(idade);
		this.setContato(contato);

	}


	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade)throws DadosException {
		if(idade>0){
			this.idade = idade;
		}
		else
			throw new DadosException();
	}

	public long getContato() {
		return contato;
	}

	public void setContato(long contato) throws DadosException {
		if(contato>=10000000){
			this.contato = contato;
		}
		else
			throw new DadosException("contato inválido");
	}


	public void setNome(String nome) throws DadosException{
		if(nome!= ""){
			this.nome = nome;
		}
		else
			throw new DadosException();
	}

	
}
