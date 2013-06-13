package dungeoncrawler;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class Inventar extends JPanel {

	/**
	 * Create the panel.
	 */
	public Inventar() {
		setLayout(null);
		
		JLabel lblInventar = new JLabel("Inventar");
		lblInventar.setFont(new Font("Stencil", Font.PLAIN, 28));
		lblInventar.setBounds(130, 11, 148, 29);
		add(lblInventar);
		
		JLabel LabelMedikit = new JLabel("Medikit");
		LabelMedikit.setFont(new Font("Stencil", Font.PLAIN, 11));
		LabelMedikit.setBounds(57, 49, 46, 23);
		add(LabelMedikit);
		
		JLabel LabelRuestung = new JLabel("R\u00FCstung");
		LabelRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		LabelRuestung.setBounds(57, 78, 54, 14);
		add(LabelRuestung);
		
		JLabel LabelMana = new JLabel("Mana");
		LabelMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		LabelMana.setBounds(57, 103, 54, 14);
		add(LabelMana);
		
		JLabel BildMana = new JLabel("");
		BildMana.setIcon(new ImageIcon(Inventar.class.getResource("/dungeoncrawler/Medikit.PNG")));
		BildMana.setBounds(33, 52, 14, 14);
		add(BildMana);
		
		JLabel BildRuestunglabel_4 = new JLabel("");
		BildRuestunglabel_4.setIcon(new ImageIcon(Inventar.class.getResource("/dungeoncrawler/ruestung.PNG")));
		BildRuestunglabel_4.setBounds(33, 77, 14, 14);
		add(BildRuestunglabel_4);
		
		JLabel BildMana_1 = new JLabel("");
		BildMana_1.setIcon(new ImageIcon(Inventar.class.getResource("/dungeoncrawler/Mana.PNG")));
		BildMana_1.setBounds(33, 102, 14, 14);
		add(BildMana_1);
		
		JButton btnZumShop = new JButton("Zum Shop");
		btnZumShop.setBounds(265, 266, 89, 23);
		add(btnZumShop);
		
		JButton btnZumSpiel = new JButton("Zum Spiel");
		btnZumSpiel.setBounds(150, 266, 89, 23);
		add(btnZumSpiel);
		
		JLabel BildSchwert = new JLabel("");
		BildSchwert.setIcon(new ImageIcon(Inventar.class.getResource("/dungeoncrawler/Sword.PNG")));
		BildSchwert.setBounds(33, 127, 14, 14);
		add(BildSchwert);
		
		JLabel BildBogen = new JLabel("");
		BildBogen.setIcon(new ImageIcon(Inventar.class.getResource("/dungeoncrawler/bogen.png")));
		BildBogen.setBounds(33, 153, 14, 14);
		add(BildBogen);
		
		JLabel BildPfeil = new JLabel("");
		BildPfeil.setIcon(new ImageIcon(Inventar.class.getResource("/dungeoncrawler/pfeil1.png")));
		BildPfeil.setBounds(33, 178, 14, 14);
		add(BildPfeil);
		
		JLabel LabelSchwert = new JLabel("Schwert");
		LabelSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		LabelSchwert.setBounds(57, 128, 54, 14);
		add(LabelSchwert);
		
		JLabel LabelBogen = new JLabel("Bogen");
		LabelBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		LabelBogen.setBounds(57, 153, 54, 14);
		add(LabelBogen);
		
		JLabel LabelPfeil = new JLabel("Pfeil");
		LabelPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		LabelPfeil.setBounds(57, 178, 54, 14);
		add(LabelPfeil);
		
		JLabel AnzahlMedikit = new JLabel("0");
		AnzahlMedikit.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlMedikit.setBounds(113, 52, 14, 14);
		add(AnzahlMedikit);
		
		JLabel AnzahlRuestung = new JLabel("0");
		AnzahlRuestung.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlRuestung.setBounds(113, 77, 14, 14);
		add(AnzahlRuestung);
		
		JLabel AnzahlMana = new JLabel("0");
		AnzahlMana.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlMana.setBounds(113, 102, 14, 14);
		add(AnzahlMana);
		
		JLabel AnzahlSchwert = new JLabel("0");
		AnzahlSchwert.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlSchwert.setBounds(113, 128, 14, 14);
		add(AnzahlSchwert);
		
		JLabel AnzahlBogen = new JLabel("0");
		AnzahlBogen.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlBogen.setBounds(113, 153, 14, 14);
		add(AnzahlBogen);
		
		JLabel AnzahlPfeil = new JLabel("0");
		AnzahlPfeil.setFont(new Font("Stencil", Font.PLAIN, 11));
		AnzahlPfeil.setBounds(113, 178, 14, 14);
		add(AnzahlPfeil);
		
		JLabel BackgroundInventar = new JLabel("Inventar");
		BackgroundInventar.setIcon(new ImageIcon(Inventar.class.getResource("/dungeoncrawler/Inventar.PNG")));
		BackgroundInventar.setBounds(0, 0, 400, 320);
		add(BackgroundInventar);

	}
}
