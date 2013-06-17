package dungeoncrawler;
import dungeoncrawler.BuildLevel;
import dungeoncrawler.CollisionControl;
import dungeoncrawler.Gegner;
import dungeoncrawler.LevelControl;
import java.awt.event.KeyEvent;




public abstract class MovementListener extends Thread implements java.awt.event.KeyListener {
    public long timeSlice = 50; // Zeit in Millisekunden in der die Tastatureingabe überprüft wird.
    public static int left = 0;
    public static int right = 0;
    public static int up = 0;
    public static int down = 0;
    public static boolean stopFlag = false;
    

    public void keyTyped(java.awt.event.KeyEvent e) {}
    

    public void keyPressed(java.awt.event.KeyEvent e) {
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
	        if (e.getKeyCode() == KeyEvent.VK_2) {
	        	BuildLevel.Current_Level = BuildLevel.Current_Level+1;
	        	BuildLevel.change_level_phase = true;
	        	
	        }
	        
	        // Bewegung:
	        this.doMovement(left, right, up, down);
	        
	        // Kontrolliere:
	        Gegner.trap_collision();
	        LevelControl.Item_pickUp(null);
	        LevelControl.door_collision(null);
	        
	        
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
            	
            	BuildLevel.neuesLevel(null);
            	//this.doMovement(left,right,up,down);
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
