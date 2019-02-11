import javax.swing.JFrame;

/* 
have only one click listener or have them in the class rather than a seperate file
find and display senso logo for front screen /
when front screen is clicked, go on to register interface /
have dropdown bar or menu buttons at top to display different information for each product
choose between stock, price etc.
have login button for deciding each staff /
close logo screen when clicked /
use LogoScreen.setVisible(true); to reopen logo screen if no action is performed for 1 minute, use as screensaver
Have a screen for ordering stock and adding it to the system rather than resetting stock
possibly save all stock in a file so stock levels dont reset when the program is closed
*/

public class Vending extends JFrame {
	
	public static void main (String[] args) {
		LogoScreen logo = new LogoScreen();
		logo.setTitle("Senso Register");
		logo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logo.setBounds(0, 0, 700, 600);
		logo.setVisible(true);
		
	}
}
