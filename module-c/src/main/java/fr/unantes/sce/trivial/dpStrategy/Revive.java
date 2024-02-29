package fr.unantes.sce.trivial.dpStrategy;

import fr.unantes.sce.trivial.modele.CardEffect;
import fr.unantes.sce.trivial.vue.FightGP;

public class Revive implements CardEffect {
	public void bonusEffect(FightGP fgp) {
		System.out.println("Respond 2 times at the question");
		
		System.out.println(fgp.getLblPlayerName());
	}
}
