

=
public class Main {

    public static void main(String[] args) {
//        Employee[]array = new Employee[4];
//        array[0] = new Employee(4, "Mohammad", 1200198, 3000.0,new Date() ,new Date() );
//        array[1] = new Employee(5, "Ahmad", 1200199, 5000.5, new Date()  ,new Date()  );
//        array[2] = new Employee(1, "Mahmoud", 1100198, 3500.0,new Date()   ,new Date()  );
//        array[3] = new Employee(3, "Amro", 1280100, 9000.0, new Date()  ,new Date()  );
//        largestSalary(array).printEmployeeInfo();
//        MyArray x = new MyArray(new int[]{10, 20, 30, 40, 50, 60});
//        System.out.println(x.max());
//        System.out.println(x.min());
//        System.out.println(x.average());
//        System.out.println(x.getSize());
//        x.printArray();
    City[]array = new City[4];
    array[0] = new City("Ramallah", 90, 80, 22);
    array[1] = new City("Nablus", 5, 80, 27);
    array[2] = new City("Hebron", 90, 5, 17);
    array[3] = new City("Yafa", 90, 5, 13);
    belowAverage(array,24);
    }
    public static void belowAverage( City [ ] cities , int avgTemp) {
        for ( City x : cities) {
            if (x.getTempreture() < avgTemp)
                x.printCityInfo();
        }

    }
//    public static Employee largestSalary ( Employee [ ] employees) {
//            double largest = employees[0].getBasicSalary();
//            int largest_index = 0;
//            for (int i=0; i<employees.length; i++) {
//                if (largest < employees[i].getBasicSalary())
//                    largest_index = i;
//            }
//            return employees[largest_index];
//    }
}
