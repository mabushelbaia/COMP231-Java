package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(exponential(1));
        for (int i=1;i<=10000;i++)
            if (isPerfect(i))
                System.out.println(i);
        System.out.println(toBinary(1023));
        System.out.println(toDecimal(toBinary(128)));
    }

    public static double exponential ( double num) {
        double sum = 0;
        int d = 0;
        while (Math.pow(num, d) / factorial(d) > 0.00000001) {
            sum += Math.pow(num, d) / factorial(d);
            d++;
        }
        return sum;
    }
    public static long factorial (long num) {
        int sum = 1;
        for (int i=2; i<=num; i++)
            sum *= i;
        return sum;
    }
    public static boolean isPerfect (int num) {
        int sum = 0;
        for(int i =1; i<num ;i++)
            if (num%i == 0)
                sum += i;
        return sum == num;
    }
    public static long toBinary (long num) {
        int binary_num = 0;
        int d = 0;
        while( num != 0) {
            if (num % 2 == 1)
                binary_num += 1 * Math.pow(10, d);
            d++;
            num /= 2;
        }
        return binary_num;
    }
    public static long toDecimal (long num) {
        int decimal_num = 0, d = 0;
        while(num != 0) {
            decimal_num += num%10 * Math.pow(2,d);
            num /= 10;
            d++;
        }
        return decimal_num;
    }
}
