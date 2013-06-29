package NetworkSystem;

import java.io.IOException;
import java.net.InetAddress;

public class GetComputerName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try{
		String ComputerName = InetAddress.getLocalHost().getHostName();
		System.out.println(ComputerName);
	}catch (IOException e){
		System.out.println("Exception caught = " + e.getMessage());
	}

	}

}
