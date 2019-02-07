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
public class Pinta extends Canvas{

    protected void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(50, 200, 100);
        g.drawLine(25, 255, 200, 50);
        g.drawRect(20, 30, 250, 100);
    }

}
