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
 * Created on 7/02/2019
 */
public class Palindromo extends MIDlet implements CommandListener {
    private Display  d;
    private Form  f;
    private TextField tf;
    private Command  cc;
    private StringItem si;
    private Command  cs;
    
    public Palindromo() {
        d  = Display.getDisplay(this);
        tf = new TextField("Número:", "", 10, TextField.NUMERIC);
        si = new StringItem("¿Es palindromo?:", "");
        f  = new Form ("Palindromos");
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
    
    public boolean esPalindromo(String numero) {
        int longitud = numero.length();
        int i = 0;
        while ( i < longitud/2) {
            if (numero.charAt(i) != numero.charAt(longitud-i-1))
                return false;
            i++;
        }
        return true;
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cc) {
            if (esPalindromo(tf.getString()))
                si.setText("Sí es palindromo");
            else
                si.setText("No es palindromo");
        } else if (c == cs) {
            destroyApp(true);
            notifyDestroyed();
        }
    }
}
