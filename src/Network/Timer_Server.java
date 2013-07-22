package Network;

import Network.BuildLevel_Server;

public abstract class Timer_Server extends Thread {
	
	public static boolean stopFlag = false;
	private int counter = 0;
	
	public void run() {
	
		long timeout = 500;
		while(!stopFlag) {
			try{
				Thread.sleep(timeout);
				System.out.println("Package Network;\nTimer.counter(): "+ counter + "; " + timeout + " Millisekunden gewartet.");
				counter = counter + 1;
				if (Network.BuildLevel_Server.PlayerFireActive) {
					Network.BuildLevel_Server.fire(null);
				}
				
				
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
	}
	
	public abstract void Fuschi();
}
