import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentName;
    private double studentGrade;
    public Student() {

    }
    public Student(int stId, String stName,double stGrade) {
        studentId = stId;
        studentName = stName;
        studentGrade = stGrade;
    }
    public void setStudentId(int number) {
        studentId = number;
    }
    public int getStudentId() {
        return studentId;
    }
    public double getStudentGrade() {
        return studentGrade;
    }
    public void setStudentName(String name) {
        studentName = name;
    }
    public void setStudentGrade(String grade) {
        studentName = grade;
    }
    public String getStudentName() {
        return studentName;
    }


    }
}