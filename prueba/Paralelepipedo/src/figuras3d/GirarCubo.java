/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figuras3d;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class GirarCubo extends MIDlet implements CommandListener{
private Display d;
private Command c; 
private miCanvas k;
private Alert timeAlert;

    public GirarCubo(){
        d = Display.getDisplay(this);
	c = new Command("Salir",Command.EXIT, 3);
        k = new miCanvas(this);
	k.addCommand(c);
	k.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(k);
        /*timeAlert = new Alert("Alert!");
        timeAlert.setString("El volumen del paralelepipedo es: ");
        timeAlert.setTimeout(Alert.FOREVER);    
        Display.getDisplay(this).setCurrent(timeAlert);*/
         
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Displayable di) {
        if (co==c) {
	   destroyApp(true);
	   notifyDestroyed();
        }
    }
}
