package ufrpe.projetos.canil.negocio;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import ufrpe.projetos.canil.dados.*;

public class Adocao {
	
	Date d = new Date();  
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
    String data =  sdf.format(d).toString();
	
	public void adotar(Cachorro c, Pessoa p){
		c.setAdotado(true);
		//juntar cachorro, pessoa e data em um registro. 
		
		
	}
	
	
	
	
	
	
}
