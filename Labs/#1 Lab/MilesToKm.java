import javax.swing.*;  
public class MilesToKm{  
	JFrame f;  
	MilesToKm(){  
    		f=new JFrame();
		double miles, kms;
		String input;
		input = JOptionPane.showInputDialog("Enter Length"); 
		miles = Integer.parseInt(input);
		kms = miles * 1.609;
		JOptionPane.showMessageDialog(null,
                                    "Kilometers: " + kms); 
	}  
	public static void main(String[] args) {  
    		new MilesToKm();  
	}  
}  