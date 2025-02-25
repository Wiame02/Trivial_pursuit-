package fr.unantes.sce.trivial;

import java.util.ArrayList;
import java.util.List;

import fr.unantes.sce.trivial.model.Category;
import fr.unantes.sce.trivial.model.IteratorQuestion;
import fr.unantes.sce.trivial.model.IteratorQuestionCategory;
import fr.unantes.sce.trivial.model.Question;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteratorQuestionCategoryTest
{
	private IteratorQuestion it;
	private List<Question> list;
	
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		List<Question> listQ = new ArrayList<Question>();
		
		listQ.add(new Question("Decroos Christophe","In what hemisphere is located the  tropic of Cancer?",Category.GEOGRAPHY));
		listQ.add(new Question("Decroos Christophe","Usually, when can you watch the Australian open ?",Category.ENTERTAINMENT));
		listQ.add(new Question("Decroos Christophe","Where Jesus was born ?",Category.HISTORY));
		listQ.add(new Question("Decroos Christophe","Who is the � father � of the cummunism",Category.BUSINESS));
		listQ.add(new Question("Decroos Christophe","How many are there planet into the solar system ?",Category.SCIENCE_NATURE));
		listQ.add(new Question("Decroos Christophe","How many times Eddy Mercks won � Le tour de France � ?",Category.SPORT_LEISURE));
		listQ.add(new Question("Decroos Christophe","How measure the Earth's circumference ?",Category.GEOGRAPHY));
		listQ.add(new Question("Decroos Christophe","In wich planet Darth Vader was born ?",Category.ENTERTAINMENT));
		listQ.add(new Question("Decroos Christophe","Who was the president of USA during the Second World War ?",Category.HISTORY));
		listQ.add(new Question("Decroos Christophe","What�s the income of a shareholder ?",Category.BUSINESS));
		listQ.add(new Question("Decroos Christophe","What is the nearest star of the sun ?",Category.SCIENCE_NATURE));
		listQ.add(new Question("Decroos Christophe","Wich football club won the most time the football cup of Belgium ?",Category.SPORT_LEISURE));
		listQ.add(new Question("Decroos Christophe","What is the capital city of Kenya?",Category.GEOGRAPHY));
		listQ.add(new Question("Decroos Christophe","In wich game can you pull the black ball ?",Category.ENTERTAINMENT));
		listQ.add(new Question("Decroos Christophe","Who was the last king of France ?",Category.HISTORY));
		listQ.add(new Question("Decroos Christophe","What is the element that isn�t a primary need ?",Category.BUSINESS));
		listQ.add(new Question("Decroos Christophe","What is the lowest temperature that can exist ?", Category.SCIENCE_NATURE));
		listQ.add(new Question("Decroos Christophe","What is the nationality of stanislas wawrinka ?",Category.SPORT_LEISURE));
		
		it = new IteratorQuestionCategory(listQ,Category.GEOGRAPHY);
		list=(List<Question>)Explorateur.getField(it,"list");
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		it = null;
		list = null;
	}
	
	//TODO Demander au prof car probl�mes avec l'explorateur pour les super classes.
	@Test
	public void testNext()
	{
		
	}
	
	@Test
	public void testIterator()
	{
		
	}
	
	
}
