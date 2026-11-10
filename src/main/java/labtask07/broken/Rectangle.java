package labtask07.broken;

/**
 * Base class. Contract: setDimensions accepts ANY width and height.
 */
public class Rectangle {
    protected int width;
    protected int height;

    public void setDimensions(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int area() {
        return width * height;
    }
}
