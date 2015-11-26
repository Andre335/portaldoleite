package estrategias;

import java.util.List;
import java.util.Map;

import models.Ajuda;

public interface FilterStrategy {
	public static final Map<String,FilterStrategy> FilterMap = StrategyMap.getMap();
	
	public List<? extends Ajuda> filter(List<? extends Ajuda> dicas);
}