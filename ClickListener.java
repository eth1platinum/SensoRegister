import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Color;

public class ClickListener implements ActionListener {
	
	private MachineInterface machine;
	private double totalSales;
	
public ClickListener(JButton target, MachineInterface window, double sales) {
	machine = window;
	
}

public void actionPerformed(ActionEvent event) {
	
	JButton pressed = (JButton) event.getSource(); //overwrites 'pressed' with the source of the click
	totalSales = machine.getTotalSales(); //import arrays from machine object
	JButton[] buttonarray = machine.getButtonArray();
	JLabel[] labelsarray = machine.getLabelArray();
	int[] stock = machine.getStockLevels();
	JButton vendinfo = machine.getvendinfo();
	double[] costArray = machine.getCosts();
	
	if (pressed.equals(vendinfo)) { //if vendinfo button clicked, open VendInfo window
		VendorInfo vendor = new VendorInfo(totalSales, machine);
		vendor.setTitle("Vendor Information");
		vendor.setBounds(0, 0, 200, 100);
		vendor.setVisible(true);
		
	}
	 
	else {

		for (int i = 0; i < 9; i++) {
			if (pressed == buttonarray[i]) {
		
				if (stock[i] == 0) { //if no stock left for item selected, open error message window
					ErrorMessage error = new ErrorMessage();
					error.setTitle("Message");
					error.setBounds(0, 0, 200, 100);
					error.setVisible(true);
				}
				else {
					stock[i] -= 1; //removes 1 from stock
					labelsarray[i].setText(stock[i] + " left"); //overwrite text of label with new stock level
					totalSales += costArray[i]; //adds cost of purchased item to totalsales
					machine.setTotalSales(totalSales);
					if (stock[i] == 0) { //if no stock left, change label colour to red
						labelsarray[i].setOpaque(true);
						labelsarray[i].setBackground(Color.red);
						machine.setLabelArray(labelsarray);
					}
				}
			}
		}
	}
}

}
