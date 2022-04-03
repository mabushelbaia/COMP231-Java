package Question2;

public abstract class Shape implements Comparable<Shape> {
    protected String color;
    protected boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public Shape(){
        this("", false);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();

    @Override
    public int compareTo(Shape x){
        if (this.getArea()>x.getArea())
            return 1;
        else if(this.getArea() == x.getArea())
            return 0;
        else
            return -1;
    }

}
