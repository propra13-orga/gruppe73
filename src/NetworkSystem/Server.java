package NetworkSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
 /**
  * 
  * Diese Klasse repräsentiert einen Server. 
  * Der Konstruktor bekommt die Nummer des Ports übergeben an dem "gehorcht"werden soll.
  *
  */

public class Server {
	
	public static ServerSocket server;
	public int getLocalPort() {
		return 0;
	}
	public Server(int port) throws IOException {
		server = new ServerSocket(port);
	}
	
	private void verbinde() {
		
		while(true){
			Socket socket = null;
			try{
				socket = server.accept();
				/**
				 * Stellt die Verbindung mit einem Server innerhalb einer Endlosschleife her.
				 */
				reinRaus(socket);
				/**
				 * Methode liest und beschreibt Input und Output Streams. 
				 * Werden vom Socket geliefert.
				 */
			}
			catch (IOException e){
				e.printStackTrace();				
			}finally{
				if (socket != null)
					try{
						socket.close();
						/**
						 * Socket wird nach Beenden des Servers geschlossen.
						 * 
						 */
					}catch (IOException e){
						e.printStackTrace();
					}
					}
			}
		}
	private void reinRaus(Socket socket) throws IOException{
		BufferedReader rein = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream raus = new PrintStream(socket.getOutputStream());
		String s;
		
		while(rein.ready()){
			s = rein.readLine();
			raus.println(s);
		}
	}
		
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Server server = new Server(0);
		server.verbinde();
	}

}
