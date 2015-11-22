package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaisVotosPositivosStrategy implements FilterStrategy {
	
	private List<Dica> dicas;
	
	public MaisVotosPositivosStrategy(List<Dica> dicas) {
		this.dicas = dicas;
	}
	
	@Override
	public List<Dica> filter() {
		List<Dica> dicasFiltrada = new ArrayList<>();
		Collections.sort(dicas, new MaisVotosComparator());
		if (dicas.size() > 10) {
			for (int i = 0; i < 10; i++) {
				dicasFiltrada.add(dicas.get(i));
			}
			return dicasFiltrada;
		} else {
			return dicas;
		}
	}

}

class MaisVotosComparator implements Comparator<Dica> {

	@Override
	public int compare(Dica o1, Dica o2) {
		if (o1.getConcordancias()>o2.getConcordancias()) {
			return -1;
		} else if (o1.getConcordancias()<o2.getConcordancias()) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
