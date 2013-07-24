package dungeoncrawler;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class Shop extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static JPanel ShopContent;
	
	public static JLabel lblPfeil;
	public static JLabel lblAnzahlPfeil;
	public static JLabel lblBogen;
	public static JLabel lblAnzahlBogen;
	public static JLabel lblSchwert;
	public static JLabel lblAnzahlSchwert;
	public static JLabel lblMana;
	public static JLabel lblAnzahlMana;
	public static JLabel lblRuestung;
	public static JLabel lblAnzahlRuestung;
	public static JLabel lblMedikit;
	public static JLabel lblAnzahlMedikit;
	public static JLabel lblKontostand;
	public static JLabel lblBudgetnachKauf;
	
	// WARENKORB
	
	private static int WKBudgetnachKauf = Player.CurrentPoints;
	
	private static int WKMana = 0;
	private static int WKMedikit =0;
	private static int WKPfeil=0;
	private static int WKBogen=0;
	private static int WKRuestung=0;
	private static int WKSchwert=0;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Shop() {
		ShopContent = new JPanel();
		setBounds(615, 300, 415, 398);
		ShopContent.setBorder(null);
		setContentPane(ShopContent);
		setDefaultCloseOperation(BuildLevel.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setTitle("Dungeoncrawler - SHOP");
		
		
	/*
	 *  MEDIKIT
	 *  =======================================
	 */
		JLabel BildMedikit = new JLabel("");
		BildMedikit.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Medikit.PNG")));
		BildMedikit.setBounds(40, 120, 15, 15);			// x -> , y, Breite, Höhe
		add(BildMedikit);
		
		JLabel lblHealth = new JLabel("Medikit");
		lblHealth.setFont(new Font("Arial",Font.BOLD, 13));
		lblHealth.setBounds(70, 115, 70, 30);		//Platz Bild - Schrift - 30
		add(lblHealth);
		
		lblAnzahlMedikit = new JLabel(String.valueOf(WKMedikit));
		lblAnzahlMedikit.setFont(new Font("Arial",Font.BOLD, 13));
		lblAnzahlMedikit.setBounds(150, 122, 15, 15);
		add(lblAnzahlMedikit);
		
		JLabel PlusMedikit = new JLabel("");
		PlusMedikit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf - Player.priceMedikit) >= 0) ) {
					WKMedikit = WKMedikit+1;
					lblAnzahlMedikit.setText(String.valueOf(WKMedikit));
					WKBudgetnachKauf = WKBudgetnachKauf - Player.priceMedikit;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		
		PlusMedikit.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusMedikit.setBounds(180, 120, 15, 15);
		add(PlusMedikit);
		
		JLabel MinusMedikit = new JLabel("");
		MinusMedikit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf + Player.priceMedikit) <= Player.CurrentPoints)&(WKMedikit>0)) {
					WKMedikit = WKMedikit-1;
					lblAnzahlMedikit.setText(String.valueOf(WKMedikit));
					WKBudgetnachKauf = WKBudgetnachKauf + Player.priceMedikit;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		MinusMedikit.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusMedikit.setBounds(205, 120, 15, 15);
		add(MinusMedikit);
		
		JLabel PreisMedikit = new JLabel("350");
		PreisMedikit.setFont(new Font("Arial",Font.BOLD, 13));
		PreisMedikit.setBounds(250, 122, 25, 15);
		add(PreisMedikit);
		
		JLabel MuenzeMedikit = new JLabel("");
		MuenzeMedikit.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeMedikit.setBounds(275, 120, 15, 15);
		add(MuenzeMedikit);
		
	/*
	 *  Ruestung
	 *  ================================================
	 */
		
		JLabel BildRüstung = new JLabel("");
		BildRüstung.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/ruestung.PNG")));
		BildRüstung.setBounds(40, 150, 15, 15);
		add(BildRüstung);
		
		JLabel lblRuestung = new JLabel("R\u00FCstung");
		lblRuestung.setFont(new Font("Arial",Font.BOLD, 13));
		lblRuestung.setBounds(70, 153, 70, 15);
		add(lblRuestung);
		
		lblAnzahlRuestung = new JLabel(String.valueOf(WKRuestung));
		lblAnzahlRuestung.setFont(new Font("Arial",Font.BOLD, 13));
		lblAnzahlRuestung.setBounds(150, 153, 15, 15);
		add(lblAnzahlRuestung);
		
		
		JLabel PlusRuestung = new JLabel("");
		PlusRuestung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf - Player.pricesuitofarmor) >= 0) ) {
					WKRuestung = WKRuestung+1;
					lblAnzahlRuestung.setText(String.valueOf(WKRuestung));
					WKBudgetnachKauf = WKBudgetnachKauf - Player.pricesuitofarmor;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
			}
			}
		});
		PlusRuestung.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusRuestung.setBounds(180, 150, 15, 15);
		add(PlusRuestung);
		
		JLabel MinusRuestung = new JLabel("");
		MinusRuestung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf + Player.pricesuitofarmor) <= Player.CurrentPoints)&(WKRuestung>0)) {
					WKRuestung = WKRuestung-1;
					lblAnzahlRuestung.setText(String.valueOf(WKMedikit));
					WKBudgetnachKauf = WKBudgetnachKauf + Player.pricesuitofarmor;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		MinusRuestung.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusRuestung.setBounds(205, 150, 15, 15);
		add(MinusRuestung);
		
		
		
		
		
		JLabel PreisRuestung = new JLabel("600");
		PreisRuestung.setFont(new Font("Arial",Font.BOLD, 13));
		PreisRuestung.setBounds(250, 150, 25, 15);
		add(PreisRuestung);
		
		JLabel MuenzeRuestung = new JLabel("");
		MuenzeRuestung.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeRuestung.setBounds(275, 150, 15, 15);
		add(MuenzeRuestung);
	
		
		
/*
 *  MANA
 *  ===============================		
 */
		
		JLabel BildMana = new JLabel("");
		BildMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Mana.PNG")));
		BildMana.setBounds(40, 180, 15, 15);
		add(BildMana);
		
		JLabel lblMana = new JLabel("Mana");
		lblMana.setFont(new Font("Arial",Font.BOLD, 13));
		lblMana.setBounds(70, 185, 54, 15);
		add(lblMana);
		
		lblAnzahlMana = new JLabel(String.valueOf(WKMana));
		lblAnzahlMana.setFont(new Font("Arial",Font.BOLD, 13));
		lblAnzahlMana.setBounds(150, 185, 15, 15);
		add(lblAnzahlMana);
		
		JLabel PlusMana = new JLabel("");
		PlusMana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((WKBudgetnachKauf - Player.priceManadrinks) >= 0) {
					WKMana = WKMana+1;
					lblAnzahlMana.setText(String.valueOf(WKMana));
					WKBudgetnachKauf = WKBudgetnachKauf - Player.priceManadrinks;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}	
			}
		});
		PlusMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusMana.setBounds(180, 182, 15, 15);
		add(PlusMana);
		
		JLabel MinusMana = new JLabel("");
		MinusMana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf + Player.priceManadrinks) <= Player.CurrentPoints)&(WKMana>0)) {
					WKMana = WKMana-1;
					lblAnzahlMana.setText(String.valueOf(WKMana));
					WKBudgetnachKauf = WKBudgetnachKauf + Player.priceManadrinks;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
			
		MinusMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusMana.setBounds(205, 182, 15, 15);
		add(MinusMana);
					
	    JLabel PreisMana = new JLabel("100");
		PreisMana.setFont(new Font("Arial",Font.BOLD, 13));
		PreisMana.setBounds(250, 183, 25, 15);
		add(PreisMana);
		
		JLabel MuenzeMana = new JLabel("");
		MuenzeMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeMana.setBounds(275, 180, 15, 15);
		add(MuenzeMana);
		
		/*
		 * SCHWERT
		 * =======================================
		 */
		
		JLabel BildSchwert = new JLabel("");
		BildSchwert.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Sword.PNG")));
		BildSchwert.setBounds(40, 215, 15, 15);
		add(BildSchwert);
		
		JLabel lblSchwert = new JLabel("Schwert");
		lblSchwert.setFont(new Font("Arial",Font.BOLD, 13));
		lblSchwert.setBounds(70, 215, 65, 15);
		add(lblSchwert);
		
		lblAnzahlSchwert = new JLabel(String.valueOf(WKSchwert));
		lblAnzahlSchwert.setFont(new Font("Arial",Font.BOLD, 13));
		lblAnzahlSchwert.setBounds(150, 215, 15, 15);
		add(lblAnzahlSchwert);
		
		JLabel PlusSchwert = new JLabel("");
		PlusSchwert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((WKBudgetnachKauf - Player.priceSword) >= 0) ) {
					WKSchwert = WKSchwert+1;
					lblAnzahlSchwert.setText(String.valueOf(WKSchwert));
					WKBudgetnachKauf = WKBudgetnachKauf - Player.priceSword;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		PlusSchwert.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusSchwert.setBounds(180, 213, 15, 15);
		add(PlusSchwert);
		
		JLabel MinusSchwert = new JLabel("");
		MinusSchwert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf + Player.priceSword) <= Player.CurrentPoints)&(WKSchwert>0)) {
					WKSchwert = WKSchwert-1;
					lblAnzahlSchwert.setText(String.valueOf(WKSchwert));
					WKBudgetnachKauf = WKBudgetnachKauf + Player.priceSword;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		
		MinusSchwert.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusSchwert.setBounds(205, 213, 15, 15);
		add(MinusSchwert);
		
		JLabel PreisSchwert = new JLabel("200");
		PreisSchwert.setFont(new Font("Arial",Font.BOLD, 13));
		PreisSchwert.setBounds(250, 215, 25, 15);
		add(PreisSchwert);
						
		JLabel MunezeSchwert = new JLabel("");
		MunezeSchwert.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MunezeSchwert.setBounds(275, 213, 15, 15);
		add(MunezeSchwert);
		
		
		/*
		 * BOGEN
		 * ========================================
		 */
		JLabel BildBogen = new JLabel("");
		BildBogen.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/bogen.png")));
		BildBogen.setBounds(40, 245, 15, 15);
		add(BildBogen);
		
		JLabel lblBogen = new JLabel("Bogen");
		lblBogen.setFont(new Font("Arial",Font.BOLD, 13));
		lblBogen.setBounds(70, 245, 54, 15);
		add(lblBogen);
		
		lblAnzahlBogen = new JLabel(String.valueOf(WKBogen));
		lblAnzahlBogen.setFont(new Font("Arial",Font.BOLD, 13));
		lblAnzahlBogen.setBounds(150, 245, 15, 15);
		add(lblAnzahlBogen);
		
		JLabel PlusBogen = new JLabel("");
		PlusBogen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((WKBudgetnachKauf - Player.priceBow) >= 0) ) {
					WKBogen = WKBogen+1;
					lblAnzahlBogen.setText(String.valueOf(WKBogen));
					WKBudgetnachKauf = WKBudgetnachKauf - Player.priceBow;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		PlusBogen.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusBogen.setBounds(180, 245, 15, 15);
		add(PlusBogen);
		 
		JLabel MinusBogen = new JLabel("");
		MinusBogen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf + Player.priceBow) <= Player.CurrentPoints)&(WKBogen>0)) {
					WKBogen = WKBogen-1;
					lblAnzahlBogen.setText(String.valueOf(WKBogen));
					WKBudgetnachKauf = WKBudgetnachKauf + Player.priceBow;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		MinusBogen.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusBogen.setBounds(205, 245, 15, 15);
		add(MinusBogen);
		
		JLabel PreisBogen = new JLabel("200");
		PreisBogen.setFont(new Font("Arial",Font.BOLD, 13));
		PreisBogen.setBounds(250, 245, 25, 15);
		add(PreisBogen);
		
		JLabel MuenzeBogen = new JLabel("");
		MuenzeBogen.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeBogen.setBounds(275, 245, 15, 15);
		add(MuenzeBogen);
		
		/*
		 * PFEIL
		 * =================================================
		 */
		JLabel BildPfeil = new JLabel("");
		BildPfeil.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/pfeil1.png")));
		BildPfeil.setBounds(40, 280, 15, 15);
		add(BildPfeil);
		
		JLabel lblPfeil = new JLabel("Pfeil");
		lblPfeil.setFont(new Font("Arial",Font.BOLD, 13));
		lblPfeil.setBounds(70, 280, 54, 15);
		add(lblPfeil);
		
		lblAnzahlPfeil = new JLabel(String.valueOf(WKPfeil));
		lblAnzahlPfeil.setFont(new Font("Arial",Font.BOLD, 13));
		lblAnzahlPfeil.setBounds(150, 280, 15, 15);
		add(lblAnzahlPfeil);
		
		JLabel PlusPfeil = new JLabel("");
		PlusPfeil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (((WKBudgetnachKauf - Player.priceArrow) >= 0) ) {
					WKPfeil = WKPfeil+1;
					lblAnzahlPfeil.setText(String.valueOf(WKPfeil));
					WKBudgetnachKauf = WKBudgetnachKauf - Player.priceArrow;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		PlusPfeil.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusPfeil.setBounds(180, 278, 15, 15);
		add(PlusPfeil);
				
		JLabel MinusPfeil = new JLabel("");
		MinusPfeil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((WKBudgetnachKauf + Player.priceArrow) <= Player.CurrentPoints)&(WKPfeil>0)) {
					WKPfeil = WKPfeil-1;
					lblAnzahlPfeil.setText(String.valueOf(WKPfeil));
					WKBudgetnachKauf = WKBudgetnachKauf + Player.priceArrow;
					lblBudgetnachKauf.setText(String.valueOf(WKBudgetnachKauf));
					ShopContent.repaint();
				}
			}
		});
		MinusPfeil.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusPfeil.setBounds(205, 278, 15, 15);
		add(MinusPfeil);
		
		JLabel PreisPfeil = new JLabel("100");
		PreisPfeil.setFont(new Font("Arial",Font.BOLD, 13));
		PreisPfeil.setBounds(250, 282, 25, 15);
		add(PreisPfeil);
		
		JLabel MuenzePfeil = new JLabel("");
		MuenzePfeil.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzePfeil.setBounds(275, 280, 15, 15);
		add(MuenzePfeil);
		
		/*
		 * Buttons zum Abbrechen und Kauf bestaettigen
		 * ==============================================	
		 */
			
			JButton btnKaufen = new JButton("Kaufen");
			btnKaufen.setBounds(260, 310, 89, 23);
			add(btnKaufen);
			
			btnKaufen.addActionListener (new ActionListener() {
				 
				@Override
				public void actionPerformed (ActionEvent e) {
					Player.PlayerSword = Player.PlayerSword+WKSchwert;
					Player.Medikit= Player.Medikit+WKMedikit;
					Player.Bow= Player.Bow+WKBogen;
					Player.Manadrinks = Player.Manadrinks+WKMana;
					Player.suitofarmor= Player.suitofarmor+WKRuestung;
					Player.Arrow= Player.Arrow+WKPfeil;
					Player.CurrentPoints = WKBudgetnachKauf;
					
					BuildLevel.ShopSchliessen(null);
					
					MovementListener.down = 0;
					MovementListener.up = 0;
					MovementListener.left = 0;
					MovementListener.right = 0;
					
			        LevelControl.Shop_opened = false;
			        
			        BuildLevel.refreshInventar(null);
			        
			        WKSchwert = 0;
			        WKMedikit = 0;
			        WKBogen = 0;
			        WKMana = 0;
			        WKRuestung = 0;
			        WKPfeil = 0;
			        WKBudgetnachKauf = 0;
			        
	        		dispose();
				}
			
			});
			
			JButton btnAbbrechen = new JButton("Abbrechen");
			btnAbbrechen.setBounds(50, 310, 100, 23);
			add(btnAbbrechen);
			btnAbbrechen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					BuildLevel.ShopSchliessen(null);
					
					MovementListener.down = 0;
					MovementListener.up = 0;
					MovementListener.left = 0;
					MovementListener.right = 0;
					
					WKSchwert = 0;
			        WKMedikit = 0;
			        WKBogen = 0;
			        WKMana = 0;
			        WKRuestung = 0;
			        WKPfeil = 0;
			        WKBudgetnachKauf = 0;
					
			        LevelControl.Shop_opened = false;
	        		dispose();
				}
			});
			
		/*
		 * Kontostand vor und nach Kauf
		 * =====================================
		 */
		
		
		JLabel lblAktuelle = new JLabel("Aktuelle");
		lblAktuelle.setFont(new Font("Arial",Font.BOLD, 11));
		lblAktuelle.setBounds(310, 110, 67, 15);
		add(lblAktuelle);
		
		JLabel lblPunktzahl = new JLabel("Punktzahl:");
		lblPunktzahl.setFont(new Font("Arial",Font.BOLD, 11));
		lblPunktzahl.setBounds(310, 120, 67, 15);
		add(lblPunktzahl);
		
		lblKontostand = new JLabel();
		lblKontostand.setText(String.valueOf(Player.CurrentPoints));
		lblKontostand.setBounds(335, 135, 46, 15);
		add(lblKontostand);
		
		JLabel lblPunktzahl_1 = new JLabel("Punktzahl");
		lblPunktzahl_1.setFont(new Font("Arial",Font.BOLD, 11));
		lblPunktzahl_1.setBounds(310, 170, 67, 15);
		add(lblPunktzahl_1);
		
		JLabel lblNachKauf = new JLabel("nach Kauf:");
		lblNachKauf.setFont(new Font("Arial",Font.BOLD, 11));
		lblNachKauf.setBounds(310, 180, 67, 15);
		add(lblNachKauf);
		
		lblBudgetnachKauf = new JLabel(String.valueOf(WKBudgetnachKauf));
		lblBudgetnachKauf.setBounds(335, 195, 46, 15);
		add(lblBudgetnachKauf);
		
		/*
		 * Obere Leiste /Aktuelles Inventar
		 * ========================
		 */
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Medikit.PNG")));
		label.setBounds(60, 40, 15, 15);			//Abstand Bild - Bild 40 px
		add(label);
		
		lblMedikit = new JLabel();
		lblMedikit.setText(String.valueOf(Player.Medikit));
		lblMedikit.setFont(new Font("Arial",Font.BOLD, 13));
		lblMedikit.setBounds(85, 40, 25, 15);					//Anzahl immer um +25 auf der x-Achse verschoben
		add(lblMedikit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/ruestung.PNG")));
		label_1.setBounds(100, 40, 15, 15);
		add(label_1);
		
		lblRuestung= new JLabel();
		lblRuestung.setText(String.valueOf(Player.suitofarmor));
		lblRuestung.setFont(new Font("Arial",Font.BOLD, 13));
		lblRuestung.setBounds(125, 40,215, 15);
		add(lblRuestung);	
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Mana.PNG")));
		label_4.setBounds(140, 40, 15, 15);
		add(label_4);
		
		lblMana = new JLabel();
		lblMana.setText(String.valueOf(Player.Manadrinks));
		lblMana.setFont(new Font("Arial",Font.BOLD, 13));
		lblMana.setBounds(165, 40, 25, 15);
		add(lblMana);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Sword.PNG")));
		label_5.setBounds(180, 40, 15, 15);
		add(label_5);
		
		
		lblSchwert = new JLabel();
		lblSchwert.setText(String.valueOf(Player.PlayerSword));
		lblSchwert.setFont(new Font("Arial",Font.BOLD, 13));
		lblSchwert.setBounds(205, 40, 25, 15);
		add(lblSchwert);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/bogen.png")));
		label_8.setBounds(220, 40, 15, 15);
		add(label_8);
		
		lblBogen= new JLabel();
		lblBogen.setText(String.valueOf(Player.Bow));
		lblBogen.setFont(new Font("Arial",Font.BOLD, 13));
		lblBogen.setBounds(245, 40, 25, 15);
		add(lblBogen);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/pfeil1.png")));
		label_10.setBounds(260, 40, 25, 15);
		add(label_10);
		
		lblPfeil = new JLabel();
		lblPfeil.setText(String.valueOf(Player.Arrow));
		lblPfeil.setFont(new Font("Arial",Font.BOLD, 13));
		lblPfeil.setBounds(285, 40, 25, 15);
		add(lblPfeil);
		
		/*
		 * =====================================
		 */
		JLabel lblShopBackground = new JLabel("");
		lblShopBackground.setBackground(Color.WHITE);
		lblShopBackground.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/ShopBackground.PNG")));
		lblShopBackground.setBounds(0, 0, 400, 360);
		add(lblShopBackground);
	}

}
