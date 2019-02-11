import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants.*;
import java.text.NumberFormat;
import java.util.Locale;

public class VendorInfo extends JFrame {

	private JLabel totalSales;
	private JButton resetStock;
	
	public VendorInfo(double cost, MachineInterface machine) {
		
		setLayout(null); // turns off default layout
		
		totalSales = new JLabel(); //initialise and add total sales label
		add(totalSales);
		totalSales.setText("Total sales = " + toCurrency(cost));
		totalSales.setBounds(40,0,120,20);
		
		resetStock = new JButton(); //initialise and add reset stock button
        resetStock.addActionListener(new VendorListener(resetStock, this, machine)); 
		add(resetStock);
		resetStock.setText("Reset Stock");
		resetStock.setBounds(40,30,120,30);
		
	}
	
	public String toCurrency (double price) { //formats decimal as a currency string
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        String newCurrency = currency.format(price);
        return newCurrency;
	}
    
    public JButton getReset() {
        return resetStock;
    }
    
    public void setLabelText(double cost) {
        totalSales.setText("Total sales = " + toCurrency(cost));
    }
}