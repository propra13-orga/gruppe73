package dungeoncrawler;

public class LevelControl {

	/**
	 * @param args
	 */
	
	//PARAMETER DES AKTUELLEN LEVELS:
	public static char Current_LevelAnzeige = '?';
	public static char Current_SubLevelAnzeige = '?';
	
	public static int FinishDoorX;
	public static int FinishDoorY;
	
	public static int StartDoorX;
	public static int StartDoorY;
	
	public static char Item1Type = 'X';
	public static int Item1X = 0;
	public static int Item1Y = 0;
	public static String Item1Pfad = "";
	
	public static char Item2Type = 'X';
	public static int Item2X = 0;
	public static int Item2Y = 0;
	public static String Item2Pfad = "";
	
	public static char Item3Type = 'X';
	public static int Item3X = 0;
	public static int Item3Y = 0;
	public static String Item3Pfad = "";
	
	public static char Item4Type = 'X';
	public static int Item4X = 0;
	public static int Item4Y = 0;
	public static String Item4Pfad = "";
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void door_collision(String args[]) {
		
		
		if (BuildLevel.getCurrentPlayerPos(0) == FinishDoorX) {
			if (BuildLevel.getCurrentPlayerPos(1) == FinishDoorY) {
				BuildLevel.Current_Level = BuildLevel.Current_Level+1;
				BuildLevel.change_level_phase = true;
				//MovementListener.stopFlag = true;
				BuildLevel.neuesLevel(null);
				System.out.println("door_collision ---> Neues Level laden!");
				
			}
		}
		
	} 
	
	public static String Item_Pfade_aktualisieren(int ItemNr) {
		String Pfad = "/dungeoncrawler/gameover.PNG";
		
		
		// ITEM 1:
		
			if (ItemNr == 1) {
				if (Item1Type == 'T') {
					Pfad = "/dungeoncrawler/points.PNG";
				} 
				
		// ITEM 2:
				
			} else if (ItemNr == 2) {
				if (Item2Type == 'T') {
					Pfad = "/dungeoncrawler/points.PNG";
				} 
				
		// ITEM 3:
				
			} else if (ItemNr == 3) {
				if (Item3Type == 'T') {
					Pfad = "/dungeoncrawler/points.PNG";
				} 
				
		// ITEM 4:
			
			} else if (ItemNr == 4) {
				if (Item4Type == 'T') {
					Pfad = "/dungeoncrawler/points.PNG";
				} 
			}
		
		return Pfad;
	}

}
