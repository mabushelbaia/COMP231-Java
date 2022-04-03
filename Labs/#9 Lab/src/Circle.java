public class Circle {
    public Circle(double radius) {
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException{
        if (radius >= 0)
            this.radius = radius;
        throw new IllegalArgumentException("Radius cannot be negative");
    }

    public Circle(){
        this(0);
    }

    private double radius;
    private String color;
}
