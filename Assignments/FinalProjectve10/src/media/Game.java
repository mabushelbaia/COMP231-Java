package media;
public class Game extends Media{

    private double weight;
    public Game(String title, int copiesAvailable, double weight) {
        super(title,copiesAvailable);
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Game " +
                title + ' ' +
                copies + ' ' +
                weight;
    }
    public String displayString(){
        return "Title: " + title
                +"\nCopies: " + copies
                +"\nWeight: " + weight;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



}
