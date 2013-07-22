package Multiplayergame;

import java.applet.Applet;
import java.applet.*;



public class LevelControl {
	 
	/**
	*PARAMETER DES AKTUELLEN LEVELS:
	*In LevelControl wird wie der Name schon sagt, dass Level immer neu berechnet.
	* Dabei werden alle möglichen Daten ermittelt.
	* Es wird zum Beispiel festgestellt, ob etwas aufgehoben worden ist, 
	* es im Inventar gelandet ist und ob angegeben ob es noch angezeigt oder entfernt
	* werden muss.Genauso ist es auch mit den Gegnern. etc.
	*/
	
	//private static int[] range;
	
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
	

	public static boolean drache_alive = false;
	public static boolean hexe_alive = false;
	public static boolean spinne_alive = false;
	
	public static boolean SavePoint = false;
	public static boolean SavePointAnzeige = false;
	public static int SavePointX = 0;
	public static int SavePointY = 0;
	public static int SaveLevel = 0;

	public static boolean Shop_opened = false; // von NPC & Shop verwendet


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * Abfrage der Collision mit der Türe. Stimmen Position des Spielers und des Ausgangs überein, wird das neue Level 
	 * geladen
	 * 
	 */
	
	public static void door_collision(String args[]) {
		
		
		if (BuildLevel.getCurrentPlayerPos(0) == FinishDoorX) {
			if (BuildLevel.getCurrentPlayerPos(1) == FinishDoorY) {
				BuildLevel.Current_Level = BuildLevel.Current_Level+1;
				BuildLevel.change_level_phase = true;
				//MovementListener.stopFlag = true;
				hexe_alive = false;
				spinne_alive = false;
				drache_alive = false;
				BuildLevel.neuesLevel(null);
				System.out.println("door_collision ---> Neues Level laden!");
				
				
			}
		}
		
	} 
	
	/**
	 * Festlegen der Items und ihrer Bilder.
	 * 
	 */
	
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
				} else if (Item1Type == 'H'|Item1Type == 'Z') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item1Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item1Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				} else if (Item1Type == 'P') {
					Pfad = "/dungeoncrawler/pfeil1.PNG";
				} else if (Item1Type == 'C') { 
					Pfad = "/dungeoncrawler/Sword.PNG";
				} else if (Item1Type == 'R') {
		        	Pfad = ("/dungeoncrawler/ruestung.PNG");
				} else if (Item1Type == 'W') {
					MovementListener.moveDown = false;
					MovementListener.moveUp = true;
					hexe_alive = true;
					Pfad = ("/dungeoncrawler/hexe.PNG");
					Gegner.EnemyEnergy = 20;
				} else if (Item1Type == 'G') {
					Pfad = ("/dungeoncrawler/drache.PNG");
					Gegner.EnemyEnergy = 30;
					MovementListener.moveDown = false;
					MovementListener.moveUp = true;
					drache_alive = true;
				} else if (Item1Type == 'S') {
					Pfad = ("/dungeoncrawler/spinne.PNG");
					Gegner.EnemyEnergy = 12;
					MovementListener.moveDown = false;
					MovementListener.moveUp = true;
					spinne_alive = true;
				} else if (Item1Type == 'J') {
					Pfad = ("/dungeoncrawler/lagerfeuer.PNG");
				} 
				
		// ITEM 2:
				
			} else if (ItemNr == 2) {
				if ((Item2Type == 'T')&(gotItem2 == false)) {
					Pfad = "/dungeoncrawler/points.PNG";
				} else if (Item2Type == 'D') {
					Pfad = "/dungeoncrawler/Mana.PNG";
				} else if (Item2Type == 'E') {
					Pfad = "/dungeoncrawler/shop_door.PNG";
				} else if (Item2Type == 'L') {
					Pfad = "/dungeoncrawler/heart.PNG";
				} else if (Item2Type == 'H'|Item2Type == 'Z') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item2Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item2Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				} else if (Item2Type == 'P') {
					Pfad = "/dungeoncrawler/pfeil1.PNG";
				} else if (Item2Type == 'C') { 
					Pfad = "/dungeoncrawler/Sword.PNG";
				} else if (Item2Type == 'R') {
					Pfad = "/dungeoncrawler/ruestung.PNG";
				} else if (Item2Type == 'J') {
					Pfad = ("/dungeoncrawler/lagerfeuer.PNG");
				} else if (Item2Type == 'R') {
		        	BuildLevel.lblCheckpoint.setText("Du hast eine Rüstung gefunden...");
		        	SavePointAnzeige = true;
		        	Player.suitofarmor = Player.suitofarmor+1;			        	
		        	BuildLevel.lblRuestungAnzeige.setVisible(true);
		        	Player.PlayerPower = Player.PlayerPower +5;
				}
				
		// ITEM 3:
				
			} else if (ItemNr == 3) {
				if ((Item3Type == 'T')&(gotItem3 == false)) {
					Pfad = "/dungeoncrawler/points.PNG";
				} else if (Item3Type == 'D') {
					Pfad = "/dungeoncrawler/Mana.PNG";
				} else if (Item3Type == 'E') {
					Pfad = "/dungeoncrawler/shop_door.PNG";
				} else if (Item3Type == 'L') {
					Pfad = "/dungeoncrawler/heart.PNG";
				} else if (Item3Type == 'H'|Item3Type == 'Z') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item3Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item3Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				} else if (Item3Type == 'P') {
					Pfad = "/dungeoncrawler/pfeil1.PNG";
				} else if (Item3Type == 'C') { 
					Pfad = "/dungeoncrawler/Sword.PNG";
				} else if (Item3Type == 'R') {
					Pfad = "/dungeoncrawler/ruestung.PNG";
				} else if (Item3Type == 'J') {
					Pfad = ("/dungeoncrawler/lagerfeuer.PNG");
				} else if (Item3Type == 'R') {
		        	BuildLevel.lblCheckpoint.setText("Du hast eine Rüstung gefunden...");
		        	SavePointAnzeige = true;
		        	Player.suitofarmor = Player.suitofarmor+1;			        	
		        	BuildLevel.lblRuestungAnzeige.setVisible(true);
		        	Player.PlayerPower = Player.PlayerPower +5;
				}
				
		// ITEM 4:
			
			} else if (ItemNr == 4) {
				if ((Item4Type == 'T')&(gotItem4 == false)) {
					Pfad = "/dungeoncrawler/points.PNG";
					Treasure.PlayMusic("treasure");
				} else if (Item4Type == 'D') {
					Pfad = "/dungeoncrawler/Mana.PNG";
				} else if (Item4Type == 'E') {
					Pfad = "/dungeoncrawler/shop_door.PNG";
				} else if (Item4Type == 'L') {
					Pfad = "/dungeoncrawler/heart.PNG";
				} else if (Item4Type == 'H'|Item4Type == 'Z') {
					Pfad = "/dungeoncrawler/Medikit.PNG";
				} else if (Item4Type == 'A') {
					Pfad = "/dungeoncrawler/bogen.PNG";
				} else if (Item4Type == 'B') {
					Pfad = "/dungeoncrawler/boooo.PNG";
				} else if (Item4Type == 'P') {
					Pfad = "/dungeoncrawler/pfeil1.PNG";
				} else if (Item4Type == 'C') { 
					Pfad = "/dungeoncrawler/Sword.PNG";
				} else if (Item4Type == 'R') {
					Pfad = "/dungeoncrawler/ruestung.PNG";
				} else if (Item4Type == 'J') {
					Pfad = ("/dungeoncrawler/lagerfeuer.PNG");
				} else if (Item4Type == 'R') {
		        	BuildLevel.lblCheckpoint.setText("Du hast eine Ruestung gefunden...");
		        	SavePointAnzeige = true;
		        	Player.suitofarmor = Player.suitofarmor+1;			        	
		        	BuildLevel.lblRuestungAnzeige.setVisible(true);
		        	Player.PlayerPower = Player.PlayerPower +5;
				}
			}
		
		return Pfad;
	}
	
	/*
	 * Shop Abfrage
	 */
	
	
	
	/*
	 * Abfrage ob der Player mit dem Gegner kollidiert ist
	 */
	
	public static void checkEnemyCollision(String args[]) {
		if ((Item1Type == 'S')&(spinne_alive == true)) {
			if (BuildLevel.lblPlayer.getX() >= 195) {
					MovementListener.moveDown = false;
					MovementListener.moveUp = false;
					hexe_alive = false;
					spinne_alive = false;
					drache_alive = false;
					BuildLevel.GameOver(5);
			}
		}
		if ((Item1Type == 'G')&(drache_alive == true)) {
			if (BuildLevel.lblPlayer.getX() >= 195) {
				if (BuildLevel.lblPlayer.getY() < 165) {
					MovementListener.moveDown = false;
					MovementListener.moveUp = false;
					hexe_alive = false;
					spinne_alive = false;
					drache_alive = false;
					BuildLevel.GameOver(5);
				}
			}
		}
		if ((Item1Type == 'W')&(hexe_alive == true)) {
			if (BuildLevel.lblPlayer.getX() >= 195) {
				if (BuildLevel.lblPlayer.getY() < 165) {
						MovementListener.moveDown = false;
						MovementListener.moveUp = false;
						hexe_alive = false;
						spinne_alive = false;
						drache_alive = false;
						BuildLevel.GameOver(5);
				}
			}
		}
	}

	
	
	private static int range(int i, int j) {
		int range = 0;
		/**
		 * Diese Methode ist ueberfluessig und kann geloescht werden.
		 */
		/*
		range = new int[j - i + 1];
	    for (int k = i; k <= j; k++) {
	        range[k - i] = k;
	    }
	    return range;
	    */
		return range;
	}

	public static int Item_Width_Height(int ItemNr) {
		/**
		 * Veraendert die groesse des Item-Labels, wenn es mit dem grossen Endgegner belegt wird.
		 */
		int Width_Height = 15;
		if (ItemNr == 1) {
			if ((Item1Type == 'W')|(Item1Type == 'G')|(Item1Type == 'S'));
			Width_Height = 30;
		} else {
			Width_Height = 15;
		}
		
		return Width_Height;
		
	}

}
