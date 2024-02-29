package fr.unantes.sce.trivial;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import fr.unantes.sce.trivial.model.Dice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest 
{
	Dice dice;
	
	@Before
	public void setUp() throws Exception
	{
		dice = Dice.getInstance();
	}
	
	@After
	public void tearDown() throws Exception
	{
		// Les 3 instructions suivantes permettent de tester n'importe quel Singleton gr�ce � l'introspection.
		Field instance = Dice.class.getDeclaredField("instance");// On r�cup�re l'attribut "instance".
		// que l'on place dans un objet "Field".
		instance.setAccessible(true); // On rend l'objet "Field" accessible.
		instance.set(null, null);// On donne la valeur null � l'attribut "instance".
		dice = null; // On donne la valeur null au r�f�rent de l'instance.
	}

	@Test
	public void testGetInstance()
	{
		assertTrue(dice == Dice.getInstance());
	}
	
	@Test
	public void testRollDice()
	{
		dice.rollDice();
		assertTrue(dice.getFace()>0 && dice.getFace()<7);
	}

}
