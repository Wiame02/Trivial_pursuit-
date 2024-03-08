package fr.unantes.sce.trivial;


import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.unantes.sce.trivial.model.Gamer;



import fr.unantes.sce.trivial.exception.BirthdayGamerException;
import fr.unantes.sce.trivial.exception.EmailGamerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamerTest 
{
	Gamer gamer;
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		gamer = new Gamer("toto01", "helha", "toto01@student.helha.be", "Reporter", "Tintin", "28/04/1998");
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		gamer = null;
	}

	@Test
	public void testEquals() 
	{
		Gamer gamerTest1 = null;
		try {
			gamerTest1 = new Gamer("toto01", "helha", "toto01@student.helha.be", "Reporter", "Tintin", "28/04/1998");
		} catch (BirthdayGamerException | EmailGamerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gamer gamerTest2 = null;
		try {
			gamerTest2 = new Gamer("toto02", "helha", "toto01@student.helha.be", "Reporter", "Tintin", "28/04/1998");
		} catch (BirthdayGamerException | EmailGamerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(gamer.equals(gamerTest1) && !gamer.equals(gamerTest2));
	}

	
}
