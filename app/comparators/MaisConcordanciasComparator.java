package comparators;

import java.util.Comparator;

import models.Ajuda;

public class MaisConcordanciasComparator implements Comparator<Ajuda>{
	
	@Override
	public int compare(Ajuda o1, Ajuda o2) {
		if (o1.getConcordancias() > o2.getConcordancias()){
			return -1;
		} else if (o1.getDiscordancias()<o2.getDiscordancias()) {
			return 1;
		} else {
			return 0;
		}
	}
}
