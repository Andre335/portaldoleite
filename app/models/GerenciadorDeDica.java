package models;

import java.util.Map;

import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;

public class GerenciadorDeDica {
	
	private Dica dica;
	
	public GerenciadorDeDica(){
		this.dica = new DicaAssunto("sem texto");
	}
	
	
	public GerenciadorDeDica(Dica dica){
		this.dica = dica;
	}


	public Dica getDica() {
		return dica;
	}


	public void setDica(Dica dica) {
		this.dica = dica;
	}
	
	public void salvarDica(Tema tema, String userName , GenericDAOImpl dao){		
		tema.addDica(dica);
		dica.setTema(tema);
		dica.setUser(userName);
		dao.persist(dica);
		
	}
}
