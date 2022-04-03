import javax.swing.*;  
public class OptionPaneExample {  
JFrame f;  
OptionPaneExample(){  
    f=new JFrame();  
    String name=JOptionPane.showInputDialog(f,"Enter Number of Miles.");      
}  
public static void main(String[] args) {  
    new OptionPaneExample();  
}  
}  