package models;

import java.util.Comparator;

public class MaisDiscordanciasComparator implements Comparator<Dica> {

	@Override
	public int compare(Dica o1, Dica o2) {
		if (o1.getDiscordancias()>o2.getDiscordancias()) {
			return -1;
		} else if (o1.getDiscordancias()<o2.getDiscordancias()) {
			return 1;
		} else {
			return 0;
		}
	}

}
