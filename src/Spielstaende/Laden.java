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
	public static int pfeil;
	
	public static String Bogen;
	public static int bogen;
	
	public static String Punkte;
	public static int punkte;
	
	public static String Leben;
	public static int leben;
	
	public static String Mana;
	public static int mana;
	
	public static String Medi;
	public static int medi;
	
	public static String Power;
	public static int intpower;
	
	public static String Schwert;
	public static int schwert;

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
				auslesen = new BufferedReader(new FileReader(FilePath+"/src/Spielstaende/Spielstand/"+FileName));
				gespeichertesLevel = auslesen.readLine();
				intgespeichertesLevel = Integer.parseInt(gespeichertesLevel);
				System.out.println(gespeichertesLevel);
				
				PlayerPosX = auslesen.readLine();
				intPlayerPosX = Integer.parseInt(PlayerPosX);
				System.out.println(PlayerPosX);
				
				PlayerPosY = auslesen.readLine();
				intPlayerPosY = Integer.parseInt(PlayerPosY);
				System.out.println(PlayerPosY);
				
				Waffe = auslesen.readLine();
				waffe = Waffe.charAt(0);
				System.out.println(waffe);
				
				Pfeil = auslesen.readLine();
				pfeil = Integer.parseInt(Pfeil);
				System.out.println(Pfeil);
				
				Bogen = auslesen.readLine();
				bogen = Integer.parseInt(Bogen);
				System.out.println(Bogen);
				
				Punkte = auslesen.readLine();
				punkte = Integer.parseInt(Punkte);
				System.out.println(Punkte);
				
				Leben = auslesen.readLine();
				leben = Integer.parseInt(Leben);
				System.out.println(Leben);
				
				Mana = auslesen.readLine();
				mana = Integer.parseInt(Mana);
				System.out.println(Mana);
				
				Medi = auslesen.readLine();
				medi = Integer.parseInt(Medi);
				System.out.println(Medi);
				
				Power = auslesen.readLine();
				intpower = Integer.parseInt(Leben);
				System.out.println(Leben);
				
				Schwert = auslesen.readLine();
				schwert = Integer.parseInt(Schwert);
				System.out.println(Schwert);
				
				
				} 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Datei nicht gefunden");
			}
			
	}

}
