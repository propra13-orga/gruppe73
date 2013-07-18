package Network;

public class Timer {
	
	public static boolean stopFlag = false;
	
	public void counter() {
		long timeout = 50;
		while(!stopFlag) {
			try{
				Thread.sleep(timeout);
				//BuildLevel.PlayerFire();
				//BuildLevel.repainter();
				System.out.println("Bla");
				stopFlag = false;
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
	}
}
