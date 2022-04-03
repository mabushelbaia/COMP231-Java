public class MyArray {
    public int[] array;
    public int size;
    public MyArray(int[]a){
        array = new int[a.length];
        size = a.length;
        System.arraycopy(a,0,array,0,a.length);
    }
    public int max(){
        int max = array[0];
        for ( int x : array){
            if (x > max) max = x;
        }
        return max;
    }
    public int min(){
        int min = array[0];
        for ( int x : array){
            if (x < min) min = x;
        }
        return min;
    }
    public double average(){
        double sum = 0;
        int size = 0;
        for( int x : array) {
            sum += x;
            size++;
        }
        return sum/size;
    }
    public void printArray() {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
    public int getSize() {
        return size;
    }
}
