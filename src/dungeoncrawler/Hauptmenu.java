package dungeoncrawler;
import java.awt.event.ActionEvent;
import dungeoncrawler.BuildLevel;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hauptmenu extends JFrame {
	/*
	*
	*/
	private static final long serialVersionUID = 1L;
	JLabel label_name;
	ImageIcon icon_bild = new ImageIcon(this.getClass().getResource("/dungeoncrawler/MenuBackground.PNG"));
	JButton button_start;
	JButton button_ende;
	
	
	public Hauptmenu() {
		// Fenstersetting zum Hauptmenue
		setSize(600, 400);
		setLocation(300, 50);
		setTitle("DungeonCrawler - Hauptmenue");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);

		//Label- und Buttoneigenschaften setzen / positionieren
		label_name = new JLabel(icon_bild);
		label_name.setBounds(0, 0, 600, 400);
		button_start = new JButton("Spiel starten");
		button_start.setBounds(300, 200, 150, 50);
		button_ende = new JButton("Spiel beenden");
		button_ende.setBounds(300, 270, 150, 50);

		//Label und Buttons hinzufuegen

		add(button_start);
		add(button_ende);
		add(label_name);
		button_start.setVisible(true);
		button_ende.setVisible(true);

		button_start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

			BuildLevel.main(null);
			// new Hauptspiel();

			}
			
		});
		button_ende.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);          //Programm beenden
			}
			
		});
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hauptmenu();

	}

}
