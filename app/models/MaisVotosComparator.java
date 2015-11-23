package models;

import java.util.Comparator;

public class MaisVotosComparator implements Comparator<Dica> {

	@Override
	public int compare(Dica o1, Dica o2) {
		if (o1.getConcordancias()>o2.getConcordancias()) {
			return -1;
		} else if (o1.getConcordancias()<o2.getConcordancias()) {
			return 1;
		} else {
			return 0;
		}
	}

}
