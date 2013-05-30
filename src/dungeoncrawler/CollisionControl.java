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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	
		
		
	}
	
	/*
	 * Diese Methode überprüft, dass der Player innerhalb der Grenzen bleibt!
	 */
	
	public static boolean check_Xborder(int current_posX) {
		
		// Abfrage X-Bewegung
		
		boolean permit_Xmovement = true;
		
		if ((current_posX == 0)&(MovementListener.checkLeft() == true)) {
			permit_Xmovement = false;
		}
		else if ((current_posX == 285)&(MovementListener.checkRight() == true)) {
			permit_Xmovement = false;
		}
		else {
			permit_Xmovement = true;
		}
		return permit_Xmovement;
	}
	
	public static boolean check_Yborder(int current_posY) {
		
		// Abfrage Y-Bewegung
		
		boolean permit_Ymovement = true;
		
		if ((current_posY == 15)&(MovementListener.checkUp() == true)) {
			permit_Ymovement = false;
		}
		else if ((current_posY == 225)&(MovementListener.checkDown() == true)) {
			permit_Ymovement = false;
		}
		else {
			permit_Ymovement = true;
		}
		return permit_Ymovement;
	}
	
	/*
	 * WALL-Kollisions-Abfrage
	 * =======================
	 */
	
	public static boolean check_wall(int current_posX, int current_posY) {
		
		String Current_LevelMap = LoadLevel.getCurrent_LevelMap();
		boolean permit_movement = true;
		int newPosX = current_posX/15;
		int finalPos = 0;
		char checkposL = 'P';
		char checkposR = 'P';
		char checkposU = 'P';
		char checkposD = 'P';
		
		// Positionen von lblPlayer in String-Positionen umrechnen.
		
		if (current_posY == 15) {
			finalPos = newPosX;
		}
		else if (current_posY == 30) {
			finalPos = newPosX+20;
		}
		else if (current_posY == 45) {
			finalPos = newPosX+40;
		}
		else if (current_posY == 60) {
			finalPos = newPosX+60;
		}
		else if (current_posY == 75) {
			finalPos = newPosX+80;
		}
		else if (current_posY == 90) {
			finalPos = newPosX+100;
		}
		else if (current_posY == 105) {
			finalPos = newPosX+120;
		}
		else if (current_posY == 120) {
			finalPos = newPosX+140;
		}
		else if (current_posY == 135) {
			finalPos = newPosX+160;
		}
		else if (current_posY == 150) {
			finalPos = newPosX+180;
		}
		else if (current_posY == 165) {
			finalPos = newPosX+200;
		}
		else if (current_posY == 180) {
			finalPos = newPosX+220;
		}
		else if (current_posY == 195) {
			finalPos = newPosX+240;
		}
		else if (current_posY == 210) {
			finalPos = newPosX+260;
		}
		else if (current_posY == 225) {
			finalPos = newPosX+280;
		}
		
		int finalPosL = (finalPos-1);
		int finalPosR = (finalPos+1);
		int finalPosU = (finalPos-20);
		int finalPosD = (finalPos+20);
	
		// CHECK in X-Richtung
		
		if ((current_posX == 0)&(current_posY == 15)) {
			checkposL = 'P';	
		}
		else {
			checkposL = Current_LevelMap.charAt(finalPosL);
			checkposR = Current_LevelMap.charAt(finalPosR);
			if (MovementListener.checkLeft() == true) {
				if (checkposL == 'W') {
					permit_movement = false;
				}
			}
		}
			
		
		if (MovementListener.checkRight() == true) {
			
			if (checkposR == 'W') {
				permit_movement = false;
			}
		}
		
		// Check in Y-Richtung
	
		if (permit_movement != false) {
			
			if (current_posY != 225) {
				if (MovementListener.checkDown() == true) {
					checkposD = Current_LevelMap.charAt(finalPosD);
					if (checkposD == 'W') {
						permit_movement = false;
					}
				}
			}
			
			if (current_posY != 15) {
				if (MovementListener.checkUp() == true) {
					checkposU = Current_LevelMap.charAt(finalPosU);
					if (checkposU == 'W') {
						permit_movement = false;
					}
				}
			}
			
		}
		
			
		return permit_movement;
	}
	
	/*
	 *  FALLEN-Kollisionsabfrage
	 *  ========================
	 * 
	 */
	
	public static boolean check_trap(int current_posX, int current_posY) {
		
		String Current_LevelMap = LoadLevel.getCurrent_LevelMap();
		boolean trap = false;
		int newPosX = current_posX/15;
		int finalPos = 0;
		char checkpos = 'P';
		
		// Positionen von lblPlayer in String-Positionen umrechnen.
		
		if (current_posY == 15) {
			finalPos = newPosX;
		}
		else if (current_posY == 30) {
			finalPos = newPosX+20;
		}
		else if (current_posY == 45) {
			finalPos = newPosX+40;
		}
		else if (current_posY == 60) {
			finalPos = newPosX+60;
		}
		else if (current_posY == 75) {
			finalPos = newPosX+80;
		}
		else if (current_posY == 90) {
			finalPos = newPosX+100;
		}
		else if (current_posY == 105) {
			finalPos = newPosX+120;
		}
		else if (current_posY == 120) {
			finalPos = newPosX+140;
		}
		else if (current_posY == 135) {
			finalPos = newPosX+160;
		}
		else if (current_posY == 150) {
			finalPos = newPosX+180;
		}
		else if (current_posY == 165) {
			finalPos = newPosX+200;
		}
		else if (current_posY == 180) {
			finalPos = newPosX+220;
		}
		else if (current_posY == 195) {
			finalPos = newPosX+240;
		}
		else if (current_posY == 210) {
			finalPos = newPosX+260;
		}
		else if (current_posY == 225) {
			finalPos = newPosX+280;
		}
		
		checkpos = Current_LevelMap.charAt(finalPos);
		if (checkpos == 'S') {
			trap = true;
		}
		return trap;
	}
	
	
	/*
	 *  GEGNER-Kollisions-ABFRAGE
	 *  ==============
	 */
	
	public static boolean check_enemies(int plyX, int plyY, int enmX, int enmY) {
		boolean collision = false;
		if (plyX == enmX) {
			if (plyY == enmY) {
				collision = true;
			}
		}
		return collision;
	}

}
