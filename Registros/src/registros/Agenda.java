/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registros;

import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 13/02/2019
 */
public class Agenda extends MIDlet implements CommandListener {
    Command commandSalir;
    Command commandVer, commandNuevo, commandRegresar, commandListar, commandGuardar;
    Display d;
    Form formLista, formContacto;
    List listaContactos;
    String sel, contacto[];
    TextField nombre, edad, email;
    Image img;
    ImageItem imgI;
    DateField df;
    ChoiceGroup	cg;
    int	i, j;
    String[] SEXO = {"Hombre", "Mujer"};
    
    public Agenda() {
        i = 0;
        d = Display.getDisplay(this);
        
        commandSalir = new Command("Salir", Command.EXIT, 3);
        commandListar = new Command("Mi agenda", Command.SCREEN, 0);
        commandNuevo = new Command("Nuevo contacto", Command.SCREEN, 2);
        
        commandGuardar = new Command("Guardar", Command.SCREEN, 2);
        commandRegresar = new Command("Regresar", Command.SCREEN, 3);
        commandVer = new Command("Ver", Command.OK, 0);
        
        try {
            img = Image.createImage("/resources/C11.jpg");
        } catch (IOException ioe) {
            System.err.println("Error" + ioe);
        }
        
        imgI = new ImageItem("HOLA", img, 1, "hola");
        formLista = new Form("Mi Agenda");
        formContacto = new Form("Nuevo contacto");
        contacto = new String[5];
        for(j=0; j<5; j++)
            contacto[j]="";
        df = new DateField("creado", DateField.DATE_TIME);
        
        cg = new ChoiceGroup("", List.EXCLUSIVE, SEXO, null);
        nombre = new TextField("Nombre", "", 30, TextField.ANY);
        edad = new TextField("Edad", "", 30, TextField.NUMERIC);
        email = new TextField("E-mail", "", 30, TextField.EMAILADDR);
        
        formContacto.addCommand(commandRegresar);
        formContacto.addCommand(commandGuardar);
        formContacto.append(nombre);
        formContacto.append(edad);
        formContacto.append(email);
        formContacto.append(cg);
        formContacto.setCommandListener(this);
        
        formLista.addCommand(commandListar);
        formLista.addCommand(commandSalir);
        formLista.addCommand(commandNuevo);
        formLista.setCommandListener(this);
    }
    
    public void startApp() {
        d.setCurrent(formLista);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command co, Displayable disp) {
        // Mostrar el formulario de crear un nuevo contacto
        if(co == commandNuevo)
            d.setCurrent(formContacto);
        // Muestra la lista de contactos
        else if(co == commandListar)
            // Leer antes los registros
            d.setCurrent(listaContactos);
        else if(co == commandGuardar){
            // Se agrega un nuevo nombre de contacto
            contacto[i] = nombre.getString();
            // Se carga listaContactos cada que se guarda
            listaContactos = new List("Contactos", List.IMPLICIT, contacto, null);
            listaContactos.addCommand(commandSalir);
            listaContactos.addCommand(commandNuevo);
            listaContactos.addCommand(commandVer);
            listaContactos.setCommandListener(this);
            Alert alerta = new Alert("", "contacto guardado", img,AlertType.INFO);
            d.setCurrent(alerta);
            alerta.setTimeout(2000);
            i++;
        } else if(co == commandRegresar){
            // AL darle regresar recuperamos los datos
            if(cg.getSelectedIndex() == 0){
                sel = "Hombre";
            } else{
                sel = "Mujer";
            }
            StringItem si = new StringItem("",
                    "Nombre: "+nombre.getString()+"\nEdad: "+edad.getString()+"\nE-mail: "+email.getString()+"\n"+"Sexo: "+sel+"\n");
            // Agregamos al formLista
            formLista.append(si);
            // Mostramos la lista de nombre de contactos
            d.setCurrent(listaContactos);
        } else if(co == commandVer){
            System.out.println("OPCION" + listaContactos.getSelectedIndex());
            // Se muestran todos los StringItem guardados
            d.setCurrent(formLista);
        } else if(co == commandSalir){
            destroyApp(false);
            notifyDestroyed();
        }
    }
}

