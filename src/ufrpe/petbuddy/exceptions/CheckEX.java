package ufrpe.petbuddy.exceptions;

public class CheckEX {

	public CheckEX() {

	}

	public String checaNome(String nome) throws NAMException {
		String a = null;
		if (nome.length() > 1) {
			for (int pos = 0; pos < nome.length(); pos++)
				if (nome.charAt(pos) >= 'A' && nome.charAt(pos) <= 'Z'|| nome.charAt(pos) >= 'a'
				&& nome.charAt(pos) <= 'z' || nome.charAt(pos) == ' ')
					a = a + nome.charAt(pos);
				else
					throw new NAMException(nome);
		} else
			throw new NAMException(nome);
		return a;
	}
}
