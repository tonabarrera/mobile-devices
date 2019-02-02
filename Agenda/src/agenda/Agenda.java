/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda;

import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 1/02/2019
 */
public class Agenda extends MIDlet implements CommandListener {
    Command		c;
    Command	ventanaVer, ventanaNuevo, ventanaInicio, ventanaLista, guardar;
    Display		d;
    Form		f, ingresar;
    List		lista;
    String sel, contacto[];
    TextField	nombre, edad, email;
    Image img;
    ImageItem	imgI;
    DateField	df;
    ChoiceGroup	cg;
    int		i, j;
    
    public Agenda() {
        i = 0;
        d = Display.getDisplay(this);
        c = new Command("salir", Command.EXIT, 3);
        ventanaNuevo = new Command("Nvo contacto", Command.SCREEN, 2);
        guardar = new Command("Guardar", Command.SCREEN, 2);
        ventanaInicio = new Command("Regresar", Command.SCREEN, 3);
        ventanaVer = new Command("Ver", Command.OK, 0);
        ventanaLista = new Command("Mi agenda", Command.SCREEN, 0);
        try {
            img = Image.createImage("/resources/C11.jpg");
        } catch (IOException ioe) { System.err.println("Error" + ioe); }
        imgI = new ImageItem("HOLA", img, 1, "hola");
        f = new Form("Mi Agenda");
        ingresar = new Form("Nuevo contacto");
        contacto = new String[5];
        for(j=0; j<5; j++)
                contacto[j]="";
        df = new DateField("creado", DateField.DATE_TIME);
        String sexo[] = {"Hombre", "Mujer"};
        cg = new ChoiceGroup("",List.EXCLUSIVE,sexo,null);
        nombre = new TextField("Nombre", "", 30, TextField.ANY);
        edad = new TextField("Edad", "", 30, TextField.NUMERIC);
        email = new TextField("E-mail", "", 30, TextField.EMAILADDR);
        ingresar.addCommand(ventanaInicio);
        ingresar.addCommand(guardar);
        ingresar.append(nombre);
        ingresar.append(edad);
        ingresar.append(email);
        ingresar.append(cg);
        ingresar.setCommandListener(this);
        f.addCommand(ventanaLista);
        f.addCommand(c);
        f.addCommand(ventanaNuevo);
        f.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Displayable disp) {
        if(co == ventanaNuevo){
            d.setCurrent(ingresar);
        }
        if(co == ventanaLista){
            d.setCurrent(lista);
        }
        if(co == guardar){
            contacto[i] = nombre.getString();
            lista=new List("Contactos", List.IMPLICIT, contacto, null);
            lista.addCommand(c);
            lista.addCommand(ventanaNuevo);
            lista.addCommand(ventanaVer);
            lista.setCommandListener(this);
            Alert alerta = new Alert("", "contacto guardado", img,AlertType.INFO);
            d.setCurrent(alerta);
            alerta.setTimeout(2000);
            i++;
        }
        if(co == ventanaInicio){
            if(cg.getSelectedIndex() == 0){
                sel = "Hombre";
            }
            else{
                sel = "Mujer";
            }
            StringItem si = new StringItem("",
                    "Nombre: "+nombre.getString()+"\nEdad: "+edad.getString()+"\nE-mail: "+email.getString()+"\n"+"Sexo: "+sel+"\n");
            f.append(si);
            d.setCurrent(lista);
        }
        if(co == ventanaVer){
            System.out.println("OPCION" + lista.getSelectedIndex());
            d.setCurrent(f);
        }
        if(co == c){
            destroyApp(false);
            notifyDestroyed();
        }
    }
}
