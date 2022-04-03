
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // new scanner

        System.out.println("Enter Number of Classes: ");
        int numberClasses = input.nextInt(); // reading the number of classes
        Students[][] arr = new Students[numberClasses][]; // creating a matrix contest of numberClasses : rows, with number of students on each.


        for (int i=0;i<numberClasses;i++) { // loop to read numberStudents in each class.
            System.out.println("Enter Number of Students in Class#" + (i + 1) + ": ");
            int numberStudents = input.nextInt(); // reading numberStudents

            while (numberStudents <= 1 || numberStudents >= 100) {  // input validation
                System.out.println("Error : Number of students must be between 1-100 exclusive.");
                numberStudents = input.nextInt();
            }
            arr[i] = new Students[numberStudents]; // setting the rows of each class
            for (int j=0;j<numberStudents;j++) { // loop to enter data for each student
                Scanner scanner = new Scanner(System.in).useDelimiter("\\n"); // .useDelimiter("\\n") : reads the input till the specified delimiter

                String rawInput = scanner.next(); // reading each line
                String[] tokens = rawInput.split(" "); // splitting data
                arr[i][j] =  new Students(tokens[0],tokens[1],Long.parseLong(tokens[2]), tokens[3]); // tokens[0-3] , f_name, l_name, id, birthdate
                // parseLong(): casting string into long datatype

            }
        }

        for (int i=0;i<numberClasses;i++) { // loop to sort each class and printing data accordingly
            sortStudents(arr[i]); // sorting method
            System.out.println("\nClass #"+(i+1)+" Sorted:");
            for (int j=0;j<arr[i].length;j++) {
                System.out.println(arr[i][j].getName()); // getName() : method in Students returns f_name + l_name as string
            }

        }
        for (int i=0;i<numberClasses;i++) { // loop to enter grades
            System.out.println("\nEnter Grades for CLASS #"+(i+1)+": ");
            for (int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j].getName() + ": ");
                arr[i][j].setGrade(input.nextDouble()); // entering grade
            }

        }
        for (int i=0;i<numberClasses;i++) {
            System.out.println("\nClass #"+(i+1)+" Ordering:");
            for (int j=0;j<arr[i].length;j++) {
                System.out.println(arr[i][j].getRequestedOutput()); // getRequestedOutput() method in student returns getName() + email + grade as string
            }
            System.out.println("Average of Class: "+ classAverage(arr[i])); // classAverage(arr[i])  Calculating Average method

        }

    }

    public static void sortStudents(Students[] studentsArr) { // sorting method : sorts each class independently
        int[][] frequency = new int[26][studentsArr.length]; // initializing matrix for the redundancy of each letter in the last name
        char ch = 'a';
        for (int i=0;i<26;i++){ //loop to fill the matrix with data accordingly
            for(int j=0;j< studentsArr.length;j++){
                frequency[i][j] = charCount(studentsArr[j].getLast_name(),ch); // CharCount method
            }
            ch++;
        }
        int i,j,k;
        for (i=0;i<studentsArr.length-1;i++) // normal bubble sort method
            for(j=0;j<studentsArr.length-i-1;j++){
                for(k=0;k<26;k++)
                    if(frequency[k][j] != frequency[k][j+1]) // k : first letter index at which the redundancy is different between 2 strings
                        break;
                if(frequency[k][j] < frequency[k][j+1]) {  // swapping the string & index according to k to the correct position
                    Students temp = studentsArr[j+1];
                    studentsArr[j+1] = studentsArr[j];
                    studentsArr[j] = temp;
                    int tempInt = frequency[k][j+1];
                    frequency[k][j+1] = frequency[k][j];
                    frequency[k][j] = tempInt;
                }

            }
    }

    public static int charCount(String str, char ch) { // method to find the frequency of certain letter in a string
        int count = 0;
        for(int i=0;i<str.length();i++)
            if(str.toLowerCase().charAt(i) ==  ch)
                count++;
        return count;
    }

    public static double classAverage(Students[] students) { // method to find average of the class
        double sum = 0;
        for (Students student : students) {
            sum += student.getGrade();
        }
        return sum/students.length;
    }

}
