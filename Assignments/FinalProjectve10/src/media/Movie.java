package media;
public class Movie extends Media{
    private String rating;
    public Movie(String title, int copies, String rating) {
        super(title,copies);
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Movie " +
                title + ' ' +
                copies + ' ' +
                rating;
    }

    public String displayString(){
        return "Title: " + title
                +"\nCopies: " + copies
                +"\nRating: " + rating;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
