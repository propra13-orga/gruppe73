package dungeoncrawler;

import dungeoncrawler.LoadLevel;
import dungeoncrawler.MovementListener;
/**
 * Diese Klasse ist für die Kollisionsabfrage mit dem Rahmen des Fensters zuständig.
 * Ausserdem werden mit dieser Klasse die Berührungen mit dem Gegner abgefragt.
 * 
 */
public class CollisionControl {

	/**
	 * @param args
	 */
	
	public static Boolean permit_movement;
	public static boolean meet_NPC = false;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	
		
		
	}
	
	/*
	 * Diese Methode überprüft, dass der Player innerhalb der Grenzen bleibt!
	 */
	
	public static boolean check_Xborder(int current_posX) {
		
		/*
		 *  Abfrage X-Bewegung
		 */
		
		boolean permit_Xmovement = true;
		
		if ((current_posX == 0)&(MovementListener.left == (-15))) {
			permit_Xmovement = false;
		}
		else if ((current_posX == 285)&(MovementListener.right == (15))) {
			permit_Xmovement = false;
		}
		else {
			permit_Xmovement = true;
		}
		return permit_Xmovement;
	}
	
	public static boolean check_Yborder(int current_posY) {
		
		/*
		 *  Abfrage Y-Bewegung
		 */
		
		boolean permit_Ymovement = true;
		
		if ((current_posY == 15)&(MovementListener.up == (-15))) {
			permit_Ymovement = false;
		}
		else if ((current_posY == 225)&(MovementListener.down == (15))) {
			permit_Ymovement = false;
		}
		else {
			permit_Ymovement = true;
		}
		return permit_Ymovement;
	}

	
	/*
	 * NPC-Kollisionsabfrage
	 * =====================
	 * 
	 */
	public static void meet_NPC(String args[]) {
		
		if (meet_NPC == false) {	
			String Current_LevelMap = LoadLevel.Current_LevelMap;
			if (Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'I'|Current_LevelMap.charAt(PlyPosUmrechnen()-20)=='I') {
				LevelControl.Shop_opened = true;
				StoryNPC.main(null);
				
				
			}
			
		}
	}
	

	
	
	/*
	 *  GEGNER-Kollisions-ABFRAGE
	 *  ==============
	 */
	

	
	/*
	 * ################################################################
	 *Kollisionsabfrage (WALL, AUSSENRÄNDER) für left, right, up, down
	 * ################################################################
	 */
	
	public static void left(String args[]) {
		System.out.println("Überprüfe Links:");
		String Current_LevelMap = LoadLevel.Current_LevelMap;
		System.out.println("In folgenem String: "+Current_LevelMap);
		System.out.println(PlyPosUmrechnen());
		if (BuildLevel.getCurrentPlayerPos(0) == 0) {
			MovementListener.left = 0;
		} else if ((Current_LevelMap.charAt(PlyPosUmrechnen()-1) == 'P')|(Current_LevelMap.charAt(PlyPosUmrechnen()-1) == ' ')|(Current_LevelMap.charAt(PlyPosUmrechnen()-1) == 'D')|(Current_LevelMap.charAt(PlyPosUmrechnen()-1) == 'S')|(Current_LevelMap.charAt(PlyPosUmrechnen()-1) == 'T')|(Current_LevelMap.charAt(PlyPosUmrechnen()-1) == 'X')|(Current_LevelMap.charAt(PlyPosUmrechnen()-1) == 'N')|(Current_LevelMap.charAt(PlyPosUmrechnen()-1) == 'M')) {
			MovementListener.left = -15;
		} else {
			MovementListener.left = 0;
			System.out.println("Geht nicht");
		}
	}
	
	public static void right(String args[]) {
		System.out.println("Überprüfe Rechts");
		String Current_LevelMap = LoadLevel.Current_LevelMap;
		System.out.println("In folgenem String: "+Current_LevelMap);
		System.out.println(PlyPosUmrechnen());
		if (BuildLevel.getCurrentPlayerPos(0) == 285) {
			MovementListener.right = 0;
		} else if ((Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'P')|(Current_LevelMap.charAt(PlyPosUmrechnen()+1) == ' ')|(Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'D')|(Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'S')|(Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'T')|(Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'X')|(Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'N')|(Current_LevelMap.charAt(PlyPosUmrechnen()+1) == 'M')) {
			MovementListener.right = 15;
		} else {
			MovementListener.right = 0;
			System.out.println("Geht nicht");
		}
	}
	
	public static void up(String args[]) {
		System.out.println("Überprüfe Oben:");
		String Current_LevelMap = LoadLevel.Current_LevelMap;
		System.out.println("In folgenem String: "+Current_LevelMap);
		System.out.println(PlyPosUmrechnen());
		if (BuildLevel.getCurrentPlayerPos(1) == 15) {
			MovementListener.up = 0;
	    } else if ((Current_LevelMap.charAt(PlyPosUmrechnen()-20) == 'P')|(Current_LevelMap.charAt(PlyPosUmrechnen()-20) == ' ')|(Current_LevelMap.charAt(PlyPosUmrechnen()-20) == 'D')|(Current_LevelMap.charAt(PlyPosUmrechnen()-20) == 'S')|(Current_LevelMap.charAt(PlyPosUmrechnen()-20) == 'T')|(Current_LevelMap.charAt(PlyPosUmrechnen()-20) == 'X')|(Current_LevelMap.charAt(PlyPosUmrechnen()-20) == 'N')|(Current_LevelMap.charAt(PlyPosUmrechnen()-20) == 'M')) {
			MovementListener.up = -15;
		} else {
			MovementListener.up = 0;
			System.out.println("Geht nicht");
		}
	}
	
	public static void down(String args[]) {
		System.out.println("Überprüfe Unten:");
		String Current_LevelMap = LoadLevel.Current_LevelMap;
		System.out.println("In folgenem String: "+Current_LevelMap);
		System.out.println(PlyPosUmrechnen());
		if (BuildLevel.getCurrentPlayerPos(1) == 225) {
			MovementListener.down = 0;
		} else if ((Current_LevelMap.charAt(PlyPosUmrechnen()+20) == 'P')|(Current_LevelMap.charAt(PlyPosUmrechnen()+20) == ' ')|(Current_LevelMap.charAt(PlyPosUmrechnen()+20) == 'D')|(Current_LevelMap.charAt(PlyPosUmrechnen()+20) == 'S')|(Current_LevelMap.charAt(PlyPosUmrechnen()+20) == 'T')|(Current_LevelMap.charAt(PlyPosUmrechnen()+20) == 'X')|(Current_LevelMap.charAt(PlyPosUmrechnen()+20) == 'N')|(Current_LevelMap.charAt(PlyPosUmrechnen()+20) == 'M')) {
			MovementListener.down = 15;
		} else {
			MovementListener.down = 0;
			System.out.println("Geht nicht");
		}
	}
	
	/* ######################################################
	* Rechnet X-Y-Koordinaten des Players in Labelnummer um:
	* ######################################################
	*/
	
	public static int PlyPosUmrechnen() {
		
		int newPosX = (BuildLevel.getCurrentPlayerPos(0))/15;
		int current_posY = (BuildLevel.getCurrentPlayerPos(1));
		int PlyPosNeu = 0;
		
		// Positionen von lblPlayer in String-Positionen umrechnen.
		
		if (current_posY == 15) {
			PlyPosNeu = newPosX;
		}
		else if (current_posY == 30) {
			PlyPosNeu = newPosX+20;
		}
		else if (current_posY == 45) {
			PlyPosNeu = newPosX+40;
		}
		else if (current_posY == 60) {
			PlyPosNeu = newPosX+60;
		}
		else if (current_posY == 75) {
			PlyPosNeu = newPosX+80;
		}
		else if (current_posY == 90) {
			PlyPosNeu = newPosX+100;
		}
		else if (current_posY == 105) {
			PlyPosNeu = newPosX+120;
		}
		else if (current_posY == 120) {
			PlyPosNeu = newPosX+140;
		}
		else if (current_posY == 135) {
			PlyPosNeu = newPosX+160;
		}
		else if (current_posY == 150) {
			PlyPosNeu = newPosX+180;
		}
		else if (current_posY == 165) {
			PlyPosNeu = newPosX+200;
		}
		else if (current_posY == 180) {
			PlyPosNeu = newPosX+220;
		}
		else if (current_posY == 195) {
			PlyPosNeu = newPosX+240;
		}
		else if (current_posY == 210) {
			PlyPosNeu = newPosX+260;
		}
		else if (current_posY == 225) {
			PlyPosNeu = newPosX+280;
		}
		
		return PlyPosNeu;
	}

}
