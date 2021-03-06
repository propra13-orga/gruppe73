package dungeoncrawler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DateiLaden {
	/**
	 * Dateiladen kann aus einer TextDatei die in einen String "umgewandelt" wird
	 * ein Level laden.
	 * Die leveldata.txt besteht pro Raum aus einem String. Der Reader lie�t die R�ume zeilenweise aus.
	 */
	private static BufferedReader auslesen;
	public static int q = 0;

	public static String LeseData (int current_level) /*throws IOException*/{
		String ausw = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW150120285075X000000X000000X000000X000000??";
		
		try {
			if ((current_level % 2) != 0) {
				
				String FileName = ("/src/dungeoncrawler/"+Hauptmenu.DateiLadenPfad);
				String FilePath = System.getProperty("user.dir");
				System.out.println(FilePath+FileName);
				auslesen = new BufferedReader(new FileReader(FilePath+FileName));
				
				q = q+1;
				System.out.println("Ich lade die Datei neu! Zum "+q+"ten Mal");

				
				int x = 1;
				if (current_level == 1) {
					// do_nothing
				} else {
					while(x < (current_level)) {
						ausw = auslesen.readLine();
						x = x+1;
					}
				}
				ausw = auslesen.readLine();
			} else if ((current_level % 2) == 0) {
				ausw = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW150120285075X000000X000000X000000X000000??";
			}
		} catch (IOException ex) { 
			System.out.println("Datei nicht gefunden!");
			ausw = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW150120285075X000000X000000X000000X000000??";
		}
		 
		return ausw;
		
		
	}
}