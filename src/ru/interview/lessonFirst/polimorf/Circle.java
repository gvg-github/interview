package ru.interview.lessonFirst.polimorf;

public class Circle extends Figure {

    private int radius;

    Circle(float x, float y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * Math.PI * radius);
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * (radius * radius));
    }
}
