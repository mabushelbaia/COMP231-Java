
import java.util.*;
public class Employee {
        int departmentNo;
        String name;
        long ID;
        double basicSalary;
        Date hireDate;
        Date birthDate;

        public Employee() {

        }
        public Employee(int dep_num,String emp_name, long emp_ID,double emp_salary, Date hire_date, Date birth_date) {
                departmentNo = dep_num;
                name = emp_name;
                ID = emp_ID;
                basicSalary = emp_salary;
                birthDate = birth_date;
                hireDate = hire_date;
        }

        public void setDepartmentNo(int departmentNo) {
                this.departmentNo = departmentNo;
        }

        public void setBasicSalary(double basicSalary) {
                this.basicSalary = basicSalary;
        }

        public void setID(long ID) {
                this.ID = ID;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }

        public double getBasicSalary() {
                return basicSalary;
        }

        public int getDepartmentNo() {
                return departmentNo;
        }

        public long getID() {
                return ID;
        }
        public void printEmployeeInfo() {
                System.out.println(departmentNo + " " + ID + " " + name + " " + basicSalary + " " + hireDate+ " " + birthDate);
        }
}
