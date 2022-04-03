package media;
import java.util.ArrayList;
public interface MediaRentalInt {
    boolean addCustomer(String name, String address, String plan, String ID, String mobileNumber);
    boolean addMovie(String title, int CopiesAvailable, String rating);
    boolean addAlbum(String title, int CopiesAvailable, String artist, String songs);
    boolean addGame(String title, int CopiesAvailable, double weight);
    void setLimitedPlanLimit(int value);
    String getAllCustomersInfo();
    String getALlMediaInfo();
    boolean addToCart(String customerName,String mediaTitle);
    boolean removeFromCart(String customerName,String mediaTitle);
    String processRequest();
    boolean returnMedia(String customerName,String mediaTitle);
    ArrayList<String> searchMedia(String title, String rating, String artist, String songs);
}
