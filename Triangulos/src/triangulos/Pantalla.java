/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triangulos;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 10/02/2019
 */
public class Pantalla extends MIDlet implements CommandListener {
    Display display;
    Command c;
    Dibujo dibujo;
    
    public Pantalla() {
        display = Display.getDisplay(this);
        c = new Command("Salir", Command.SCREEN, 2);
        dibujo = new Dibujo();
        dibujo.addCommand(c);
        dibujo.setCommandListener(this);
    }
    public void startApp() {
        display.setCurrent(dibujo);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
    

    public void commandAction(Command co, Displayable d) {
        if (c == co) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
