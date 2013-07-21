package dungeoncrawler;
import dungeoncrawler.BuildLevel;
import dungeoncrawler.CollisionControl;
import dungeoncrawler.Gegner;
import dungeoncrawler.LevelControl;
import java.awt.event.KeyEvent;
import java.io.IOException;

import Spielstaende.Laden;
import Spielstaende.Speichern;




public abstract class MovementListener extends Thread implements java.awt.event.KeyListener {
	
	/**
	 * Hinzufügen der KeyEvents zu den Pfeiltasten.
	 */
    public long timeSlice = 50; // Zeit in Millisekunden in der die Tastatureingabe überprüft wird.
    public static int left = 0;
    public static int right = 0;
    public static int up = 0;
    public static int down = 0;
    public static boolean stopFlag = false;
    public static boolean moveUp = true;
    public static boolean moveDown = false;
    public static boolean gespeichert = false;
    public static boolean laden = false;
    

    public void keyTyped(java.awt.event.KeyEvent e) {}
    

    public void keyPressed(java.awt.event.KeyEvent e) {
	    if (LevelControl.Shop_opened == false) {	
    		if (stopFlag == false) {
		        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        	CollisionControl.left(null);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		        	CollisionControl.right(null);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_UP) {
		        	CollisionControl.up(null);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		        	CollisionControl.down(null);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_F) {
		        	Gegner.PlayerFire1Active = true;
		        }
		        if (e.getKeyCode() == KeyEvent.VK_C) {
		        	Player.WaffeWechseln(null);
		        }
		        if (e.getKeyCode() == KeyEvent.VK_S) {
		        	Speichern.main(null);
		        	gespeichert = true;
		        }
		        if(e.getKeyCode() == KeyEvent.VK_L){
					Laden.main(null);
					laden = true;
					BuildLevel.gespeichertesSpiel(null);
					System.out.println("Ich lade das gespeicherte Spiel");
		        }
		        if (e.getKeyCode() == KeyEvent.VK_M){ 
		        	if (Player.Medikit > 0){
		        		Player.PlayerPower = Player.PlayerPower +4;
		        		Player.Medikit = Player.Medikit -1;
		        		BuildLevel.refreshInventar(null);
		        		BuildLevel.checkPower(null);
		        	}
		        	
		        }
		        if (e.getKeyCode() == KeyEvent.VK_2) {
		        	BuildLevel.Current_Level = BuildLevel.Current_Level+1;
		        	BuildLevel.change_level_phase = true;
		        	LevelControl.spinne_alive = false;
		        	LevelControl.hexe_alive = false;
		        	LevelControl.drache_alive = false;
		        	
		        }
		        
		        // Bewegung:
		        this.doMovement(left, right, up, down);
		        
		        // Kontrolliere:
		        Gegner.trap_collision();
		        LevelControl.Item_pickUp(null);
		        LevelControl.Shop_open(null);
		        LevelControl.door_collision(null);
		        CollisionControl.meet_NPC(null);
		        
		        
		        // Spielfeld aktualisieren:
		        
		        	// FEHLT!!!: Inventar aktualisieren (Leisten oben und unten)
		        /*
		        javax.swing.SwingUtilities.invokeLater(new Runnable() {
		        	public void run() {
		        		//BuildLevel.neuesLevel(null);
		        		BuildLevel.FeldNeuzeichnen(null);
					}
				});
				*/
		        
		        
		        
		        
	    	}
	    }
    }

    public void keyReleased(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	left = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	right = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	up = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	down = 0;
        }
    }
    
   
    
    /*
     * Ruft alle timeSlice Millisekunden die abstrakte Methode doMovement auf
     */
    
    /*
    @Override
    public void run() {
        stopFlag = false;
        long lastRunTime = System.currentTimeMillis();
        while(!stopFlag) {
            long timeDif = System.currentTimeMillis() - lastRunTime;
            try {
                sleep(timeSlice - timeDif);
            } catch (InterruptedException ex) { }
            BuildLevel.lblPunkteanzeige.setText(String.valueOf(Player.CurrentPoints));
            this.doMovement(left,right,up,down);
            if ((BuildLevel.Current_Level%2)==0) {
            	try {
	                sleep(2000);
	            } catch (InterruptedException ex) { }
            	BuildLevel.Current_Level = BuildLevel.Current_Level+1;
            	BuildLevel.PlayerPosition(null);
           
            }
	            
           
            lastRunTime = System.currentTimeMillis();
              
        }
    }
    */
    
    public void run() {
        stopFlag = false;
        	
		    while(!stopFlag) {
		            if ((BuildLevel.Current_Level%2)==0) {
		            	try {
		            		sleep(2000);
		            	} catch (InterruptedException ex) { }
		            	BuildLevel.Current_Level = BuildLevel.Current_Level+1;
		            	
		            	LevelControl.gotItem1 = false;
		            	LevelControl.gotItem2 = false;
		            	LevelControl.gotItem3 = false;
		            	LevelControl.gotItem4 = false;
		            	BuildLevel.lblYouDied.setVisible(false);
		            	BuildLevel.lblYouDied2.setVisible(false);
		            	BuildLevel.neuesLevel(null);
		            	//this.doMovement(left,right,up,down);
		            } 
		            
	            	if (LevelControl.spinne_alive == true) {
	            		while (moveUp) {
	            			try {
	    	            		sleep(50);
	    	            		
	    	            	} catch (InterruptedException ex) { }
	            			BuildLevel.EnemyFire(null);
	            			BuildLevel.moveEnemyUp(null);
	            			LevelControl.checkEnemyCollision(null);
	            			if (Gegner.PlayerFire1Active) {
	            				Gegner.fire(null);
	            			}

	            			if ((BuildLevel.EnemyStdPosY-30) == BuildLevel.EnemyPosY) {
	            				moveUp = false;
	            				moveDown = true;
	            			}
	            		}
	            		while (moveDown) {
	            			try {
	    	            		sleep(50);
	    	            		
	    	            	} catch (InterruptedException ex) { }
	            			BuildLevel.EnemyFire(null);
	            			BuildLevel.moveEnemyDown(null);
	            			LevelControl.checkEnemyCollision(null);
	            			if (Gegner.PlayerFire1Active) {
	            				Gegner.fire(null);
	            			}
	            			
	            			if ((BuildLevel.EnemyStdPosY+30) == BuildLevel.EnemyPosY) {
	            				moveUp = true;
	            				moveDown = false;
	            			}
	            		}
	            	}
	            	
	            	if (LevelControl.hexe_alive == true) {
	            		while (moveUp) {
	            			try {
	    	            		sleep(50);
	    	            		
	    	            	} catch (InterruptedException ex) { }
	            			BuildLevel.EnemyFire(null);
	            			BuildLevel.moveEnemyUp(null);
	            			LevelControl.checkEnemyCollision(null);
	            			if (Gegner.PlayerFire1Active) {
	            				Gegner.fire(null);
	            			}

	            			if ((BuildLevel.EnemyStdPosY-30) == BuildLevel.EnemyPosY) {
	            				moveUp = false;
	            				moveDown = true;
	            			}
	            		}
	            		while (moveDown) {
	            			try {
	    	            		sleep(50);
	    	            		
	    	            	} catch (InterruptedException ex) { }
	            			BuildLevel.EnemyFire(null);
	            			BuildLevel.moveEnemyDown(null);
	            			LevelControl.checkEnemyCollision(null);
	            			if (Gegner.PlayerFire1Active) {
	            				Gegner.fire(null);
	            			}
	            			
	            			if ((BuildLevel.EnemyStdPosY+30) == BuildLevel.EnemyPosY) {
	            				moveUp = true;
	            				moveDown = false;
	            			}
	            		}
	            	}
	            	
	            	if (LevelControl.drache_alive == true) {
	            		while (moveUp) {
	            			try {
	    	            		sleep(50);
	    	            		
	    	            	} catch (InterruptedException ex) { }
	            			BuildLevel.EnemyFire(null);
	            			BuildLevel.moveEnemyUp(null);
	            			LevelControl.checkEnemyCollision(null);
	            			if (Gegner.PlayerFire1Active) {
	            				Gegner.fire(null);
	            			}

	            			if ((BuildLevel.EnemyStdPosY-30) == BuildLevel.EnemyPosY) {
	            				moveUp = false;
	            				moveDown = true;
	            			}
	            		}
	            		while (moveDown) {
	            			try {
	    	            		sleep(50);
	    	            		
	    	            	} catch (InterruptedException ex) { }
	            			BuildLevel.EnemyFire(null);
	            			BuildLevel.moveEnemyDown(null);
	            			LevelControl.checkEnemyCollision(null);
	            			if (Gegner.PlayerFire1Active) {
	            				Gegner.fire(null);
	            			}
	            			
	            			if ((BuildLevel.EnemyStdPosY+30) == BuildLevel.EnemyPosY) {
	            				moveUp = true;
	            				moveDown = false;
	            			}
	            		}
	            	}
	            	
	            	if (LevelControl.SavePointAnzeige == true) {
	            		BuildLevel.lblCheckpoint.setVisible(true);
	            		BuildLevel.FeldNeuzeichnen(null);
	            		try {
	            			sleep(2000);
	            		} catch (InterruptedException ex) { }
	            		BuildLevel.lblCheckpoint.setVisible(false);
	            		LevelControl.SavePointAnzeige = false;
	            	}
		    }
    }
    


    // BEENDET DEN TIMER:
    // ==================
    
    public void end() {
        stopFlag = true;
    }
    
    public abstract void doMovement(int left, int right, int up, int down);
    
}
