package com.morozec.helloworld;

/**
 * Created by moro2609 on 23.01.2018.
 */
public class SimpleCircle {
    public static final int AREA_COEFF = 3;
    protected int x;
    protected int y;
    protected int radius;
    private int color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public SimpleCircle getCircleAre() {
        return new SimpleCircle(x,y,radius* AREA_COEFF);
    }

    public boolean isIntersect(SimpleCircle circle) {
        return Math.pow(radius + circle.radius,2 ) >= Math.pow(x-circle.x,2) + Math.pow(y - circle.y, 2);
    }


}
