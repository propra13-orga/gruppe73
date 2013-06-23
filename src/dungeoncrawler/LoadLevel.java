package dungeoncrawler;

import dungeoncrawler.LevelControl;

// Diese Klasse laedt die Level aus einer Datei und gibt die ausgelesenen
// Informationen an die Labels der BuildLevel.java weiter.



public class LoadLevel {
	
	public static String Current_LevelMap = null;
	
	public static void Export_to_LevelControl(String args[]) {
		
		LevelControl.StartDoorX = Integer.parseInt(Current_LevelMap.substring(300, 303));
		LevelControl.StartDoorY = Integer.parseInt(Current_LevelMap.substring(303, 306));
		
		LevelControl.FinishDoorX = Integer.parseInt(Current_LevelMap.substring(306, 309));
		LevelControl.FinishDoorY = Integer.parseInt(Current_LevelMap.substring(309, 312));
		
		LevelControl.Current_LevelAnzeige = Current_LevelMap.charAt(340);
		LevelControl.Current_SubLevelAnzeige = Current_LevelMap.charAt(341);
		
		LevelControl.Item1Type = Current_LevelMap.charAt(312);
		LevelControl.Item2Type = Current_LevelMap.charAt(319);
		LevelControl.Item3Type = Current_LevelMap.charAt(326);
		LevelControl.Item4Type = Current_LevelMap.charAt(333);
		
		LevelControl.Item1X = Integer.parseInt(Current_LevelMap.substring(313, 316));
		LevelControl.Item2X = Integer.parseInt(Current_LevelMap.substring(320, 323));
		LevelControl.Item3X = Integer.parseInt(Current_LevelMap.substring(327, 330));
		LevelControl.Item4X = Integer.parseInt(Current_LevelMap.substring(334, 337));
		
		LevelControl.Item1Y = Integer.parseInt(Current_LevelMap.substring(316, 319));
		LevelControl.Item2Y = Integer.parseInt(Current_LevelMap.substring(323, 326));
		LevelControl.Item3Y = Integer.parseInt(Current_LevelMap.substring(330, 333));
		LevelControl.Item4Y = Integer.parseInt(Current_LevelMap.substring(337, 340));
		
		
		
	}

	public static String main(int current_level, int position) {
		String output = "/dungeoncrawler/wall.PNG";
			
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
			
			String Strr = "r";
			char[] Char = Strr.toCharArray();
			
			String StrR = "R";
			char[] ChaR = StrR.toCharArray();
			
			String StrG = "G";
			char[] ChaG = StrG.toCharArray();
			
			String Strg = "g";
			char[] Chag = Strg.toCharArray();
			
			String StrH = "H";
			char[] ChaH = StrH.toCharArray();
			
			String Strh = "h";
			char[] Chah = Strh.toCharArray();
			
			String StrN = "N";
			char[] ChaN = StrN.toCharArray();
			
			String StrM = "M";
			char[] ChaM = StrM.toCharArray();
			
			String StrO = "O";
			char[] ChaO = StrO.toCharArray();
			
			String Stro = "o";
			char[] Chao = Stro.toCharArray();
			
			String StrU = "U";
			char[] ChaU = StrU.toCharArray();
			
			String StrI = "I";
			char[] ChaI = StrI.toCharArray();
			
			
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
			
			else if (SingleChar[position] == Char[0]) {
				output = "/dungeoncrawler/shop1.PNG";
			}
			
			else if (SingleChar[position] == ChaR[0]) {
				output = "/dungeoncrawler/shop2.PNG";
			}
			
			else if (SingleChar[position] == ChaG[0]) {
				output = "/dungeoncrawler/Seeganz.PNG";
			}
			
			else if (SingleChar[position] == Chag[0]) {
				output = "/dungeoncrawler/Seehalb.PNG";
			}
			
			else if (SingleChar[position] == ChaH[0]) {
				output = "/dungeoncrawler/Seehalb2.PNG";
			}
			
			else if (SingleChar[position] == Chah[0]) {
				output = "/dungeoncrawler/Seehalb3.PNG";
			}
			
			else if (SingleChar[position] == ChaN[0]) {
				output = "/dungeoncrawler/Busch.PNG";
			}
			
			else if (SingleChar[position] == ChaM[0]) {
				output = "/dungeoncrawler/platz.PNG";
			}
			
			else if (SingleChar[position] == ChaO[0]) {
				output = "/dungeoncrawler/Burgmauer.PNG";
			}
			
			else if (SingleChar[position] == Chao[0]) {
				output = "/dungeoncrawler/Burgfenster.PNG";
			}
			
			else if (SingleChar[position] == ChaU[0]) {
				output = "/dungeoncrawler/Zinnen.PNG";
			}
			
			else if (SingleChar[position] == ChaI[0]) {
				output = "/dungeoncrawler/NPC.PNG";
			}
			
		return output;
	}
	
	public static String EnemyFire(String args[]) {
		String Pfad = "/dungeoncrawler/EnemyFire.PNG";
		if (LevelControl.Item1Type == 'S') {
			Pfad = "/dungeoncrawler/spidernet.PNG";
		}
		return Pfad;
	}
}
