/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaregistros;

import javax.microedition.lcdui.*;


/**
 *
 * @author tona Created on 18/02/2019
 */
public class EditForm extends Form implements CommandListener {

    Command g, s;
    TextField tfName, tfLastName, tfPhone, tfCellPhone, tfAddress;
    MidletPrincipal p;
    Alert a;
    int id;

    public EditForm(MidletPrincipal mid) {
        super("Agenda");
        p = mid;
        tfName = new TextField("Nombre:", "", 30, TextField.ANY);
        tfLastName = new TextField("Apellido:", "", 30, TextField.ANY);
        tfPhone = new TextField("Telefono:", "", 30, TextField.ANY);
        tfCellPhone = new TextField("Celular:", "", 30, TextField.ANY);
        tfAddress = new TextField("Domicilio:", "", 30, TextField.ANY);
        s = new Command("Cancelar", Command.EXIT, 1);
        g = new Command("Guardar", Command.EXIT, 1);
        append(tfName);
        append(tfLastName);
        append(tfPhone);
        append(tfCellPhone);
        append(tfAddress);
        addCommand(g);
        addCommand(s);
        setCommandListener(this);
    }

    public void commandAction(Command co, Displayable di) {
        if (co == s) { 
            p.d.setCurrent(p.formContact); 
        } else if (co == g) {
            Persistence persistence = new Persistence();
            persistence.open();
            
            Person person = persistence.getElement(id);
            person.setName(tfName.getString());
            person.setLastName(tfLastName.getString());
            person.setTelephone(tfPhone.getString());
            person.setCellPhone(tfCellPhone.getString());
            person.setAddress(tfAddress.getString());
            //person.setPhoto(foto);
            
            persistence.update(id, person);
            
            a = new Alert("NOTA", "Guardado", null, AlertType.CONFIRMATION);
            a.setTimeout(5000);
            p.d.setCurrent(a, this);
            p.contactList.constructList();
            p.d.setCurrent(p.contactList);
            tfName.setString("");
            tfLastName.setString("");
            tfPhone.setString("");
            tfCellPhone.setString("");
            tfAddress.setString(""); 
        }
    }
    
    public void setData(int indice) {
        Persistence persistence = new Persistence();
        persistence.open();
        this.id = indice;
        Person person = persistence.getElement(indice);
        tfName.setString(person.getName());
        tfLastName.setString(person.getLastName());
        tfPhone.setString(person.getTelephone());
        tfCellPhone.setString(person.getCellPhone());
        tfAddress.setString(person.getAddress());
        
        persistence.close();
    }

}
