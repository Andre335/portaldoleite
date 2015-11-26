package estrategias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Ajuda;

import comparators.MaisVotosComparator;

public class MaisVotosPositivosStrategy implements FilterStrategy {
	
	private List<? extends Ajuda> dicas;
	
	public MaisVotosPositivosStrategy(List<? extends Ajuda> dicasTotal) {
		this.dicas = dicasTotal;
	}
	
	@Override
	public List<? extends Ajuda> filter() {
		List<Ajuda> dicasFiltrada = new ArrayList<Ajuda>();
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
