package joshua;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Server extends JFrame {

	private DataInputStream[] input = new DataInputStream[4];
	Thread thread1;
	private String Uname;
	int x;
	private String Uname2;
	private DataOutputStream[] output = new DataOutputStream[4];
	private ServerSocket serverSocket;
	private Socket[] clientSocket = new Socket[4];
	private JButton button;
	private JTextField textfield;
	int i;
	String theInput;
	private final int PORT = 25543;
	private int one = 1;
	Thread thread2;

	public Server() {
		super("Server for Messeger");
		if (one == 1) {
			button = new JButton("Make server");
			textfield = new JTextField(40);
			textfield.setEditable(false);
			setLayout(new FlowLayout());
			add(button);
			add(textfield);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					remove(button);
					try {
						serverSocket = new ServerSocket(PORT);
						MakeServer();
					} catch (IOException e1) {

						textfield.setText("before server is made");
					}

				}
			});
		}
	}

	public void MakeServer() throws IOException {
		for (i = 0; i < 2; i++) {
			System.out.println("before clientsocket");
			clientSocket[i] = serverSocket.accept();
			System.out.println("after clint");
			output[i] = new DataOutputStream(clientSocket[i].getOutputStream());
			input[i] = new DataInputStream(clientSocket[i].getInputStream());
			System.out.println("after input");
			Thread thread2 = new Thread() {
				public void run() {
					try {
						while (true) {
							Uname2 = input[1].readUTF();
							writeToAll0(Uname2);
							System.out.println("After write to al");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			};
			Thread thread1 = new Thread() {

				public void run() {
					System.out.println("before while(true)");
					int x = 3;
					while (true) {
						try {

							System.out.println("before Write to all");

							Uname = (input[0].readUTF());
							writeToAll0(Uname);
							System.out.println("After write to all");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NullPointerException e) {

						}
					}

				}
			};
			System.out.println("before thread");
			if(i == 0){
			thread1.start();
			}
			if(i == 1){
			thread2.start();
			}
			System.out.println("after thread");
		};
	}

	public void writeToAll0(String inside) {
		try {

			output[0].writeUTF(inside);
			output[1].writeUTF(inside);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToAll1(String two) throws IOException {
		if (clientSocket[1] != null) {
			output[0].writeUTF(two);
			output[1].writeUTF(two);
		}

	}
}
