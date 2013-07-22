package dungeoncrawler;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import dungeoncrawler.BuildLevel;
import dungeoncrawler.Shop;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import Leveleditor.editor;
import Network.Chat;
import Network.ServerChat;
import java.awt.event.MouseAdapter;


public class Hauptmenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Dateipfad;
	public static String DateiLadenPfad = "leveldata.txt";
		

	/**
	 * Create the frame.
	 */
	public Hauptmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Label und Buttoneigenschaften
		 */
		Dateipfad = new JTextField("leveldata.TXT");
		Dateipfad.setBounds(174, 37, 150, 30);
		getContentPane().add(Dateipfad);
		Dateipfad.setVisible(true);
		
		JLabel lblSpielBeenden = new JLabel("Spiel beenden");
		lblSpielBeenden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblSpielBeenden.setIcon(new ImageIcon(Hauptmenu.class.getResource("/Resources/btnExit.PNG")));
		lblSpielBeenden.setBounds(508, 488, 190, 50);
		contentPane.add(lblSpielBeenden);
		
		JLabel lblLeveleditor = new JLabel("Leveleditor");
		lblLeveleditor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editor.main(null);
			}
		});
		lblLeveleditor.setIcon(new ImageIcon(Hauptmenu.class.getResource("/Resources/btnLeveleditor.PNG")));
		lblLeveleditor.setBounds(0, 27, 172, 50);
		contentPane.add(lblLeveleditor);
		
		JLabel lblEinzelspiel = new JLabel("");
		lblEinzelspiel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DateiLadenPfad = Dateipfad.getText();
				BuildLevel.main(null);
				//new Hauptspiel
			}
		});
		lblEinzelspiel.setIcon(new ImageIcon(Hauptmenu.class.getResource("/Resources/btnEinzelspiel.PNG")));
		lblEinzelspiel.setBackground(Color.white);
		lblEinzelspiel.setBounds(272, 178, 200, 35);
		getContentPane().add(lblEinzelspiel);
		
		JLabel lblMultiplayerGameStarten = new JLabel("Multiplayer Game starten");
		lblMultiplayerGameStarten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ServerChat.main(null);
			}
		});
		lblMultiplayerGameStarten.setIcon(new ImageIcon(Hauptmenu.class.getResource("/Resources/btnMulti.PNG")));
		lblMultiplayerGameStarten.setBounds(252, 240, 230, 64);
		contentPane.add(lblMultiplayerGameStarten);
		
		JLabel lblMulitplayerBeitreten = new JLabel("Mulitplayer beitreten");
		lblMulitplayerBeitreten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chat.main(null);
			}
		});
		lblMulitplayerBeitreten.setIcon(new ImageIcon(Hauptmenu.class.getResource("/Resources/btnMultibeitreten.PNG")));
		lblMulitplayerBeitreten.setBounds(246, 337, 258, 40);
		contentPane.add(lblMulitplayerBeitreten);
				
		JLabel lblNPCBackground = new JLabel("");
		lblNPCBackground.setBackground(Color.WHITE);
		lblNPCBackground.setIcon(new ImageIcon(Shop.class.getResource("/Resources/NetworkMainBackground.PNG")));
		lblNPCBackground.setBounds(0, 0, 800, 600);
		getContentPane().add(lblNPCBackground);
		
	}
	
	/**
	 * Main Methode des Hauptmenüs, erstellt das Fenster und startet die Methode zum Abspielen der Musik
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptmenu frame = new Hauptmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Treasure.PlayBackground();
	}

	public static void restart(String[] args) {
		BuildLevel.main(null);
	}

}
