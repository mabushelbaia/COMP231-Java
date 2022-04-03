import java.util.*;
public class Prime {
    public static void main(String[] args) {
        int i;
        for (i = 100; i <= 200; i++)
            if (is_prime(i))
        System.out.println(i);
    }
    public static boolean is_prime(int number) {
        int i;
        for (i = 2; i < number ;i++)
            if (number % i == 0)
                return false;
        return true;
    }
}
