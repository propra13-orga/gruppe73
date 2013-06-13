package dungeoncrawler;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class shop extends JPanel {
	private JLabel lblHealth;

	/**
	 * Create the panel.
	 */
	public shop() {
		setBounds(300, 300, 400, 320);
		setLayout(null);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setFont(new Font("Stencil", Font.PLAIN, 28));
		lblShop.setBounds(173, 11, 98, 34);
		add(lblShop);
		
		JLabel BildMedikit = new JLabel("");
		BildMedikit.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/Medikit.PNG")));
		BildMedikit.setBounds(20, 50, 14, 14);
		add(BildMedikit);
		
		lblHealth = new JLabel("Medikit");
		lblHealth.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblHealth.setBounds(43, 47, 46, 23);
		add(lblHealth);
		
		JLabel AnzahlMedikit = new JLabel("0");
		AnzahlMedikit.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlMedikit.setBounds(102, 50, 14, 14);
		add(AnzahlMedikit);
		
		JLabel PlusMedikit = new JLabel("");
		PlusMedikit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		PlusMedikit.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusMedikit.setBounds(126, 50, 14, 14);
		add(PlusMedikit);
		
		JLabel MinusMedikit = new JLabel("");
		MinusMedikit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		MinusMedikit.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusMedikit.setBounds(149, 50, 14, 14);
		add(MinusMedikit);
		
		JLabel PreisMedikit = new JLabel("350");
		PreisMedikit.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisMedikit.setBounds(173, 50, 18, 14);
		add(PreisMedikit);
		
		JLabel MuenzeMedikit = new JLabel("");
		MuenzeMedikit.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeMedikit.setBounds(194, 50, 14, 14);
		add(MuenzeMedikit);
		
		JLabel lblRuestung = new JLabel("R\u00FCstung");
		lblRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblRuestung.setBounds(43, 78, 54, 14);
		add(lblRuestung);
		
		JLabel AnzahlRuestung = new JLabel("0");
		AnzahlRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlRuestung.setBounds(102, 78, 14, 14);
		add(AnzahlRuestung);
		
		JLabel AnzahlMana = new JLabel("0");
		AnzahlMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlMana.setBounds(102, 103, 14, 14);
		add(AnzahlMana);
		
		JLabel lblMana = new JLabel("Mana");
		lblMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblMana.setBounds(43, 103, 54, 14);
		add(lblMana);
		
		JButton btnKaufen = new JButton("Kaufen");
		btnKaufen.setBounds(287, 286, 89, 23);
		add(btnKaufen);
		
		JButton button = new JButton("Abbrechen");
		button.setBounds(173, 286, 89, 23);
		add(button);
		
		JLabel PlusRuestung = new JLabel("");
		PlusRuestung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		PlusRuestung.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusRuestung.setBounds(126, 77, 14, 14);
		add(PlusRuestung);
		
		JLabel PlusMana = new JLabel("");
		PlusMana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		PlusMana.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusMana.setBounds(126, 102, 14, 14);
		add(PlusMana);
		
		JLabel MinusRuestung = new JLabel("");
		MinusRuestung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		MinusRuestung.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusRuestung.setBounds(149, 77, 14, 14);
		add(MinusRuestung);
		
		JLabel MinusMana = new JLabel("");
		MinusMana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		MinusMana.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusMana.setBounds(150, 102, 14, 14);
		add(MinusMana);
		
		JLabel BildRüstung = new JLabel("");
		BildRüstung.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/ruestung.PNG")));
		BildRüstung.setBounds(20, 77, 14, 14);
		add(BildRüstung);
		
		JLabel BildMana = new JLabel("");
		BildMana.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/Mana.PNG")));
		BildMana.setBounds(20, 102, 14, 14);
		add(BildMana);
		
		JLabel PreisRuestung = new JLabel("600");
		PreisRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisRuestung.setBounds(173, 77, 18, 14);
		add(PreisRuestung);
		
		JLabel PreisMana = new JLabel("100");
		PreisMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisMana.setBounds(174, 102, 18, 14);
		add(PreisMana);
		
		JLabel BildSchwert = new JLabel("");
		BildSchwert.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/Sword.PNG")));
		BildSchwert.setBounds(20, 127, 14, 14);
		add(BildSchwert);
		
		JLabel lblSchwert = new JLabel("Schwert");
		lblSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblSchwert.setBounds(43, 128, 54, 14);
		add(lblSchwert);
		
		JLabel AnzahlSchwert = new JLabel("0");
		AnzahlSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlSchwert.setBounds(102, 128, 14, 14);
		add(AnzahlSchwert);
		
		JLabel PlusSchwert = new JLabel("");
		PlusSchwert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		PlusSchwert.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusSchwert.setBounds(126, 127, 14, 14);
		add(PlusSchwert);
		
		JLabel MinusSchwert = new JLabel("");
		MinusSchwert.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusSchwert.setBounds(149, 127, 14, 14);
		add(MinusSchwert);
		
		JLabel PreisSchwert = new JLabel("200");
		PreisSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisSchwert.setBounds(173, 127, 18, 14);
		add(PreisSchwert);
		
		JLabel MuenzeRuestung = new JLabel("");
		MuenzeRuestung.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeRuestung.setBounds(194, 77, 14, 14);
		add(MuenzeRuestung);
		
		JLabel MuenzeMana = new JLabel("");
		MuenzeMana.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeMana.setBounds(194, 102, 14, 14);
		add(MuenzeMana);
		
		JLabel MunezeSchwert = new JLabel("");
		MunezeSchwert.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/points.PNG")));
		MunezeSchwert.setBounds(194, 127, 14, 14);
		add(MunezeSchwert);
		
		JLabel BildBogen = new JLabel("");
		BildBogen.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/bogen.png")));
		BildBogen.setBounds(20, 152, 14, 14);
		add(BildBogen);
		
		JLabel lblBogen = new JLabel("Bogen");
		lblBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblBogen.setBounds(43, 152, 54, 14);
		add(lblBogen);
		
		JLabel AnzahlBogen = new JLabel("0");
		AnzahlBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlBogen.setBounds(102, 153, 14, 14);
		add(AnzahlBogen);
		
		JLabel PlusBogen = new JLabel("");
		PlusBogen.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusBogen.setBounds(126, 152, 14, 14);
		add(PlusBogen);
		
		JLabel MinusBogen = new JLabel("");
		MinusBogen.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusBogen.setBounds(149, 152, 14, 14);
		add(MinusBogen);
		
		JLabel PreisBogen = new JLabel("200");
		PreisBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisBogen.setBounds(173, 152, 18, 14);
		add(PreisBogen);
		
		JLabel MuenzeBogen = new JLabel("");
		MuenzeBogen.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzeBogen.setBounds(194, 152, 14, 14);
		add(MuenzeBogen);
		
		JLabel BildPfeil = new JLabel("");
		BildPfeil.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/pfeil1.png")));
		BildPfeil.setBounds(20, 177, 14, 14);
		add(BildPfeil);
		
		JLabel AnzahlPfeil = new JLabel("0");
		AnzahlPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlPfeil.setBounds(102, 177, 14, 14);
		add(AnzahlPfeil);
		
		JLabel PlusPfeil = new JLabel("");
		PlusPfeil.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/plus.PNG")));
		PlusPfeil.setBounds(126, 177, 14, 14);
		add(PlusPfeil);
		
		JLabel lblPfeil = new JLabel("Pfeil");
		lblPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblPfeil.setBounds(43, 177, 54, 14);
		add(lblPfeil);
		
		JLabel MinusPfeil = new JLabel("");
		MinusPfeil.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/minus.PNG")));
		MinusPfeil.setBounds(149, 177, 14, 14);
		add(MinusPfeil);
		
		JLabel PreisPfeil = new JLabel("100");
		PreisPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		PreisPfeil.setBounds(173, 177, 18, 14);
		add(PreisPfeil);
		
		JLabel MuenzePfeil = new JLabel("");
		MuenzePfeil.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/points.PNG")));
		MuenzePfeil.setBounds(194, 177, 14, 14);
		add(MuenzePfeil);
		
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
		
		JLabel lblNewLabel = new JLabel("000");
		lblNewLabel.setBounds(343, 77, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("000");
		lblNewLabel_1.setBounds(343, 138, 46, 14);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/Medikit.PNG")));
		label.setBounds(20, 0, 14, 14);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/ruestung.PNG")));
		label_1.setBounds(60, 0, 14, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("0");
		label_2.setFont(new Font("Stencil", Font.PLAIN, 11));
		label_2.setBounds(38, 0, 14, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("0");
		label_3.setFont(new Font("Stencil", Font.PLAIN, 11));
		label_3.setBounds(118, 0, 14, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/Mana.PNG")));
		label_4.setBounds(100, 0, 14, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/Sword.PNG")));
		label_5.setBounds(140, 0, 14, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("0");
		label_6.setFont(new Font("Stencil", Font.PLAIN, 11));
		label_6.setBounds(78, 0, 14, 14);
		add(label_6);
		
		JLabel label_7 = new JLabel("0");
		label_7.setFont(new Font("Stencil", Font.PLAIN, 11));
		label_7.setBounds(158, 0, 14, 14);
		add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/bogen.png")));
		label_8.setBounds(180, 0, 14, 14);
		add(label_8);
		
		JLabel label_9 = new JLabel("0");
		label_9.setFont(new Font("Stencil", Font.PLAIN, 11));
		label_9.setBounds(198, 0, 14, 14);
		add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/pfeil1.png")));
		label_10.setBounds(220, 0, 14, 14);
		add(label_10);
		
		JLabel label_11 = new JLabel("0");
		label_11.setFont(new Font("Stencil", Font.PLAIN, 11));
		label_11.setBounds(238, 0, 14, 14);
		add(label_11);
		
		JLabel lblShopBackground = new JLabel("");
		lblShopBackground.setBackground(Color.WHITE);
		lblShopBackground.setIcon(new ImageIcon(shop.class.getResource("/dungeoncrawler/Inventar.PNG")));
		lblShopBackground.setBounds(0, 0, 400, 320);
		add(lblShopBackground);
		
		

	}
}
