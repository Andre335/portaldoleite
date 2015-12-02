package estrategias;

import java.util.HashMap;
import java.util.Map;

abstract class StrategyMap{
	
	static Map<String, FilterStrategy> getMap(){
		Map<String,FilterStrategy> mapa = new HashMap<String, FilterStrategy>();
		mapa.put("filtroMaisVotosPositivos", new MaisVotosPositivosStrategy());
		mapa.put("filtroMaisDiscordancias", new MaisDiscordanciasStrategy());
		mapa.put("filtroMaisRecentes", new UltimasDezStrategy());
		
		return mapa;
	}
}