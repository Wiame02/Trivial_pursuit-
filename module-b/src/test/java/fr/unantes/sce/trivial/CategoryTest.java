package fr.unantes.sce.trivial;

import fr.unantes.sce.trivial.model.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CategoryTest 
{
	@Test
	public void testValueIndexOf() 
	{
		assertTrue(Category.GEOGRAPHY==Category.valueIndexOf(0));
		assertTrue(Category.ENTERTAINMENT==Category.valueIndexOf(1));
		assertTrue(Category.HISTORY==Category.valueIndexOf(2));
		assertTrue(Category.BUSINESS==Category.valueIndexOf(3));
		assertTrue(Category.SCIENCE_NATURE==Category.valueIndexOf(4));
		assertTrue(Category.SPORT_LEISURE==Category.valueIndexOf(5));
	}

}
