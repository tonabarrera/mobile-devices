/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agendaregistros;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 17/02/2019
 */
public class MidletPrincipal extends MIDlet {
    Display d; 
    FormContact formContact;
    ContactList contactList;
    PhotoList photoList;
    public MidletPrincipal() {
        d = Display.getDisplay(this);
        contactList = new ContactList(this);
        formContact = new FormContact(this);
        photoList = new PhotoList(this);
    }
    public void startApp() {
        d.setCurrent(formContact); 
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
