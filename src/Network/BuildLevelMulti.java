package Network;



	/**
	 * @param args
	 */
	
	import java.awt.Color;


import dungeoncrawler.Player;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dungeoncrawler.BuildLevel;
import dungeoncrawler.CollisionControl;
import dungeoncrawler.LevelControl;
import dungeoncrawler.LoadLevel;
import dungeoncrawler.MovementListener;
import dungeoncrawler.Treasure;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


	// ###################################################
	// Diese Klasse bildet die Mainmethode des Spiels!
	// ###################################################

	
	public class BuildLevelMulti {	

		// ##############
				// DEKLARATIONEN:
				// ##############
				
				private static JPanel Content;
				private static MovementListener mListener;
				
				// ZUSTÄNDE (INTEGER):
				// ###################
				
				public static int Current_Level = 1;
				public static int level_load = 1;
				public static boolean SavePointLoad = false;
				public static boolean game_over = false;
				public static boolean change_level_phase = false;
				
				// ZUSTÄNDE (BOOLEAN):
				// ###################
				
				public static boolean first_load = true;

				// LABEL-DECLARATIONS:
				// ###################
				
				public static javax.swing.JLabel lblPlayer;
				private static javax.swing.JLabel lblPunkteanzeige;
				public static javax.swing.JLabel lblAktuelleWaffe;
				private static javax.swing.JLabel lblGameOver;
				private static javax.swing.JLabel lblNeustart;
				public static javax.swing.JLabel lblItem1;
				public static javax.swing.JLabel lblItem2;
				public static javax.swing.JLabel lblItem3;
				public static javax.swing.JLabel lblItem4;
				public static javax.swing.JLabel lblEnemyFire;
				public static javax.swing.JLabel lblPergament;
				public static javax.swing.JLabel lblCurrentLevel;
				public static javax.swing.JLabel lblRuestungAnzeige;
				
				// PLAYER-FIRE:
				// ############
				
				public static javax.swing.JLabel lblPlayerFire1;
				public static javax.swing.JLabel lblPlayerFire2;
				public static javax.swing.JLabel lblPlayerFire3;
				public static javax.swing.JLabel lblPlayerFire4;
				
				// Inventar:
				// =========
				
				public static javax.swing.JLabel lblMana;
				public static javax.swing.JLabel lblSchwert;
				public static javax.swing.JLabel lblBogen;
				public static javax.swing.JLabel lblPfeil;
				public static javax.swing.JLabel lblRuestung;
				public static javax.swing.JLabel lblMedikit;
				public static javax.swing.JLabel lblLebensanzeige;
				public static javax.swing.JLabel lblPowerAnzeige;
				public static javax.swing.JLabel lblYouDied;
				public static javax.swing.JLabel lblYouDied2;
				public static javax.swing.JLabel lblCheckpoint;
				
				
				// Labels für das Spielfeld:
				// #########################
				
				private static javax.swing.JLabel lvlA1;
				private static javax.swing.JLabel lvlA2;
				private static javax.swing.JLabel lvlA3;
				private static javax.swing.JLabel lvlA4;
				private static javax.swing.JLabel lvlA5;
				private static javax.swing.JLabel lvlA6;
				private static javax.swing.JLabel lvlA7;
				private static javax.swing.JLabel lvlA8;
				private static javax.swing.JLabel lvlA9;
				private static javax.swing.JLabel lvlA10;
				private static javax.swing.JLabel lvlA11;
				private static javax.swing.JLabel lvlA12;
				private static javax.swing.JLabel lvlA13;
				private static javax.swing.JLabel lvlA14;
				private static javax.swing.JLabel lvlA15;
				private static javax.swing.JLabel lvlA16;
				private static javax.swing.JLabel lvlA17;
				private static javax.swing.JLabel lvlA18;
				private static javax.swing.JLabel lvlA19;
				private static javax.swing.JLabel lvlA20;
				
				private static javax.swing.JLabel lvlB1;
				private static javax.swing.JLabel lvlB2;
				private static javax.swing.JLabel lvlB3;
				private static javax.swing.JLabel lvlB4;
				private static javax.swing.JLabel lvlB5;
				private static javax.swing.JLabel lvlB6;
				private static javax.swing.JLabel lvlB7;
				private static javax.swing.JLabel lvlB8;
				private static javax.swing.JLabel lvlB9;
				private static javax.swing.JLabel lvlB10;
				private static javax.swing.JLabel lvlB11;
				private static javax.swing.JLabel lvlB12;
				private static javax.swing.JLabel lvlB13;
				private static javax.swing.JLabel lvlB14;
				private static javax.swing.JLabel lvlB15;
				private static javax.swing.JLabel lvlB16;
				private static javax.swing.JLabel lvlB17;
				private static javax.swing.JLabel lvlB18;
				private static javax.swing.JLabel lvlB19;
				private static javax.swing.JLabel lvlB20;
				
				private static javax.swing.JLabel lvlC1;
				private static javax.swing.JLabel lvlC2;
				private static javax.swing.JLabel lvlC3;
				private static javax.swing.JLabel lvlC4;
				private static javax.swing.JLabel lvlC5;
				private static javax.swing.JLabel lvlC6;
				private static javax.swing.JLabel lvlC7;
				private static javax.swing.JLabel lvlC8;
				private static javax.swing.JLabel lvlC9;
				private static javax.swing.JLabel lvlC10;
				private static javax.swing.JLabel lvlC11;
				private static javax.swing.JLabel lvlC12;
				private static javax.swing.JLabel lvlC13;
				private static javax.swing.JLabel lvlC14;
				private static javax.swing.JLabel lvlC15;
				private static javax.swing.JLabel lvlC16;
				private static javax.swing.JLabel lvlC17;
				private static javax.swing.JLabel lvlC18;
				private static javax.swing.JLabel lvlC19;
				private static javax.swing.JLabel lvlC20;
				
				private static javax.swing.JLabel lvlD1;
				private static javax.swing.JLabel lvlD2;
				private static javax.swing.JLabel lvlD3;
				private static javax.swing.JLabel lvlD4;
				private static javax.swing.JLabel lvlD5;
				private static javax.swing.JLabel lvlD6;
				private static javax.swing.JLabel lvlD7;
				private static javax.swing.JLabel lvlD8;
				private static javax.swing.JLabel lvlD9;
				private static javax.swing.JLabel lvlD10;
				private static javax.swing.JLabel lvlD11;
				private static javax.swing.JLabel lvlD12;
				private static javax.swing.JLabel lvlD13;
				private static javax.swing.JLabel lvlD14;
				private static javax.swing.JLabel lvlD15;
				private static javax.swing.JLabel lvlD16;
				private static javax.swing.JLabel lvlD17;
				private static javax.swing.JLabel lvlD18;
				private static javax.swing.JLabel lvlD19;
				private static javax.swing.JLabel lvlD20;
				
				private static javax.swing.JLabel lvlE1;
				private static javax.swing.JLabel lvlE2;
				private static javax.swing.JLabel lvlE3;
				private static javax.swing.JLabel lvlE4;
				private static javax.swing.JLabel lvlE5;
				private static javax.swing.JLabel lvlE6;
				private static javax.swing.JLabel lvlE7;
				private static javax.swing.JLabel lvlE8;
				private static javax.swing.JLabel lvlE9;
				private static javax.swing.JLabel lvlE10;
				private static javax.swing.JLabel lvlE11;
				private static javax.swing.JLabel lvlE12;
				private static javax.swing.JLabel lvlE13;
				private static javax.swing.JLabel lvlE14;
				private static javax.swing.JLabel lvlE15;
				private static javax.swing.JLabel lvlE16;
				private static javax.swing.JLabel lvlE17;
				private static javax.swing.JLabel lvlE18;
				private static javax.swing.JLabel lvlE19;
				private static javax.swing.JLabel lvlE20;
				
				private static javax.swing.JLabel lvlF1;
				private static javax.swing.JLabel lvlF2;
				private static javax.swing.JLabel lvlF3;
				private static javax.swing.JLabel lvlF4;
				private static javax.swing.JLabel lvlF5;
				private static javax.swing.JLabel lvlF6;
				private static javax.swing.JLabel lvlF7;
				private static javax.swing.JLabel lvlF8;
				private static javax.swing.JLabel lvlF9;
				private static javax.swing.JLabel lvlF10;
				private static javax.swing.JLabel lvlF11;
				private static javax.swing.JLabel lvlF12;
				private static javax.swing.JLabel lvlF13;
				private static javax.swing.JLabel lvlF14;
				private static javax.swing.JLabel lvlF15;
				private static javax.swing.JLabel lvlF16;
				private static javax.swing.JLabel lvlF17;
				private static javax.swing.JLabel lvlF18;
				private static javax.swing.JLabel lvlF19;
				private static javax.swing.JLabel lvlF20;
				
				private static javax.swing.JLabel lvlG1;
				private static javax.swing.JLabel lvlG2;
				private static javax.swing.JLabel lvlG3;
				private static javax.swing.JLabel lvlG4;
				private static javax.swing.JLabel lvlG5;
				private static javax.swing.JLabel lvlG6;
				private static javax.swing.JLabel lvlG7;
				private static javax.swing.JLabel lvlG8;
				private static javax.swing.JLabel lvlG9;
				private static javax.swing.JLabel lvlG10;
				private static javax.swing.JLabel lvlG11;
				private static javax.swing.JLabel lvlG12;
				private static javax.swing.JLabel lvlG13;
				private static javax.swing.JLabel lvlG14;
				private static javax.swing.JLabel lvlG15;
				private static javax.swing.JLabel lvlG16;
				private static javax.swing.JLabel lvlG17;
				private static javax.swing.JLabel lvlG18;
				private static javax.swing.JLabel lvlG19;
				private static javax.swing.JLabel lvlG20;
				
				private static javax.swing.JLabel lvlH1;
				private static javax.swing.JLabel lvlH2;
				private static javax.swing.JLabel lvlH3;
				private static javax.swing.JLabel lvlH4;
				private static javax.swing.JLabel lvlH5;
				private static javax.swing.JLabel lvlH6;
				private static javax.swing.JLabel lvlH7;
				private static javax.swing.JLabel lvlH8;
				private static javax.swing.JLabel lvlH9;
				private static javax.swing.JLabel lvlH10;
				private static javax.swing.JLabel lvlH11;
				private static javax.swing.JLabel lvlH12;
				private static javax.swing.JLabel lvlH13;
				private static javax.swing.JLabel lvlH14;
				private static javax.swing.JLabel lvlH15;
				private static javax.swing.JLabel lvlH16;
				private static javax.swing.JLabel lvlH17;
				private static javax.swing.JLabel lvlH18;
				private static javax.swing.JLabel lvlH19;
				private static javax.swing.JLabel lvlH20;
				
				private static javax.swing.JLabel lvlI1;
				private static javax.swing.JLabel lvlI2;
				private static javax.swing.JLabel lvlI3;
				private static javax.swing.JLabel lvlI4;
				private static javax.swing.JLabel lvlI5;
				private static javax.swing.JLabel lvlI6;
				private static javax.swing.JLabel lvlI7;
				private static javax.swing.JLabel lvlI8;
				private static javax.swing.JLabel lvlI9;
				private static javax.swing.JLabel lvlI10;
				private static javax.swing.JLabel lvlI11;
				private static javax.swing.JLabel lvlI12;
				private static javax.swing.JLabel lvlI13;
				private static javax.swing.JLabel lvlI14;
				private static javax.swing.JLabel lvlI15;
				private static javax.swing.JLabel lvlI16;
				private static javax.swing.JLabel lvlI17;
				private static javax.swing.JLabel lvlI18;
				private static javax.swing.JLabel lvlI19;
				private static javax.swing.JLabel lvlI20;
				
				
				private static javax.swing.JLabel lvlJ1;
				private static javax.swing.JLabel lvlJ2;
				private static javax.swing.JLabel lvlJ3;
				private static javax.swing.JLabel lvlJ4;
				private static javax.swing.JLabel lvlJ5;
				private static javax.swing.JLabel lvlJ6;
				private static javax.swing.JLabel lvlJ7;
				private static javax.swing.JLabel lvlJ8;
				private static javax.swing.JLabel lvlJ9;
				private static javax.swing.JLabel lvlJ10;
				private static javax.swing.JLabel lvlJ11;
				private static javax.swing.JLabel lvlJ12;
				private static javax.swing.JLabel lvlJ13;
				private static javax.swing.JLabel lvlJ14;
				private static javax.swing.JLabel lvlJ15;
				private static javax.swing.JLabel lvlJ16;
				private static javax.swing.JLabel lvlJ17;
				private static javax.swing.JLabel lvlJ18;
				private static javax.swing.JLabel lvlJ19;
				private static javax.swing.JLabel lvlJ20;
				
				private static javax.swing.JLabel lvlK1;
				private static javax.swing.JLabel lvlK2;
				private static javax.swing.JLabel lvlK3;
				private static javax.swing.JLabel lvlK4;
				private static javax.swing.JLabel lvlK5;
				private static javax.swing.JLabel lvlK6;
				private static javax.swing.JLabel lvlK7;
				private static javax.swing.JLabel lvlK8;
				private static javax.swing.JLabel lvlK9;
				private static javax.swing.JLabel lvlK10;
				private static javax.swing.JLabel lvlK11;
				private static javax.swing.JLabel lvlK12;
				private static javax.swing.JLabel lvlK13;
				private static javax.swing.JLabel lvlK14;
				private static javax.swing.JLabel lvlK15;
				private static javax.swing.JLabel lvlK16;
				private static javax.swing.JLabel lvlK17;
				private static javax.swing.JLabel lvlK18;
				private static javax.swing.JLabel lvlK19;
				private static javax.swing.JLabel lvlK20;
				
				private static javax.swing.JLabel lvlL1;
				private static javax.swing.JLabel lvlL2;
				private static javax.swing.JLabel lvlL3;
				private static javax.swing.JLabel lvlL4;
				private static javax.swing.JLabel lvlL5;
				private static javax.swing.JLabel lvlL6;
				private static javax.swing.JLabel lvlL7;
				private static javax.swing.JLabel lvlL8;
				private static javax.swing.JLabel lvlL9;
				private static javax.swing.JLabel lvlL10;
				private static javax.swing.JLabel lvlL11;
				private static javax.swing.JLabel lvlL12;
				private static javax.swing.JLabel lvlL13;
				private static javax.swing.JLabel lvlL14;
				private static javax.swing.JLabel lvlL15;
				private static javax.swing.JLabel lvlL16;
				private static javax.swing.JLabel lvlL17;
				private static javax.swing.JLabel lvlL18;
				private static javax.swing.JLabel lvlL19;
				private static javax.swing.JLabel lvlL20;
				
				private static javax.swing.JLabel lvlM1;
				private static javax.swing.JLabel lvlM2;
				private static javax.swing.JLabel lvlM3;
				private static javax.swing.JLabel lvlM4;
				private static javax.swing.JLabel lvlM5;
				private static javax.swing.JLabel lvlM6;
				private static javax.swing.JLabel lvlM7;
				private static javax.swing.JLabel lvlM8;
				private static javax.swing.JLabel lvlM9;
				private static javax.swing.JLabel lvlM10;
				private static javax.swing.JLabel lvlM11;
				private static javax.swing.JLabel lvlM12;
				private static javax.swing.JLabel lvlM13;
				private static javax.swing.JLabel lvlM14;
				private static javax.swing.JLabel lvlM15;
				private static javax.swing.JLabel lvlM16;
				private static javax.swing.JLabel lvlM17;
				private static javax.swing.JLabel lvlM18;
				private static javax.swing.JLabel lvlM19;
				private static javax.swing.JLabel lvlM20;
				
				private static javax.swing.JLabel lvlN1;
				private static javax.swing.JLabel lvlN2;
				private static javax.swing.JLabel lvlN3;
				private static javax.swing.JLabel lvlN4;
				private static javax.swing.JLabel lvlN5;
				private static javax.swing.JLabel lvlN6;
				private static javax.swing.JLabel lvlN7;
				private static javax.swing.JLabel lvlN8;
				private static javax.swing.JLabel lvlN9;
				private static javax.swing.JLabel lvlN10;
				private static javax.swing.JLabel lvlN11;
				private static javax.swing.JLabel lvlN12;
				private static javax.swing.JLabel lvlN13;
				private static javax.swing.JLabel lvlN14;
				private static javax.swing.JLabel lvlN15;
				private static javax.swing.JLabel lvlN16;
				private static javax.swing.JLabel lvlN17;
				private static javax.swing.JLabel lvlN18;
				private static javax.swing.JLabel lvlN19;
				private static javax.swing.JLabel lvlN20;
				
				private static javax.swing.JLabel lvlO1;
				private static javax.swing.JLabel lvlO2;
				private static javax.swing.JLabel lvlO3;
				private static javax.swing.JLabel lvlO4;
				private static javax.swing.JLabel lvlO5;
				private static javax.swing.JLabel lvlO6;
				private static javax.swing.JLabel lvlO7;
				private static javax.swing.JLabel lvlO8;
				private static javax.swing.JLabel lvlO9;
				private static javax.swing.JLabel lvlO10;
				private static javax.swing.JLabel lvlO11;
				private static javax.swing.JLabel lvlO12;
				private static javax.swing.JLabel lvlO13;
				private static javax.swing.JLabel lvlO14;
				private static javax.swing.JLabel lvlO15;
				private static javax.swing.JLabel lvlO16;
				private static javax.swing.JLabel lvlO17;
				private static javax.swing.JLabel lvlO18;
				private static javax.swing.JLabel lvlO19;
				private static javax.swing.JLabel lvlO20;
				
				// PLAYER-STANDARDPOSITION:
				// ########################
				
				public static int newY = 225;
			    public static int newX = 30;
				
			    // ENEMY-STANDARDPOSITION:
			    // =======================
			    
			    public static int EnemyPosY = 120;
			    public static int EnemyStdPosY = 120;
			    public static int EnemyFirePos = 195;
			    public static int EnemyStdFirePos = 195;	
			    
			    
				public static void main(String[] args) {
					// TODO Auto-generated method stub
				final BuildLevelMulti m = new BuildLevelMulti();
				javax.swing.SwingUtilities.invokeLater(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						m.setVisible(true);
					}
					
				});
	}


				public void setVisible(boolean value) {
					// TODO Auto-generated method stub
					if(value == true){
						this.addKeyListener(mListener);
						mListener.start();
					}else{
						mListener.end();
						this.removeKeyListener(mListener);
					}
					super.setVisible(value);
				


				mListener = new MovementListener(){

					@Override
					public void doMovement(int left, int right, int up, int down) {
						// TODO Auto-generated method stub
						java.awt.Rectangle pos = lblPlayer.getBounds();
						newX = pos.x + left + right;  
						newY = pos.y + up + down; 
					}
					
				};
				
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        //lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
                        //lblTreasure.setBounds(Treasure.buildTreasureX(), Treasure.buildTreasureY(), 15, 15);
                    }
                });
				          	
                //}
            	
            //}
            
            


            
			lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
		}


				private void removeKeyListener(MovementListener mListener2) {
					// TODO Auto-generated method stub
					
				}


				private void addKeyListener(MovementListener mListener2) {
					// TODO Auto-generated method stub
					
				}
		
	
	
	
	
	
	public static void WaffeLabel(String args[]) {
		if (Player.AktuelleWaffe == 'A') {
			lblPlayerFire1.setIcon(new ImageIcon(BuildLevelMulti.class.getResource("/dungeoncrawler/pfeilfire.PNG")));
		} else if (Player.AktuelleWaffe == 'M') {
			lblPlayerFire1.setIcon(new ImageIcon(BuildLevelMulti.class.getResource("/dungeoncrawler/manafire.PNG")));
		} else if (Player.AktuelleWaffe == 'C') {
			lblPlayerFire1.setIcon(new ImageIcon(BuildLevelMulti.class.getResource("/dungeoncrawler/swordfire.PNG")));
		}
	}
	
	public static int getCurrentPlayerPos(int XY) {
		int Pos = 0;
		if (XY == 0) {
			Pos = lblPlayer.getX();
		} else if (XY == 1) {
			Pos = lblPlayer.getY();
		}
		return Pos;
	} 
	
public static void checkPower(String args[]) {
		
		if (Player.PlayerPower >= 4) {
			lblPowerAnzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/green.PNG")));
			lblRuestungAnzeige.setVisible(false);
			Content.repaint();
		} else if (Player.PlayerPower == 3) {
			lblPowerAnzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/yellow1.PNG")));
			lblRuestungAnzeige.setVisible(false);
			Content.repaint();
		} else if (Player.PlayerPower == 2) {
			lblPowerAnzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/yellow2.PNG")));
			lblRuestungAnzeige.setVisible(false);
			Content.repaint();
		} else if (Player.PlayerPower == 1) {
			lblPowerAnzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/red.PNG")));
			lblRuestungAnzeige.setVisible(false);
			Content.repaint();
		} else if (Player.PlayerPower <= 0) {
			if (Player.Lives == 1) {
				
				
				Player.Arrow = 0;
				Player.Bow = 0;
				Player.PlayerSword = 0;
				Player.Manadrinks = 0;
				Player.Medikit = 0;
				Player.suitofarmor = 0;
				
				lblPowerAnzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/white.PNG")));
				
				lblGameOver.setVisible(true);
				lblNeustart.setVisible(true);
				lblNeustart.setEnabled(true);
				LevelControl.SavePoint = false;
				LevelControl.SaveLevel = 1;
				LevelControl.spinne_alive = false;
				LevelControl.drache_alive = false;
				LevelControl.hexe_alive = false;
				MovementListener.stopFlag = true;
				MovementListener.moveUp = false;
				MovementListener.moveDown = false;
				
				Content.repaint();
				
				
				
				
				game_over = true;
			}  else if (Player.Lives > 1) {
				
				if (LevelControl.SavePoint == true) {
					SavePointLoad = true;
					Player.PlayerPower = 4;
					lblYouDied.setVisible(true);
					lblYouDied2.setVisible(true);
					Player.Lives = Player.Lives-1;
					BuildLevel.change_level_phase = true;
					//MovementListener.stopFlag = true;
					BuildLevel.neuesLevel(null);
					System.out.println("Tot!!! ---> Back to CheckPoint.");
				} else {
					Player.PlayerPower = 4;
					lblYouDied.setVisible(true);
					lblYouDied2.setVisible(true);
					Player.Lives = Player.Lives-1;
					BuildLevel.change_level_phase = true;
					//MovementListener.stopFlag = true;

					System.out.println("Tot!!! ---> Back to 1st Level");
				}
				
				
			}
		}
		
	}

	public static void GameOver(int DamageType) {
		
		/*
		 *  DAMAGE - Types:
		 *  
		 *  5: sofort tot
		 *  3: 1 Schadenspunkt
		 *  1: 2 Schadenspunkte
		 */
		
		if (DamageType == 5) {
			Player.PlayerPower = Player.PlayerPower-10;
		} else if (DamageType == 3) {
			Player.PlayerPower = Player.PlayerPower-1;
		} else if (DamageType == 1) {
			Player.PlayerPower = Player.PlayerPower-2;
		}
		
		checkPower(null);
				
		
		
	}
	
	public BuildLevelMulti() {
		setResizable(false);
		
		//create Jframe and Grid
		
		setTitle("Dungeon Crawler - Level "+Current_Level);
		setDefaultCloseOperation(BuildLevel.DO_NOTHING_ON_CLOSE);
		setBounds(300, 300, 306, 372);
		Content = new JPanel();
		Content.setBackground(Color.WHITE);
		Content.setBorder(null);
		setContentPane(Content);
		Content.setLayout(null);
	
}
/**sinn?**/

	private void setContentPane(JPanel content2) {
		// TODO Auto-generated method stub
		
	}


	private void setBounds(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}


	private void setDefaultCloseOperation(int doNothingOnClose) {
		// TODO Auto-generated method stub
		
	}


	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}


	private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	
	
	// NEUSTART-Button
	
	lblNeustart = new JLabel ("");
	lblNeustart.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			Player.PlayerPower = 4;
			Current_Level = 1;
			game_over = false;
			MovementListener.stopFlag = false;
			newY = 225;
        	newX = 30;
			
			change_level_phase = false;
			level_load = 1;
			first_load = true;
			
        	lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
			main(null);
			dispose();
		}
	});
	lblNeustart.setBounds(50, 150, 200, 50);
	lblNeustart.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/restart.PNG")));
	lblNeustart.setEnabled(false);
	lblNeustart.setVisible(false);
	Content.add(lblNeustart);
	
	
	
	// Inventar:
			// =========
			
			lblMana = new JLabel ("0 ");
			lblMana.setBounds(20 ,295, 50, 15);
			lblMana.setForeground(Color.WHITE);
			lblMana.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/Mana.PNG")));
			lblMana.setVisible(true);
			Content.add(lblMana);
			
			lblSchwert = new JLabel ("0 ");
			lblSchwert.setBounds(60 ,295, 50, 15);
			lblSchwert.setForeground(Color.WHITE);
			lblSchwert.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/Sword.PNG")));
			lblSchwert.setVisible(true);
			Content.add(lblSchwert);
			
			lblBogen = new JLabel ("0 ");
			lblBogen.setBounds(100 ,295, 50, 15);
			lblBogen.setForeground(Color.WHITE);
			lblBogen.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/bogen.PNG")));
			lblBogen.setVisible(true);
			Content.add(lblBogen);
			
			lblPfeil = new JLabel ("0 ");
			lblPfeil.setBounds(140 ,295, 50, 15);
			lblPfeil.setForeground(Color.WHITE);
			lblPfeil.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/pfeil1.PNG")));
			lblPfeil.setVisible(true);
			Content.add(lblPfeil);
			
			lblRuestung = new JLabel ("0 ");
			lblRuestung.setBounds(180 ,295, 50, 15);
			lblRuestung.setForeground(Color.WHITE);
			lblRuestung.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/ruestung.PNG")));
			lblRuestung.setVisible(true);
			Content.add(lblRuestung);
			
			// Label für die Anzeige der Rüstung im Inventar
			lblRuestungAnzeige  = new JLabel("");
			lblRuestungAnzeige.setIcon(new ImageIcon(Shop.class.getResource("/dungeoncrawler/ruestung.PNG")));
			lblRuestungAnzeige.setBounds(265, 265, 50, 15);	
			lblRuestungAnzeige.setVisible(false);
			Content.add(lblRuestungAnzeige);
			
			lblMedikit = new JLabel ("0 ");
			lblMedikit.setBounds(220 ,295, 50, 15);
			lblMedikit.setForeground(Color.WHITE);
			lblMedikit.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/Medikit.PNG")));
			lblMedikit.setVisible(true);
			Content.add(lblMedikit);
			
			lblPowerAnzeige = new JLabel ("");
			lblPowerAnzeige.setBounds(233, 265, 50, 15);
			lblPowerAnzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/green.PNG")));
			lblPowerAnzeige.setVisible(true);
			Content.add(lblPowerAnzeige);
			
			lblCheckpoint = new JLabel ("Check Point gespeichert...");
			lblCheckpoint.setBounds(20, 313, 200, 15);
			lblCheckpoint.setForeground(Color.WHITE);
			lblCheckpoint.setVisible(false);
			Content.add(lblCheckpoint);
			
			
			lblPergament = new JLabel("");
			lblPergament.setBounds(0, 240, 300, 100);
			lblPergament.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/pergament.PNG")));
			Content.add(lblPergament);
			
			
			//LEBENSANZEIGE
			
			lblLebensanzeige = new JLabel("1 ");
			lblLebensanzeige.setForeground(Color.BLACK);
			lblLebensanzeige.setBackground(Color.WHITE);
			lblLebensanzeige.setBounds(250, 0, 50, 15);
			lblLebensanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/heart.PNG")));
			lblLebensanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
			Content.add(lblLebensanzeige);
			
			lblAktuelleWaffe = new JLabel("");
			lblAktuelleWaffe.setBounds(150, 0, 15, 15);
			lblAktuelleWaffe.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/keineWaffe.PNG")));
			lblAktuelleWaffe.setVisible(true);
			Content.add(lblAktuelleWaffe);
			
			//Punkteanzeige
			
			lblPunkteanzeige = new JLabel(Player.CurrentPoints+" ");
			lblPunkteanzeige.setForeground(Color.BLACK);
			lblPunkteanzeige.setBackground(Color.WHITE);
			lblPunkteanzeige.setBounds(210, 0, 90, 15);
			lblPunkteanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/points.PNG")));
			//lblPunkteanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
			Content.add(lblPunkteanzeige);
	
}


	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}