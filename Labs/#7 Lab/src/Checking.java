public class Checking extends Account{
    @Override
    public String toString() {
        return "Checking{" +
                "id=" + id +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public Checking() {
    }

    public Checking(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void widthraw(double money) {
        if (money <= balance +1000)
            balance -= money;
        else System.out.println("insufficient funds");
    }
}
