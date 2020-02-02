package com.company;

public class Circle extends Shape {

    private float radius;

    public Circle(float startX, float startY, float radius) {
        super(startX, startY);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }
}
