package fr.unantes.sce.trivial.dpStrategy;

import java.util.Random;

import fr.unantes.sce.trivial.enumeration.Category;
import fr.unantes.sce.trivial.modele.CardEffect;
import fr.unantes.sce.trivial.modele.Question;
import fr.unantes.sce.trivial.vue.FightGP;

public class Repel implements CardEffect {
	public void bonusEffect(FightGP fgp) {
		System.out.println("Change the question !");
		Random rand = new Random();
		
		Question questionFight = fgp.getQuestionRand();
		Category categoryFight = questionFight.getCategory();
		String statementFight = questionFight.getStatement();
		
		//Récupérer une question d'une catégorie différente
		while(questionFight.getStatement().equals(statementFight) || !questionFight.getCategory().equals(categoryFight))
		{
			fgp.getQuestionRand(rand.nextInt(6) + 1);
			questionFight =  fgp.getQuestionRand();
		}
		
		//Changer les valeurs de la question et de la réponse
		fgp.getLblAnswer().setText("Correct : " + questionFight.getAnswer());
		fgp.getLblQuestion().setText(questionFight.getStatement());
		fgp.getTxtAnswer().setText("");
		
		//Modifier la question dans le combat
		fgp.setQuestionRand(questionFight);
		
		//Réafficher les informations de la question
		fgp.getInformations();
	}
}
