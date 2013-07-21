package Network;

import Network.BuildLevel;

public class Timer {
	
	public static boolean stopFlag = false;
	private int counter = 0;
	
	public void counter() {
		long timeout = 250;
		while(!stopFlag) {
			try{
				Thread.sleep(timeout);
				System.out.println("Package Network;\nTimer.counter(): "+ counter + "; " + timeout + " Millisekunden gewartet.");
				counter = counter + 1;
				if (Network.BuildLevel.PlayerFireActive) {
					Network.BuildLevel.fire(null);
				}
				
				
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
	}
}
