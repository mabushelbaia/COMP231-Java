public class SalariedEmployee extends Employee{
    double weekly_Salary;

    public SalariedEmployee(String first_name,String last_name, long id,double weekly_Salary) {
        super(first_name,last_name,id);
        this.weekly_Salary = weekly_Salary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id=" + id +
                ", weekly_Salary=" + weekly_Salary +
                '}';
    }

    @Override
    double earning() {
        return weekly_Salary*4;
    }
}
