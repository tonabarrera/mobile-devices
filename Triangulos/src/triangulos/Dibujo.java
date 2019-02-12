/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triangulos;

import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author tona
 * Created on 10/02/2019
 */
public class Dibujo extends Canvas{
    Punto puntos[] = new Punto[3];
    Punto puntoExterior;
    Random rand;
    int eleccion;
    
    public Dibujo() {
        rand = new Random();
        puntoExterior = new Punto(10, 5);
        puntos[0] = new Punto(1, 217);
        puntos[1] = new Punto(239, 217);
        puntos[2] = new Punto(120, 20);
    }

    protected void paint(Graphics g) {
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(50, 200, 100);
        g.drawRect(puntos[0].getX(), puntos[0].getY(), 1, 1);
        g.drawRect(puntos[1].getX(), puntos[1].getY(), 1, 1);
        g.drawRect(puntos[2].getX(), puntos[2].getY(), 1, 1);
        
        for (int i = 0; i < 10000; i++) {
            g.drawRect(puntoExterior.getX(), puntoExterior.getY(), 1, 1);
            eleccion = rand.nextInt(3);
            puntoExterior = obtenerPuntoMedio(puntoExterior, puntos[eleccion]);
            // Pintar el punto
        }
    }
    
    public Punto obtenerPuntoMedio(Punto p1, Punto p2) {
        Punto nuevoPunto = new Punto();
        nuevoPunto.setX((p1.getX() + p2.getX())/2);
        nuevoPunto.setY((p1.getY() + p2.getY())/2);
        return nuevoPunto;
    }
}
