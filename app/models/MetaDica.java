package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import comparators.MaisConcordanciasComparator;
import comparators.MaisVotosComparator;

@Table(name="metadica")
@Entity(name="MetaDica")
public class MetaDica extends Ajuda{	
	@Column
	private String comment;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Dica> dicasAdicionadas;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<MetaDica> metaDicasAdicionadas;
	
	@ManyToOne
	private Disciplina disciplina;
	
	public MetaDica(){}
	
	public MetaDica(Disciplina disciplina, String user, String comment) {
		super();
		this.disciplina = disciplina;
		setUser(user);
		this.comment = comment;
		this.dicasAdicionadas = new ArrayList<Dica>();
		this.metaDicasAdicionadas = new ArrayList<MetaDica>();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Disciplina getDisciplina() {
		return this.disciplina;
	}
	
	public void addDica(Dica dica) {
		this.dicasAdicionadas.add(dica);
	}
	
	public void addMetaDica(MetaDica metaDica) {
		this.metaDicasAdicionadas.add(metaDica);
	}

	public List<Dica> getDicasAdicionadas() {
		Collections.sort(dicasAdicionadas, new MaisVotosComparator());
		
		for (Dica dica : dicasAdicionadas) {
			dica.checaTipoDica();
		}
		
		return dicasAdicionadas;
	}

	public void setDicasAdicionadas(List<Dica> dicasAdicionadas) {
		this.dicasAdicionadas = dicasAdicionadas;
	}

	public List<MetaDica> getMetaDicasAdicionadas() {
		Collections.sort(metaDicasAdicionadas, new MaisConcordanciasComparator());
		return metaDicasAdicionadas;
	}

	public void setMetaDicasAdicionadas(List<MetaDica> metaDicasAdicionadas) {
		this.metaDicasAdicionadas = metaDicasAdicionadas;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
