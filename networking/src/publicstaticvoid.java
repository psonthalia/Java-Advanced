import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class publicstaticvoid extends JFrame implements ActionListener {
	ChatClient client;
	JTextArea area;
	JTextField input;

	public static void main(String[] args) {
		new publicstaticvoid();
	}
	public publicstaticvoid() {
		super("iparans chat");
		setSize(new Dimension(400, 600));
		setLayout(new BorderLayout());
		initializeComponents();
		setVisible(true);
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTask(), 0, 100);
	}
	class UpdateTask extends TimerTask {
		@Override
		public void run() {
			String in = client.getInput();
			if (in != null) {
				area.append("\n");
				area.append(in);
			}
		}
	}
	private void initializeComponents() {
		String ip = JOptionPane.showInputDialog("What's the server's IP adress?");
		client = new ChatClient(ip);
		
		area = new JTextArea(30, 20);
		add(area, BorderLayout.NORTH);
		input = new JTextField(20);
		input.addActionListener(this);
		add(input, BorderLayout.SOUTH);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == input) {
			client.sendOutput(input.getText());
			input.setText("");
		}
		
	}

}
