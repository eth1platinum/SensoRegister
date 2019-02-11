import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants.*;
import java.awt.Graphics;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;

public class MachineInterface extends JFrame {

	private String[] buttonLabels;
	private double[] allCosts;
	private JButton[] allButtons;
	private JLabel[] allLabels;
	private int[] stockLevels;
	private JButton vendInfoButton;
	private double totalSales;
	private JLabel nameLabel;

public MachineInterface(String userName) {

	buttonLabels = new String[9];
	allCosts = new double[9];
	allButtons = new JButton[9];
	allLabels = new JLabel[9];
	stockLevels = new int[9];
	int x;
	int y;
	int i;
	
	setLayout(null); // turns off default layout
	
	x = 40;
	y = 20;
	i = 0;
	
	for (int out = 0; out < 3; out++) { //initialise and add all buttons to frame
		Color[] colourArray = {Color.red, Color.cyan, Color.green}; //used to change colour of buttons
		y = 20;
		for (int in = 0; in < 3; in++) {
	
			allButtons[i] = new JButton();
			allButtons[i].addActionListener(new ClickListener(allButtons[i], this, totalSales));
			add(allButtons[i]);
			allButtons[i].setBounds(x, y, 225, 20);
			allButtons[i].setBackground(colourArray[out]); //will set button to currently selected colour in colourArray
			y += 70; //moves the y co-ordinate of the next button
			i += 1; //next button
		}
		x += 250; //moves the x co-ordinate of the next button
	}
	
	
    
    for (int k = 0; k < stockLevels.length; k++) {
        stockLevels[k] = 4; //set stock of all items = 4
    }
	
	x = 140;
	y = 50;
	i = 0;
	
	for (int out = 0; out < 3; out++) { //initialise and add all labels to frame
		y = 50;
		for (int in = 0; in < 3; in++) {
	
		allLabels[i] = new JLabel(stockLevels[i] + " left");
		add(allLabels[i]);
		allLabels[i].setBounds(x, y, 30, 20);
		y += 70; //moves the y co-ordinate of the next label
		i += 1;
		}
		x += 250; //moves the x co-ordinate of the next label
	}
	
	//initialise and add vendor information button
	vendInfoButton = new JButton("Vendor Information");
	vendInfoButton.addActionListener(new ClickListener(vendInfoButton, this, totalSales));
	add(vendInfoButton);
	vendInfoButton.setBounds(630, 240, 150, 20);
	vendInfoButton.setVisible(true);
	
	nameLabel = new JLabel("Logged in as: " + userName);
		add(nameLabel);
		nameLabel.setBounds(10, 0, 200, 20);
	
		
	setCosts();
	setButtonLabels();
	
	}
	
	public JButton[] getButtonArray() {
		return allButtons;
	}
	
	public void setButtonArray(JButton[] array) {
		allButtons = array;
	}
	
	public JLabel[] getLabelArray() {
		return allLabels;
	}
	
	public void setLabelArray(JLabel[] array) {
		allLabels = array;
	}
	
	public int[] getStockLevels() {
		return stockLevels;
	}
	
	public void setStockLevels(int[] array) {
		stockLevels = array;
	}
	
	public JButton getvendinfo() {
		return vendInfoButton;
	}
	
	public void setCosts(double[] array) {
		allCosts = array;
	}
	
	public double[] getCosts() {
		return allCosts;
	}
	
	public void setTotalSales(double value) {
		totalSales = value;
	}
	
	public double getTotalSales() {
		return totalSales;
	}
	
	public void setButtonLabels() { //set the text of each button
		buttonLabels[0] = "Budweiser (" + toCurrency(allCosts[0]) + ")";
		buttonLabels[1] = "Corona (" + toCurrency(allCosts[1]) + ")";
		buttonLabels[2] = "Hooch (" + toCurrency(allCosts[2]) + ")";
		buttonLabels[3] = "VK (" + toCurrency(allCosts[3]) + ")";
		buttonLabels[4] = "Coors (" + toCurrency(allCosts[4]) + ")";
		buttonLabels[5] = "Desperados (" + toCurrency(allCosts[5]) + ")";
		buttonLabels[6] = "House Vodka (" + toCurrency(allCosts[6]) + ")";
		buttonLabels[7] = "Promo Shots (" + toCurrency(allCosts[7]) + ")";
		buttonLabels[8] = "Bombs (" + toCurrency(allCosts[8]) + ")";
		
		for (int i = 0; i < 9; i++) {
			allButtons[i].setText(buttonLabels[i]);
		}
	}
	
	public void setCosts() { //set the cost of each item
		allCosts[0] = 3.7;
		allCosts[1] = 3.7;
		allCosts[2] = 3.9;
		allCosts[3] = 3.6;
		allCosts[4] = 3.7;
		allCosts[5] = 3.7;
		allCosts[6] = 3.7;
		allCosts[7] = 1.0;
		allCosts[8] = 2.0;
	}
    
    public void resetStock() { //resets all stock levels to 4 and overwrites all labels
        for (int i = 0; i < stockLevels.length; i++) {
            stockLevels[i] = 4;
            allLabels[i].setText(stockLevels[i] + " left");
        }
    }
	
	public String toCurrency (double price) { //formats a decimal as a currency string
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        String newCurrency = currency.format(price);
        return newCurrency;
	}
}