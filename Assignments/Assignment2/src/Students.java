
public class Students {
    private String last_name, first_name, birth_date;
    private long ID;
    private double grade;


    public Students(String first_name, String last_name, long ID,String birth_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.ID = ID;
        this.birth_date = birth_date;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {return (first_name.charAt(0) + last_name + "@ritaj.birzeit.edu").toLowerCase();}

    public long getID() {return ID;}

    public String getBirth_date() {return birth_date;}

    public String getFirst_name() {return first_name;}

    public void setID(long ID) {this.ID = ID;}

    public void setBirth_date(String birth_date) {this.birth_date = birth_date;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public String getName() {
        return first_name + " " + last_name;
    }
    public String getRequestedOutput() {
        return this.getName() + ", " + this.getEmail() + ", " + this.getGrade();
    }
}
