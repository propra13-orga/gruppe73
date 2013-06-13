package dungeoncrawler;

import dungeoncrawler.BuildLevel;

import java.io.*;

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
	public static int counter = 0;
	public static String StringPosX = null;
	public static String StringPosY = null;
	private static LineNumberReader reader;
	private static BufferedReader auslesen;
	public static String getCurrent_LevelMap() {
		return Current_LevelMap;
	}
	
	
	public static int getPlayerPosStartY(int aktuelles_level) {
		
		StringPosY = Current_LevelMap.substring(303, 306);
		PosStartY = Integer.parseInt(StringPosY);
		
		return PosStartY;
		
	}
	
	public static int getPlayerPosStartX(int aktuelles_level) {
		
		StringPosX = Current_LevelMap.substring(300, 303);
		PosStartX = Integer.parseInt(StringPosX);
		return PosStartX;
		
	}
	
	
	public static String LadeDatei() throws IOException{
			String map = null;
			if ((BuildLevel.Current_Level != BuildLevel.level_load)|(BuildLevel.first_load = true)) {
			reader = new LineNumberReader (new FileReader("/dungeoncrawler/leveldata.txt") );
			   for(int i = 0; i<BuildLevel.Current_Level-1; i++)
			      reader.readLine();
			   map = reader.readLine();
			   
			}
			return map;
				
		   
		}
	
	
	public static void DateiLesen (String args[]) {
		try {
			auslesen = new BufferedReader(new FileReader("dungeoncrawler/leveldata.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ((BuildLevel.Current_Level % 2) == 0) {
			Current_LevelMap = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW15012085075";
		} else {
			try {
				Current_LevelMap = auslesen.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String main(int current_level, int position) {
		String output = "/dungeoncrawler/wall.PNG";
		
		

		
		// ############################################
		// Hier fehlt die Datei-Import funktion! (Nils)
		// Levelparameter einzelnd eingelesen
		// ############################################
		
			
				
				
			
				
		
			if (BuildLevel.Current_Level == 1) {
				Current_LevelMap = "PPPPPPPPPPWWWWWWWWWWPWWWWWWWWPWWPPPPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPWWWWPWWWWWWWWPWWPWWPPPPDPWWWWWWWWPPPPWWWWWWWPWWWWWWWWPWWPWWWWWWWPPPWWWWWWPWWPWWWWWWWWWPWWWWWWPWWPWWWWWWWWWPPPPPPPPWWPWWWWWWWWWPWWWWWWPWWPPPPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWPWWWWWWPWWPWWPWWWWWWDWWWWWWSWWSWWSWWWW030225285075";
			} else if ((current_level % 2) == 0) {
				Current_LevelMap = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW15012085075";
			} else if (current_level == 3) {
				Current_LevelMap = "WWWPPPPPPPWWWWWPPPPWWWWPWWWWWPWWWWWPWWPWWWWPWWWWWPWWWWWPWWPWWWWPWWWWWPWWWWWPWWPWDPPPWWWWWPWWWWWPWWPWWWWPWWWWWPPPPPPPWWPWWWWPPPPPPPWWWWWWWWPWWWWPWWWWWPWWWWWWWWPWSPPPWWWWWPPPPPPPWWPWWWWPPPPPPPWWWWWPWWPWWWWPWWWWWPWWWWWPWWPWWWWPWWWWWPWWWWWPWWPWWWWPWWWWWPWWWWWPWWPWWWWPWWWWWPWWWWWPWWPWSPPPWWWWWDWWWWWWWWWW000075285075";	
			} else if (current_level == 5) {
				Current_LevelMap = "WSWWWSWWWDWWWWSWWWWWWPWWWPWWWPWWWWPWWWWWWPPPPPPPPPWWWWPPPPPWWPWWWPWWWWWWWWPWWWPWSPWWWPWWWWWWWWPWWWPWWPWWWPWWWWWWWWPWWWPWWPPPPPPPPPPPPPPWWWPWWWWWWPWWWWWWWWWWWWPWWWWWWSWWWWWWWWWWWWPWWWWWWWWWWWWWWWWWSPPSWWWWWWWWWWWWWWWWWWPWDPPPPWWWPPPPPPPWWWPWWWWWPWWWPWWWWWPWWWPWWWWWPWWWPWWWWWPWWWPWWWWWPPPPPWWWWWPPPPPW000180285075";	
			} else if (current_level == 7) {
				Current_LevelMap = "WWWWWWWWWWWWWWWWWWWWWPPPPPPPPPPPPPPPPWWWWPWWWWWWWWWWWWWWPWWWWPPPPPPPPPPPPPPWPWWWWWWWWWWWWWWWWWPWPWWWWPPPPPPPPPPWWWPWPWWWWPWWWWWWWWPWWWPWPWWWWPPPPPPPSWPWWWPWPWWWWPWWWWWWWWPPSWPWPPPSWPWWWWWWWWPWWWPWPWWWSPPPPPPWWWPWWWPWPWWWWPWWWWPWWWPPPPPWPPPDWPPPWWPWWWWWWWPWWWWWWPWPWWPWWWWWWWPPPPPSWSWSWWDWWWWWWWWWWWWW285180285075";	
			} else if (current_level == 9) {
				Current_LevelMap = "SPPPPPPWSWWWWWWWWWWWSPSSSSPPPWWWWPPPPPPWSPPPPPWWPPPSSSPSSSPSSPSSSSWWWSPPPSPPPSPSWPWWWWDWWWWWPSSSPSPSSPPWWPPPWSSWPSPPPSPSWSPWWPPPWSPPPSPSSSPSWPPWWPSSWSPWWSPPPSPSWPSWSPPPPPPWWSSSPSPPWPPWSSSSSSWWPPPPPSSPWSPSSPPPPPPPPWWWWWSPWPPWWPWWWWWWSSSWWWPPWPWWWPPPPPPPPDSWWWPSWPWWWSWWWWWWSSSWWWPSWPPPPPPPPPPPPPPPPPPP195195285075";	
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
