public class HourlyEmployee extends Employee{

        double wage,numberofHours;

        public HourlyEmployee(String first_name,String last_name, long id,double wage,double numberofHours) {
            super(first_name,last_name,id);
            this.numberofHours = numberofHours;
            this.wage = wage;
        }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id=" + id +
                ", wage=" + wage +
                ", numberofHours=" + numberofHours +
                '}';
    }

    @Override
        double earning() {
            return wage*numberofHours;

    }

}
