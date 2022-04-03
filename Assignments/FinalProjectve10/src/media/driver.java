package media;

public class driver {


    public static void main(String[] args) {
        MediaRentalManager manager = new MediaRentalManager("src/files/DataBase.txt");
        System.out.println(manager.getAllCustomersInfo());
    }
}
