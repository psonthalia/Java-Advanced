import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SimpleChatServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9090);

			while(true) {
				Socket client = server.accept();

				ChatRunnable runnable = new ChatRunnable(client);
				Thread t = new Thread(runnable);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class ChatRunnable implements Runnable {
	PrintWriter output;
	Scanner input;

	public ChatRunnable(Socket client) throws IOException {
		output = new PrintWriter(client.getOutputStream(), true);
		input = new Scanner(client.getInputStream());
	}

	@Override
	public void run() {
		while (true) {
			String in = input.nextLine();
			if (in !=null) {
				System.out.println(in);
			}
		} 

	}

}
