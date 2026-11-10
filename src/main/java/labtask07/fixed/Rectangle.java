package labtask07.fixed;

public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setDimensions(int w, int h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public int area() {
        return width * height;
    }
}
