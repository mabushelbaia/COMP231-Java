import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] building = new int[5];
        Scanner input = new Scanner(System.in);
        System.out.println(building.length);
        for (int j=0; j< building.length;j++){
            building[j] = input.nextInt();
        }
        int sum = 0,below = 0, above=0;
        for (int j : building)
            sum += j;
        int average = sum/building.length;
        for (int x: building){
            if (x > average)
                above++;
            else if (x < average)
                below++;
        }
        System.out.println("Sum: "+ sum +"\nAverage: " + average + "\nBelow: " + below +"\nAbove: " + above);
        int[][] ages = new int[building.length][];
        for (int j=0;j< building.length;j++)
            ages[j] = new int[building[j]];
        for (int i =0; i < building.length;i++) {
            System.out.println("Enter Ages of people in apartment " + i);
            for (int x = 0; x < building[i]; x++) {
                ages[i][x] = input.nextInt();
            }

        }
        System.out.println("Average Age: " + averageAge(ages));
        System.out.println("Enter The Number of people in a certain apertment ");
        int flag;
        flag = input.nextInt();
        System.out.println("The Building is: " + linearSearch(building, flag));
    }
    public static int averageAge(int[][]a){
        int sum = 0, size = 0;
        for (int[] j : a)
            for (int x: j) {
               sum += x;
               size++;
            }
        return sum/size;
    }
    public static int linearSearch(int[]a, int key){
        for(int i=0;i<a.length;i++){
            if (a[i] == key)
                return  i;
        }
        return -1;
    }
}


