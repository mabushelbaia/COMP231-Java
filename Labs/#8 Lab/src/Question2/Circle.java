package Question2;

public class Circle extends Shape{
    protected double radius;

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this("",false,radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                ", Area=" + getArea() +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }
}
