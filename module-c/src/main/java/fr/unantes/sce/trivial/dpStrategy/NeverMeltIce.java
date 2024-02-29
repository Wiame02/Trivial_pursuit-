package fr.unantes.sce.trivial.dpStrategy;

import fr.unantes.sce.trivial.modele.CardEffect;
import fr.unantes.sce.trivial.vue.FightGP;

public class NeverMeltIce implements CardEffect {
	public void bonusEffect(FightGP fgp) {
		System.out.println("Time stop !");
		
		fgp.getTimer();
	}
}
