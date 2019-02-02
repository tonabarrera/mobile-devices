/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author tona
 */
public class BajoNivelME extends MIDlet implements CommandListener {
    private Display  d;
    private Command c;
    private Canvas ca;
    
    public BajoNivelME() {
        d  = Display.getDisplay(this);
        ca = new Canvas() {
            private int w;
            private int h;
            public void paint(Graphics g) {
                w = getWidth();
                h = getHeight();
                g.setColor(0, 0, 0);
                g.fillRect(0, 0, w, h);
                g.setColor(255, 255, 255);
                g.setStrokeStyle(Graphics.SOLID);
                g.drawString("Hola MIDlet", w/2, h/2, (Graphics.BASELINE|Graphics.HCENTER));
            }
        };
        c = new Command("Salir", Command.EXIT, 3);
        ca.addCommand(c);
        ca.setCommandListener(this);
    }
    protected void startApp() {
        d.setCurrent(ca); 
    }
    protected void pauseApp() { }
    protected void destroyApp(boolean b) { }
    public void commandAction(Command co, Displayable di) {
        if (co == c) {
            destroyApp(true);
            notifyDestroyed();
        } else 
            d.setCurrent(new Alert("", "Otro comando...", null, AlertType.ERROR));
    } 
} 
