package fr.unantes.sce.trivial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.List;

import fr.unantes.sce.trivial.model.Game;
import fr.unantes.sce.trivial.model.Piece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest
{
	private Game game;
	private List<Piece> listGamers;
	private Piece p;
	@BeforeEach
	public void setUp() throws Exception 
	{
		game = Game.getInstance();
		listGamers =(List<Piece>)Explorateur.getField(game,"listGamers");
		p = Piece.getInstance();
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		// Les 3 instructions suivantes permettent de tester n'importe quel Singleton gr�ce � l'introspection.
				java.lang.reflect.Field instance = Game.class.getDeclaredField("instance");// On r�cup�re l'attribut "instance".
				// que l'on place dans un objet "Field".
				instance.setAccessible(true); // On rend l'objet "Field" accessible.
				instance.set(null, null);// On donne la valeur null � l'attribut "instance".
				game = null; // On donne la valeur null au r�f�rent de l'instance.
				p=null;
	}
	
	@Test
	public void testDateToday()
	{
		Calendar calendar = Calendar.getInstance();
		int day  = calendar.get(Calendar.DAY_OF_MONTH);
		int month  = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		assertTrue(String.format("%02d/%02d/%4d", day, month, year).equals(Game.dateToday()));
	}
	
	@Test
	public void testAddPiece()
	{
		
		listGamers.add(p);
	}

}
