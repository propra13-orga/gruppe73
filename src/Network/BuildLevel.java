package Network;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import dungeoncrawler.CollisionControl;
import dungeoncrawler.Gegner;
import dungeoncrawler.LevelControl;
import dungeoncrawler.MovementListener;
import dungeoncrawler.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class BuildLevel extends JFrame{

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildLevel frame = new BuildLevel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Timer counter = new Timer();
		counter.counter();
	}
	
	
	
	public static void movePlayerUP() {
		if (lblPlayer.getY() > 0) {
			lblPlayer.setBounds(lblPlayer.getX(), (lblPlayer.getY()-15), 15, 15);
			contentPane.repaint();
		}
		
	}
	
	public static void movePlayerDOWN() {
		if (lblPlayer.getY() < 270) {
			lblPlayer.setBounds(lblPlayer.getX(), (lblPlayer.getY()+15), 15, 15);
			contentPane.repaint();
		}
		
	}
	
	public static void movePlayerLEFT() {
		if (lblPlayer.getX() > 0) {
			lblPlayer.setBounds((lblPlayer.getX()-15), lblPlayer.getY(), 15, 15);
			contentPane.repaint();
		}
		
	}
	
	public static void movePlayerRIGHT() {
		if (lblPlayer.getX() < 530) {
			lblPlayer.setBounds((lblPlayer.getX()+15), lblPlayer.getY(), 15, 15);
			contentPane.repaint();
		}
		
	}
	
	public static void PlayerFire() {
			if (!PlayerFired) {
				PlayerFired = true;

				contentPane.repaint();
				PlayerFire1StartX = 135+BuildLevel.lblPlayer.getX();
				BuildLevel.lblPlayerFire1.setBounds(BuildLevel.lblPlayer.getX(), BuildLevel.lblPlayer.getY(), 15, 10);
			}
			if (PlayerFired) {
				BuildLevel.lblPlayerFire1.setBounds((BuildLevel.lblPlayerFire1.getX()+15), (BuildLevel.lblPlayerFire1.getY()), 15, 10);
			}
			if (BuildLevel.lblPlayerFire1.getX() >= (PlayerFire1StartX)) {
				PlayerFired = false;
				PlayerFireActive = false;
				BuildLevel.lblPlayerFire1.setBounds(400, 400, 15, 10);
			}
			
			/*
			if ((BuildLevel.lblPlayerFire1.getX() >= BuildLevel.lblItem1.getX())&(BuildLevel.lblPlayerFire1.getX() <= (BuildLevel.lblItem1.getX()+30))) {
				if ((BuildLevel.lblPlayerFire1.getY() >= BuildLevel.lblItem1.getY())&(BuildLevel.lblPlayerFire1.getY() <= (BuildLevel.lblItem1.getY()+30))) {
					if (LevelControl.hexe_alive == true){
						EnemyEnergy = EnemyEnergy-1;
					} else if (LevelControl.drache_alive == true){
						EnemyEnergy = EnemyEnergy;
						
					} else if (LevelControl.spinne_alive == true) {
						EnemyEnergy = EnemyEnergy-1;
					}
				}
			}
			*/
			/*
			if (EnemyEnergy == 0) {
				MovementListener.moveDown = false;
				MovementListener.moveUp = false;
				BuildLevel.lblEnemyFire.setBounds(300, 400, 15, 10);
				BuildLevel.lblPlayerFire1.setBounds(300, 400, 15, 10);
			}
			*/
	}
	
	

	/**
	 * Create the frame.
	 */
	public BuildLevel() {
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/player.PNG")));
		lblPlayer.setBounds(0, 0, 15, 15);
		contentPane.add(lblPlayer);
		
		lblGegner = new JLabel("");
		lblGegner.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/player.PNG")));
		lblGegner.setBounds(0, 0, 15, 15);
		contentPane.add(lblGegner);
		
		JLabel lblfussballfeld = new JLabel("");
		lblfussballfeld.setIcon(new ImageIcon(BuildLevel.class.getResource("/Resources/fussballfeld.jpg")));
		lblfussballfeld.setBounds(0, 0, 550, 295);
		contentPane.add(lblfussballfeld);
		
		JLabel lblSpieler1 = new JLabel("Spieler 1:");
		lblSpieler1.setBounds(10, 307, 61, 16);
		contentPane.add(lblSpieler1);
		
		JLabel lblSpieler2 = new JLabel("Spieler 2:");
		lblSpieler2.setBounds(10, 335, 61, 16);
		contentPane.add(lblSpieler2);
		
		JLabel lblBarPly1 = new JLabel("");
		lblBarPly1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/green.PNG")));
		lblBarPly1.setBounds(81, 307, 50, 15);
		contentPane.add(lblBarPly1);
		
		JLabel lblBarPly2 = new JLabel("");
		lblBarPly2.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/green.PNG")));
		lblBarPly2.setBounds(81, 335, 50, 15);
		contentPane.add(lblBarPly2);
		
		lblEnemyFire = new JLabel ("");
		lblEnemyFire.setBounds(300, 300, 15, 10);
		lblEnemyFire.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblEnemyFire.setVisible(true);
		contentPane.add(lblEnemyFire);
		
		lblPlayerFire1 = new JLabel ("");
		lblPlayerFire1.setBounds(300, 300, 15, 10);
		lblPlayerFire1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblPlayerFire1.setVisible(true);
		contentPane.add(lblPlayerFire1);
		
	}
	
	
}