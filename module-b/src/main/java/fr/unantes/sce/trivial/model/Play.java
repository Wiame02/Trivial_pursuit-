package fr.unantes.sce.trivial.model;

import java.util.ArrayList;
import java.util.List;

public class Play {

	/**
	 * This method check if the game is over
	 * @param g
	 * @return boolean
	 */
	
	public static boolean isGameFinish(Game g){
		if(g.isGetSixCheese()){
			return true;
		}
		return false;
	}
	
	/**
	 * This method return the ids of the squares where the player can go 
	 * @param g current game
	 * @param s the square where the player is
	 * @param des
	 * @return List<Integer> 
	 */
	
	public static List<Integer> getListDeplacement(Square s,int des){
		List<Integer>listeChoix = null;
		listeChoix = new ArrayList<Integer>();
		
		//d�part case central plateau, 6 choix possibles
		if(s instanceof SquareBegin){
			listeChoix.add(s.getIdCase()+des);
			listeChoix.add(s.getIdCase()+des+12);
			listeChoix.add(s.getIdCase()+des+24);
			listeChoix.add(s.getIdCase()+des+36);
			listeChoix.add(s.getIdCase()+des+48);
			listeChoix.add(s.getIdCase()+des+60);
		}
		//d�part case camembert, 3 choix possibles 
		else if(s instanceof SquareQuestionCheese)
		{
			listeChoix.add(s.getIdCase()+des);
			//si la valeur du d�s est de 6, on ajoute la possibilit� de retourner sur la case de d�part
			if(des==6){
				listeChoix.add(0);
			}
			else
			{
				//sinon on recule vers la case de d�part
				listeChoix.add(s.getIdCase()-des);
			}
			
			if(s.getIdCase()==6){
				listeChoix.add(73-des);
			}
			else 
			{
				listeChoix.add(s.getIdCase()-5-des);
			}
			
		}
		//d�part case question ou relancer d�s, au moins 2 choix
		else
		{
			//test des choix possibles en diminuant l'id de la case initial
			//test pour savoir si le joueur passe par la case centrale
			if(passByStart(s.getIdCase(), des)==true){
				int j=0;
				for(int i=s.getIdCase();i>=s.getIdCase()-des;i--){
					if(i==0 || i==12 || i==24 || i==36 || i==48 || i==60){
						
						if(des==j){
							listeChoix.add(0);
						}
						
						//si le joueur vient de la 1�re branche
						else if(i==0){
							listeChoix.add(0+des-j+12);
							listeChoix.add(0+des-j+24);
							listeChoix.add(0+des-j+36);
							listeChoix.add(0+des-j+48);
							listeChoix.add(0+des-j+60);
						}
						
						//si le joueur vient de la 2�me branche
						else if(i==12){
							listeChoix.add(0+des-j);
							listeChoix.add(0+des-j+24);
							listeChoix.add(0+des-j+36);
							listeChoix.add(0+des-j+48);					
							listeChoix.add(0+des-j+60);
						}
						//si le joueur vient de la 3�me branche
						else if(i==24){
							listeChoix.add(0+des-j);
							listeChoix.add(0+des-j+12);
							listeChoix.add(0+des-j+36);
							listeChoix.add(0+des-j+48);
							listeChoix.add(0+des-j+60);
						}						
						//si le joueur vient de la 4�me branche
						else if(i==36){
							listeChoix.add(0+des-j);
							listeChoix.add(0+des-j+12);
							listeChoix.add(0+des-j+24);
							listeChoix.add(0+des-j+48);
							listeChoix.add(0+des-j+60);
						}
						
						//si le joueur vient de la 5�me branche
						else if(i==48){
							listeChoix.add(0+des-j);
							listeChoix.add(0+des-j+12);
							listeChoix.add(0+des-j+24);
							listeChoix.add(0+des-j+36);
							listeChoix.add(0+des-j+60);
						}
						//si le joueur vient de la 6�me branche
						else if(i==60){
							listeChoix.add(0+des-j);
							listeChoix.add(0+des-j+12);
							listeChoix.add(0+des-j+24);
							listeChoix.add(0+des-j+36);
							listeChoix.add(0+des-j+48);
						}
					}
					j++;
				}
			}
			//test pour savoir si le joueur passe par une case camembert
			else if(passByCheeseDown(s.getIdCase(), des)==true){
				int j=0;
				for(int i=s.getIdCase();i>=s.getIdCase()-des;i--){
					if( i==18 || i==30 || i==42 || i==54 || i==66){
						if(des==j){
							listeChoix.add(i);
						}
						else
						{
							listeChoix.add(s.getIdCase()-des);
							listeChoix.add(s.getIdCase()-des-5);
						}
					}
					if(i==6){
						if(des==j){
							listeChoix.add(i);
						}
						else
						{
							listeChoix.add(s.getIdCase()-des);
							listeChoix.add(s.getNbCase()-(des-j));
						}
						
					}
					j++;
				}
			}
			//si le joueur ne passe pas par une case camembert ou la case centrale
			else
			{
				listeChoix.add(s.getIdCase()-des);
			}
			
			//test des choix possibles en augmentant l'id de la case initial
			//si le joueur se d�place d'une branche int�rieur et d�passe une case camembert
			if(passByCheeseUp1(s.getIdCase(), des)==true){
				int j=1;
				for(int i=s.getIdCase()+1;i<=s.getIdCase()+des;i++){
					if( i==18 || i==30 || i==42 || i==54 || i==66) {
						listeChoix.add(s.getIdCase()-5+j-(des-j));
						listeChoix.add(s.getIdCase()+des);
					}
					
					if(i==6){
						listeChoix.add(73-(des-j));
						listeChoix.add(s.getIdCase()+des);
					}
					j++;
				}
			}
			//si le joueur se trouve sur le contour du plateau et qu'il passe par une case camembert
			else if(passByCheeseUp2(s.getIdCase(), des)==true){
				int j=1;
				for(int i=s.getIdCase();i<s.getIdCase()+des;i++){
					if(i==12 || i==24 || i==36 || i==48 || i==60 ||i==72){
						//si il s'arr�te sur la case camembert
						if(des==j){
							//cas particulier car les ids des cases s'arr�tent � 72
							if(i==72){
								listeChoix.add(6);
							}
							//autres cas
							else
							{
								listeChoix.add(s.getIdCase()+des+5);
							}
						}
						// si il d�passe la case camembert
						//cas particulier car les ids des cases s'arr�tent � 72
						else if(i==72){
							listeChoix.add(6+(des-j));
							listeChoix.add(6-(des-j));
						}
						// autres cas
						else
						{
							listeChoix.add(s.getIdCase()+des+5);
							listeChoix.add(s.getIdCase()+5+j-(des-j));
						}
					}
					j++;
				}
			}
			//si le joueur ne rencontre aucune case camembert
			else
			{
				listeChoix.add(s.getIdCase()+des);
			}
		}
		
		return listeChoix;
	}

	/**
	 * This method check if the player pass by a cheese square by the center of the gameboard
	 * @param idSquare
	 * @param des
	 * @return
	 */
	private static boolean passByCheeseUp1(int idSquare,int des){
		for(int i=idSquare;i<idSquare+des;i++){
			if(i==6 || i==18 || i==30 || i==42 || i==54 || i==66) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 *This method check if the player pass by a cheese square by the round of the gameboard
	 * @param idSquare
	 * @param des
	 * @return
	 */
	private static boolean passByCheeseUp2(int idSquare,int des){
		for(int i=idSquare;i<idSquare+des;i++){
			if(i==12 || i==24 || i==36 || i==48 || i==60 || i==72) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method check if the player pass by a cheese square by the round of the gameboard
	 * @param idSquare
	 * @param des
	 * @return
	 */
	private static boolean passByCheeseDown(int idSquare,int des){
		for(int i=idSquare;i>=idSquare-des;i--){
			if(i==6 || i==18 || i==30 || i==42 || i==54 || i==66) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * This method check if the player pass by the begin square 
	 * @param idSquare
	 * @param des
	 * @return
	 */
	private static boolean passByStart(int idSquare,int des){
		for(int i=idSquare;i>idSquare-des;i--){
			if(i==1 || i==13 || i==25 || i==37 || i==49 || i==61) {
				return true;
			}
		}
		return false;
	}
}