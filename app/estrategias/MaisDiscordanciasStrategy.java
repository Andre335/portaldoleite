package estrategias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Ajuda;

import comparators.MaisDiscordanciasComparator;

public class MaisDiscordanciasStrategy implements FilterStrategy {
	
	private List<? extends Ajuda> dicas;
	
	public MaisDiscordanciasStrategy(List<? extends Ajuda> dicas) {
		this.dicas = dicas;
	}
	
	@Override
	public List<? extends Ajuda> filter() {
		List<Ajuda> dicasFiltrada = new ArrayList<Ajuda>();
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
