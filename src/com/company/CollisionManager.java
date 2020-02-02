package com.company;

import java.util.ArrayList;

public class CollisionManager {

    public static void manageCollision(ArrayList<Shape> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i) instanceof Rectangle && shapes.get(j) instanceof Rectangle) {
                    if (rectanglesCollision((Rectangle) shapes.get(i), (Rectangle) shapes.get(j))) {
                        System.out.println("Rectangle[" + i + "] & Rectangle[" + j + "] collided");
                    }

                } else if (shapes.get(i) instanceof Rectangle && shapes.get(j) instanceof Circle) {
                    if (rectangleCircleCollision((Rectangle) shapes.get(i), (Circle) shapes.get(j))) {
                        System.out.println("Rectangle[" + i + "] & Circle[" + j + "] collided");
                    }


                } else if (shapes.get(i) instanceof Rectangle && shapes.get(j) instanceof Point) {
                    if (rectanglePointCollision((Rectangle) shapes.get(i), (Point) shapes.get(j))) {
                        System.out.println("Rectangle[" + i + "] & Point[" + j + "] collided");
                    }


                } else if (shapes.get(i) instanceof Circle && shapes.get(j) instanceof Circle) {
                    if (circlesCollision((Circle) shapes.get(i), (Circle) shapes.get(j))) {
                        System.out.println("Circle[" + i + "] & Circle[" + j + "] collided");
                    }


                } else if (shapes.get(i) instanceof Circle && shapes.get(j) instanceof Point) {
                    if (circlePointCollision((Circle) shapes.get(i), (Point) shapes.get(j))) {
                        System.out.println("Circle[" + i + "] & Point[" + j + "] collided");
                    }


                } else if (shapes.get(i) instanceof Point && shapes.get(i + 1) instanceof Point) {
                    if (pointsCollision((Point) shapes.get(i), (Point) shapes.get(j))) {
                        System.out.println("Point[" + i + "] & Point[" + j + "] collided");
                    }

                }
            }
        }
    }


    private static boolean rectangleCircleCollision(Rectangle r, Circle c) {
        float testX = 0, testY = 0;

        if (c.getStartX() < r.getStartX()) testX = r.getStartX(); //check left edge of the rectangle
        else if (c.getStartX() > r.getEndX()) testX = r.getEndX();//check right edge of the rectangle

        if (c.getStartY() < r.getStartY()) testY = r.getStartY();//check bottom edge of the rectangle
        else if (c.getStartY() > r.getEndY()) testY = r.getEndY();//check top edge of the rectangle

        var dx = c.getStartX() - testX;
        var dy = c.getStartY() - testY;

        var distance = Math.sqrt((dx * dx) + (dy * dy));

        return distance <= c.getRadius();

    }

    private static boolean rectanglesCollision(Rectangle r1, Rectangle r2) {
        boolean collisionX = r1.getEndX() >= r2.getStartX() && r2.getEndX() >= r1.getStartX();
        boolean collisionY = r1.getEndY() >= r2.getStartY() && r2.getEndY() >= r1.getStartY();
        return collisionX && collisionY;

    }

    private static boolean circlesCollision(Circle c1, Circle c2) {
        var dx = c1.getStartX() - c2.getStartX();
        var dy = c2.getStartY() - c2.getStartY();
        var distance = Math.sqrt((dx * dx) + (dy * dy));
        return distance < (c1.getRadius() + c2.getRadius());

    }

    private static boolean rectanglePointCollision(Rectangle r, Point p) {
        boolean collisionX = p.getStartX() <= r.getEndX() && p.getStartX() > r.getStartX();
        boolean collisionY = p.getStartY() <= r.getEndY() && p.getStartY() > r.getStartY();
        return collisionX && collisionY;


    }

    private static boolean circlePointCollision(Circle c, Point p) {
        var dx = c.getStartX() - p.getStartX();
        var dy = c.getStartY() - p.getStartY();
        var distance = Math.sqrt((dx * dx) + (dy * dy));
        return distance < c.getRadius();

    }

    private static boolean pointsCollision(Point p1, Point p2) {
        return p1.getStartX() == p2.getStartX() && p1.getStartY() == p2.getStartY();

    }

}
