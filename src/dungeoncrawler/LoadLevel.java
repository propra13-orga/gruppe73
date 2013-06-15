package dungeoncrawler;

import dungeoncrawler.BuildLevel;
import dungeoncrawler.DateiLaden;
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
	public static String Current_LevelMapRestart = null;
	public static int PosStartX;
	public static int PosStartY;
	public static int DoorX;
	public static int DoorY;
	public static int counter = 0;
	public static String StringPosX = null;
	public static String StringPosY = null;
	private static LineNumberReader reader;
	public static String getCurrent_LevelMap() {
		return Current_LevelMap;
	}
	
	
	public static int getPlayerPosStartY(int aktuelles_level) {
		
		Current_LevelMapRestart = DateiLaden.LeseData(BuildLevel.Current_Level);
		StringPosY = Current_LevelMap.substring(303, 306);
		PosStartY = Integer.parseInt(StringPosY);
		
		return PosStartY;
		
	}
	
	public static int getPlayerPosStartX(int aktuelles_level) {
		
		Current_LevelMapRestart = DateiLaden.LeseData(BuildLevel.Current_Level);
		StringPosX = Current_LevelMapRestart.substring(300, 303);
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
	
	
	
	
	public static String main(int current_level, int position) {
		String output = "/dungeoncrawler/wall.PNG";
		
		

		
		// ############################################
		// Hier fehlt die Datei-Import funktion! (Nils)
		// Levelparameter einzelnd eingelesen
		// ############################################
		
			
		
			Current_LevelMap = DateiLaden.LeseData(BuildLevel.Current_Level);	
			
				
			
			/*	
		
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
			*/
			
			char[] SingleChar = Current_LevelMap.toCharArray();
			
			String StrP = "P";
			char[] ChaP = StrP.toCharArray();
			
			String Strp = "p";
			char[] Chap = Strp.toCharArray();
			
			String StrW = "W";
			char[] ChaW = StrW.toCharArray();
			
			String StrD = "D";
			char[] ChaD = StrD.toCharArray();
			
			String StrS = "S";
			char[] ChaS = StrS.toCharArray();
			
			String StrB = "B";
			char[] ChaB = StrB.toCharArray();
			
			String Strb = "b";
			char[] Chab = Strb.toCharArray();
			
			String StrT = "T";
			char[] ChaT = StrT.toCharArray();
			
			String StrF = "F";
			char[] ChaF = StrF.toCharArray();
			
			String StrA = "A";
			char[] ChaA = StrA.toCharArray();
			
			String StrC = "C";
			char[] ChaC = StrC.toCharArray();
			
			String StrE = "E";
			char[] ChaE = StrE.toCharArray();
			
			String StrK ="K";
			char[] ChaK = StrK.toCharArray();
			
			String StrQ = " ";
			char[] ChaQ = StrQ.toCharArray();
			
			String StrZ = "Z";
			char[] ChaZ = StrZ.toCharArray();
			
			String StrJ = "J";
			char[] ChaJ = StrJ.toCharArray();
			
			String StrX = "X";
			char[] ChaX = StrX.toCharArray();
			
			
			
			if (SingleChar[position] == ChaP[0]) {
				output = "/dungeoncrawler/path.PNG";			
			}
			
			if (SingleChar[position] == Chap[0]) {
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
			
			else if (SingleChar[position] == ChaB[0]) {
				output = "/dungeoncrawler/baum1.PNG";
			}	
			
			else if (SingleChar[position] == Chab[0]){
				output ="/dungeoncrawler/baum2.PNG";
			}
			
			else if (SingleChar[position] == ChaT[0]) {
				output = "/dungeoncrawler/tuer.PNG";
			}
			
			else if (SingleChar[position] == ChaF[0]) {
				output = "/dungeoncrawler/fenster.PNG";
			}	
			 
			else if (SingleChar[position] == ChaA[0]) {
				output = "/dungeoncrawler/dach1.PNG";
			}
			
			else if (SingleChar[position] == ChaC[0]) {
				output = "/dungeoncrawler/dach2.PNG";
			}
			
			else if (SingleChar[position] == ChaE[0]) {
				output = "/dungeoncrawler/dach3.PNG";
			}
			
			else if (SingleChar[position] == ChaK[0]) {
				output = "/dungeoncrawler/dachkomplett.PNG";
			}
			
			else if (SingleChar[position] == ChaQ[0]) {
				output = "/dungeoncrawler/freiflaeche.PNG";
			}
			
			else if (SingleChar[position] == ChaZ[0]) {
				output = "/dungeoncrawler/zaun1.PNG";
			}
			
			else if (SingleChar[position] == ChaJ[0]) {
				output = "/dungeoncrawler/zaun2.PNG";
			}
			
			else if (SingleChar[position] == ChaX[0]) {
				output = "/dungeoncrawler/wegweiser.PNG";
			}
			
		return output;
		// TODO Auto-generated method stub
		

	}

}
