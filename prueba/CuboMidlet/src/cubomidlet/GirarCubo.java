/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cubomidlet;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class GirarCubo extends MIDlet implements CommandListener{
Display d;
private Command c; 
miCanvas k,cuadrado,esfera,cono,pentagono; 
ListaFiguras lf;

    public GirarCubo(){
        d = Display.getDisplay(this);
	c = new Command("Salir",Command.EXIT, 3);
        k = new miCanvas(this,4,1);
        pentagono = new miCanvas(this,20,20);
        cono = new miCanvas(this,360,1);
        cuadrado = new miCanvas(this,4,4);
	k.addCommand(c);
	k.setCommandListener(this);
        pentagono.addCommand(c);
	pentagono.setCommandListener(this);
        cono.addCommand(c);
	cono.setCommandListener(this);
        cuadrado.addCommand(c);
	cuadrado.setCommandListener(this);
        lf = new ListaFiguras(this);
    }
    public void startApp() {
        d.setCurrent(lf);
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
