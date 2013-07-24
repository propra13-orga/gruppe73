package dungeoncrawler;

/***********
 * Klasse die die Eigenschaften des Players definiert.
 * 
 * 
 *
 */

public class Player {
	
	// PLAYER-INVENTAR:
	// ================
	
	public static int PlayerSword = 0;		// Anzahl der Schwerter, die der Player besitzt
	public static int Medikit = 0;			//  ''    ''  Medikits, ''
	public static int CurrentPoints = 1800;	//Anzahl der Punkte - wird beim Gewinn des Schatzes o.ä hoch gesetzt
	public static int Lives = 1;			//Anzahl Leben
	public static int Manadrinks = 0;		// " Manadrinks (ermöglichen das Zaubern)
	public static int Bow = 0;				// " Bögen
	public static int Arrow = 0;			// " Pfeile
	public static int suitofarmor = 0;  	// " Rüstungen
	public static char AktuelleWaffe = 'N'; // 'A': Bogen, 'M': Mana, 'C': Schwert, 'N': None
	
	// SHOP PREISE:
	// ============
	
	public static int priceManadrinks = 100;
	public static int priceMedikit = 350; 
	public static int priceSword = 200;
	public static int priceBow = 200;
	public static int priceArrow = 100; 	// 100 Taler pro Stück!
	public static int pricesuitofarmor = 600;
	
	// PLAYER-POWER:
	
	/*
	 *  Zustände:
	 *  0:	tot
	 *  1:	red
	 *  2: 	yellow2
	 *  3:	yellow1
	 *  4: 	green
	 */
	
	public static int PlayerPower = 4;
	
	public static void WaffeWechseln(String args[]) {
		if (AktuelleWaffe == 'M') {
			if (PlayerSword > 0) {
				AktuelleWaffe = 'C';
			} else if (Bow > 0) {
				AktuelleWaffe = 'A';
			} else {
				AktuelleWaffe = 'M';
			}
			
	
		} else if (AktuelleWaffe == 'A') {
			if (Manadrinks > 0) {
				AktuelleWaffe = 'M';
			} else if (PlayerSword > 0) {
				AktuelleWaffe = 'C';
			} else {
				AktuelleWaffe = 'A';
			}
		
		} else if (AktuelleWaffe == 'C') {
			  if (Bow > 0) {
				AktuelleWaffe = 'A';
			} else if (Manadrinks > 0) {
				AktuelleWaffe = 'M';
			} else {
				AktuelleWaffe = 'C';
			}
			
		} else if (AktuelleWaffe == 'N') {
			if (PlayerSword > 0) {
				AktuelleWaffe = 'C';
			} else if (Bow > 0) {
				AktuelleWaffe = 'A';
			} else if (Manadrinks > 0) {
				AktuelleWaffe = 'M';
			} else {
				AktuelleWaffe = 'N';
			}
		}
		BuildLevel.FeldNeuzeichnen(null);
	}
	


}
