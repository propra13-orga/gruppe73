package Network;

public class LoadLevelMulti {

	/**
	 * @param args
	 */
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
		
	}


