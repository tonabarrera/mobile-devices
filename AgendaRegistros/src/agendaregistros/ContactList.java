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
    Vector eliminados = new Vector();

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
        }
        if (co == commandDelete) {
            //delete();
        }
        if (co == commandEdit) {
            //edit();
        }
    }

    public void constructList() {
        try {
            deleteAll();
            Persistence persistence = new Persistence();
            persistence.open();
            for (int i = 1; i <= persistence.getNumRecords(); i++) {
                Person person = persistence.getElement(i);
                System.out.println(person.toString());
                Image photoImage = Image.createImage(person.getPhoto());
                append(person.getName() + " " + person.getLastName(), photoImage);
            }
            persistence.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public void delete() {
        try {
            for (int i = 1; i < size(); i++) {
                if (isSelected(i)) {
                    String find = "" + i;
                    //eliminados.addElement(findtodelete(find));
                }
            }
            constructList();
            midletPrincipal.d.setCurrent(midletPrincipal.formContact);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
    /*
    public void commandEdit() {
        try {
            String f = "";
            for (int i = 1; i < size(); i++) {
                if (isSelected(i)) {
                    String find = "" + i;
                    f = findtodelete(find);
                }
            }
            midletPrincipal.e.setData((Integer.valueOf(f)).intValue() + 1);
            midletPrincipal.d.setCurrent(midletPrincipal.e);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
    /*
    public String findtodelete(String find) {
        try {
            RMSOps rmso = new RMSOps();
            rmso.abrir("ZonaJavaZone");
            int findindice = (Integer.valueOf(find)).intValue();
            int counter = 0;
            for (int i = 1; i < rmso.rs.getNumRecords(); i++) {
                String finds = "" + i;
                if (eliminados.indexOf(finds) == -1) {
                    counter++;
                }
                if (counter == findindice) {
                    return i + "";
                }
            }
            rmso.cerrar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0 + "";
    }*/
}
