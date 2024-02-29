package fr.unantes.sce.trivial.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import fr.unantes.sce.trivial.model.Game;
import fr.unantes.sce.trivial.model.Piece;
import fr.unantes.sce.trivial.model.Stack;

/**
 * This class launch the game
 * @author Thomas
 *
 */
public class PanelGame extends JPanel
{
	

	private static final long serialVersionUID = 1L;

	public PanelGame()
	{
		
		this.setLayout(new BorderLayout());
	
		startGame();

	}
	
	public void startGame()
	{
		
		//lancement des classes pour d�marrer une partie
        Game.getInstance();
		Game.getInstance().addPiece(Piece.getInstance());
		Game.getInstance().putPlayerOnGameBoard();
		Stack.getInstance().mixQuestion();
		this.add(new PanelDice(), BorderLayout.CENTER);
		
	
	}
		
		

}

