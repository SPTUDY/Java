package hyerim.section04.ex;

public class Rectangle {
    int width;
    int height;

    int calculateArea() {
        return width * height;
    }

    int calculatePerimeter() {
        return (width + height) * 2;
    }

    boolean isSquare() {
        if (width == height) {
            return true;
        } else {
            return false;
        }
    }
}


