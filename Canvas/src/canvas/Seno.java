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
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 7/02/2019
 */
public class Seno extends MIDlet implements CommandListener{
    Display d;
    Command cExit;
    Command cPintar;
    Command cRegresar;
    CanvasSeno p;
    private Form  f;
    private TextField tfPhi;
    private TextField tfAmplitud;
    
    public Seno() {
        d = Display.getDisplay(this);
        p = new CanvasSeno();
        f  = new Form ("Dibujar función seno");
        cExit = new Command("Salir", Command.EXIT, 2);
        cPintar = new Command("Pintar", Command.SCREEN, 1);
        cRegresar = new Command("Regresar", Command.SCREEN, 1);
        tfPhi = new TextField("Phi:", "0", 10, TextField.NUMERIC);
        tfAmplitud = new TextField("Amplitud:", "1", 10, TextField.NUMERIC);
        
        f.append(tfPhi);
        f.append(tfAmplitud);
        
        f.addCommand(cExit);
        f.addCommand(cPintar);
        f.setCommandListener(this);
        
        p.addCommand(cRegresar);
        p.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Displayable dd) {
        if (cExit == co) {
            destroyApp(false);
            notifyDestroyed();
        } else if (cRegresar == co) {
            d.setCurrent(f);
        } else if (cPintar == co) {
            p = new CanvasSeno();
            p.AMPLITUD = Integer.parseInt(tfAmplitud.getString());
            p.FASE = Integer.parseInt(tfPhi.getString());
            p.addCommand(cRegresar);
            p.setCommandListener(this);
            //p.repaint();
            d.setCurrent(p);
            //p.repaint();
        }

    }
}
