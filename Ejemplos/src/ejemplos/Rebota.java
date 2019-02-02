/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author tona
 * Created on 1/02/2019
 */
public class Rebota extends MIDlet {
    Display d;
    Pantalla p;
    
    public Rebota() {
        d = Display.getDisplay(this);
        p = new Pantalla();
    } 
    
    public void startApp() {
        d.setCurrent(p);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
