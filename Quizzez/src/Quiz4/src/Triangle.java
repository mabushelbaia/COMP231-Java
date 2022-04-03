public class Triangle {
    double a,b,c;
    public Triangle(){
        this(10,10,10);
    }
    public Triangle(double a, double b, double c){
        isVaild(a,b,c);
        this.a = a;
        this.b = b;
        this.c = c;

    }
    private void isVaild(double a,double b,double c) throws IllegalArgumentException {
        if(a+b < c || a+c < b || b+c < a) {
            throw new IllegalArgumentException("The sum of two sides mustn't be greater than the third");
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        isVaild(a,b,c);
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        isVaild(a,b,c);
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        isVaild(a,b,c);
        this.c = c;
    }
}
