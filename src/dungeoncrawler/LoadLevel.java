package dungeoncrawler;

// Diese Klasse laedt die Level aus einer Datei und gibt die ausgelesenen
// Informationen an die Labels der BuildLevel.java weiter.

public class LoadLevel {


	/**
	 * @param args
	 * @return 
	 * @return 
	 * @return 
	 */
	public static String Current_LevelMap = null;
	public static int PosStartX;
	public static int PosStartY;
	public static int DoorX;
	public static int DoorY;
	
	public static String getCurrent_LevelMap() {
		
		return Current_LevelMap;
	}
	
	
	
	public static int getPlayerPosStartX(int aktuelles_level) {
		/*
		 * String StringPosX = null;
		 * StringPosX = Current_LevelMap.substring(299, 3);
		 * PosStartX = Integer.parseInt(StringPosX);
		 */
		if (aktuelles_level == 1) {
			PosStartX = 30;
		}
		return PosStartX;	
	}
	
	public static int getPlayerPosStartY(int aktuelles_level) {
		/*
		 * String StringPosY = null;
		 * StringPosY = Current_LevelMap.substring(302, 3);
		 * PosStartY = Integer.parseInt(StringPosY);
		 */
		if (aktuelles_level == 1) {
			PosStartY = 225;
		}
		return PosStartY;	
	}
	
	
	
	public static String main(int current_level, int position) {
		String output = null;

		
		// ############################################
		// Hier fehlt die Datei-Import funktion! (Nils)
		// Levelparameter einzelnd eingelesen
		// ############################################
		
		if (BuildLevel.Current_Level == 1) {
			Current_LevelMap = "PPPPPPPPPPWWWWWWWWWWPWWWWWWWWPWWPPPPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPPPPDPWWWWWWWWPPPPWWWWWWWPWWWWWWWWPWWPWWWWWWWPPPWWWWWWPWWPWWWWWWWWWPWWWWWWPWWPWWWWWWWWWPPPPPPPPWWPWWWWWWWWWPWWWWWWPWWPPPPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWDWWWWWWSWWSWWSWWWW225030285075";
		}
		else if (current_level == 2) {
			Current_LevelMap = "PPPPPPPPPPWWWWWWWWWWPWWWWWWWWPWWPPPPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPPPPDPWWWWWWWWPPPPWWWWWWWPWWWWWWWWPWWPWWWWWWWPPPWWWWWWPWWPWWWWWWWWWPWWWWWWPWWPWWWWWWWWWPPPPPPPPWWPWWWWWWWWWPWWWWWWPWWPPPPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWDWWWWWWSWWSWWSWWWW225030285075";
		}
		else if (BuildLevel.Current_Level == 3) {
			
		}
		
		char[] SingleChar = Current_LevelMap.toCharArray();
		
		String StrP = "P";
		char[] ChaP = StrP.toCharArray();
		
		String StrW = "W";
		char[] ChaW = StrW.toCharArray();
		
		String StrD = "D";
		char[] ChaD = StrD.toCharArray();
		
		String StrS = "S";
		char[] ChaS = StrS.toCharArray();
		
		if (SingleChar[position] == ChaP[0]) {
			output = "/dungeoncrawler/path.PNG";			
		}
		
		else if (SingleChar[position] == ChaS[0]) {
			output = "/dungeoncrawler/falle.PNG";			
		}
		
		else if (SingleChar[position] == ChaW[0]) {
			output = "/dungeoncrawler/wall.PNG";			
		}
		
		else if (SingleChar[position] == ChaD[0]) {
			output = "/dungeoncrawler/door.PNG";			
		}
		return output;
		// TODO Auto-generated method stub
		

	}

}
