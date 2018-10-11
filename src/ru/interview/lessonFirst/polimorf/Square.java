package ru.interview.lessonFirst.polimorf;

public class Square extends Figure {

    private int height;

    Square(float x, float y, int height) {
        super(x, y);
        this.height = height;
    }

    @Override
    public float getPerimeter() {
        return height * 4;
    }

    @Override
    public float getArea() {
        return height * height;
    }
}
