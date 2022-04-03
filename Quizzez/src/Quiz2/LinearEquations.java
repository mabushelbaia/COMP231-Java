package Quiz2;

@SuppressWarnings("IntegerDivisionInFloatingPointContext")
public class LinearEquations {
    private final int a,b,c,d,e,f;

    public LinearEquations(int[] a) {
        this.a = a[0];
        this.b = a[1];
        this.c = a[2];
        this.d = a[3];
        this.e = a[4];
        this.f = a[5];
    }
    public boolean isSolvable(){
        return a * d - b * c != 0;
    }
    public double getX(){
        return (e*d-b*f)/(a*d-b*c);
    }
    public double getY(){
        return (a*f-e*c)/(a*d-b*c);

    }
}
