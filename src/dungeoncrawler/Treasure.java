package dungeoncrawler;

import dungeoncrawler.BuildLevel;

public class Treasure {
	
	
	/*
	 *  KLASSENBESCHREIBUNG:
	 *  Diese Klasse berechnet für das jeweilige Level, sofern
	 *  vorhanden die Position des Schatzes und führt eine Kollisionsabfrage 
	 *  mit der Playerfigur aus. Außerdem wird bei positivem Ergebnis die 
	 *  Punktzahl erhöht.
	 * 
	 */
	
	// POSITIONSBERECHNUNG DES SCHATZES:
	
	public static int buildTreasureX(){
		int PosX = 0;
		if (BuildLevel.Current_Level == 9) {
			PosX = 75;
		} else {
			PosX = 300;
		}
		BuildLevel.treasureX = PosX;
		return PosX;
		
	}
	public static int buildTreasureY(){
		int PosY = 0;
		if (BuildLevel.Current_Level == 9) {
			PosY = 45;
		} else {
			PosY = 15;
		}
		BuildLevel.treasureY = PosY;
		return PosY;
		
	}
	
	// KOLLISIONSABFRAGE SCHATZ:
	
	public static boolean check_treasure() {
			
		boolean get_treasure = false;
		
		if (BuildLevel.getCurrentPlayerPos(0) == BuildLevel.treasureX) {
			if (BuildLevel.getCurrentPlayerPos(1) == BuildLevel.treasureY) {
				BuildLevel.Current_Points = BuildLevel.Current_Points+100;
				/*
				
				*/
			}
		}
		
		/*
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
		
		*/
		
		return get_treasure;
	}

}
