package com.company;

public class Rectangle extends Shape {

    private float endX;
    private float endY;

    public Rectangle(float startX, float startY, float endX, float endY) {
        super(startX, startY);
        this.endX = endX;
        this.endY = endY;
    }

    public float getEndY() {
        return endY;
    }

    public float getEndX() {
        return endX;
    }

}
