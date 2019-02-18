/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registros;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*; 

/**
 * @author tona
 * Created on 14/02/2019
 */
public class Principal extends MIDlet implements CommandListener{
    Display d; 
    Forma f; 
    Editar e;
    ListaContactos lc;
    ListaFotos lf;
    public Principal() {
        d = Display.getDisplay(this); 
        f = new Forma(this); 
        lc = new ListaContactos(this);
        lf = new ListaFotos(this);
        e = new Editar(this);
    } 
    public void startApp() {
         d.setCurrent(f); 
    } 
    public void pauseApp() {} 
    public void destroyApp(boolean x) {} 
    public void commandAction (Command co, Displayable di){ }
} 
