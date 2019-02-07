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
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 7/02/2019
 */
public class Maravilloso extends MIDlet implements CommandListener {
    private Display  d;
    private Form  f;
    private TextField tf;
    private Command  cc;
    //private StringItem si;
    private Command  cs;
    private Command cr;
    private TextBox tb;
    
    int MAX_ITERACIONES = 70;
    
    public Maravilloso() {
        d  = Display.getDisplay(this);
        tf = new TextField("Número:", "", 10, TextField.NUMERIC);
        //si = new StringItem("¿Es fibonacci?:", "");
        f  = new Form ("Numeros Maravillosos");
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
    
    public long  maravilloso(long x) {
        if (x % 2 == 0)
            return x/2;
        return 3*x+1;
    }

    public void commandAction(Command c, Displayable dd) {
        if (c == cc) {
            int i = 0;
            long x = Integer.parseInt(tf.getString());
            String resultado = "No es maravilloso";
            StringBuffer lista = new StringBuffer();
            lista.append(x);
            while (i < MAX_ITERACIONES) {
                if (x == 1) {
                    resultado = "Es maravilloso";
                    break;
                }
                x = maravilloso(x);
                lista.append(",").append(x);
                i++;
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
