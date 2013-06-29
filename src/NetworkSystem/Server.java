package NetworkSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	
	public static ServerSocket server;
	public StringServer(int port) throws IOException {
		server = new ServerSocket(port);
	}
	
	private void verbinde() {
		
		while(true){
			Socket socket = null;
			try{
				socket = server.accept();
				reinRaus(socket);
			}
			catch (IOException e){
				e.printStackTrace();				
			}finally{
				if (socket != null)
					try{
						socket.close();
					}catch (IOException e){
						e.printStackTrace();
					}
					}
			}
		}
	private void reinRaus(Socket socket) throws IOException{
		BufferedReader rein = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
		StringServer server = new StringServer();
		server.verbinde();
	}

}
