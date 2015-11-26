package estrategias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Ajuda;

import comparators.MaisVotosComparator;

public class MaisVotosPositivosStrategy implements FilterStrategy {
	
	@Override
	public List<? extends Ajuda> filter(List<? extends Ajuda> dicas) {
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
