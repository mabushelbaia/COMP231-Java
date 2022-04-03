public abstract class Employee {
    protected String first_name, last_name;
    protected long id;

    public Employee(String first_name, String last_name, long id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
    }

    abstract double earning();

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id=" + id +
                '}';
    }
}
