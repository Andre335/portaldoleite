package estrategias;

import java.util.ArrayList;
import java.util.List;

import models.Ajuda;

public class UltimasDezStrategy implements FilterStrategy {
	
	private List<? extends Ajuda> dicas;
	
	public UltimasDezStrategy(List<? extends Ajuda> dicas) {
		this.dicas = dicas;
	}
	
	@Override
	public List<? extends Ajuda> filter() {
		List<Ajuda> dicasFiltrada = new ArrayList<Ajuda>();
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
