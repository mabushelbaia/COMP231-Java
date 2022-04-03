public class Main {

    public static void main(String[] args) {
        Saving x = new Saving(100, 9999);
        Checking y = new Checking(199, 9999);
        x.widthraw(10000);
        y.widthraw(10999);
        System.out.println(x +"\n" + y);
    }
}
