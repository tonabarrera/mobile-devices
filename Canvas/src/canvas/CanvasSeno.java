/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canvas;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author tona
 * Created on 7/02/2019
 */
public class CanvasSeno extends Canvas {
    int x = 20;
    int y = 30;
    int MEDIA = 160;
    int AMPLITUD = 1;
    int ANCHO = 240;
    int FASE = 0;

    protected void paint(Graphics g) {
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(50, 200, 100);
        for (int i = 0; i < 240; i++) {
            g.drawRect(x, obtenerY(obtenerX(x)), 1, 1);
            x++;
            y++;
        }
    }
    
    private double obtenerX(int x) {
         double aux = 4d/ANCHO;
        return (aux*x - 2) * Math.PI;
    }
    
    private int obtenerY(double x) {
        return (int) (-20*AMPLITUD*Math.sin(x + Math.toRadians(FASE)) + MEDIA);
    }

}
