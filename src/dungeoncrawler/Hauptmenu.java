package dungeoncrawler;
import java.awt.event.ActionEvent;
import dungeoncrawler.BuildLevel;
import java.awt.event.ActionListener;
import dungeoncrawler.Shop;
import Network.ClientMain;
import Network.ServerMain;
import Network.ServerWindow;

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
	JButton button_shop;
	JButton button_networkServer;
	JButton button_networkClient;
	
	
	public Hauptmenu() {
		// Fenstersetting zum Hauptmenue
		setSize(600, 400);
		setLocation(300, 50);
		setTitle("DungeonCrawler - Hauptmenue");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);

		//Label- und Buttoneigenschaften setzen / positionieren
		label_name = new JLabel(icon_bild);
		label_name.setBounds(0, 0, 600, 400);
		button_start = new JButton("Einzelspiel starten");
		button_start.setBounds(280, 200, 185, 30);
		button_ende = new JButton("Spiel beenden");
		button_ende.setBounds(280, 320, 185, 30);
		button_shop = new JButton("Shop");
		button_shop.setBounds(100, 270, 120, 35);
		button_networkServer = new JButton("Multipayer starten (Host)");
		button_networkServer.setBounds(280, 240, 185, 30);
		button_networkClient = new JButton("Multiplayer beitreten");
		button_networkClient.setBounds(280, 280, 185, 30);

		//Label und Buttons hinzufuegen

		add(button_start);
		add(button_ende);
		//add(button_shop);
		add(button_networkClient);
		add(button_networkServer);
		add(label_name);
		button_start.setVisible(true);
		button_ende.setVisible(true);
		button_shop.setVisible(true);
		button_shop.setEnabled(false);

		button_start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

			BuildLevel.main(null);
			// new Hauptspiel();

			}
			
		});
		
		button_shop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				Shop.main(null);
			// Shoptest();

			}
			
		});
		button_ende.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);          //Programm beenden
			}
			
		});
		button_networkClient.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientMain.main(null);          //Programm beenden
			}
			
		});
		button_networkServer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ServerMain.main(null);
				//Programm beenden
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
	
	public static void restart(String[] args) {
		BuildLevel.main(null);
	}

}
