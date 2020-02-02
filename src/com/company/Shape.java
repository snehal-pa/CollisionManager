package com.company;

public abstract class Shape {
    private float startX;
    private float startY;

    public Shape(float startX, float startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public float getStartY() {
        return startY;
    }

    public float getStartX() {
        return startX;
    }
}
