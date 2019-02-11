import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants.*;

public class ErrorMessage extends JFrame {

	private JLabel error;
	
	public ErrorMessage() {
		
		setLayout(null); // turns off default layout
		
		error = new JLabel(); //create and set parameters of new label
		add(error);
		error.setText("Oops, there is no stock left!");
		error.setBounds(10,20,300,50);
	}
}