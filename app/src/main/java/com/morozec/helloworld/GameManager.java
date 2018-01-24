package com.morozec.helloworld;

import java.util.ArrayList;

/**
 * Created by moro2609 on 23.01.2018.
 */
public class GameManager {
    public static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private ICanvasView canvasView;
    private static int width;
    private static int height;



    public GameManager(ICanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;

        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        SimpleCircle mainCircleArea = mainCircle.getCircleAre();
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES; ++i){
            EnemyCircle circle;
            do {
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for(EnemyCircle circle:circles){
            circle.setEnemyOrFoodColor(mainCircle);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


    private void initMainCircle() {
        mainCircle = new MainCircle(width/2,height/2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle:circles){
            canvasView.drawCircle(circle);
        }
    }


    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x,y);
        checkCollisions();
        moveCircles();
    }

    private void checkCollisions() {
        SimpleCircle circleForDel = null;
        for (EnemyCircle circe:circles){
            if (mainCircle.isIntersect(circe)){
                if (circe.isSmallerThan(mainCircle)){
                    mainCircle.growRadius(circe);
                    circleForDel = circe;
                    calculateAndSetCirclesColor();
                    break;
                }
                else {
                    gameEnd("YOU LOSE!");
                    return;
                }
            }
        }
        if (circleForDel != null){
            circles.remove(circleForDel);
        }
        if (circles.isEmpty()){
            gameEnd("YOU WIN!");
        }
    }

    private void gameEnd(String text) {
        canvasView.showMessage(text);
        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.redraw();
    }

    private void moveCircles() {
        for (EnemyCircle circle: circles){
            circle.moveOneStep();
        }
    }
}
