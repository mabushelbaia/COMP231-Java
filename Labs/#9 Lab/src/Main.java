import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class Main {

    public static void main(String[] args) throws Exception {
//        Circle circle = new Circle(-1);
        File file = new File("src\\students.txt");
        Scanner in = new Scanner(file).useDelimiter("\\n");
        PrintWriter writer =null;
        writer = new PrintWriter("src\\output.txt");
        while(in.hasNext()){
            String[] tokens = in.next().split(" ");
            double sum =0;
            for(int i=1;i<tokens.length;i++){
                sum += Double.parseDouble(tokens[i]);
            }
            writer.write(tokens[0] + " " + sum/3 + "\n" );

        }
        writer.close();

//        try{ //Question 1
//            System.out.println(binaryToDecimal("100111c"));
//        }catch (NumberFormatException ex){
//            System.out.println("HI");
//        }
    }

    public static long binaryToDecimal(String s)throws NumberFormatException{
        long sum = 0;
        int n = s.length() - 1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(n-i) != '0' && s.charAt(n-i) != '1'){
                throw new NumberFormatException();
            }

            if (s.charAt(n-i) == '1')
                sum += Math.pow(2,i);

        }
        return sum;
    }

}
