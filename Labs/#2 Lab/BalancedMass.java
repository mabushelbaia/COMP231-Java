import java.util.*;
public class BalancedMass {
	public static void main(String[]args) {
		double w_poundes , h_inches, BMI;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Height :");
		h_inches = input.nextDouble() * 0.39;
		System.out.println("Enter Weight:");
		w_poundes = input.nextDouble() * 2.2;
		
		BMI = (w_poundes * 703)/(h_inches * h_inches );
		System.out.println(BMI);
		if ( 15 <= BMI && BMI < 19)
			System.out.println("Under Weight");

		else if ( 19 <= BMI && BMI < 25 )
			System.out.println("Normal");

		else if ( 25 <= BMI && BMI < 30)
			System.out.println("Over Weight");
		else
			System.out.println("Not included");
		
}
}