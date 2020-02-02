package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    private static ArrayList<Shape> shapes = new ArrayList<>();
    private static final int FIELD_SIZE = 100;

    Menu menu = new Menu();

    public void run() {
        addRectangles();
        addCircles();
        addPoints();
        CollisionManager.manageCollision(shapes);
    }


    private void addRectangles() {
        int numRect = menu.getRandomRectangles();
        int counter = 0;
        Rectangle r;
        while (counter < numRect) {
            var x1 = randomNumber();
            var x2 = randomNumber();
            var y1 = randomNumber();
            var y2 = randomNumber();
            x1 = Math.min(x1,x2);
            x2 = Math.max(x1,x2);
            y1 = Math.min(y1,y2);
            y2 = Math.max(y1,y2);
            r = new Rectangle(x1,y1,x2,y2);
            if (r.getStartX() != r.getEndX() && r.getStartY() != r.getEndY()) {
                shapes.add(r);
                System.out.printf("Rectangle(x1:%.2f | y1:%.2f |  x2:%.2f |  y2:%.2f)%n",r.getStartX(),r.getStartY(), r.getEndX(),r.getEndY());
                counter++;
            }
        }


    }

    private void addCircles() {
        int numCircle = menu.getRandomCircles();
        int counter = 0;
        Circle c;
        while (counter < numCircle) {
            c = new Circle(randomNumber(), randomNumber(), randomNumber());
            if (c.getStartX() + c.getRadius() < 100 && c.getStartX() - c.getRadius() > 0 && c.getStartY() + c.getRadius() < 100 && c.getStartY() - c.getRadius() > 0) {
                shapes.add(c);
                System.out.printf("Circle(x:%.2f | y:%.2f | r:%.2f)%n",c.getStartX(),c.getStartY(),c.getRadius());
                counter++;
            }

        }


    }

    private void addPoints() {
        int numPoints = menu.getRandomPoints();
        Point p;
        for (int i = 0; i < numPoints; i++) {
            p = new Point(randomNumber(), randomNumber());
            shapes.add(p);
            System.out.printf("Point(x:%.2f | y:%.2f)%n", p.getStartX(), p.getStartY());
        }
        System.out.print("\n----------------------------------------------------------------\n");

    }

    private float randomNumber() {
        Random random = new Random();
        return random.nextFloat() * FIELD_SIZE;
        // return Math.round((float) (Math.random() * FIELD_WIDTH));

    }


}
