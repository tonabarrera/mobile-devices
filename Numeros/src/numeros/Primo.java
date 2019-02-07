/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numeros;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 6/02/2019
 */
public class Primo extends MIDlet implements CommandListener {
    private Display  d;
    private Form  f;
    private TextField tf;
    private Command  cc;
    private StringItem si;
    private Command  cs;
    
    public Primo() {
        d  = Display.getDisplay(this);
        tf = new TextField("Número:", "", 10, TextField.NUMERIC);
        si = new StringItem("¿Es primo?:", "");
        f  = new Form ("Números primos");
        f.append(tf);
        f.append(si);
        cc = new Command("Revisar", Command.SCREEN, 1);
        cs = new Command("Salir", Command.EXIT, 2);
        f.addCommand(cs);
        f.addCommand(cc);
        f.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
    
    public boolean esPrimo(int numero) {
        if (numero <= 1)
            return false;
        if (numero <= 3)
            return true;
        
        if (numero % 2 == 0 || numero % 3 == 0) return false; 
      
        for (int i = 5; i * i <= numero; i = i + 6) 
            if (numero % i == 0 || numero % (i + 2) == 0) 
                return false;
        return true;
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cc) {
            int numero = Integer.parseInt(tf.getString());
            if (esPrimo(numero))
                si.setText("Sí es primo");
            else
                si.setText("No es primo");
        } else if (c == cs) {
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
