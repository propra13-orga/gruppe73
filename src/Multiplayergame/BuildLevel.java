package Multiplayergame;



import java.awt.Color;


import dungeoncrawler.Player;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Multiplayergame.LoadLevel;
import Multiplayergame.Treasure;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BuildLevel extends JFrame {
	/**
	 * 
	 * Diese Klasse bildet die Mainmethode des Spiels!
	 * Sie definiert die Labels für ds Spielfeld, die Standardposition des Players, die Position des Schatzes etc. Des weiteren werden
	 * KeyListener und Positionsabfragen definiert.
	 * */
	
	// ##############
	// DEKLARATIONEN:
	// ##############
	
	private static JPanel Content;
	private static final long serialVersionUID = 1L;
	private static MovementListener mListener;
	
	// ZUSTÄNDE (INTEGER):
	// ###################
	
	public static int Current_Level = 1;
	public static int level_load = 1;
	public static boolean SavePointLoad = false;
	
	// ZUSTÄNDE (BOOLEAN):
	// ###################
	
	public static boolean first_load = true;
	public static boolean got_treasure = false;
	public static boolean stop_treasure = false;
	public static boolean change_level_exitX = false;
	public static boolean change_level_exitY = false;
	public static boolean game_over = false;
	public static boolean change_level_phase = false;
	
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
	

	
	/**
	 * Player Standardposition
	 */
	
	public static int newY = 225;
    public static int newX = 30;
    
    /**
     * Treasure Standardposition
     */
    
    public static int treasureX = 300;
    public static int treasureY = 15;
    
   /**
    * Enemy Standardposition
    */
    
    public static int EnemyPosY = 120;
    public static int EnemyStdPosY = 120;
    public static int EnemyFirePos = 195;
    public static int EnemyStdFirePos = 195;
    

    // MAIN-METHODE:
    // =============
    
	public static void main(String[] args) {
		final BuildLevel m = new BuildLevel();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
        		m.setVisible(true);
			}
		});
		
	}

	/**
	 * Hier wird das JFrame auf Visible gesetzt und ein KeyListener hinzu gefügt
	 * 
	 */
	
	@Override
    public void setVisible(boolean value) {
        if (value == true) {
            this.addKeyListener(mListener);
            mListener.start();
        } else {
            mListener.end();
            this.removeKeyListener(mListener);
        }
        super.setVisible(value);
	}
	
	public static void ShopSchliessen(String args[]) {
		
		java.awt.Rectangle pos = lblPlayer.getBounds();
		newX = pos.x;  
		newY = pos.y + 15; 
		lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
		lblPunkteanzeige.setText(Player.CurrentPoints+" ");
		Content.repaint();
	}
	
	//Schließen des NPC Fensters
		public static void StoryNPCSchliessen(String args[]) {
			
			if (Current_Level == 1) {
				java.awt.Rectangle pos = lblPlayer.getBounds();
				newX = pos.x;  
				newY = pos.y -15; 
				lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
				lblPunkteanzeige.setText(Player.CurrentPoints+" ");
				Content.repaint();
			} else if (Current_Level == 5) {
				java.awt.Rectangle pos = lblPlayer.getBounds();
				newX = pos.x + 15;  
				newY = pos.y; 
				lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
				lblPunkteanzeige.setText(Player.CurrentPoints+" ");
				Content.repaint();
			} else if (Current_Level == 11) {
				java.awt.Rectangle pos = lblPlayer.getBounds();
				newX = pos.x -15;  
				newY = pos.y; 
				lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
				lblPunkteanzeige.setText(Player.CurrentPoints+" ");
				Content.repaint();
			} else if (Current_Level == 13) {
				java.awt.Rectangle pos = lblPlayer.getBounds();
				newX = pos.x;  
				newY = pos.y +15; 
				lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
				lblPunkteanzeige.setText(Player.CurrentPoints+" ");
				Content.repaint();
			}
			
		}
	/**
	 * Abfrage der aktuellen Waffe
	 * 	
	 */
	public static void WaffeLabel(String args[]) {
			if (Player.AktuelleWaffe == 'A') {
				lblPlayerFire1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/pfeilfire.PNG")));
			} else if (Player.AktuelleWaffe == 'M') {
				lblPlayerFire1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/manafire.PNG")));
			} else if (Player.AktuelleWaffe == 'C') {
				lblPlayerFire1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/swordfire.PNG")));
			}
	}
	/**
	 * Methode zur Bewegung des Gegners
	 * 
	 */
	public static void moveEnemyUp(String args[]) {
		
		EnemyPosY = EnemyPosY-3;
		lblItem1.setBounds(BuildLevel.lblItem1.getX(), EnemyPosY, 30, 30);
		System.out.println("Move enemy up" + EnemyPosY);
		Content.repaint();
	}
	
	public static void moveEnemyDown(String args[]) {
		EnemyPosY = EnemyPosY+3;
		lblItem1.setBounds(BuildLevel.lblItem1.getX(), EnemyPosY, 30, 30);
		System.out.println("Move enemy down");
		Content.repaint();
	}
	
	public static void EnemyFire(String args[]) {
		/*if (lblItem1.getY() == 120) {
			lblEnemyFire.setBounds(EnemyFirePos, 120, 15, 10);
			*/
		EnemyFirePos = EnemyFirePos-15;
		lblEnemyFire.setBounds(EnemyFirePos, lblEnemyFire.getY(), 15, 10);
		if (lblItem1.getY() == 150) {
			EnemyFirePos = EnemyStdFirePos;
			lblEnemyFire.setBounds(EnemyFirePos, 165, 15, 10);
		} else if (lblItem1.getY() == 90) {
			EnemyFirePos = EnemyStdFirePos;
			lblEnemyFire.setBounds(EnemyFirePos, 105, 15, 10);
		} else if (lblItem1.getY() == 120) {
			EnemyFirePos = EnemyStdFirePos;
			lblEnemyFire.setBounds(EnemyFirePos, 135, 15, 10);
		}
		
		if (lblPlayer.getX() == lblEnemyFire.getX()) {
			if (lblPlayer.getY() == lblEnemyFire.getY()) {
				BuildLevel.GameOver(1);
			}
			
		}
		
		
		Content.repaint();
	}
	
	public static void FeldNeuzeichnen(String args[]) {
		if (Player.AktuelleWaffe == 'A') {
			lblAktuelleWaffe.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/bogen.PNG")));
		} else if (Player.AktuelleWaffe == 'M') {
			lblAktuelleWaffe.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/Mana.PNG")));
		} else if (Player.AktuelleWaffe == 'C') {
			lblAktuelleWaffe.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/Sword.PNG")));
		}
		Content.repaint();
		SavePointLoad = false;
	}
	
	public static void neuesLevel(String args[]) {
		LevelControl.spinne_alive = false;
		LevelControl.drache_alive = false;
		LevelControl.hexe_alive = false;
		first_load = false;
		
		EnemyPosY = 120;
		EnemyStdPosY = 120;
		LoadLevel.Current_LevelMap = DateiLaden.LeseData(BuildLevel.Current_Level);
		LoadLevel.Export_to_LevelControl(null);
		newX = 15;
		newY = 15;
		
		checkPower(null);
		
		if (SavePointLoad == true) {
			lblPlayer.setBounds(LevelControl.SavePointX, LevelControl.SavePointY, 15, 15);
			SavePointLoad = false;
		} else {
			lblPlayer.setBounds(newX, newY, lblPlayer.getWidth(), lblPlayer.getHeight());
		}
		
	
		
		
		
		
		
		lblCurrentLevel.setText("Level "+LevelControl.Current_LevelAnzeige+" ("+LevelControl.Current_SubLevelAnzeige+")");
		
		
		// Label ImageIcons neu laden:
		// ===========================
		
		System.out.println("Aktualisiere Labels");
		
		
		LevelControl.gotItem1 = false;
		LevelControl.gotItem2 = false;
		LevelControl.gotItem3 = false;
		LevelControl.gotItem4 = false;
		
		lblEnemyFire.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.EnemyFire(null))));
		lblEnemyFire.setBounds(300, 400, 15, 10);	
		
		lblItem1.setBounds(LevelControl.Item1X, LevelControl.Item1Y, LevelControl.Item_Width_Height(1), LevelControl.Item_Width_Height(1));
		System.out.println("Y-Pos Enemy: "+LevelControl.Item1Y);
		lblItem2.setBounds(LevelControl.Item2X, LevelControl.Item2Y, LevelControl.Item_Width_Height(2), LevelControl.Item_Width_Height(2));
		lblItem3.setBounds(LevelControl.Item3X, LevelControl.Item3Y, LevelControl.Item_Width_Height(3), LevelControl.Item_Width_Height(3));
		lblItem4.setBounds(LevelControl.Item4X, LevelControl.Item4Y, LevelControl.Item_Width_Height(4), LevelControl.Item_Width_Height(4));
		
		LevelControl.spinne_alive = false;
		LevelControl.drache_alive = false;
		LevelControl.hexe_alive = false;
		
		lblItem1.setIcon(new ImageIcon(BuildLevel.class.getResource(LevelControl.Item_Pfade_aktualisieren(1))));
		lblItem2.setIcon(new ImageIcon(BuildLevel.class.getResource(LevelControl.Item_Pfade_aktualisieren(2))));
		lblItem3.setIcon(new ImageIcon(BuildLevel.class.getResource(LevelControl.Item_Pfade_aktualisieren(3))));
		lblItem4.setIcon(new ImageIcon(BuildLevel.class.getResource(LevelControl.Item_Pfade_aktualisieren(4))));
		
		
		
		if (level_load != Current_Level) {
			level_load = level_load+1;
		}
		
	}
/**
 * Abfrage der aktuellen Playerposition
 * 
 */
	public static int getCurrentPlayerPos(int XY) {
		int Pos = 0;
		if (XY == 0) {
			Pos = lblPlayer.getX();
		} else if (XY == 1) {
			Pos = lblPlayer.getY();
		}
		return Pos;
	} 
	
	/**
	 * aktualisiert das Inventar
	 */
	
	
	
	public static void refreshInventar(String args[]) {
		
		lblMana.setText(Player.Manadrinks+" ");
		lblSchwert.setText(Player.PlayerSword+" ");
		lblBogen.setText(Player.Bow+" ");
		lblPfeil.setText(Player.Arrow+" ");
		lblRuestung.setText(Player.suitofarmor+" ");
		lblMedikit.setText(Player.Medikit+" ");
		lblPunkteanzeige.setText(Player.CurrentPoints+" ");
		lblLebensanzeige.setText(Player.Lives+" ");
		
	}
	
	/**
	 * Abfrage der Spieler Power
	 * 
	 */
	
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
					LevelControl.hexe_alive = false;
					LevelControl.drache_alive = false;
					LevelControl.spinne_alive = false;
					Player.PlayerPower = 4;
					lblYouDied.setVisible(true);
					lblYouDied2.setVisible(true);
					Player.Lives = Player.Lives-1;
					BuildLevel.Current_Level = LevelControl.SaveLevel-1;
					BuildLevel.change_level_phase = true;
					//MovementListener.stopFlag = true;
					LevelControl.hexe_alive = false;
					LevelControl.spinne_alive = false;
					LevelControl.drache_alive = false;
					BuildLevel.neuesLevel(null);
					System.out.println("Tot!!! ---> Back to CheckPoint.");
				} else {
					LevelControl.hexe_alive = false;
					LevelControl.drache_alive = false;
					LevelControl.spinne_alive = false;
					Player.PlayerPower = 4;
					lblYouDied.setVisible(true);
					lblYouDied2.setVisible(true);
					Player.Lives = Player.Lives-1;
					BuildLevel.Current_Level = 0;
					BuildLevel.change_level_phase = true;
					//MovementListener.stopFlag = true;
					LevelControl.hexe_alive = false;
					LevelControl.spinne_alive = false;
					LevelControl.drache_alive = false;
					BuildLevel.neuesLevel(null);
					System.out.println("Tot!!! ---> Back to 1st Level");
				}
				
				
			}
		}
		
	}
		
	/**
	 *  DAMAGE - Types:
	 *  
	 *  5: sofort tot
	 *  3: 1 Schadenspunkt
	 *  1: 2 Schadenspunkte
	 */
	
	public static void GameOver(int DamageType) {
		
		if (DamageType == 5) {
			Player.PlayerPower = Player.PlayerPower-10;
		} else if (DamageType == 3) {
			Player.PlayerPower = Player.PlayerPower-1;
		} else if (DamageType == 1) {
			Player.PlayerPower = Player.PlayerPower-2;
		}
		
		checkPower(null);
				
		
		
	}
	
	public BuildLevel() {
		setResizable(false);
		
		//create Jframe and Grid
		
		setTitle("Dungeon Crawler - Level "+Current_Level);
		setDefaultCloseOperation(BuildLevel.DO_NOTHING_ON_CLOSE);
		setBounds(300, 300, 550, 372);
		Content = new JPanel();
		Content.setBackground(Color.WHITE);
		Content.setBorder(null);
		setContentPane(Content);
		Content.setLayout(null);
		
		
		
		
		/*
		 * MovementListener
		 */
		
		
		mListener = new MovementListener() {
			@Override
			public void doMovement(int left, int right, int up, int down){
				
				java.awt.Rectangle pos = lblPlayer.getBounds();
				newX = pos.x + left + right;  
				newY = pos.y + up + down; 
                /* 
				
                
                
                // Bewegt den Player waehrend des Level-Wechsels an die mittlere Position
                
                if ((BuildLevel.change_level_phase == true)&(counter == 2)) {
                	counter = 4;
                	change_level_phase = false;
                	newX = LoadLevel.getPlayerPosStartX(Current_Level);
					newY = LoadLevel.getPlayerPosStartY(Current_Level);
					change_level_exitX = true;
					
                } else if (BuildLevel.change_level_phase == true){
					newX = LoadLevel.getPlayerPosStartX(Current_Level);
					newY = LoadLevel.getPlayerPosStartY(Current_Level);
					level_load = level_load+1;
					counter = 2;
				}
                
                
                
                
                if ((change_level_exitX == true)&(counter == 6)) {
                	
                	newY = LoadLevel.getPlayerPosStartY(Current_Level);
                	newX = LoadLevel.getPlayerPosStartX(Current_Level);
					counter = 0;
					change_level_exitX = false;
                }
               
                
                if (change_level_exitX == true) {
                	
                	newY = LoadLevel.getPlayerPosStartY(Current_Level);
                	newX = LoadLevel.getPlayerPosStartX(Current_Level);
					counter = 6;
					
                }
                
            
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        //lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
                        //lblTreasure.setBounds(Treasure.buildTreasureX(), Treasure.buildTreasureY(), 15, 15);
                    }
                });
                
                
                // FALLEN-Abfrage
                
                
                if (Treasure.check_treasure() == true) {
                	Player.CurrentPoints = Player.CurrentPoints+100;
                	got_treasure = true;
                	
                	stop_treasure = true;
                	if (stop_treasure = true) {
                    	lblTreasure.setBounds(300, 15, 15, 15);
                    	stop_treasure = false;
                    	lblPergament.setText(lblPergament.getText()+"/nSchatz aufgesammelt");
                    	System.out.println("Schatz aufgesammelt");
                    	//Treasure.check_treasure();
                    }
                }
                
                
                
                //if (CollisionControl.check_Xborder(lblPlayer.getX()) == true) {
                	if (CollisionControl.check_trap(lblPlayer.getX(), lblPlayer.getY()) == true) {
                		lblGameOver.setVisible(true);
                		MovementListener.stopFlag = true;
                		
                	}
                	//if (CollisionControl.check_Yborder(lblPlayer.getY()) == true) {
                    	if (CollisionControl.check_trap(lblPlayer.getX(), lblPlayer.getY()) == true) {
                    		lblGameOver.setVisible(true);
                    		lblNeustart.setVisible(true);
                    		lblNeustart.setEnabled(true);
                    		MovementListener.stopFlag = true;
                    		game_over = true;
                    		
                    	}	            	
                    //}
                	
                //}
                
                


                */
				lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
			}
			
		};
		mListener.setPriority(Thread.NORM_PRIORITY);
		
		
		
		
		
		
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
		
		// Treasure
		
		lblItem1 = new JLabel ("");
		lblItem1.setBounds(15, 15, 15, 15);
		lblItem1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/gameover.PNG")));
		lblItem1.setVisible(true);
		Content.add(lblItem1);
		
		lblItem2 = new JLabel ("");
		lblItem2.setBounds(300, 300, 15, 15);
		lblItem2.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/gameover.PNG")));
		lblItem2.setVisible(true);
		Content.add(lblItem2);
		
		lblItem3 = new JLabel ("");
		lblItem3.setBounds(300, 300, 15, 15);
		lblItem3.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/gameover.PNG")));
		lblItem3.setVisible(true);
		Content.add(lblItem3);
		
		lblItem4 = new JLabel ("");
		lblItem4.setBounds(300, 300, 15, 15);
		lblItem4.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/gameover.PNG")));
		lblItem4.setVisible(true);
		Content.add(lblItem4);
		//Current_Level
		
		lblEnemyFire = new JLabel ("");
		lblEnemyFire.setBounds(300, 400, 15, 10);
		lblEnemyFire.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblEnemyFire.setVisible(true);
		Content.add(lblEnemyFire);
		
		lblPlayerFire1 = new JLabel ("");
		lblPlayerFire1.setBounds(300, 400, 15, 10);
		lblPlayerFire1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/EnemyFire.PNG")));
		lblPlayerFire1.setVisible(true);
		Content.add(lblPlayerFire1);
		
		lblCurrentLevel = new JLabel("Level "+Current_Level+" ("+Current_Level+")");
		lblCurrentLevel.setBounds(3, 0, 100, 14);
		Content.add(lblCurrentLevel);
		
		lblGameOver = new JLabel("");
		lblGameOver.setBounds(50, 90, 200, 50);
		lblGameOver.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/gameover.PNG")));
		lblGameOver.setVisible(false);
		Content.add(lblGameOver);
		
		
		
		lblYouDied = new JLabel ("<html>Oops! You died!<br>Return to the last check point.</html>");
		lblYouDied.setBounds(60, 110, 200, 100);
		lblYouDied.setForeground(Color.WHITE);
		lblYouDied.setVisible(false);
		Content.add(lblYouDied);
		lblYouDied2 = new JLabel ("<html>Oops! You died!<br>Return to the last check point.</html>");
		lblYouDied2.setBounds(61, 111, 200, 100);
		lblYouDied2.setForeground(Color.BLACK);
		lblYouDied2.setVisible(false);
		Content.add(lblYouDied2);
		

		
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		
		
		
		
		lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/player.PNG")));
		lblPlayer.setBounds(newX, newY, 15, 15);
		Content.add(lblPlayer);
		
		// Einzelne Level Items
		// Hab's leider nicht geschafft das zu automatisieren :-(
		
		// A-Reihe (id 0-19)
		
		JLabel lblfussballfeld = new JLabel("");
		lblfussballfeld.setIcon(new ImageIcon(BuildLevel.class.getResource("/Resources/fussballfeld.jpg")));
		lblfussballfeld.setBounds(0, 0, 550, 295);
		Content.add(lblfussballfeld);
		
		neuesLevel(null);
		
		}


	
		
	
		

	}

