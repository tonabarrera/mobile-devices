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
public class Textos extends MIDlet implements CommandListener {
    private Display d;
    private Command cs;
    private Canvas  ca;
    
    public Textos() {
        d  = Display.getDisplay(this);
        ca = new Canvas() {
            private int w, h;
            public void paint (Graphics g){
                w = getWidth();
                h = getHeight();
                g.setColor(0, 0, 0);
                g.fillRect(0, 0, w, h);
                g.setColor(255, 255, 255);
                g.setStrokeStyle(Graphics.SOLID);
                g.drawString("...Una carta...", w/2, h/2, (Graphics.BASELINE| Graphics.HCENTER));
            }
        };
        cs = new Command("Salir", Command.EXIT, 3);
        ca.addCommand(cs);
        ca.setCommandListener(this);  
    }
    
    public void startApp() {
        d.setCurrent(ca);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void commandAction(Command co, Displayable di) {
        if (co == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else 
            d.setCurrent(new Alert("", "Otro comando digitado...", null, AlertType.ERROR));
    }
}
