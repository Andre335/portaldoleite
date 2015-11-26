package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

@Entity(name="Ajuda")
public abstract class Ajuda{
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String username;
	
	@ElementCollection
	private List<String> usuariosQueJaVotaram;
	
	@ElementCollection
	private List<String> usuarioqueQueJaDenunciaram;
	
	@ElementCollection
    @MapKeyColumn(name="user_meta")
    @Column(name="commentary")
    @CollectionTable(name="meta_comm", joinColumns=@JoinColumn(name="dica_id"))
	private Map<String, String> usersCommentaries;
	
	@Column
	private int concordancias;
	
	@Column
	private int discordancias;
	
	@Column
	private int flag;
	
	public Ajuda(){
		this.usuarioqueQueJaDenunciaram = new ArrayList<String>();
		this.usuariosQueJaVotaram = new ArrayList<String>();
		this.usersCommentaries = new HashMap<String, String>();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}
	
	public int getConcordancias() {
		return concordancias;
	}

	public void setConcordancias(int concordancias) {
		this.concordancias = concordancias;
	}
	
	public void incrementaConcordancias(){
		this.concordancias++;
	}
	
	public int getDiscordancias() {
		return discordancias;
	}

	public void setDiscordancias(int discordancias) {
		this.discordancias = discordancias;
	}
	
	public void incrementaDiscordancias(){
		this.discordancias = discordancias + 1;
	}
	
	public String getIndiceConcordancia() {
		int soma = concordancias + discordancias;
		if(soma == 0){
			return "0";
		}
		return String.format("%.2f", this.getConcordancias()/((float)soma));
	}
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public void incrementaFlag() {
		this.flag = flag + 1;
	}
	
	public void addUsuarioQueVotou(String user){
		usuariosQueJaVotaram.add(user);
	}
	
	public boolean wasVotedByUser(String user){
		return usuariosQueJaVotaram.contains(user); 
	}
	
	public void addUserCommentary(String login, String commentary) {
		usersCommentaries.put(login, commentary);
	}
	
	public void addUsuarioFlag(String user) {
		this.usuarioqueQueJaDenunciaram.add(user);
	}
	
	public boolean wasFlaggedByUser(String user) {
		return usuarioqueQueJaDenunciaram.contains(user);
	}
	
	public boolean isUnvotable() {
		return this.concordancias>=20 || this.discordancias>=20;
	}
	
	public List<String> getUsuariosQueJaVotaram() {
		return usuariosQueJaVotaram;
	}

	public void setUsuariosQueJaVotaram(List<String> usuariosQueJaVotaram) {
		this.usuariosQueJaVotaram = usuariosQueJaVotaram;
	}

	public List<String> getUsuarioqueQueJaDenunciaram() {
		return usuarioqueQueJaDenunciaram;
	}

	public void setUsuarioqueQueJaDenunciaram(
			List<String> usuarioqueQueJaDenunciaram) {
		this.usuarioqueQueJaDenunciaram = usuarioqueQueJaDenunciaram;
	}
	
	public Map<String, String> getUsersCommentaries() {
		return usersCommentaries;
	}

	public void setUsersCommentaries(Map<String, String> usersCommentaries) {
		this.usersCommentaries = usersCommentaries;
	}
}
