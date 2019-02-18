/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figuras;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 17/02/2019
 */
public class CubitoRota extends MIDlet implements CommandListener {
    private Display d;
    private Command c; 
    private Perspectiva k;
    
    public CubitoRota(){
        d = Display.getDisplay(this);
        k = new Perspectiva();
    }
    
    public void startApp() {
        d.setCurrent(k);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

