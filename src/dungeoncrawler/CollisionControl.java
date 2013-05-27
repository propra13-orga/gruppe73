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
		
		String Current_LevelMap = LoadLevel.getCurrent_LevelMap();
		
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
		else if ((current_posY == 210)&(MovementListener.checkDown() == true)) {
			permit_Ymovement = false;
		}
		else {
			permit_Ymovement = true;
		}
		return permit_Ymovement;
	}

}
