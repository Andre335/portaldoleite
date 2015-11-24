package estrategias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import comparators.MaisDiscordanciasComparator;

import models.Dica;

public class MaisDiscordanciasStrategy implements FilterStrategy {
	
	private List<Dica> dicas;
	
	public MaisDiscordanciasStrategy(List<Dica> dicas) {
		this.dicas = dicas;
	}
	
	@Override
	public List<Dica> filter() {
		List<Dica> dicasFiltrada = new ArrayList<>();
		Collections.sort(dicas, new MaisDiscordanciasComparator());
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
