package com.morozec.helloworld;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by moro2609 on 23.01.2018.
 */
public class EnemyCircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        if (random.nextBoolean()) dx *= -1;
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        if (random.nextBoolean()) dy *= -1;
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle=new EnemyCircle(x,y,radius,dx,dy);
        return enemyCircle;
    }

    public void setEnemyOrFoodColor(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)){
            setColor(Color.rgb(0,200,0));
        }else{
            setColor(ENEMY_COLOR);
        }
    }

    public boolean isSmallerThan(SimpleCircle circle) {
        if(radius < circle.radius) return true;
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0){
            dx = -dx;
        }
        if (y > GameManager.getHeight() || y < 0){
            dy = -dy;
        }
    }
}
