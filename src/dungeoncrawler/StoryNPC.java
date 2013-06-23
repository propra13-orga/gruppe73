package dungeoncrawler;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StoryNPC extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static boolean stopFlag = false;
	private static JPanel NPC_Interaction;
	public static javax.swing.JLabel lblNPC;
	public String TextL11 = "Kyle, dein Dorf ist angegriffen worden. Du musst schnell nach Hause und helfen!";
	public String TextL13 = "Es schien, als würde das Grauen dass dein Dorf angegriffen hat aus dem dunklen Wald kommen.";
	public String TextL23 = "Der Großteil der Menschen ist nach dem Angriff der bösen Hexe geflohen. Bitte Hilf uns und befrei das Dorf von ihr!";
	public String TextL31 = "Das Grauen zog wie ein Schatten über dein Dorf, der Himmel verdunkelte sich, die Luft begann zu flimmern und Dinge gingen plötzlich in Flammen auf.";
	public String TextL33 = "Er schien wie eins der längst ausgestorbenen Wesen zu sein. Die Lösung der Probleme in der Gegenwart scheint ihren Ursprung in der Vergangenheit zu haben.";
	
	
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
		
		JLabel lblNPCBackground = new JLabel("");
		lblNPCBackground.setBackground(Color.WHITE);
		lblNPCBackground.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/BackgroundNPC.PNG")));
		lblNPCBackground.setBounds(0, 0, 567, 416);
		add(lblNPCBackground);
		
		JLabel lblText = new JLabel("");
		lblText.setFont(new Font("Stencil", Font.PLAIN, 13));
		lblText.setBounds(70, 153, 70, 15);
		add(lblText);		
		
		
	};
	
	 public void keyTyped(java.awt.event.KeyEvent t) {}
	    

	  /**  public void keyPressed(java.awt.event.KeyEvent t) {
		    if (LevelControl.NPC_in == false) {	
	    		if (stopFlag == false) {
			        if (t.getKeyCode() == KeyEvent.VK_T) {
			        	Shop.main(null);
			        }
			       
			        	
			        }
		    }
	    }**/
	
		
		public static void getText(String args[]){
			if (BuildLevel.Current_Level == 1){
				
			}
			
		}
			

}

