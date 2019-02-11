import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener {
	
	private JButton[] allButtons = new JButton[16];
	private String[] buttonLabels = new String[16];
	
	public Login() {
		InitialElements();
	}
	
	public void InitialElements() {
		
		setLayout(null);
		
	int x = 40;
	int y = 20;
	int i = 0;
	
	for (int out = 0; out < 3; out++) { //initialise and add all buttons to frame
		//Color[] colourArray = {Color.red, Color.blue, Color.green}; //used to change colour of buttons
		y = 20;
		for (int in = 0; in < 5; in++) {
	
			allButtons[i] = new JButton();
			allButtons[i].addActionListener(this);
			add(allButtons[i]);
			allButtons[i].setBounds(x, y, 160, 60);
			//allButtons[i].setBackground(colourArray[out]); //will set button to currently selected colour in colourArray
			y += 70; //moves the y co-ordinate of the next button
			i += 1; //next button
		}
		x += 220; //moves the x co-ordinate of the next button
	}
	
	allButtons[15] = new JButton();
	allButtons[i].addActionListener(this);
	add(allButtons[15]);
	allButtons[15].setBounds(500, 400, 160, 60);
	
	setButtonLabels();
	
	}
	
	public void setButtonLabels() {
		buttonLabels[0] = "Declan";
		buttonLabels[1] = "Brittany";
		buttonLabels[2] = "Curtis";
		buttonLabels[3] = "Chelsea";
		buttonLabels[4] = "Kiara";
		buttonLabels[5] = "Tamsin";
		buttonLabels[6] = "Sean";
		buttonLabels[7] = "Ethan";
		buttonLabels[8] = "Kaysha";
		buttonLabels[9] = "James";
		buttonLabels[10] = "Josh";
		buttonLabels[11] = "Ian";
		buttonLabels[12] = "Leigh";
		buttonLabels[13] = "Jordan";
		buttonLabels[14] = "Natalie";
		buttonLabels[15] = "Guest";
		
		for (int i = 0; i < 16; i++) {
			allButtons[i].setText(buttonLabels[i]);
		}
	} 
	
	public void actionPerformed(ActionEvent event) {
	
	JButton pressed = (JButton) event.getSource(); //overwrites 'pressed' with the source of the click
	
	for (int i = 0; i < 16; i++) {
		if (pressed == allButtons[i]) {
			MachineInterface mainWindow = new MachineInterface(buttonLabels[i]); //creates and initialises the initial main window
			mainWindow.setTitle("Senso Register");
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWindow.setBounds(0, 0, 800, 300);
			mainWindow.setVisible(true);
			this.setVisible(false);
		};
	}
}
}