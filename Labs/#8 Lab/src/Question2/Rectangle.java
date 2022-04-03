package Question2;
public class Rectangle extends Shape {
    protected double width,length;

    public Rectangle(double width, double height) {
        this.width = width;
        this.length = height;
    }

    public Rectangle() {
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                ", Area=" + getArea() +
                '}';
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width*length;

    }
}
