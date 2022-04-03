import java.util.Scanner;
public class ConvertProgram{
    final static double KMS_PER_MILES=1.609;
    public static void main(String[]args){
        double miles, kms;
        System.out.println("Please enter the number in miles.");
        Scanner input = new Scanner(System.in);
        miles = input.nextDouble();
        kms = miles * KMS_PER_MILES;
        System.out.println("Result " + kms);
    }
}
