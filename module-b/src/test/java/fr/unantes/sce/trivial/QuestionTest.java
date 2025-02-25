package fr.unantes.sce.trivial;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import fr.unantes.sce.trivial.model.Category;
import fr.unantes.sce.trivial.model.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionTest {
	private HashMap<String,Boolean>choices;
	private Question quest;
	private String answer;
	private String answer2;
	private String answer3;
	private String answer4;
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		quest = new Question("Rochez Adrien","What is the capital city of Russia?",Category.GEOGRAPHY);
		choices = (HashMap<String, Boolean>)Explorateur.getField(quest, "choices");
		answer = "Moscow";
		answer2 = "Kiev";
		answer3 = "Sochi";
		answer4 = "Saint Petersburg";
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		quest = null;
		choices = null;
		answer = null;
		answer2 = null;
	}

	@Test
	public void testAddChoice() 
	{
		quest.addChoice(answer,true);
		assertTrue(choices.containsKey(answer));
		quest.addChoice(answer2,false);
		assertTrue(choices.containsKey(answer2));
		assertFalse(quest.addChoice(answer,true));// Ajout d'un doublon
		
	}

	@Test
	public void testRemoveChoice() 
	{
		choices.put(answer,true);
		quest.removeChoice(answer);
		assertFalse(choices.containsKey(answer));
	}

	@Test
	public void testVerify() 
	{
		assertFalse(quest.verify());
		choices.put(answer,true);
		choices.put(answer2,false);
		assertTrue(quest.verify());
		choices.put("Donesk",true); // Ajout de deux bonnes r�ponses
		assertFalse(quest.verify());
	}
	
	@Test
	public void testGetChoices()
	{
		choices.put(answer, true);
		choices.put(answer2, false);
		choices.put(answer3, false);
		choices.put(answer4, false);
		
		assertTrue(quest.getChoices().entrySet().containsAll(choices.entrySet()));
		// On place les deux map dans un set gr�ce � la m�thode entrySet
		// Cela permet ensuite de comparer leursd �l�ments gr�ce � la m�thode entrySet
	}
	
	@Test
	public void testEquals()
	{
		assertTrue(!new Question("Decroos Christophe", "What time is it?", Category.GEOGRAPHY).equals(quest));
	}
	
	

}

