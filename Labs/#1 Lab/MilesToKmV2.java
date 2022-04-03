import javax.swing.*;  
public class MilesToKmV2{  
	JFrame f;  
	MilesToKmV2(){  
    		f=new JFrame();
		double miles, kms;  
    		String name=JOptionPane.showInputDialog(f,"Enter Number of Miles.");
		kms = miles * 1.609;
		JOptionPane.showMessageDialog(null, "Kilometers: ");  
	}  
	public static void main(String[] args) {  
    		new OptionPaneExample();  
	}  
}  