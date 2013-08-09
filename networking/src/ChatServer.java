import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class ChatServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList <String> messages = new ArrayList <String> ();
		try {
			ServerSocket server = new ServerSocket(9090);

			while(true) {
				Socket client = server.accept();

				ChatLink runnable = new ChatLink(client, messages);
				Thread t = new Thread(runnable);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class ChatLink implements Runnable {
	PrintWriter output;
	Scanner input;
	ArrayList <String> chatroom;
	int position = 0;

	public ChatLink(Socket client, ArrayList <String> messages) throws IOException {
		output = new PrintWriter(client.getOutputStream(), true);
		input = new Scanner(client.getInputStream());
		chatroom = messages;
	}

	@Override
	public void run() {
		while (true) {
			String in = input.nextLine();
			if (in !=null) {
				chatroom.add(in);
			}
			while(position < chatroom.size()) {
				output.println(chatroom.get(position));
				position++;
			}
		} 

	}

}
