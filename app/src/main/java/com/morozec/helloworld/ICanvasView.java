package com.morozec.helloworld;

/**
 * Created by moro2609 on 23.01.2018.
 */
public interface ICanvasView {
    void drawCircle(SimpleCircle mainCircle);

    void redraw();

    void showMessage(String text);
}
