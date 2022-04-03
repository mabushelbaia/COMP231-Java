package media;
import java.util.ArrayList;

public class Customer extends MediaRentalManager implements Comparable<Customer> {
    private String name;
    private String address;
    private boolean plan;
    private ArrayList<String> cart;
    private ArrayList<String> rented;
    private String ID, mobileNumber;

    public void setPlan(boolean plan) {
        this.plan = plan;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String toString() {
        return "Customer " +
                name + " " +
                address + " " +
                getPlan() + " " +
                ID + " "+
                mobileNumber + " "+
                cart.toString() + " " +
                rented.toString();
    }
    public String displayString(){
        return  "Name: " + name
                +"\nAdress: " + address
                +"\nPlan: " + getPlan()
                +"\nID: " + ID
                +"\nPhone: " + mobileNumber
                +"\nCart: " + cart
                +"\nRented: " + rented;
    }
    public Customer(String name, String address, String plan, String ID, String mobileNumber) {
        this.name = name;
        this.address = address;
        this.plan = plan.equalsIgnoreCase("UNLIMITED");
        cart = new ArrayList<>();
        rented = new ArrayList<>();
        this.ID = ID;
        this.mobileNumber = mobileNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getPlan(){
        return plan?"UNLIMITED":"LIMITED";
    }
    public Boolean isPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan.equalsIgnoreCase("UNLIMITED");
    }

    public ArrayList<String> getCart() {
        return cart;
    }

    public void setCart(ArrayList<String> cart) {
        this.cart = cart;
    }

    public ArrayList<String> getRented() {
        return rented;
    }

    public void setRented(ArrayList<String> rented) {
        this.rented = rented;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    @Override
    public int compareTo(Customer o) {
        return this.getName().compareTo(o.getName());
    }
    @Override
    public boolean equals(Object obj) {
        return ((Customer) obj).getName().equals(name);
    }

    public String getID() {return ID;}
}
