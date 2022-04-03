package Assignment1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[][] data = {{40.5,41,39.8,38.7},{41.2,41.3,40.7,40.8,41.3},{40.9,38.5,38.9,40.1,39.8},{38.2,37.9,38.2},{37.5,37.2}}; // for testing
//        Scanner input = new Scanner(System.in); // creating Scanner  object.
//        System.out.println("Enter the number of days that a patient has entered the hospital: ");
//        int days = input.nextInt(); //reading the number of days'
//        double[][] data = new double[days][]; // creating a 2D Array Object.
//        for (int i = 0; i < days; i++) {
//            System.out.println("Enter the number of times that nurse read the temperatures for day #" +(i+1)+": ");
//            int n_reads = input.nextInt();  // reading number of reads for each day.
//            data[i] = new double[n_reads]; //  creating the row Arrays on the 2D array.
//            for (int j = 0; j < n_reads; j++) {
//                System.out.println("Enter Read #" +  (j+1) + ": ");
//                double x = input.nextDouble(); // reading x
//                while (x < 30 || x > 45) { // input checking
//                    System.out.println("Error : Temp must be between 30-45");
//                    x = input.nextDouble(); // re-reading x in case of invalid input.
//                }
//                data[i][j] = x; // storing x in the array.
//
//            }
//        }
        double[] summary = Summary(data); // calling Summary() Method which takes the data 2D array and returns an array in this order {average, min, max}.
        System.out.println("Average : " + summary[0]);
        System.out.println("Min : " + summary[1]);
        System.out.println("Max : " + summary[2]);
        int[] count = countBelowAboveAverage(data, summary[0]); // calling Summary() Method which takes the data 2D array and the average, returns an array in this order {below_average, above_aberage}.
        System.out.println("Below : " + count[0]);
        System.out.println("Above : " + count[1]);
        printArray(sortArray(data));  // calling printArray() and giving it sortArray() as parameter, the latter returns an copy of the original 2D array sorted.
        if (leaveHospital(data)) // leaveHospital() a method that returns a boolean, according to the given condition.
            System.out.println("Yes!, You can leave the hospital.");
        else
            System.out.println("No!, You can't leave the hospital.");

    }


    public static double[] Summary (double[][] a) {
        double sum = 0; // creating sum counter.
        double min = a[0][0]; //giving min and max initial values.
        double max = a[0][0];
        int size = 0; //creating size counter.
        for (double[] i : a)
            for (double x: i) {
                sum += x; //adding the reads values to the sum.
                size++; //adding 1 to the size counter.
                if ( x < min) min = x; //
                if (x> max) max = x;
            }

        return new double[]{sum/size, min, max}; //returning anonymous array containing the average, minimum, and maximum reads.
    }


    public static int[] countBelowAboveAverage(double[][] a, double average) {
        int below = 0; // creating counters
        int above =0;
        for (double[] i: a)
            for( double j: i) {
                if (j <= average) below++; // adding one to below if the read is below or equals the average.
                else above++;  // adding one to above if the read is above average
            }
        return new int[]{below,above}; //returning anonymous array containing the below and above counters.
    }


    public static double[][] sortArray(double[][]a) {
        double[][] sorted_arr = new double[a.length][]; // creating a new array to copy data from the original array into.
        for (int i=0; i< a.length; i++) { // copying the data from the original array to temp array.
            sorted_arr[i] = new double[a[i].length];
            System.arraycopy(a[i], 0, sorted_arr[i], 0, a[i].length);
        }
        for (double[] arr: sorted_arr) { //sorting each row of the temp array.
            int n = arr.length -1;
            for (int i=0; i < n; i++) //bubble sort method
                for (int j=0; j < n-i;j++)
                    if (arr[j] > arr[j+1]) {
                        double temp = arr[j]; //swapping adjacent elements.
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }

        }
        return sorted_arr; //returning the temp array sorted.

    }


    public static void printArray(double[][]a) {
        System.out.println("Days\t # ofReadings\tActual Reading Per Day (in Celsius )"); //headings
        for(int i=0;i<a.length;i++) { // loop to go through each row
            System.out.print(i+1 + "\t\t\t" + a[i].length +"\t\t\t"); // first 2 columns " days + # of reads "
            for ( int j=0;j<a[i].length;j++) // remaining columns "reads"
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }


    public static boolean leaveHospital(double[][]a) {
        double[][] arr  = sortArray(a); // sorting array so the last element "read" in the row is the maximum. "note that the sortArray() sort a temp array not the original array"
        double x1,x2,y1,y2;
        if (arr[arr.length - 1].length >= 2 || arr[arr.length - 2].length >= 2) { // checking if the patient had at least 2 reads in the last 2 days.
            x1 = arr[arr.length - 1][arr[arr.length - 1].length - 1]; // last read in the last day.
            x2 = arr[arr.length - 1][arr[arr.length - 1].length - 2]; // second last read in the last day.
            y1 = arr[arr.length - 2][arr[arr.length - 2].length - 1]; // last read in the second last day.
            y2 = arr[arr.length - 2][arr[arr.length - 2].length - 2]; // second last read in the second last day.
        }
        else
            return false; // if he didn't have at least 2 reads taken in the last 2 days the method will return false. "not specified what do in the assignment"
        double avg = (x1+x2+y1+y2)/4;
        return 35.5 < avg && avg < 36.5; // returns a boolean expression.
    }
}
