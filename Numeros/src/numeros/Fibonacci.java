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
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 6/02/2019
 */
public class Fibonacci extends MIDlet implements CommandListener {
    private Display  d;
    private Form  f;
    private TextField tf;
    private Command  cc;
    //private StringItem si;
    private Command  cs;
    private Command cr;
    private TextBox tb;
    
    private int fn1 = 0;
    private int fn2 = 1;
    
    public Fibonacci() {
        d  = Display.getDisplay(this);
        tf = new TextField("Número:", "", 10, TextField.NUMERIC);
        //si = new StringItem("¿Es fibonacci?:", "");
        f  = new Form ("Sucesión de fibonacci");
        tb = new TextBox("Estado", "Sin Conexion", 400, TextField.ANY);
        f.append(tf);
        //f.append(si);
        cc = new Command("Revisar", Command.SCREEN, 1);
        cs = new Command("Salir", Command.EXIT, 2);
        cr = new Command("Regresar", Command.EXIT, 2);

        f.addCommand(cs);
        f.addCommand(cc);
        f.setCommandListener(this);
        tb.addCommand(cr);
        tb.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
    
    public int obtenerFibo() {
        int aux = fn1;
        fn1 = fn2;
        fn2 = aux + fn2;
        return fn2;
    }

    public void commandAction(Command c, Displayable dis) {
        if (c == cc) {
            fn1 = 0;
            fn2 = 1;
            int numero = Integer.parseInt(tf.getString());
            String resultado = "No es fibonacci";
            StringBuffer lista = new StringBuffer("0,1");
            while (obtenerFibo() <= numero) {
                lista.append("," + fn2);
                if (fn2 == numero) {
                    resultado = "Es fibonacci";
                    break;
                }
            }
            lista.append("\n").append(resultado);
            tb.setString(lista.toString());
            d.setCurrent(tb);
        } else if (c == cs) {
            destroyApp(true);
            notifyDestroyed();
        } else if (c == cr) {
            d.setCurrent(f);
        }
        
    }
}
