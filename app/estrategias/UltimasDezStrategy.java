package estrategias;

import java.util.ArrayList;
import java.util.List;

import models.Dica;

public class UltimasDezStrategy implements FilterStrategy {
	
	private List<Dica> dicas;
	
	public UltimasDezStrategy(List<Dica> dicas) {
		this.dicas = dicas;
	}
	
	@Override
	public List<Dica> filter() {
		List<Dica> dicasFiltrada = new ArrayList<>();
		if(dicas.size() > 10) {
			for (int i = 0; i < 10; i++) {
				dicasFiltrada.add(dicas.get(dicas.size()-1-i));
			}
			return dicasFiltrada;
		} else {
			return dicas;
		}
	}

}
