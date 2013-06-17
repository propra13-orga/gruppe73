package dungeoncrawler;

import javax.swing.ImageIcon;

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
	public static boolean gotItem1 = false;
	
	public static char Item2Type = 'X';
	public static int Item2X = 0;
	public static int Item2Y = 0;
	public static String Item2Pfad = "";
	public static boolean gotItem2 = false;
	
	public static char Item3Type = 'X';
	public static int Item3X = 0;
	public static int Item3Y = 0;
	public static String Item3Pfad = "";
	public static boolean gotItem3 = false;
	
	public static char Item4Type = 'X';
	public static int Item4X = 0;
	public static int Item4Y = 0;
	public static String Item4Pfad = "";
	public static boolean gotItem4 = false;
	
	
	
	
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
		String Pfad = "/dungeoncrawler/default.PNG";
		
		
		// ITEM 1:
		
			if (ItemNr == 1) {
				if ((Item1Type == 'T')&(gotItem1 == false)) {
					Pfad = "/dungeoncrawler/points.PNG";
				} else if (Item1Type == 'D') {
					Pfad = "/dungeoncrawler/Mana.PNG";
				} else if (Item1Type == 'E') {
					Pfad = "/dungeoncrawler/shop_door.PNG";
				} else if (Item1Type == 'L') {
					Pfad = "/dungeoncrawler/heart.PNG";
				} else if (Item1Type == 'H') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item1Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item1Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				}
				
		// ITEM 2:
				
			} else if (ItemNr == 2) {
				if (Item2Type == 'T'&(gotItem2 == false)) {
					Pfad = "/dungeoncrawler/points.PNG";
				} else if (Item2Type == 'D') {
					Pfad = "/dungeoncrawler/Mana.PNG";
				} else if (Item2Type == 'E') {
					Pfad = "/dungeoncrawler/shop_door.PNG";
				} else if (Item2Type == 'L') {
					Pfad = "/dungeoncrawler/heart.PNG";
				} else if (Item2Type == 'H') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item2Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item2Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				}
				
		// ITEM 3:
				
			} else if (ItemNr == 3) {
				if (Item3Type == 'T'&(gotItem3 == false)) {
					Pfad = "/dungeoncrawler/points.PNG";
				} else if (Item3Type == 'D') {
					Pfad = "/dungeoncrawler/Mana.PNG";
				} else if (Item3Type == 'E') {
					Pfad = "/dungeoncrawler/shop_door.PNG";
				} else if (Item3Type == 'L') {
					Pfad = "/dungeoncrawler/heart.PNG";
				} else if (Item3Type == 'H') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item3Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item3Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				}
				
		// ITEM 4:
			
			} else if (ItemNr == 4) {
				if (Item4Type == 'T'&(gotItem4 == false)) {
					Pfad = "/dungeoncrawler/points.PNG";
				} else if (Item4Type == 'D') {
					Pfad = "/dungeoncrawler/Mana.PNG";
				} else if (Item4Type == 'E') {
					Pfad = "/dungeoncrawler/shop_door.PNG";
				} else if (Item4Type == 'L') {
					Pfad = "/dungeoncrawler/heart.PNG";
				} else if (Item4Type == 'H') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item4Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item4Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				}
			}
		
		return Pfad;
	}
	
	public static void Item_pickUp(String args[]) {
		if (gotItem1 == false) {	
			if (BuildLevel.getCurrentPlayerPos(0) == Item1X) {
				if (BuildLevel.getCurrentPlayerPos(1) == Item1Y) {
					gotItem1 = true;
			        BuildLevel.lblItem1.setBounds(400, 300, BuildLevel.lblItem1.getWidth(), BuildLevel.lblItem1.getHeight());
			        BuildLevel.FeldNeuzeichnen(null);
				}
			}
		}
		
		if (gotItem2 == false) {	
			if (BuildLevel.getCurrentPlayerPos(0) == Item2X) {
				if (BuildLevel.getCurrentPlayerPos(1) == Item2Y) {
					gotItem2 = true;
			        BuildLevel.lblItem2.setBounds(400, 300, BuildLevel.lblItem2.getWidth(), BuildLevel.lblItem2.getHeight());
			        BuildLevel.FeldNeuzeichnen(null);			
				}
			}
		}
		
		if (gotItem3 == false) {	
			if (BuildLevel.getCurrentPlayerPos(0) == Item3X) {
				if (BuildLevel.getCurrentPlayerPos(1) == Item3Y) {
					gotItem3 = true;
					BuildLevel.lblItem3.setBounds(400, 300, BuildLevel.lblItem3.getWidth(), BuildLevel.lblItem3.getHeight());
					BuildLevel.FeldNeuzeichnen(null);
				}
			}
		}
		
		if (gotItem4 == false) {	
			if (BuildLevel.getCurrentPlayerPos(0) == Item4X) {
				if (BuildLevel.getCurrentPlayerPos(1) == Item4Y) {
					gotItem4 = true;
					BuildLevel.lblItem4.setBounds(400, 300, BuildLevel.lblItem4.getWidth(), BuildLevel.lblItem4.getHeight());
					BuildLevel.FeldNeuzeichnen(null);
				}
			}
		}
	}
	
	public static int Item_Width_Height(int ItemNr) {
		
		int Width_Height = 15;
		return Width_Height;
		
	}

}
