package Quiz2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = new int[6];
        System.out.println("Enter a-f, one by one");
        for(int i=0;i<a.length;i++) {
            a[i] = input.nextInt();
        }
        LinearEquations q = new LinearEquations(a);
        if (!q.isSolvable()) {
            System.out.println("System Has no solution!");
        }
        else {
            System.out.println("X = " + q.getX()+ " Y " + q.getY());
        }
    }
}