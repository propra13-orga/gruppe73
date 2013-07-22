package Network;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BuildLevel_Client extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static Timer_Client TimerC;
	public static JPanel contentPane;
	public static int newX;
	public static int newY;
	public static int newXgegner;
	public static int newYgegner;
	public static javax.swing.JLabel lblPlayer;
	public static javax.swing.JLabel lblGegner;
	public static javax.swing.JLabel lblEnemyFire;
	public static javax.swing.JLabel lblPlayerFire1;
	public static javax.swing.JLabel lblBarPly1;
	public static javax.swing.JLabel lblBarPly2;
	public static boolean PlayerFired = false;
	public static boolean PlayerFireActive = false;
	public static boolean GegnerFired = false;
	public static boolean GegnerFireActive = false;
	public static int PlayerFire1StartX;
	
	public static int PlayerEnergy = 4;
	public static int GegnerEnergy = 4;
	
	public static void repainter() {
		contentPane.repaint();
	}
	
	public static void main(String[] args) {
		final BuildLevel_Client frame = new BuildLevel_Client();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
        		frame.setVisible(true);
			}
		});	
	}
	
	public void setVisible(boolean value) {
		
		TimerC.start();
		
        super.setVisible(value);
	}
	
	public static void moveGegnerUP() {
		if (lblGegner.getY() > 0) {
			lblGegner.setBounds(lblGegner.getX(), (lblGegner.getY()-15), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	public static void moveGegnerDOWN() {
		if (lblGegner.getY() < 255) {
			lblGegner.setBounds(lblGegner.getX(), (lblGegner.getY()+15), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	public static void moveGegnerLEFT() {
		if (lblGegner.getX() > 0) {
			lblGegner.setBounds((lblGegner.getX()-15), lblGegner.getY(), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	public static void moveGegnerRIGHT() {
		if (lblGegner.getX() < 515) {
			lblGegner.setBounds((lblGegner.getX()+15), lblGegner.getY(), 30, 30);
			contentPane.repaint();
		}
		
	}
	
	public static void PlayerSchaden() {
		PlayerEnergy = PlayerEnergy-1;
		if (PlayerEnergy >= 4) {
			lblBarPly1.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/green.PNG")));
			contentPane.repaint();
		} else if (PlayerEnergy == 3) {
			lblBarPly1.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/yellow1.PNG")));
			contentPane.repaint();
		} else if (PlayerEnergy == 2) {
			lblBarPly1.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/yellow2.PNG")));
			contentPane.repaint();
		} else if (PlayerEnergy == 1) {
			lblBarPly1.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/red.PNG")));
			contentPane.repaint();
		} else if (PlayerEnergy == 0) {
			//GameOver();
		}
	}
	
	public static void GegnerSchaden() {
		GegnerEnergy = GegnerEnergy-1;
		if (GegnerEnergy >= 4) {
			lblBarPly2.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/green.PNG")));
			contentPane.repaint();
		} else if (GegnerEnergy == 3) {
			lblBarPly2.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/yellow1.PNG")));
			contentPane.repaint();
		} else if (GegnerEnergy == 2) {
			lblBarPly2.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/yellow2.PNG")));
			contentPane.repaint();
		} else if (GegnerEnergy == 1) {
			lblBarPly2.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/red.PNG")));
			contentPane.repaint();
		} else if (GegnerEnergy == 0) {
			//GameOver();
		}
	}
	
	public static void CommitMovementToServer () {
		
		Chat.player2movement(ZU(lblPlayer.getX())+ZU(lblPlayer.getY()));
		
	}
	
	public static void movePlayerEXT (int Xcoord, int Ycoord) {
		
		newX = Xcoord;
		newY = Ycoord;
	
		lblPlayer.setBounds(newX, newY, lblPlayer.getX(), lblPlayer.getY());
		
		contentPane.repaint();
		
	}
	
	public static String ZU(int Eingabe) {
		String Verarbeitung = ""+Eingabe;
		String Ausgabe;
		
		if (Verarbeitung.length() == 1) {
			Ausgabe = "00" + Verarbeitung;
		} else if (Verarbeitung.length() == 2) {
			Ausgabe = "0"+ Verarbeitung;
		} else {
			Ausgabe = Verarbeitung;
		}
		
		return Ausgabe;
	}
	
	public BuildLevel_Client() {
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        	moveGegnerLEFT();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		        	moveGegnerRIGHT();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_UP) {
		        	moveGegnerUP();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		        	moveGegnerDOWN();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_C) {
		        	//WaffeWechseln(null);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_F) {
		        	GegnerFireActive = true;
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
		setTitle("BuildLevel - Client Version 1.0");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/Resources/player2.PNG")));
		lblPlayer.setBounds(60, 135, 30, 30);
		contentPane.add(lblPlayer);
		
		lblGegner = new JLabel("");
		lblGegner.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/Resources/player2.PNG")));
		lblGegner.setBounds(465, 135, 30, 30);
		contentPane.add(lblGegner);
		
		JLabel lblSpieler1 = new JLabel("Spieler 1:");
		lblSpieler1.setBounds(10, 307, 61, 16);
		contentPane.add(lblSpieler1);
		
		JLabel lblSpieler2 = new JLabel("Spieler 2:");
		lblSpieler2.setBounds(10, 335, 61, 16);
		contentPane.add(lblSpieler2);
		
		lblBarPly1 = new JLabel("");
		lblBarPly1.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/green.PNG")));
		lblBarPly1.setBounds(81, 307, 50, 15);
		contentPane.add(lblBarPly1);
		
		lblBarPly2 = new JLabel("");
		lblBarPly2.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/green.PNG")));
		lblBarPly2.setBounds(81, 335, 50, 15);
		contentPane.add(lblBarPly2);
		
		lblEnemyFire = new JLabel ("");
		lblEnemyFire.setBounds(300, 300, 15, 10);
		lblEnemyFire.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblEnemyFire.setVisible(true);
		contentPane.add(lblEnemyFire);
		
		lblPlayerFire1 = new JLabel ("");
		lblPlayerFire1.setBounds(300, 300, 15, 10);
		lblPlayerFire1.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblPlayerFire1.setVisible(true);
		contentPane.add(lblPlayerFire1);
		
		JLabel lblfussballfeld = new JLabel("");
		lblfussballfeld.setIcon(new ImageIcon(BuildLevel_Client.class.getResource("/Resources/fussballfeld.jpg")));
		lblfussballfeld.setBounds(0, 0, 550, 295);
		contentPane.add(lblfussballfeld);
		
		TimerC = new Timer_Client() {
			
			public void Fuschi() {
				
			}
			
		};
		
	}

}
