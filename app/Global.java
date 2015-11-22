import java.util.ArrayList;
import java.util.List;

import models.Dica;
import models.DicaAssunto;
import models.DicaConselho;
import models.DicaDisciplina;
import models.DicaMaterial;
import models.Disciplina;
import models.Tema;
import models.User;
import models.dao.GenericDAOImpl;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;


public class Global extends GlobalSettings {

	private static GenericDAOImpl dao = new GenericDAOImpl();
	private List<Disciplina> disciplinas = new ArrayList<>();
	private Disciplina si1, oac, es;
	private Dica dicaSiMiniT, dicaSiLabs;
	private Dica dicaEsTestes, dicaEsFerr;
	private Dica dicaOacTiposMem;
	private Tema miniteste, labs;
	private Tema testes, ferramentas;
	private Tema tiposDeMem;
	
	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				if(dao.findAllByClassName(Disciplina.class.getName()).size() == 0){
					criaDisciplinaTemas();
					criaDicas();
					criaUsuarios();
				}
			}
		});
	}

	protected void criaDicas() {
		dicaSiMiniT = new DicaConselho("Sempre esteja a par dos assuntos para quando tiver um miniteste.");
		dicaSiMiniT.setTema(miniteste);
		dicaSiMiniT.setUser("Andre");
		dicaSiMiniT.addUsuarioQueVotou("Usuario 9");
		dicaSiMiniT.addUsuarioQueVotou("Usuario 6");
		dao.persist(dicaSiMiniT);
		
		dicaSiLabs = new DicaConselho("Nao espere muito tempo para comecar a fazer os labs, para nao se atrasar.");
		dicaSiLabs.setTema(labs);
		dicaSiLabs.setUser("Usuario Padrao");
		dicaSiLabs.addUsuarioQueVotou("Usuario Padrao");
		dicaSiLabs.addUsuarioQueVotou("Usuario 3");
		dao.persist(dicaSiLabs);
		
		dicaOacTiposMem = new DicaAssunto("Memoria Cache e a mais eficiente, porem mais cara.");
		dicaOacTiposMem.setTema(tiposDeMem);
		dicaOacTiposMem.setUser("Andre");
		dicaOacTiposMem.addUsuarioQueVotou("Usuario 1");
		dicaOacTiposMem.addUsuarioQueVotou("Usuario 2");
		dao.persist(dicaOacTiposMem);
		
		dicaEsTestes = new DicaMaterial("O Livro de engenharia de software do sommerville e muito bom.");
		dicaEsTestes.setTema(testes);
		dicaEsTestes.setUser("Usuario 1");
		dicaEsTestes.addUsuarioQueVotou("Andre");
		dicaEsTestes.addUsuarioQueVotou("Usuario 4");
		dao.persist(dicaEsTestes);
		
		dicaEsFerr = new DicaDisciplina("Voce tera que estar familiarizado com varias ferramentas para o projeto."
				, "Tera de usar elas no seu projeto.");
		dicaEsFerr.setTema(ferramentas);
		dicaEsFerr.setUser("Usuario 2");
		dicaEsFerr.addUsuarioQueVotou("Usuario 5");
		dicaEsFerr.addUsuarioQueVotou("Usuario 7");
		dao.persist(dicaEsFerr);
		
		dao.flush();
	}

	protected void criaUsuarios() {
		User andre = new User();
		andre.setNome("Andre");
		andre.setEmail("andre335@gmail.com");
		andre.setLogin("andre335");
		andre.setPass("Andre95153565");
		dao.persist(andre);
		
		User padrao = new User();
		padrao.setNome("Usuario Padrao");
		padrao.setEmail("padrao@gmail.com");
		padrao.setLogin("padrao");
		padrao.setPass("123456789");
		dao.persist(padrao);
		
		User user1 = new User();
		user1.setNome("Usuario 1");
		user1.setEmail("usuario1@gmail.com");
		user1.setLogin("user1");
		user1.setPass("user123");
		dao.persist(user1);
		
		User user2 = new User();
		user2.setNome("Usuario 2");
		user2.setEmail("usuario2@gmail.com");
		user2.setLogin("user2");
		user2.setPass("user234");
		dao.persist(user2);
		
		User user3 = new User();
		user3.setNome("Usuario 3");
		user3.setEmail("usuario3@gmail.com");
		user3.setLogin("user3");
		user3.setPass("user345");
		dao.persist(user3);
		
		User user4 = new User();
		user4.setNome("Usuario 4");
		user4.setEmail("usuario4@gmail.com");
		user4.setLogin("user4");
		user4.setPass("user456");
		dao.persist(user4);
		
		User user5 = new User();
		user5.setNome("Usuario 5");
		user5.setEmail("usuario5@gmail.com");
		user5.setLogin("user5");
		user5.setPass("user567");
		dao.persist(user5);
		
		User user6 = new User();
		user6.setNome("Usuario 6");
		user6.setEmail("usuario6@gmail.com");
		user6.setLogin("user6");
		user6.setPass("user678");
		dao.persist(user6);
		
		User user7 = new User();
		user7.setNome("Usuario 7");
		user7.setEmail("usuario7@gmail.com");
		user7.setLogin("user7");
		user7.setPass("user789");
		dao.persist(user7);
		
		User user8 = new User();
		user8.setNome("Usuario 8");
		user8.setEmail("usuario8@gmail.com");
		user8.setLogin("user8");
		user8.setPass("user891");
		dao.persist(user8);
		
		dao.flush();
	}

	@Override
	public void onStop(Application app){
	    JPA.withTransaction(new play.libs.F.Callback0() {
	    @Override
	    public void invoke() throws Throwable {
	        Logger.info("Aplicação finalizando...");
	        disciplinas = dao.findAllByClassName("Disciplina");

	        for (Disciplina disciplina: disciplinas) {
	        dao.removeById(Disciplina.class, disciplina.getId());
	       } 
	    }}); 
	}
	
	private void criaDisciplinaTemas(){
		si1 = new Disciplina("Sistemas de Informação 1");
		si1.addTema(new Tema("Análise x Design"));
		si1.addTema(new Tema("Orientação a objetos"));
		si1.addTema(new Tema("GRASP"));
		si1.addTema(new Tema("GoF"));
		si1.addTema(new Tema("Arquitetura"));
		si1.addTema(new Tema("Play"));
		si1.addTema(new Tema("JavaScript"));
		si1.addTema(new Tema("HTML / CSS / Bootstrap"));
		si1.addTema(new Tema("Heroku"));
		
		labs = new Tema("Labs");
		si1.addTema(labs);
		miniteste = new Tema("Minitestes");
		si1.addTema(miniteste);
		
		si1.addTema(new Tema("Projeto"));
		dao.persist(si1);
		
		es = new Disciplina("Engenharia de Software");
		es.addTema(new Tema("Metodos Formais"));
		es.addTema(new Tema("Desenvolvimento de Software"));
		es.addTema(new Tema("Evolucao de Software"));
		
		testes = new Tema("Testes");
		es.addTema(testes);
		ferramentas = new Tema("Ferramentas");
		es.addTema(ferramentas);
		
		dao.persist(es);
		
		oac = new Disciplina("Organizacao e Arquitetura de Computadores");
		
		tiposDeMem = new Tema("Tipos de Memoria");
		oac.addTema(tiposDeMem);
		
		oac.addTema(new Tema("Assembly"));
		oac.addTema(new Tema("FPGA"));
		oac.addTema(new Tema("Circuitos Combinacionais"));
		oac.addTema(new Tema("Circuitos Sequenciais"));
		dao.persist(oac);
		dao.flush();
	}
}
