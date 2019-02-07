/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package canvas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 7/02/2019
 */
public class Dibujo extends MIDlet implements CommandListener{
    Display d;
    Command c;
    Pinta p;
    public Dibujo() {
        d = Display.getDisplay(this);
        c = new Command("Salir", Command.SCREEN, 2);
        p = new Pinta();
        p.addCommand(c);
        p.setCommandListener(this);
    }
    public void startApp() {
        d.setCurrent(p);
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
