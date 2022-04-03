import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*100);
        }
        selectionSort(arr);
        System.out.println(Arrays.toString(reverse(arr)));
    }
    public static int[] reverse(int[]x){
        int[] result = new int[x.length];
        for(int i=x.length-1;i>0;i--){
            result[result.length-i-1] = x[i];
        }
        return result;
    }
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min = arr[i];
            int minIndex = i;
            for (int j=i+1;j< arr.length;j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
//    public static void main(String[] args) {
//        Employee[] a = new Employee[4];
//        a[0] = new HourlyEmployee("Ahmad","Mohammad",1231,10,10);
//        a[1] = new BaseCommissionEmployee("Ahmad","Mohammad",1231,0.30,1000,1000);
//        a[2] = new CommissionEmployee("Ahmad","Mohammad",1231,0.30,1200);
//        a[3] = new SalariedEmployee("Ahmad","Mohammad",1231,1250);
//        System.out.println(totalEarning(a));
//        sort(a);
//        for(Employee x: a)
//            System.out.println(x.earning() +" " + x);
//    }
//    public static double totalEarning(Employee[] a){
//        double earnings=0;
//        for(Employee x: a){
//
//            earnings += x.earning();
//        }
//        return earnings;
//    }
//    public static void sort(Employee[] a){
//        int i,j;
//        for(i=0;i<a.length - 1;i++)
//            for(j=0;j<a.length-i-1;j++)
//                if(a[j].earning()>a[j+1].earning()){
//                    Employee temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//
//    }
//}
