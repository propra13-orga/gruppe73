package dungeoncrawler;

import java.awt.event.KeyEvent;




public abstract class MovementListener extends Thread implements java.awt.event.KeyListener {
    public long timeSlice = 50; // Zeit in Millisekunden in der die Tastatureingabe überprüft wird.
    public static int left = 0;
    public static int right = 0;
    public static int up = 0;
    public static int down = 0;
    public boolean stopFlag = false;

    public void keyTyped(java.awt.event.KeyEvent e) {
        // do nothing
    }

    public void keyPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = -15;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = 15;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = -15;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = 15;
    }

    public void keyReleased(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = 0;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = 0;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = 0;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = 0;
    }
    
    public static boolean checkLeft() {
    	boolean left_stop = false;
    	if (left == -15) {
    		left_stop = true;
    	}
    	else {
    		left_stop = false;
    	}
    	return left_stop;
    }
    
    public static boolean checkRight() {
    	boolean right_stop = false;
    	if (right == 15) {
    		right_stop = true;
    	}
    	else {
    		right_stop = false;
    	}
    	return right_stop;
    }
    
    public static boolean checkUp() {
    	boolean up_stop = false;
    	if (up == -15) {
    		up_stop = true;
    	}
    	else {
    		up_stop = false;
    	}
    	return up_stop;
    }
    
    public static boolean checkDown() {
    	boolean down_stop = false;
    	if (down == 15) {
    		down_stop = true;
    	}
    	else {
    		down_stop = false;
    	}
    	return down_stop;
    }
    
    

    /*
     * Ruft alle timeSlice Millisekunden die abstrakte Methode doMovement auf
     */
    @Override
    public void run() {
        stopFlag = false;
        long lastRunTime = System.currentTimeMillis();
        while(!stopFlag) {
            long timeDif = System.currentTimeMillis() - lastRunTime;
            try {
                sleep(timeSlice - timeDif);
            } catch (InterruptedException ex) { }
            this.doMovement(left,right,up,down);
            lastRunTime = System.currentTimeMillis();
        }
    }

    /*
     * Halte den Thread bei nächster Gelgenheit an
     */
    public void end() {
        stopFlag = true;
    }

    public abstract void doMovement(int left, int right, int up, int down);
}
