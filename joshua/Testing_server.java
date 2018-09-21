package joshua;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Testing_server {
	public ServerSocket ss ;
	public Socket s ;
	private final int PORT = 25543;
	public DataInputStream input;
	public DataOutputStream output ;
		public void Maker() throws IOException{
			System.out.println("before ss");
			ss = new ServerSocket(PORT);
			System.out.println("before s");
			s = ss.accept();
			System.out.println("before input");
			input = new DataInputStream(s.getInputStream());
			System.out.println("before output");
			output = new DataOutputStream(s.getOutputStream());
			System.out.println("before write");
			output.writeUTF("testing?");
			System.out.println("after write");
		}
}
