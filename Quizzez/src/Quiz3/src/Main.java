import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> x = new ArrayList<>();
        for (int i=0;i<10;i++)
            x.add(in.nextInt());
        removeDuplicate(x);
        System.out.println(x.toString());

    }
    public static void removeDuplicate(ArrayList<Integer> list) {
        for(int i=0;i<list.size();i++){
            for (int j=0;j< list.size();j++){
                if(list.get(j).equals(list.get(i)) && i != j)
                    list.remove(i);
            }
        }
    }
}
