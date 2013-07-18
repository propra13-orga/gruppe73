package dungeoncrawler;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StoryNPC extends JFrame {
	
	/**
	 * Klasse des NPC der mit dem Charakter interagiert. 
	 * Klasse generiert das Fenster, in dem die Strings, in Abhängigkeit vom aktuellen Level, ausgegeben werden.
	 */
	private static final long serialVersionUID = 1L;
    public static boolean stopFlag = false;
	private static JPanel NPC_Interaction;
	public static javax.swing.JLabel lblNPC;
	public String TextL11 = "<html>Kyle, dein Dorf ist angegriffen worden.<br> Du musst schnell nach Hause und helfen!<br> Ein Wanderer war hier und hat etwas verloren. Ich glaube du findest es bei der Hütte.</html>";
	public String TextL13 = "<html>Es schien, als würde das Grauen,<br> das dein Dorf angegriffen hat, <br> aus dem dunklen Wald kommen.</html>";
	public String TextL23 = "<html>Der Großteil der Menschen ist <br>nach dem Angriff der bösen Hexe geflohen.<br> Bitte Hilf uns und befrei das Dorf von ihr!</html>";
	public String TextL31 = "<html>Das Grauen zog wie ein Schatten über dein Dorf,<br> der Himmel verdunkelte sich, die Luft begann zu flimmern <br> und Dinge gingen plötzlich in Flammen auf.</html>";
	public String TextL33 = "<html>Er schien wie eins der längst ausgestorbenen Wesen zu sein.<br> Die Lösung der Probleme in der Gegenwart scheint <br> ihren Ursprung in der Vergangenheit zu haben.</html>";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoryNPC frame = new StoryNPC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public StoryNPC() {
		NPC_Interaction = new JPanel();
		setBounds(615, 300, 575, 415);
		NPC_Interaction.setBorder(null);
		setContentPane(NPC_Interaction);
		setDefaultCloseOperation(BuildLevel.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setTitle("Dungeoncrawler - Interaction");
			
		/*
		 * Background NPC Interaction
		 * =================================================
		 */

		JButton Schließen = new JButton("Schließen");
		Schließen.setVisible(true);
		Schließen.setBounds(50, 330, 100, 23);
		add(Schließen);
		Schließen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuildLevel.StoryNPCSchliessen(null);
				
				MovementListener.down = 0;
				MovementListener.up = 0;
				MovementListener.left = 0;
				MovementListener.right = 0;
				
				    LevelControl.Shop_opened = false;
	        		dispose();
		
	
			}
		});
		
		JLabel lblText = new JLabel("");
		
		/**  
		 *   Abfrage welcher Text gewählt werden soll:
		 */
		
		if (BuildLevel.Current_Level == 1) {
			lblText.setText(TextL11);
		} else if (BuildLevel.Current_Level == 5 ) 	{
			lblText.setText(TextL13);
		} else if (BuildLevel.Current_Level == 11 ) {
			lblText.setText(TextL23);	
		} else if (BuildLevel.Current_Level == 13) 	{
			lblText.setText(TextL31);
		} else if (BuildLevel.Current_Level == 17)	{
			lblText.setText(TextL33);
		}
		
		
		lblText.setBounds(250, 90, 250, 250);
		lblText.setVisible(true);
		lblText.setFont(new Font("Arial",Font.BOLD, 20));
		add(lblText);
		
		JLabel lblNPCBackground = new JLabel("");
		lblNPCBackground.setBackground(Color.WHITE);
		lblNPCBackground.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/BackgroundNPC.PNG")));
		lblNPCBackground.setBounds(0, 0, 567, 416);
		add(lblNPCBackground);
	};
	
	 
			

}

