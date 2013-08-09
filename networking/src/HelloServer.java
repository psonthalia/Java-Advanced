import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class HelloServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9090);

			while(true) {
				Socket client = server.accept();
				PrintWriter output = new PrintWriter(client.getOutputStream(), true);
				Scanner input = new Scanner(client.getInputStream());

				output.println("Go to iparans.wordpress.com");

				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
