package Spielstaende;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;


import dungeoncrawler.BuildLevel;
import dungeoncrawler.LevelControl;
import dungeoncrawler.MovementListener;

public class Laden {
	
	private static BufferedReader auslesen;
	
	public static String gespeichertesLevel;
	public static int intgespeichertesLevel;
	
	public static String PlayerPosX;
	public static int intPlayerPosX;
	
	public static String PlayerPosY;
	public static int intPlayerPosY;
	
	public static String Waffe;
	public static char waffe;
	
	public static String Pfeil;
	public static char pfeil;
	
	public static String Bogen;
	public static char bogen;
	
	public static String Punkte;
	public static char punkte;
	
	public static String Leben;
	public static char leben;
	
	public static String Mana;
	public static char mana;
	
	public static String Medi;
	public static char medi;
	
	public static String Power;
	public static int intpower;
	
	public static String Schwert;
	public static char schwert;

	/**
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) /**throws IOException**/ {
		// TODO Auto-generated method stub
		
			String FileName = JOptionPane.showInputDialog(null, "Bitte gib den Namen der Datei ein");
			FileName = FileName + ".TXT";
			String FilePath = System.getProperty("user.dir");
			
			try {
				if(MovementListener.gespeichert == true){
				auslesen = new BufferedReader(new FileReader(FilePath+"src/dungeoncrawler/"+FileName));
				gespeichertesLevel = auslesen.readLine();
				intgespeichertesLevel = Integer.parseInt(gespeichertesLevel);
				
				PlayerPosX = auslesen.readLine();
				intPlayerPosX = Integer.parseInt(PlayerPosX);
				
				PlayerPosY = auslesen.readLine();
				intPlayerPosY = Integer.parseInt(PlayerPosY);
				
				Waffe = auslesen.readLine();
				waffe = Waffe.charAt(0);
				
				Pfeil = auslesen.readLine();
				pfeil = Pfeil.charAt(0);
				
				Bogen = auslesen.readLine();
				bogen = Bogen.charAt(0);
				
				Punkte = auslesen.readLine();
				punkte = Punkte.charAt(0);
				
				Leben = auslesen.readLine();
				leben = Leben.charAt(0);
				
				Mana = auslesen.readLine();
				mana = Mana.charAt(0);
				
				Medi = auslesen.readLine();
				medi = Medi.charAt(0);
				
				Power = auslesen.readLine();
				intpower = Integer.parseInt(Leben);
				
				Schwert = auslesen.readLine();
				schwert = Schwert.charAt(0);
				} 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Datei nicht gefunden");
			}
			
	}

}
