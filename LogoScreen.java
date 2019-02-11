import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoScreen extends JFrame implements ActionListener {

    
	private JButton logo;

    public LogoScreen() {
		logo = new JButton();
		logo.setBorderPainted(false);
		logo.addActionListener(this);
		ImageIcon image = new ImageIcon("SensoLogo.jpg");
		logo.setIcon(image); //initialise and add total sales label
		add(logo);
       
    }

	public void actionPerformed(ActionEvent event) {
		Login login = new Login();
		login.setTitle("Senso Register");
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setBounds(0, 0, 700, 600);
		login.setVisible(true);
	}

}