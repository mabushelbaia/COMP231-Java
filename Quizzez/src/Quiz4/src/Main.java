public class Main {

    public static void main(String[] args) {
	try{
        Triangle triangle = new Triangle(10,10,10);
        triangle.setC(30);
    }catch (IllegalArgumentException ex){
        ex.printStackTrace();
    }
    }
}
