package estrategias;

import java.util.ArrayList;
import java.util.List;

import models.Ajuda;

public class UltimasDezStrategy implements FilterStrategy {
	
	@Override
	public List<? extends Ajuda> filter(List<? extends Ajuda> dicas) {
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
