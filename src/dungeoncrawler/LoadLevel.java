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
	
	public static String getCurrent_LevelMap() {
		String Current_LevelMap = "PPPPPPPPPPWWWWWWWWWWPWWWWWWWWPWWPPPPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPPPPDPWWWWWWWWPPPPWWWWWWWPWWWWWWWWPWWPWWWWWWWPPPWWWWWWPWWPWWWWWWWWWPWWWWWWPWWPWWWWWWWWWPPPPPPPPWWPWWWWWWWWWPWWWWWWPWWPPPPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWDWWWWWWSWWSWWSWWWW";
		return Current_LevelMap;
	}
	public static String main(int current_level, int position) {
		String output = null;
		
		// ############################################
		// Hier fehlt die Datei-Import funktion! (Nils)
		// Levelparameter einzelnd eingelesen
		// ############################################
		
		
		String Current_LevelMap = "PPPPPPPPPPWWWWWWWWWWPWWWWWWWWPWWPPPPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPPPPDPWWWWWWWWPPPPWWWWWWWPWWWWWWWWPWWPWWWWWWWPPPWWWWWWPWWPWWWWWWWWWPWWWWWWPWWPWWWWWWWWWPPPPPPPPWWPWWWWWWWWWPWWWWWWPWWPPPPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWDWWWWWWSWWSWWSWWWW";
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
			output = "/dungeoncrawler/wall.PNG";			
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
