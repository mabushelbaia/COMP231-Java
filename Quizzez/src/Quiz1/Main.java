public class Main {

    public static void main(String[] args) {
        for (int i=0;i<=10000;i++)
            if (isMagic(i))
                System.out.println(i);
    }
    public static boolean isMagic (int n) {
        int digit, even = 0, odd = 0;
        for(int i=0 ; n != 0; i++){
            digit = n%10;
            if (i % 2 == 0)
                even += digit;
            else
                odd += digit;
            n /= 10;
        }
        return even == odd;

    }
}
