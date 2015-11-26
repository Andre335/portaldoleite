package estrategias;

import java.util.List;

import models.Ajuda;

public interface FilterStrategy {
	
	public List<? extends Ajuda> filter();
}
