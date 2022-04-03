
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
    public void setStudentName(String name) {
        studentName = name;
    }
    public void setStudentGrade(double grade) {
        studentGrade = grade;
    }

    public String getStudentName() {
        return studentName;
    }
    public int getStudentId() {
        return studentId;
    }
    public double getStudentGrade() {
        return studentGrade;
    }

}
