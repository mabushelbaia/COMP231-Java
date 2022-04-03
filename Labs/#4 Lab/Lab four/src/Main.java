
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student []array = new Student[3];
        for (int j=0;j< array.length;j++) {
            array[j] = new Student();
            System.out.println("Enter Name: ");
            array[j].setStudentName(input.next());
            System.out.println("Enter Age: ");
            array[j].setStudentId(input.nextInt());
            System.out.println("Enter Grade: ");
            array[j].setStudentGrade(input.nextDouble());
        }
        Student smartest = smartestStudent(array);
        System.out.println(smartest.getStudentGrade() +" "+ smartest.getStudentName());
    }
    public static Student smartestStudent(Student[] a){
        double max_grade = a[0].getStudentGrade();
        int max_index = 0;
        for (int i=0; i < a.length; i++) {
            if (a[i].getStudentGrade() > max_grade)
                max_index = i;

        }
        return a[max_index];
    }
}
