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
		setBounds(300, 300, 400, 358);
		ShopContent.setBorder(null);
		setContentPane(ShopContent);
		setLayout(null);
		setTitle("Dungeoncrawler - SHOP");
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setFont(new Font("Stencil", Font.PLAIN, 28));
		lblShop.setBounds(173, 11, 98, 34);
		add(lblShop);
		
	/*
	 *  MEDIKIT
	 *  =======================================
	 */
		JLabel BildMedikit = new JLabel("");
		BildMedikit.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Medikit.PNG")));
		BildMedikit.setBounds(20, 50, 14, 14);
		add(BildMedikit);
		
		JLabel lblHealth = new JLabel("Medikit");
		lblHealth.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblHealth.setBounds(43, 47, 46, 23);
		add(lblHealth);
		
		lblAnzahlMedikit = new JLabel(String.valueOf(WKMedikit));
		lblAnzahlMedikit.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblAnzahlMedikit.setBounds(102, 50, 14, 14);
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
		PlusMedikit.setBounds(126, 50, 14, 14);
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
		MinusMedikit.setBounds(149, 50, 14, 14);
		add(MinusMedikit);
		
		JLabel PreisMedikit = new JLabel("350");
		PreisMedikit.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisMedikit.setBounds(173, 50, 18, 14);
		add(PreisMedikit);
		
		JLabel MuenzeMedikit = new JLabel("");
		MuenzeMedikit.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeMedikit.setBounds(194, 50, 14, 14);
		add(MuenzeMedikit);
		
	/*
	 *  Ruestung
	 *  ================================================
	 */
		JLabel lblRuestung = new JLabel("R\u00FCstung");
		lblRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblRuestung.setBounds(43, 78, 54, 14);
		add(lblRuestung);
		
		lblAnzahlRuestung = new JLabel(String.valueOf(WKRuestung));
		lblAnzahlRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblAnzahlRuestung.setBounds(102, 78, 14, 14);
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
		PlusRuestung.setBounds(126, 77, 14, 14);
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
		MinusRuestung.setBounds(149, 77, 14, 14);
		add(MinusRuestung);
		
		JLabel BildRüstung = new JLabel("");
		BildRüstung.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/ruestung.PNG")));
		BildRüstung.setBounds(20, 77, 14, 14);
		add(BildRüstung);
		
		
		
		JLabel PreisRuestung = new JLabel("600");
		PreisRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisRuestung.setBounds(173, 77, 18, 14);
		add(PreisRuestung);
		
		JLabel MuenzeRuestung = new JLabel("");
		MuenzeRuestung.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeRuestung.setBounds(194, 77, 14, 14);
		add(MuenzeRuestung);
	
		
		
/*
 *  MANA
 *  ===============================		
 */
		
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
		
		JLabel lblMana = new JLabel("Mana");
		lblMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblMana.setBounds(43, 103, 54, 14);
		add(lblMana);
		
		JLabel BildMana = new JLabel("");
		BildMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Mana.PNG")));
		BildMana.setBounds(20, 102, 14, 14);
		add(BildMana);
		
		MinusMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusMana.setBounds(150, 102, 14, 14);
		add(MinusMana);
		
		lblAnzahlMana = new JLabel(String.valueOf(WKMana));
		lblAnzahlMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblAnzahlMana.setBounds(102, 103, 14, 14);
		add(lblAnzahlMana);
		
		lblMana = new JLabel();
		lblMana.setText(String.valueOf(Player.Manadrinks));
		lblMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblMana.setBounds(118, 0, 14, 14);
		add(lblMana);
		
		PlusMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusMana.setBounds(126, 102, 14, 14);
		add(PlusMana);
		
	    JLabel PreisMana = new JLabel("100");
		PreisMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisMana.setBounds(174, 102, 18, 14);
		add(PreisMana);
		
		JLabel MuenzeMana = new JLabel("");
		MuenzeMana.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeMana.setBounds(194, 102, 14, 14);
		add(MuenzeMana);
		
		/*
		 * SCHWERT
		 * =======================================
		 */
		
		JLabel BildSchwert = new JLabel("");
		BildSchwert.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Sword.PNG")));
		BildSchwert.setBounds(20, 127, 14, 14);
		add(BildSchwert);
		
		JLabel lblSchwert = new JLabel("Schwert");
		lblSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblSchwert.setBounds(43, 128, 54, 14);
		add(lblSchwert);
		
		lblAnzahlSchwert = new JLabel(String.valueOf(WKSchwert));
		lblAnzahlSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblAnzahlSchwert.setBounds(102, 128, 14, 14);
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
		PlusSchwert.setBounds(126, 127, 14, 14);
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
		MinusSchwert.setBounds(149, 127, 14, 14);
		add(MinusSchwert);
		
		JLabel PreisSchwert = new JLabel("200");
		PreisSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisSchwert.setBounds(173, 127, 18, 14);
		add(PreisSchwert);
		
		
		
		
		JLabel MunezeSchwert = new JLabel("");
		MunezeSchwert.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MunezeSchwert.setBounds(194, 127, 14, 14);
		add(MunezeSchwert);
		
		
		/*
		 * BOGEN
		 * ========================================
		 */
		JLabel BildBogen = new JLabel("");
		BildBogen.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/bogen.png")));
		BildBogen.setBounds(20, 152, 14, 14);
		add(BildBogen);
		
		JLabel lblBogen = new JLabel("Bogen");
		lblBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblBogen.setBounds(43, 152, 54, 14);
		add(lblBogen);
		
		lblAnzahlBogen = new JLabel(String.valueOf(WKBogen));
		lblAnzahlBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblAnzahlBogen.setBounds(102, 153, 14, 14);
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
		PlusBogen.setBounds(126, 152, 14, 14);
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
		MinusBogen.setBounds(149, 152, 14, 14);
		add(MinusBogen);
		
		JLabel PreisBogen = new JLabel("200");
		PreisBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisBogen.setBounds(173, 152, 18, 14);
		add(PreisBogen);
		
		JLabel MuenzeBogen = new JLabel("");
		MuenzeBogen.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeBogen.setBounds(194, 152, 14, 14);
		add(MuenzeBogen);
		
		/*
		 * PFEIL
		 * =================================================
		 */
		JLabel BildPfeil = new JLabel("");
		BildPfeil.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/pfeil1.png")));
		BildPfeil.setBounds(20, 177, 14, 14);
		add(BildPfeil);
		
		lblAnzahlPfeil = new JLabel(String.valueOf(WKPfeil));
		lblAnzahlPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblAnzahlPfeil.setBounds(102, 177, 14, 14);
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
		PlusPfeil.setBounds(126, 177, 14, 14);
		add(PlusPfeil);
		
		JLabel lblPfeil = new JLabel("Pfeil");
		lblPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblPfeil.setBounds(43, 177, 54, 14);
		add(lblPfeil);
		
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
		MinusPfeil.setBounds(149, 177, 14, 14);
		add(MinusPfeil);
		
		JLabel PreisPfeil = new JLabel("100");
		PreisPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisPfeil.setBounds(173, 177, 18, 14);
		add(PreisPfeil);
		
		JLabel MuenzePfeil = new JLabel("");
		MuenzePfeil.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzePfeil.setBounds(194, 177, 14, 14);
		add(MuenzePfeil);
		
		/*
		 * Buttons zum Abbrechen und Kauf bestaettigen
		 * ==============================================	
		 */
			
			JButton btnKaufen = new JButton("Kaufen");
			btnKaufen.setBounds(287, 286, 89, 23);
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
					dispose();
				}
			
			});
			
			JButton btnAbbrechen = new JButton("Abbrechen");
			btnAbbrechen.setBounds(173, 286, 100, 23);
			add(btnAbbrechen);
			btnAbbrechen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
		/*
		 * Kontostand vor und nach Kauf
		 * =====================================
		 */
		JLabel lblPunktzahl = new JLabel("Punktzahl:");
		lblPunktzahl.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblPunktzahl.setBounds(266, 78, 67, 14);
		add(lblPunktzahl);
		
		JLabel lblAktuelle = new JLabel("Aktuelle");
		lblAktuelle.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblAktuelle.setBounds(266, 63, 67, 14);
		add(lblAktuelle);
		
		JLabel lblPunktzahl_1 = new JLabel("Punktzahl");
		lblPunktzahl_1.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblPunktzahl_1.setBounds(266, 127, 67, 14);
		add(lblPunktzahl_1);
		
		JLabel lblNachKauf = new JLabel("nach Kauf:");
		lblNachKauf.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblNachKauf.setBounds(266, 139, 67, 14);
		add(lblNachKauf);
		
		lblKontostand = new JLabel();
		lblKontostand.setText(String.valueOf(Player.CurrentPoints));
		lblKontostand.setBounds(343, 77, 46, 14);
		add(lblKontostand);
		
		lblBudgetnachKauf = new JLabel(String.valueOf(WKBudgetnachKauf));
		lblBudgetnachKauf.setBounds(343, 138, 46, 14);
		add(lblBudgetnachKauf);
		
		/*
		 * Obere Leiste /Aktuelles Inventar
		 * ========================
		 */
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Medikit.PNG")));
		label.setBounds(20, 0, 14, 14);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/ruestung.PNG")));
		label_1.setBounds(60, 0, 14, 14);
		add(label_1);
		
		lblMedikit = new JLabel();
		lblMedikit.setText(String.valueOf(Player.Medikit));
		lblMedikit.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblMedikit.setBounds(38, 0, 14, 14);
		add(lblMedikit);
		
		
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Mana.PNG")));
		label_4.setBounds(100, 0, 14, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Sword.PNG")));
		label_5.setBounds(140, 0, 14, 14);
		add(label_5);
		
		lblRuestung= new JLabel();
		lblRuestung.setText(String.valueOf(Player.suitofarmor));
		lblRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblRuestung.setBounds(78, 0, 14, 14);
		add(lblRuestung);
		
		lblSchwert = new JLabel();
		lblSchwert.setText(String.valueOf(Player.PlayerSword));
		lblSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblSchwert.setBounds(158, 0, 14, 14);
		add(lblSchwert);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/bogen.png")));
		label_8.setBounds(180, 0, 14, 14);
		add(label_8);
		
		lblBogen= new JLabel();
		lblBogen.setText(String.valueOf(Player.Bow));
		lblBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblBogen.setBounds(198, 0, 14, 14);
		add(lblBogen);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/pfeil1.png")));
		label_10.setBounds(220, 0, 14, 14);
		add(label_10);
		
		lblPfeil = new JLabel();
		lblPfeil.setText(String.valueOf(Player.Arrow));
		lblPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblPfeil.setBounds(238, 0, 14, 14);
		add(lblPfeil);
		
		/*
		 * =====================================
		 */
		JLabel lblShopBackground = new JLabel("");
		lblShopBackground.setBackground(Color.WHITE);
		lblShopBackground.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/Inventar.PNG")));
		lblShopBackground.setBounds(0, 0, 400, 320);
		add(lblShopBackground);
	}

}
