public class BaseCommissionEmployee extends CommissionEmployee{
    double base_salary;

    public BaseCommissionEmployee(String first_name, String last_name, long id, double commision_rate, double gross_rate, double base_salary) {
        super(first_name, last_name, id, commision_rate, gross_rate);
        this.base_salary = base_salary;
    }

    @Override
    double earning() {
        return super.earning()+ base_salary;
    }

    @Override
    public String toString() {
        return "BaseCommissionEmployee{" +
                "base_salary=" + base_salary +
                ", commision_rate=" + commision_rate +
                ", gross_rate=" + gross_rate +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id=" + id +
                '}';
    }
    public int compareTo(Employee e){
        if (this.earning()>e.earning())
            return 1;
        else if(this.earning()<e.earning())
            return -1;
        else
            return 0;
    }
}
