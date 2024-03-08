package fr.unantes.sce.trivial.dpStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.unantes.sce.trivial.enumeration.Category;
import javafx.scene.image.Image;
import fr.unantes.sce.trivial.modele.CardEffect;
import fr.unantes.sce.trivial.modele.Question;
import fr.unantes.sce.trivial.vue.FightGP;

public class MaxRepel implements CardEffect {
	public void bonusEffect(FightGP fgp) {
		System.out.println("Change the question and the category");
		Random rand = new Random();
		
		Question questionFight = fgp.getQuestionRand();
		Category categoryFight = questionFight.getCategory();
		
		System.out.println(questionFight);
		System.out.println(categoryFight);
		System.out.println(questionFight.getCategory());
		
		//Récupérer une question d'une catégorie différente
		while(questionFight.getCategory().equals(categoryFight))
		{
			fgp.getQuestionRand(rand.nextInt(6) + 1);
			questionFight =  fgp.getQuestionRand();
		}
		
		//Variables utiles
		//Catégories
		List<Category> badges = new ArrayList<>();
		for (Category cat : Category.values()) {
			badges.add(cat);
		}
		int indexOf = badges.indexOf(questionFight.getCategory()) + 1;
		
		//Changer les valeurs de la catégorie, du badge, du sprite adverse, de la question et de la réponse
		fgp.getLblCategoryName().setText(questionFight.getCategory().toString());
		fgp.getIvBadge().setImage(new Image(getClass().getClassLoader().getResource("./images/badges/badge" + indexOf + ".png").toString()));
		fgp.getEnemySprite().setImage(new Image(getClass().getClassLoader().getResource("./images/enemySprites/" + questionFight.getCategory().toString() + ".gif").toString()));
		fgp.getLblAnswer().setText("Correct : " + questionFight.getAnswer());
		fgp.getLblQuestion().setText(questionFight.getStatement());
		fgp.getTxtAnswer().setText("");
		
		//Modifier la question dans le combat
		fgp.setQuestionRand(questionFight);
		System.out.println(questionFight);
		
		//Réafficher les informations de la question
		fgp.getInformations();
	}
}
