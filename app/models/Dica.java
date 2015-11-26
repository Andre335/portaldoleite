package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="dica")
@Entity(name="Dica")
public abstract class Dica extends Ajuda{	
	@ManyToOne
	private Tema tema;
	
	@ManyToMany(mappedBy="dicasAdicionadas")
	private List<MetaDica> metadicas;
	
	@Transient
	private DicaDisciplina instanciaDisciplina;
	
	public Dica(){
		super();
		this.metadicas = new ArrayList<MetaDica>();
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
		setUsersCommentaries(new HashMap<String,String>());
	}
	
	public abstract String getTexto();
	
	public void checaTipoDica() {
		if (this.getTipo().equals("DicaDisciplina")) {
			this.instanciaDisciplina = (DicaDisciplina) this;
		}		
	}
	
	public DicaDisciplina getInstanciaDisciplina() {
		return instanciaDisciplina;
	}
	
	public void addMetaDica(MetaDica metadica) {
		this.metadicas.add(metadica);
	}
	
	public List<MetaDica> getMetaDicas() {
		return this.metadicas;
	}
	
	public abstract String getTipo();
	
	public abstract String getRazao();
}
