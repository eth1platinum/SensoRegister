import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
public class VendorListener implements ActionListener {
	
	private MachineInterface machine;
	private VendorInfo vInfo;
	private double totalSales;
	
public VendorListener(JButton target, VendorInfo window1, MachineInterface window2) {
	vInfo = window1;
    machine = window2;
	
}

public void actionPerformed(ActionEvent event) {
	
	JButton pressed = (JButton) event.getSource(); //overwrites 'pressed' with the source of the click
	totalSales = machine.getTotalSales(); //import arrays and variables from machine and vInfo objects
	JButton[] buttonarray = machine.getButtonArray();
	JLabel[] labelsarray = machine.getLabelArray();
	int[] stock = machine.getStockLevels();
	JButton vendinfo = machine.getvendinfo();
	double[] costArray = machine.getCosts();
    JButton reset = vInfo.getReset();
	
	machine.resetStock(); //resets each label to show original stock levels
    machine.setTotalSales(0.0); //reset total sales and overwrite label with new total
    vInfo.setLabelText(0.0);
	
	for (int i = 0; i < labelsarray.length; i++) { //returns any red labels back to the normal background
		labelsarray[i].setBackground(null);
	}
}

}
