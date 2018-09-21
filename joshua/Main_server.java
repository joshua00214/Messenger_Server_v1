package joshua;

import java.io.IOException;

import javax.swing.JFrame;

public class Main_server {
	public static void main(String[] args){
		
		Server s = new Server();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(400,175);
		s.setVisible(true);	
		/**
		Testing_server s = new Testing_server();
		try {
			s.Maker();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
	}
}
