package dungeoncrawler;

import java.applet.Applet;
import java.applet.AudioClip;

import dungeoncrawler.BuildLevel;
import dungeoncrawler.Player;

public class Treasure {
	
	
	
	
	/**
	 *  KLASSENBESCHREIBUNG:
	 *  Diese Klasse berechnet f�r das jeweilige Level, sofern
	 *  vorhanden die Position des Schatzes und f�hrt eine Kollisionsabfrage 
	 *  mit der Playerfigur aus. Au�erdem wird bei positivem Ergebnis die 
	 *  Punktzahl erh�ht.
	 * 
	 */
	
	// POSITIONSBERECHNUNG DES SCHATZES:
	
	public static int buildTreasureX(){
		int PosX = 0;
		if (BuildLevel.got_treasure == false) {
			if (BuildLevel.Current_Level == 9) {
				PosX = 75;
			}
		} else {
			PosX = 300;
		}
		BuildLevel.treasureX = PosX;
		return PosX;
		
	}
	public static int buildTreasureY(){
		int PosY = 300;
		if (BuildLevel.got_treasure == false) {
			if (BuildLevel.Current_Level == 9) {
				PosY = 45;
			}
		} else {
			PosY = 300;
		}
		BuildLevel.treasureY = PosY;
		return PosY;
		
	}
	
	// KOLLISIONSABFRAGE SCHATZ:
	
	public static boolean check_treasure() {
			
		boolean get_treasure = false;
		
		if (BuildLevel.getCurrentPlayerPos(0) == BuildLevel.treasureX) {
			if (BuildLevel.getCurrentPlayerPos(1) == BuildLevel.treasureY) {
				if (BuildLevel.got_treasure == false) {
					Player.CurrentPoints = Player.CurrentPoints+500;
					
					BuildLevel.got_treasure = true;
				}
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
	
	public static void PlayMusic(String type) {
		
		
		if (type == "treasure"){
			
			PlaySound playGotTreasure = new PlaySound();
			playGotTreasure.playGotTreasure();
			
		} else if (type == "item"){
			
			PlaySound playGotItem = new PlaySound();
			playGotItem.playGotItem();
			
		} 
		
	}

}

class PlaySound {
	
	public AudioClip getcoin = Applet.newAudioClip(getClass().getResource("/Resources/getcoin.wav"));
	//public AudioClip arrow = Applet.newAudioClip(getClass().getResource("/Resources/--.wav"));
	
	public void playGotTreasure(){
		
		getcoin.play();
		
	}
	
	public AudioClip getitem = Applet.newAudioClip(getClass().getResource("/Resources/getaitem.wav"));
	public void playGotItem(){
	
		getitem.play();
		
		
/*public AudioClip getitem = Applet.newAudioClip(getClass().getResource("/Resources/getitem.wav"));
 * 
 * Treasure.PlayMusic("item");
 * item= pfeil, bogen, r�stung, leben, schwert, mana
 * 
 * Bei allen anderen Items soll dieses Ger�usch abgespielt werden
 * ich hab alles so gemacht wie vorgezeigt nur hat es nicht funktioniert bei mir.
 * ich denke mal ist ein kleiner fehler den du sofort erkennst aber ich tus nich
 * 
 * 
 * Bei den Waffen muss geguckt werden welche waffe grad AktuelleWaffe ist 
 * manaschuss 
 * schwert
 * pfeil
 */
		
		
	
	}
	
	
}
