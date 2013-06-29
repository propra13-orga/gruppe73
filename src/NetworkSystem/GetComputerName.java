package NetworkSystem;

import java.io.IOException;
import java.net.InetAddress;

public class GetComputerName {

	/**
	 * @param args
	 */
	public static String ausfuehren() {
	String ComputerName = "";
		// TODO Auto-generated method stub
	try{
		ComputerName = InetAddress.getLocalHost().getHostName();
		System.out.println(ComputerName);
	}catch (IOException e){
		System.out.println("Exception caught = " + e.getMessage());
	}
	return ComputerName;

	}

}
