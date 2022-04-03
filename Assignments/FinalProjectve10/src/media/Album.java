package media;

public class Album extends Media{
    private String artist;
    private String songs;

    @Override
    public String toString() {
        return "Album " +
                title + ' ' +
                copies + ' ' +
                artist + ' ' +
                songs ;
    }
    public String displayString(){
        return "Title: " + title
                +"\nCopies: " + copies
                +"\nArtist: " + artist
                +"\nSongs: " + songs;
    }

    public Album(String title, int copiesAvailable, String artist, String songs) {
        super(title,copiesAvailable);
        this.artist = artist;
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }


}
