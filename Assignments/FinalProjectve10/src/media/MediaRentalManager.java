package media;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class MediaRentalManager implements MediaRentalInt{
    // DataBase
    ArrayList<Customer> Customers = new ArrayList<>();
    ArrayList<Media> Medias = new ArrayList<>();
    int LIMITED_PLAN_VALUE = 2;
    public MediaRentalManager(){}
    private File f;
    public MediaRentalManager(String file){
        f = new File(file);
        readFromFile();
    }

    @Override
    //All comments for each of those public methods are listed on the project paper
    public boolean addCustomer(String name, String address, String plan, String ID, String mobileNumber){
        if(!customersID().contains(ID)){
            Customers.add(new Customer(name.replaceAll(" ","-"), address.replaceAll(" ","-"), plan.replaceAll(" ","-"),ID.replaceAll(" ","-"),mobileNumber.replaceAll(" ","-")));
            writeToFile();
            return true;
        }
        else System.out.println("Customer Already Exists!");
        return false;
    }


    @Override
    public boolean addMovie(String title, int CopiesAvailable, String rating) {
        if(!mediaListAsStrings().contains(title)){
            if(rating.equals("HR") || rating.equals("DR") || rating.equals("AC")) {
                Medias.add(new Movie(title, CopiesAvailable, rating));
                writeToFile();
                return true;
            }
            else {
                System.out.println("Rating "+ rating +" out of range");
            }
        }
        else {
            System.out.println("Title already exists");
        }
        return false;
    }


    @Override
    public boolean addAlbum(String title, int CopiesAvailable, String artist, String songs) {
        if(!mediaListAsStrings().contains(title)){
            Medias.add(new Album(title,CopiesAvailable,artist,songs));
            writeToFile();
            return true;
        }
        else System.out.println("Title already exists");
        return false;
    }


    @Override
    public boolean addGame(String title, int CopiesAvailable, double weight) {
        if(!mediaListAsStrings().contains(title)){
            Medias.add(new Game(title,CopiesAvailable,weight));
            writeToFile();
            return true;
        }
        else System.out.println("Title already exists");
        return false;
    }


    @Override
    public void setLimitedPlanLimit(int value) {
        if(!(value > 0)) LIMITED_PLAN_VALUE = value;
        else System.out.println("Value can't be less than or equal 0");
    }


    @Override
    public String getAllCustomersInfo() {
        StringBuilder str = new StringBuilder();
        Collections.sort(Customers);
        for(Customer x: Customers)
            str.append(x.toString()).append("\n");
        return str.toString();
    }
    public String getCustomerInfo(String customer_id){
        if(customersID().contains(customer_id)){
            Customer x = Customers.get(customersID().indexOf(customer_id));
            return x.displayString();
        }
        return "Media doesn't exist";
    }
    public String getMediaInfo(String mediaTitle){
        if(mediaListAsStrings().contains(mediaTitle)){
            Media x = Medias.get(mediaListAsStrings().indexOf(mediaTitle));
            return x.displayString();
        }
        return "Media doesn't exist";
    }

    @Override
    public String getALlMediaInfo() {
        StringBuilder str = new StringBuilder();
        Collections.sort(Medias);
        for(Media x: Medias)
            str.append(x.toString()).append("\n");
        return str.toString();
    }


    @Override
    public boolean addToCart(String customerID, String mediaTitle) { // do the error exceptions

       if (customersID().contains(customerID)) {
           Customer customer = Customers.get(customersID().indexOf(customerID));
           if (!(customer.getCart().contains(mediaTitle))&& !mediaTitle.equals("")) {
               customer.getCart().add(mediaTitle);
               writeToFile();
               return true;
           }
       }
       return false;
    }


    @Override
    public boolean removeFromCart(String customerId, String mediaTitle) {
        if (customersID().contains(customerId)){
            Customer customer = Customers.get(customersID().indexOf(customerId));
            if ((customer.getCart().contains(mediaTitle))) {
                customer.getCart().remove(mediaTitle);
                writeToFile();
                return true;
            }else{
                System.out.println(mediaTitle + " Doesn't Exist!");
            }
        }
        return false;
    }


   @Override
   public String processRequest() {
        StringBuilder str = new StringBuilder();
        Collections.sort(Customers);
        for (Customer customer : Customers) {
            if (customer.isPlan()) {
                while (!customer.getCart().isEmpty())
                    Handling(str,customer);
            }
            else {
                while (!customer.getCart().isEmpty())
                    if (customer.getRented().size() < LIMITED_PLAN_VALUE) {
                        Handling(str, customer);
                    } else{break;}
            }
        }
        writeToFile();
        return str.toString();
    }




    @Override
    public boolean returnMedia(String customerId, String mediaTitle) {
        if(customersID().contains(customerId)) {
            Customer customer = Customers.get(customersID().indexOf(customerId));
            if(customer.getRented().contains(mediaTitle)){
                Media media = Medias.get(mediaListAsStrings().indexOf(mediaTitle));
                customer.getRented().remove(mediaTitle);
                media.increment(); // increment copies by 1
                writeToFile();
                return true;

            }
            else{System.out.println("Media Doesn't Exist in Customer Rented list");}

        }
        else{System.out.println("Customer Doesn't Exist");}
        writeToFile();
        return false;
    }


    @Override
    public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
        ArrayList<String> a = searchByTitle(title);
        ArrayList<String> b = searchByRating(rating);
        ArrayList<String> c = searchByArtists(artist);
        ArrayList<String> d = searchBySongs(songs);
        return intersection(a,b,c,d);
    }
    public boolean deleteCustomer(String customerID){
        if(customersID().contains(customerID)) {
            Customer customer = Customers.get(customersID().indexOf(customerID));;
            for (String x:customer.getRented()){
                returnMedia(customerID  ,x);
            }
            Customers.remove(customersID().indexOf(customerID));
            writeToFile();
            return true;
        }
        return false;
    }
    public Customer getCustomer(String customerID){
        if (customersID().contains(customerID))
            return Customers.get(customersID().indexOf(customerID));
        return null;
    }
    public void updateCustomer(String CustomerID,String customerName,String CustomerMobile,String Plan,String customerAdress){
        Customer customer = Customers.get(customersID().indexOf(CustomerID));
        customer.setName(customerName.replaceAll(" ","-"));
        customer.setMobileNumber(CustomerMobile.replaceAll(" ","-"));
        customer.setPlan(Plan);
        customer.setAddress(customerAdress.replaceAll(" ","-"));
        writeToFile();
    }















                     /*           PRIVATE METHODS     */


    public ArrayList<Customer> getCustomers() {
        return Customers;
    }

    public ArrayList<Media> getMedias() {
        return Medias;
    }

    private void Handling(StringBuilder str, Customer customer) { // redundant code in processes request method
        String title = customer.getCart().get(0);
        if (mediaListAsStrings().contains(title)) {
            Media media = Medias.get(mediaListAsStrings().indexOf(title));
            if (media.getCopies() > 0) {
                if (!customer.getRented().contains(title)) {
                    customer.getRented().add(title);
                    media.decrement(); // decrement copies by 1
                    str.append("SUCCESS: Sending ").append(title).append(" to ").append(customer.getName()).append("\n");
                }else{str.append("FAILED: Sending ").append(title).append(" to ").append(customer.getName()).append("\n\t\t").append(title).append(" Media Already Rented!\n");}
            }else {str.append("FAILED: Sending ").append(title).append(" to ").append(customer.getName()).append("\n\t\t").append(title).append(" No Available Copies\n");}
        } else {
            str.append("FAILED: Sending ").append(title).append(" to ").append(customer.getName()).append("\n\t\t").append(title).append(" Doesn't exist in library\n");
        }
        customer.getCart().remove(0);
    }



    private ArrayList<String> intersection(ArrayList<String> a, ArrayList<String> b) { // the intersection operation between 2-sets
        ArrayList<String> temp = new ArrayList<>();
        int length = Math.min(a.size(), b.size());
        if (a.size() < b.size()) {
            for (int i = 0; i < length; i++)
                if (b.contains(a.get(i)))
                    temp.add(a.get(i));

        }else {
            for (int j = 0; j < length; j++)
                if (a.contains(b.get(j)))
                    temp.add(b.get(j));
        }
        return temp;
    }
    public String mediaType(String mediaTitle){
        return Medias.get(mediaListAsStrings().indexOf(mediaTitle)).getClass().toString().replaceAll("class media\\.","");
    }
    public Media getMedia(String mediaTitle){
        return  Medias.get(mediaListAsStrings().indexOf(mediaTitle));
    }

    private ArrayList<String> intersection(ArrayList<String> a, ArrayList<String> b,ArrayList<String> c,ArrayList<String> d){
        return intersection(intersection(a,b),intersection(c,d));
    }
    public void removeMedia(String mediaTitle){
        if(mediaListAsStrings().contains(mediaTitle))
            Medias.remove(mediaListAsStrings().indexOf(mediaTitle));
        writeToFile();
    }


    private void readFromFile() { // reading from file method
        try {
        Scanner in = new Scanner(f).useDelimiter("\\n"); // reading line by line
        while (in.hasNext()) {
            String line = in.next();
            if (line.startsWith("Customer")) { //checking  the data
                String[] tokens = line.split(" ", 7);
                addCustomer(tokens[1], tokens[2], tokens[3],tokens[4],tokens[5]);
                tokens[6] = tokens[6].replaceAll(" *, *", ",");
                String[] cartAndRented = tokens[6].split(" ");
                String[] Cart = cartAndRented[0].replaceAll("[\\[\\]\\n]", "").split(",");
                String[] Rented = cartAndRented[1].replaceAll("[\\[\\]\\n]", "").split(",");

                for (String Title : Cart)
                    addToCart(tokens[4], Title.trim());
                for (String Title : Rented)
                    addToRented(tokens[1], Title.trim());

            } else if (line.startsWith("Album")) {
                String[] tokens = line.split(" ");
                addAlbum(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
            } else if (line.startsWith("Game")) {
                String[] tokens = line.split(" ");
                addGame(tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
            } else if (line.startsWith("Movie")) {
                String[] tokens = line.split(" ");
                addMovie(tokens[1], Integer.parseInt(tokens[2]), tokens[3].trim());
            }
        }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
    }




    public void writeToFile(){ //writing to file
        try {
            PrintWriter writer = new PrintWriter(f);
            for (Customer customer : Customers) {
                writer.write(customer.toString() + "\n");

            }
            for (Media media : Medias)
                writer.write(media.toString() + "\n");
            writer.close();
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }




    private ArrayList<String> searchByTitle(String n) {
        if (n == null)
            return mediaListAsStrings();
        ArrayList<String> temp = new ArrayList<>();
        for(Media media: Medias)
            if(media.getTitle().equals(n))
                temp.add(media.getTitle());
        return temp;
    }




    private ArrayList<String> searchByRating(String n) {
        if (n == null)
            return mediaListAsStrings();
        ArrayList<String> temp = new ArrayList<>();
        for(Media media: Medias)
            if (media instanceof Movie)
                if(((Movie) media).getRating().equals(n))
                    temp.add(media.getTitle());
        return temp;
    }




    private ArrayList<String> searchByArtists(String n) {
        if (n == null)
            return mediaListAsStrings();
        ArrayList<String> temp = new ArrayList<>();
        for(Media media: Medias)
            if (media instanceof Album)
                if(((Album) media).getArtist().equals(n))
                    temp.add(media.getTitle());
        return temp;
    }




    private ArrayList<String> searchBySongs(String n) {
        if (n == null)
            return mediaListAsStrings();
        ArrayList<String> temp = new ArrayList<>();
        for(Media media: Medias)
            if(media instanceof Album){
                if(((Album) media).getSongs().contains(n))
                    temp.add(media.getTitle());
            }
        return temp;
    }




    public ArrayList<String> mediaListAsStrings(){
        ArrayList<String> temp = new ArrayList<>();
        for(Media media: Medias)
            temp.add(media.getTitle());
        return temp;
    }




    private ArrayList<String> customerListAsStrings(){
        ArrayList<String> temp = new ArrayList<>();
        for(Customer customer: Customers)
            temp.add(customer.getName());
        return temp;
    }
    public ArrayList<String> customersID(){
        ArrayList<String> temp = new ArrayList<>();
        for(Customer customer: Customers)
            temp.add(customer.getID());
        return temp;
    }



    private void addToRented(String customerName, String mediaTitle) {
        if (customerListAsStrings().contains(customerName)) {
            Customer customer = Customers.get(customerListAsStrings().indexOf(customerName));
            if (!(customer.getRented().contains(mediaTitle))&& !mediaTitle.equals("")) {
                customer.getRented().add(mediaTitle);
            }
        }
    }
}
