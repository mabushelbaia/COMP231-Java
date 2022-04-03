package media;

public  class Media extends MediaRentalManager implements Comparable<Media> {
    protected String title;
    protected int copies;

    public Media(String title, int copies) {
        this.title = title;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    public void increment(){
        this.copies += 1;
    }
    public void decrement(){
        this.copies -= 1;
    }
    @Override
    public int compareTo(Media o) {
        return this.getTitle().compareTo(o.getTitle());
    }
    public String displayString(){
      return title + " " + copies;
    }

}