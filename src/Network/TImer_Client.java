package Network;

import Network.BuildLevel_Client;

public abstract class Timer_Client extends Thread {
	
	public static boolean stopFlag = false;
	private int counter = 0;
	
	public void run() {
	
		long timeout = 500;
		while(!stopFlag) {
			try{
				Thread.sleep(timeout);
				System.out.println("Package Network;\nTimer.counter(): "+ counter + "; " + timeout + " Millisekunden gewartet.");
				counter = counter + 1;
				if (Network.BuildLevel_Client.PlayerFireActive) {
					//Network.BuildLevel_Client.fire(null);
				}
				
				
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
	}
	
	public abstract void Fuschi();
}
