package Spielstaende;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import dungeoncrawler.BuildLevel;
import dungeoncrawler.MovementListener;
import dungeoncrawler.Player;

public class Speichern {
	
	
	public static final String Dateiname = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String Dateiname = JOptionPane.showInputDialog(null, "Bitte gib deinen Namen ein");
		Dateiname = Dateiname + ".TXT";
		System.out.println(Dateiname);
	
		try{
			String FilePath = System.getProperty("user.dir");
			@SuppressWarnings("resource")
			PrintWriter pWriter = new PrintWriter(new FileWriter(FilePath+"/src/dungeoncrawler/"+Dateiname));
			pWriter.println(BuildLevel.Current_Level+"\n" + BuildLevel.getCurrentPlayerPos(0)+"\n" + BuildLevel.getCurrentPlayerPos(1) +"\n" + Player.AktuelleWaffe + "\n" + Player.Arrow + "\n" + Player.Bow + "\n" + Player.CurrentPoints + "\n" + Player.Lives + "\n" + Player.Manadrinks + "\n" + Player.Medikit + "\n" + Player.PlayerPower + "\n" + Player.PlayerSword + "\n");
			pWriter.flush();
			JOptionPane.showMessageDialog(null , "Datei wurde gespeichert.", "Datei wurde gespeichert!", JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException ioe){
			JOptionPane.showMessageDialog(null, "Datei konnte nicht gespeichert werden.", "Errror", JOptionPane.ERROR_MESSAGE, null);

			
		
		
	}
	


}
}