/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras.cilindro;

import figuras.Point2D;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author USER
 */
public class PerspectivaCilindro extends Canvas{
    int centerX, centerY, maxX, maxY, minMaxXY;
    ObjCilindro obj = new ObjCilindro();
    
    public PerspectivaCilindro(){
        centerX = maxX/2;
        centerY = maxY/2;
    }
    
    int iX(float x){
        return (int)(centerX + x);
    }
    
    int iY(float y){
        return (int)(centerY - y);
    }
    
    void line(Graphics g, int i, int j){
        Point2D p = obj.vScr[i], q = obj.vScr[j];
        g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
    }

    public void paint(Graphics g){
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(0, 0, 0);
        maxX = getWidth(); 
        maxY = getHeight(); 
        minMaxXY=Math.min(maxX, maxY);
        centerX = maxX/2;
        centerY = maxY/2;
        obj.d = obj.rho*minMaxXY/obj.objSize;
        obj.eyeAndScreen();
        for (int i = 0; i < 142; i+=1){
            line(g, i, i+2);
            if (i% 2 == 0)
                line(g, i, i+1);
        }
        line(g, 142, 143);
        line(g, 142, 0);
        line(g, 143, 1);
    }
    
    protected void keyPressed(int keyCode) {
        int arriba = getKeyCode(UP);
        int abajo = getKeyCode(DOWN);
        int izq = getKeyCode(LEFT);
        int dcha = getKeyCode(RIGHT);
        if (keyCode == arriba)
            obj.phi  += (float)0.1;   
        else if (keyCode == abajo)
            obj.phi  -= (float)0.1;
        else if (keyCode == izq)
            obj.theta  += (float)0.1;
        else if (keyCode == dcha)
            obj.theta  -= (float)0.1;

        obj.rho   = (obj.phi/obj.theta)*getHeight();
        repaint();
    }
}
