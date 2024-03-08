package fr.unantes.sce.trivial;

import java.util.List;

import fr.unantes.sce.trivial.model.Category;
import fr.unantes.sce.trivial.model.Gamer;
import fr.unantes.sce.trivial.model.Piece;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class PieceTest 
{
	private Gamer gamer;
	private Piece piece;
	private List<Category> cheese;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception 
	{
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception 
	{
	}

	@BeforeEach
	public void setUp() throws Exception 
	{
		gamer = new Gamer(null,null,null,null, null, null);
		//piece = new Piece(gamer);
		cheese = (List<Category>)Explorateur.getField(piece,"cheese");
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		piece = null;
		cheese = null;
	}

	
	

}
