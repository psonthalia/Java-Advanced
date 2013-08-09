import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ChatClient {
	PrintWriter output;
	Scanner input;

	/**
	 * @param args
	 */
	public ChatClient(String ip) {
		try {
			Socket sock = new Socket(ip, 9090);
			output = new PrintWriter(sock.getOutputStream(), true);
			input = new Scanner(sock.getInputStream());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void sendOutput(String out) {
		output.println(out);
	}
	public String getInput() {
		return input.nextLine();
	}

}
