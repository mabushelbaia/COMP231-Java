import java.util.Date;

public class Account {
    int id;
    double balance;
    java.util.Date dateCreated;

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void widthraw(double money) {
        if (money <= balance)
            this.balance -= money;
        else System.out.println("insufficient funds");
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                '}';
    }
    public void deposit(double money){
        this.balance += money;
    }

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.dateCreated = new Date();
    }
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }
}
