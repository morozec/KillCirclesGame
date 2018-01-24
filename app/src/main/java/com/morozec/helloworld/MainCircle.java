package com.morozec.helloworld;

import android.graphics.Color;

/**
 * Created by moro2609 on 23.01.2018.
 */
public class MainCircle extends  SimpleCircle {
    public static final int RADIUS = 50;
    public static final int INIT_RADIUS = RADIUS;
    public static final int INIT_RADIUS1 = RADIUS;
    public static final int MAIN_SPEED = 30;
    public static final int OUR_COLOR = Color.BLUE;


    public MainCircle(int x, int y) {
       super(x,y, INIT_RADIUS1);
       setColor(OUR_COLOR);
    }

    public void moveMainCircleWhenTouchAt(int x, int y) {
        int dx = (x - this.x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y - this.y) * MAIN_SPEED / GameManager.getHeight();
        this.x += dx;
        this.y += dy;
    }

    public void initRadius() {
        radius = INIT_RADIUS;
    }

    public void growRadius(SimpleCircle circe) {
        //pi*newR^2 == pi*r^2+pi*reat^2
        //newR = sqrt(r^2+reat^2)
        radius = (int) Math.sqrt(Math.pow(radius,2) + Math.pow(circe.radius,2));
    }
}
