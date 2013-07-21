package Multiplayergame;

import dungeoncrawler.BuildLevel;


public class Gegner {
	/**
	 * Gegner defniert alle Eigenschaften der Gegner.
	 * Dabei geht es um die Waffen, den Effekt, deren Lebensenenergie etc.
	 */
	
	public static boolean moveUp = true;
	public static boolean PlayerFired = false;
	public static int PlayerFire1StartX = 0;
	public static boolean PlayerFire1Active = false;
	
	public static int EnemyEnergy = 2;
/**
 * Fallen Abfrage
 */
	public static void trap_collision() {
		String Current_LevelMap = LoadLevel.Current_LevelMap;
		if (Current_LevelMap.charAt(CollisionControl.PlyPosUmrechnen()) == 'S' | Current_LevelMap.charAt(CollisionControl.PlyPosUmrechnen()) == 'N'){
			BuildLevel.GameOver(5);
		}
	}
	
	/**
	 * Methode die die aktuelle Waffe abfragt und dann der Menge an Items eins abzieht
	 * 
	 */
	
	public static void fire(String args[]) {
		
		/**
		 * SCHWERT:
		 */
		if (Player.AktuelleWaffe == 'C') {
			System.out.println("Schwert feuer");
			if (!PlayerFired) {
				PlayerFired = true;
				Treasure.PlayMusic("schwert");
				BuildLevel.refreshInventar(null);
				PlayerFire1StartX = 30+BuildLevel.lblPlayer.getX();
				BuildLevel.lblPlayerFire1.setBounds(BuildLevel.lblPlayer.getX(), BuildLevel.lblPlayer.getY(), 15, 10);
			}
			if (PlayerFired) {
				BuildLevel.lblPlayerFire1.setBounds((BuildLevel.lblPlayerFire1.getX()+15), (BuildLevel.lblPlayerFire1.getY()), 15, 10);
			}
			if (BuildLevel.lblPlayerFire1.getX() > (PlayerFire1StartX)) {
				PlayerFired = false;
				PlayerFire1Active = false;
				BuildLevel.lblPlayerFire1.setBounds(400, 400, 15, 10);
			}
			
			if ((BuildLevel.lblPlayerFire1.getX() >= BuildLevel.lblItem1.getX())&(BuildLevel.lblPlayerFire1.getX() <= (BuildLevel.lblItem1.getX()+30))) {
				if ((BuildLevel.lblPlayerFire1.getY() >= BuildLevel.lblItem1.getY())&(BuildLevel.lblPlayerFire1.getY() <= (BuildLevel.lblItem1.getY()+30))) {
					if (LevelControl.hexe_alive == true){
						EnemyEnergy = EnemyEnergy-3;
					} else if (LevelControl.drache_alive == true){
						EnemyEnergy = EnemyEnergy-3;
					} else if (LevelControl.spinne_alive == true){
						EnemyEnergy = EnemyEnergy-1;
					}
				
				}
			}
			
			if (EnemyEnergy == 0) {
				MovementListener.moveDown = false;
				MovementListener.moveUp = false;
				LevelControl.hexe_alive = false;
				LevelControl.drache_alive = false;
				LevelControl.spinne_alive = false;
				BuildLevel.lblEnemyFire.setBounds(300, 400, 15, 10);
				BuildLevel.lblPlayerFire1.setBounds(300, 400, 15, 10);
				BuildLevel.lblCheckpoint.setText("Gegner getoetet...");
	        	LevelControl.SavePointAnzeige = true;
			}
		}
		// BOGEN:
		
		else if (Player.AktuelleWaffe == 'A') {
			if (Player.Arrow > 0) {
				if (!PlayerFired) {
					Treasure.PlayMusic("arrow");
					PlayerFired = true;
					Player.Arrow = Player.Arrow-1;
					BuildLevel.refreshInventar(null);
					PlayerFire1StartX = 135+BuildLevel.lblPlayer.getX();
					BuildLevel.lblPlayerFire1.setBounds(BuildLevel.lblPlayer.getX(), BuildLevel.lblPlayer.getY(), 15, 10);
				}
			}
				if (PlayerFired) {
					BuildLevel.lblPlayerFire1.setBounds((BuildLevel.lblPlayerFire1.getX()+15), (BuildLevel.lblPlayerFire1.getY()), 15, 10);
				}
				if (BuildLevel.lblPlayerFire1.getX() >= (PlayerFire1StartX)) {
					PlayerFired = false;
					PlayerFire1Active = false;
					BuildLevel.lblPlayerFire1.setBounds(400, 400, 15, 10);
				}
				
				if ((BuildLevel.lblPlayerFire1.getX() >= BuildLevel.lblItem1.getX())&(BuildLevel.lblPlayerFire1.getX() <= (BuildLevel.lblItem1.getX()+30))) {
					if ((BuildLevel.lblPlayerFire1.getY() >= BuildLevel.lblItem1.getY())&(BuildLevel.lblPlayerFire1.getY() <= (BuildLevel.lblItem1.getY()+30))) {
						if (LevelControl.hexe_alive == true){
							EnemyEnergy = EnemyEnergy-1;
						} else if (LevelControl.drache_alive == true){
							//EnemyEnergy = EnemyEnergy;
							/*
							 * nix ändern an der EE
							 */
						} else if (LevelControl.spinne_alive == true) {
							EnemyEnergy = EnemyEnergy-1;
						}
						
					
					}
				}
				
				if (EnemyEnergy == 0) {
					MovementListener.moveDown = false;
					MovementListener.moveUp = false;
					LevelControl.hexe_alive = false;
					LevelControl.drache_alive = false;
					LevelControl.spinne_alive = false;
					BuildLevel.lblEnemyFire.setBounds(300, 400, 15, 10);
					BuildLevel.lblPlayerFire1.setBounds(300, 400, 15, 10);
					BuildLevel.lblCheckpoint.setText("Gegner getoetet...");
		        	LevelControl.SavePointAnzeige = true;
				}
			
			
		// MANA:
			
		} else if (Player.AktuelleWaffe == 'M') {
			if (Player.Manadrinks > 0) {
				if (!PlayerFired) {
					Treasure.PlayMusic("mana");
					Player.Manadrinks = Player.Manadrinks-1;
					BuildLevel.refreshInventar(null);
					PlayerFired = true;
					PlayerFire1StartX = 105+BuildLevel.lblPlayer.getX();
					BuildLevel.lblPlayerFire1.setBounds(BuildLevel.lblPlayer.getX(), BuildLevel.lblPlayer.getY(), 15, 10);
				}
			}
				if (PlayerFired) {
					BuildLevel.lblPlayerFire1.setBounds((BuildLevel.lblPlayerFire1.getX()+15), (BuildLevel.lblPlayerFire1.getY()), 15, 10);
				}
				if (BuildLevel.lblPlayerFire1.getX() >= (PlayerFire1StartX)) {
					PlayerFired = false;
					PlayerFire1Active = false;
					BuildLevel.lblPlayerFire1.setBounds(400, 400, 15, 10);
				}
				
				if ((BuildLevel.lblPlayerFire1.getX() >= BuildLevel.lblItem1.getX())&(BuildLevel.lblPlayerFire1.getX() <= (BuildLevel.lblItem1.getX()+30))) {
					if ((BuildLevel.lblPlayerFire1.getY() >= BuildLevel.lblItem1.getY())&(BuildLevel.lblPlayerFire1.getY() <= (BuildLevel.lblItem1.getY()+30))) {
						if (LevelControl.hexe_alive == true) {
							
							/**
							 * EnemyEnergy bleibt hier unveraendert
							 */
						} else if (LevelControl.drache_alive == true) {
							EnemyEnergy = EnemyEnergy-2;
						} else if (LevelControl.spinne_alive == true) {
							EnemyEnergy = EnemyEnergy-2;
					
					}
				}
				
				if (EnemyEnergy == 0) {
					MovementListener.moveDown = false;
					MovementListener.moveUp = false;
					LevelControl.hexe_alive = false;
					LevelControl.drache_alive = false;
					LevelControl.spinne_alive = false;
					BuildLevel.lblEnemyFire.setBounds(300, 400, 15, 10);
					BuildLevel.lblPlayerFire1.setBounds(300, 400, 15, 10);
					BuildLevel.lblCheckpoint.setText("Gegner getoetet...");
		        	LevelControl.SavePointAnzeige = true;
				}
			
			
		// SCHWERT:
			
		} 
		
		
		
		
	}
	
	/*
	public static void EndgegnerMovement() {
		
		
		if (moveUp == true) {
			BuildLevel.lblItem1.setBounds(BuildLevel.lblItem1.getX(), BuildLevel.lblItem2.getY()-1, 30, 30);
			if ((LevelControl.Item1Y-30) == BuildLevel.lblItem1.getY()) {
				moveUp = false;
			}
		}
		if (moveUp == false) {
			BuildLevel.lblItem1.setBounds(BuildLevel.lblItem1.getX(), BuildLevel.lblItem2.getY()+1, 30, 30);
			if ((LevelControl.Item1Y+30) == BuildLevel.lblItem1.getY()) {
				moveUp = true;
			}
		}
		BuildLevel.FeldNeuzeichnen(null);
	}
	*/
	}

}
