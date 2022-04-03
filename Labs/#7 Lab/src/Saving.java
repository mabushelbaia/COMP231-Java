public class Saving extends Account{
    public Saving() {
    }

    public Saving(int id, double balance) {
        super(id, balance);
    }

    @Override
    public String toString() {
        return "Saving{" +
                "id=" + id +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
