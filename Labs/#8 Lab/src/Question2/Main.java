package Question2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] arr = new Shape[5];
        arr[0] = new Circle(10);
        arr[1] = new Circle(11);
        arr[2] = new Rectangle(100,99);
        arr[3] = new Rectangle(75,100);
        arr[4] = new Rectangle(95,100);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void sort(Shape[] a) {
        int i, j;
        for (i = 0; i < a.length - 1; i++)
            for (j = 0; j < a.length - i - 1; j++)
                if (a[j].compareTo(a[j+1]) == 1) {
                    Shape temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
    }
}
