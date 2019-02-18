/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaregistros;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author tona Created on 17/02/2019
 */
public class FormContact extends Form implements CommandListener {

    Command commandSave, commandExit, lista, commandSelectPhoto;
    TextField tfName, tfLastName, tfPhone, tfCellphone, tfAddress;
    MidletPrincipal midletPrincipal;
    Alert alert;
    String foto = "/resources/0.png";

    public FormContact(MidletPrincipal mid) {
        super("Agenda");
        midletPrincipal = mid;
        //foto = "";
        
        tfName = new TextField("Nombre:", "", 30, TextField.ANY);
        tfLastName = new TextField("Apellido:", "", 30, TextField.ANY);
        tfPhone = new TextField("Telefono:", "", 30, TextField.ANY);
        tfCellphone = new TextField("Celular:", "", 30, TextField.ANY);
        tfAddress = new TextField("Domicilio:", "", 30, TextField.ANY);
        
        commandExit = new Command("Salir", Command.EXIT, 1);
        commandSave = new Command("Guardar", Command.EXIT, 1);
        lista = new Command("Contactos", Command.EXIT, 1);
        commandSelectPhoto = new Command("Seleccionar Foto", Command.EXIT, 1);
        
        append(tfName);
        append(tfLastName);
        append(tfPhone);
        append(tfCellphone);
        append(tfAddress);
        
        addCommand(commandSave);
        addCommand(commandExit);
        addCommand(lista);
        addCommand(commandSelectPhoto);
        setCommandListener(this);
    }

    public void commandAction(Command co, Displayable di) {
        if (co == commandExit) {
            System.out.println("DESTRUIR");
            midletPrincipal.destroyApp(true);
            midletPrincipal.notifyDestroyed();
        } else if (co == commandSave) {
            Persistence persistence = new Persistence();
            persistence.deletePersistence();
            persistence.open();
            
            Person person = new Person();
            person.setName(tfName.getString());
            person.setLastName(tfLastName.getString());
            person.setTelephone(tfPhone.getString());
            person.setCellPhone(tfCellphone.getString());
            person.setAddress(tfAddress.getString());
            person.setPhoto(foto);
            
            persistence.save(person);
            persistence.close();
            
            alert = new Alert("NOTA", "Guardado", null, AlertType.CONFIRMATION);
            alert.setTimeout(5000);
            midletPrincipal.contactList.constructList();
            midletPrincipal.d.setCurrent(midletPrincipal.contactList);
            midletPrincipal.d.setCurrent(alert, midletPrincipal.contactList);
            tfName.setString("");
            tfLastName.setString("");
            tfPhone.setString("");
            tfCellphone.setString("");
            tfAddress.setString("");
        } else if (co == lista) {
            midletPrincipal.contactList.constructList();
            midletPrincipal.d.setCurrent(midletPrincipal.contactList);
        } else if (co == commandSelectPhoto) {
            //midletPrincipal.d.setCurrent(midletPrincipal.lf);
        }
    }
}
