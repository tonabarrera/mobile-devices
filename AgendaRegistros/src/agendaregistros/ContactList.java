/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaregistros;

import java.util.Vector;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

/**
 *
 * @author tona Created on 17/02/2019
 */
public class ContactList extends List implements CommandListener {

    Command commandRegister, commandDelete, commandEdit;
    MidletPrincipal midletPrincipal;
    Vector listaTemporal = new Vector();

    public ContactList(MidletPrincipal mid) {
        super("Contactos", Choice.IMPLICIT);
        midletPrincipal = mid;
        
        commandRegister = new Command("Registrar", Command.EXIT, 1);
        commandDelete = new Command("Eliminar", Command.EXIT, 1);
        commandEdit = new Command("Editar", Command.EXIT, 1);
        
        addCommand(commandRegister);
        addCommand(commandDelete);
        addCommand(commandEdit);
        
        setCommandListener(this);
    }

    public void commandAction(Command co, Displayable d) {
        if (co == commandRegister) {
            midletPrincipal.d.setCurrent(midletPrincipal.formContact);
        } else if (co == commandDelete) {
            delete();
        } else if (co == commandEdit) {
           edit();
        }
    }

    public void constructList() {
        try {
            listaTemporal = new Vector();
            deleteAll();
            Persistence persistence = new Persistence();
            persistence.open();
            System.out.println("TAM registro: " + persistence.getNumRecords() 
                    + " siguiente: " + persistence.rs.getNextRecordID());
            for (int i = 1; i < persistence.rs.getNextRecordID(); i++) {
                Person person = persistence.getElement(i);
                if (person == null) {
                    System.out.println("nulo en el registro: " + i);
                } else {
                    System.out.println("No nulo en el registro: " + i);
                    Image photoImage = Image.createImage(person.getPhoto());
                    listaTemporal.addElement(person);
                    append(person.getName() + " " + person.getLastName(), photoImage);
                }
            }
            persistence.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete() {
        Persistence persistence = new Persistence();
        persistence.open();
        System.out.println("Tamaño: " +listaTemporal.size());
        System.out.println("Seleccionado: " 
                + listaTemporal.elementAt(this.getSelectedIndex()).toString() 
                + " indice: " + this.getSelectedIndex());
        Person seleccionado = (Person) listaTemporal.elementAt(this.getSelectedIndex());
        int id = persistence.findRecord(seleccionado.getName(), seleccionado.getLastName());
        System.out.println("Indice recuperado: " + id + " Tam: " + persistence.getNumRecords());
        Person encontrado = persistence.getElement(id);
        System.out.println("Encontrado: " + encontrado.toString());
        persistence.deleteRecord(id);
        constructList();
        System.out.println("BORRADOfas");
        persistence.close();
    }
    
    
    public void edit() {
        Persistence persistence = new Persistence();
        persistence.open();
        Person seleccionado = (Person) listaTemporal.elementAt(this.getSelectedIndex());
        int id = persistence.findRecord(seleccionado.getName(), seleccionado.getLastName());
        midletPrincipal.e.setData(id);
        midletPrincipal.d.setCurrent(midletPrincipal.e);
        persistence.close();
    }
    
}
