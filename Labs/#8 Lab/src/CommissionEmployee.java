public class CommissionEmployee extends Employee{
    double commision_rate,gross_rate;

    public CommissionEmployee(String first_name,String last_name, long id,double commision_rate,double gross_rate) {
        super(first_name,last_name,id);
        this.commision_rate = commision_rate;
        this.gross_rate = gross_rate;
    }
    @Override
    public String toString() {  
        return "CommissionEmployee{" +
                "commision_rate=" + commision_rate +
                ", gross_rate=" + gross_rate +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    double earning() {
        return commision_rate*gross_rate;
    }
}
