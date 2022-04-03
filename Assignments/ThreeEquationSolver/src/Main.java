import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            System.out.println("Enter Equations");
            double[][] a = new double[3][4];
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < a[i].length; j++)]\\\
                    a[i][j] = in.nextDouble();

            findSolution(a);

    }
    static void findSolution(double[][] coefficients)
    {
        // Matrix d using coeff as given in cramer's rule
        double[][] d = {
                { coefficients[0][0], coefficients[0][1], coefficients[0][2] },
                { coefficients[1][0], coefficients[1][1], coefficients[1][2] },
                { coefficients[2][0], coefficients[2][1], coefficients[2][2] },
        };

        // Matrix d1 using coeff as given in cramer's rule
        double[][] d1 = {
                { coefficients[0][3], coefficients[0][1], coefficients[0][2] },
                { coefficients[1][3], coefficients[1][1], coefficients[1][2] },
                { coefficients[2][3], coefficients[2][1], coefficients[2][2] },
        };

        // Matrix d2 using coeff as given in cramer's rule
        double[][] d2 = {
                { coefficients[0][0], coefficients[0][3], coefficients[0][2] },
                { coefficients[1][0], coefficients[1][3], coefficients[1][2] },
                { coefficients[2][0], coefficients[2][3], coefficients[2][2] },
        };

        // Matrix d3 using coeff as given in cramer's rule
        double[][] d3 = {
                { coefficients[0][0], coefficients[0][1], coefficients[0][3] },
                { coefficients[1][0], coefficients[1][1], coefficients[1][3] },
                { coefficients[2][0], coefficients[2][1], coefficients[2][3] },
        };

//         Calculating Determinant of Matrices d, d1, d2, d3
        double D = determinantOfMatrix(d);
        double D1 = determinantOfMatrix(d1);
        double D2 = determinantOfMatrix(d2);
        double D3 = determinantOfMatrix(d3);
        System.out.printf("D is : %.6f \n", D);
        System.out.printf("D1 is : %.6f \n", D1);
        System.out.printf("D2 is : %.6f \n", D2);
        System.out.printf("D3 is : %.6f \n", D3);

        // Case 1
        if (D != 0)
        {
            // Coeff have a unique solution. Apply Cramer's Rule
            double x = D1 / D;
            double y = D2 / D;
            double z = D3 / D; // calculating z using cramer's rule
            System.out.printf("Value of x is : %.6f\n", x);
            System.out.printf("Value of y is : %.6f\n", y);
            System.out.printf("Value of z is : %.6f\n", z);
        }

        // Case 2
        else
        {
            if (D1 == 0 && D2 == 0 && D3 == 0)
                System.out.print("Infinite solutions\n");
            else System.out.print("No solutions\n");
        }
    }
    public static double determinantOfMatrix(double[][] mat) {
        return (mat[0][0] * (mat[1][1] * mat[2][2] - mat[2][1] * mat[1][2])
                - mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0])
                + mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]));
    }
}
