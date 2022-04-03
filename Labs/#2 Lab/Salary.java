import java.util.*;
public class Salary {
	public static void main(String[]args) {
		int hours;
		double price, salary;
		while (true){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter hours worked (-1 to end): ");
		hours = input.nextInt();
		if (hours == -1)
			break;
		System.out.println("Enter hourly rate of the worker ($00.00): ");
		price = input.nextDouble();

		if (hours > 40)
			salary = 40 * price + (hours - 40) * 1.5 * price;
		else
			salary = hours * price;
		System.out.println("Salary: " + salary);

}
		
}
}