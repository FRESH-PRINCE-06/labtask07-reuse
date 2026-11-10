package labtask07.broken;

/**
 * BAD subclass: it STRENGTHENS the precondition of setDimensions
 * (now w must equal h), so it can no longer stand in for a Rectangle.
 */
public class Square extends Rectangle {
    @Override
    public void setDimensions(int w, int h) {
        if (w != h) {
            throw new IllegalArgumentException(
                    "Square requires w == h, but got w=" + w + ", h=" + h);
        }
        super.setDimensions(w, h);
    }
}
