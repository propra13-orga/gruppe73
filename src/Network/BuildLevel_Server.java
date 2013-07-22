package Network;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dungeoncrawler.BuildLevel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class BuildLevel_Server extends JFrame{

	/**
	 *  Aequivalent zu BuildLevel
	 */
	private static final long serialVersionUID = 1L;
	private static Timer_Server TimerS;
	public static JPanel contentPane;
	public static int newX;
	public static int newY;
	public static javax.swing.JLabel lblPlayer;
	public static javax.swing.JLabel lblGegner;
	public static javax.swing.JLabel lblEnemyFire;
	public static javax.swing.JLabel lblPlayerFire1;
	public static boolean PlayerFired = false;
	public static boolean PlayerFireActive = false;
	public static int PlayerFire1StartX;
	

	/**
	 * Launch the application.
	 */
	
	public static void repainter() {
		contentPane.repaint();
	}
	
	public static void main(String[] args) {
		final BuildLevel_Server frame = new BuildLevel_Server();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
        		frame.setVisible(true);
			}
		});	
	}
	
	public void setVisible(boolean value) {
		
		TimerS.start();
		
        super.setVisible(value);
	}
	
	
	
	public static void movePlayerUP() {
		if (lblPlayer.getY() > 0) {
			lblPlayer.setBounds(lblPlayer.getX(), (lblPlayer.getY()-15), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	public static void movePlayerDOWN() {
		if (lblPlayer.getY() < 255) {
			lblPlayer.setBounds(lblPlayer.getX(), (lblPlayer.getY()+15), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	public static void movePlayerLEFT() {
		if (lblPlayer.getX() > 0) {
			lblPlayer.setBounds((lblPlayer.getX()-15), lblPlayer.getY(), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	public static void movePlayerRIGHT() {
		if (lblPlayer.getX() < 515) {
			lblPlayer.setBounds((lblPlayer.getX()+15), lblPlayer.getY(), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	
	public static void fire(String args[]) {

		System.out.print("Network.BuildLevel.fire(): Schuss abgegeben");
		if (!PlayerFired) {
			PlayerFired = true;
			contentPane.repaint();
			PlayerFire1StartX = 135+lblPlayer.getX();
			lblPlayerFire1.setBounds(lblPlayer.getX(), lblPlayer.getY()+10, 15, 10);
		}
		if (PlayerFired) {
			lblPlayerFire1.setBounds((lblPlayerFire1.getX()+15), (lblPlayerFire1.getY()), 15, 10);
			
		}
		if (lblPlayerFire1.getX() >= (PlayerFire1StartX)) {
			PlayerFired = false;
			PlayerFireActive = false;
			lblPlayerFire1.setBounds(400, 400, 15, 10);
		}
		
		
		contentPane.repaint();
		
		
		if ((lblPlayerFire1.getX() >= lblGegner.getX())&(lblPlayerFire1.getX() <= (lblGegner.getX()+30))) {
		 
			if ((lblPlayerFire1.getY() >= lblGegner.getY())&(lblPlayerFire1.getY() <= (lblGegner.getY()+30))) {

				System.out.println("You won.");
			
			}
		}
		/*
		if (EnemyEnergy == 0) {
			MovementListener.moveDown = false;
			MovementListener.moveUp = false;
			LevelControl.hexe_alive = false;
			LevelControl.drache_alive = false;
			LevelControl.spinne_alive = false;
			BuildLevel.lblEnemyFire.setBounds(300, 400, 15, 10);
			BuildLevel.lblPlayerFire1.setBounds(300, 400, 15, 10);
			BuildLevel.lblCheckpoint.setText("Gegner getoetet...");
        	LevelControl.SavePointAnzeige = true;
		}
		*/
	}
	
	public static void CommitMovementToServer () {
		
		ServerChat.player1movement("Blupp");
		
	}
	

	/**
	 * Frame erzeugen und Objekte implementieren
	 */
	
	public BuildLevel_Server() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        	movePlayerLEFT();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		        	movePlayerRIGHT();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_UP) {
		        	movePlayerUP();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		        	movePlayerDOWN();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_C) {
		        	//WaffeWechseln(null);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_F) {
		        	PlayerFireActive = true;
 		        }
		        
		        CommitMovementToServer();
		        
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setTitle("BuildLevel - Server Version 1.0");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(BuildLevel_Server.class.getResource("/Resources/player2.PNG")));
		lblPlayer.setBounds(60, 135, 30, 30);
		contentPane.add(lblPlayer);
		
		lblGegner = new JLabel("");
		lblGegner.setIcon(new ImageIcon(BuildLevel_Server.class.getResource("/Resources/player2.PNG")));
		lblGegner.setBounds(465, 135, 30, 30);
		contentPane.add(lblGegner);
		
		JLabel lblSpieler1 = new JLabel("Spieler 1:");
		lblSpieler1.setBounds(10, 307, 61, 16);
		contentPane.add(lblSpieler1);
		
		JLabel lblSpieler2 = new JLabel("Spieler 2:");
		lblSpieler2.setBounds(10, 335, 61, 16);
		contentPane.add(lblSpieler2);
		
		JLabel lblBarPly1 = new JLabel("");
		lblBarPly1.setIcon(new ImageIcon(BuildLevel_Server.class.getResource("/dungeoncrawler/green.PNG")));
		lblBarPly1.setBounds(81, 307, 50, 15);
		contentPane.add(lblBarPly1);
		
		JLabel lblBarPly2 = new JLabel("");
		lblBarPly2.setIcon(new ImageIcon(BuildLevel_Server.class.getResource("/dungeoncrawler/green.PNG")));
		lblBarPly2.setBounds(81, 335, 50, 15);
		contentPane.add(lblBarPly2);
		
		lblEnemyFire = new JLabel ("");
		lblEnemyFire.setBounds(300, 300, 15, 10);
		lblEnemyFire.setIcon(new ImageIcon(BuildLevel_Server.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblEnemyFire.setVisible(true);
		contentPane.add(lblEnemyFire);
		
		lblPlayerFire1 = new JLabel ("");
		lblPlayerFire1.setBounds(300, 300, 15, 10);
		lblPlayerFire1.setIcon(new ImageIcon(BuildLevel_Server.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblPlayerFire1.setVisible(true);
		contentPane.add(lblPlayerFire1);
		
		JLabel lblfussballfeld = new JLabel("");
		lblfussballfeld.setIcon(new ImageIcon(BuildLevel_Server.class.getResource("/Resources/fussballfeld.jpg")));
		lblfussballfeld.setBounds(0, 0, 550, 295);
		contentPane.add(lblfussballfeld);
		
		TimerS = new Timer_Server() {
			
			public void Fuschi() {
				
			}
			
		};
		//TimerS.setPriority(Thread.NORM_PRIORITY);
		
		
	}
	
	
}
