package ru.interview.lessonFirst.polimorf;

public class Triangle extends Figure {

    private int a;
    private int b;
    private int c;

    Triangle(float x, float y, int a, int b, int c) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float getPerimeter() {
        return a + b + c;
    }

    @Override
    public float getArea() {
        return (a + b + c) / 2;
    }
}
