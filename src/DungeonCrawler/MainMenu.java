package DungeonCrawler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label_name;
	ImageIcon icon_bild = new ImageIcon ("dc.PNG");
	JButton button_start;
	JButton button_ende;
	
	
	public MainMenu() {
		// Fenstersetting zum Hauptmenü
		setSize(500, 600);
		setLocation(300, 50);
		setTitle("DoofenCrawler - Hauptmenü");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		
		//Label- und Buttoneigenschaften setzen / positionieren 
		label_name = new JLabel(icon_bild);
		label_name.setBounds(100, 100, 300, 150);
		button_start = new JButton("Spiel starten");
		button_start.setBounds(150, 400, 200, 50);
		button_ende = new JButton("Spiel beenden");
		button_ende.setBounds(150, 450, 200, 50);
		
		//Label und Buttons hinzufügen
		add(label_name);
		add(button_start);
		add(button_ende);

		button_start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// wird später das Spiel starten
				
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
		new MainMenu();

	}

}
