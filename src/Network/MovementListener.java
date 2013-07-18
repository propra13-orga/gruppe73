package Network;
import Network.BuildLevel;
import java.awt.event.KeyEvent;




public abstract class MovementListener extends Thread implements java.awt.event.KeyListener {
	
    public static boolean stopFlag = false;
   
    public void run() {
        stopFlag = false;
        	
		    while(!stopFlag) {
		                   
		    	System.out.println("Bla");
	           
		    }
    }
    


    // BEENDET DEN TIMER:
    // ==================
    
    public void end() {
        stopFlag = true;
    }
    
    public abstract void doMovement(int left, int right, int up, int down);
    
}
