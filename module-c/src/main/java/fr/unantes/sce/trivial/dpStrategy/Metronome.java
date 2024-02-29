package fr.unantes.sce.trivial.dpStrategy;

import fr.unantes.sce.trivial.modele.CardEffect;
import fr.unantes.sce.trivial.vue.FightGP;

public class Metronome implements CardEffect{
	public void bonusEffect(FightGP fgp) {
		System.out.println("Reset the timer !");
		fgp.add(fgp.getTimer(), 0, 2, 10, 10);
	}
}
