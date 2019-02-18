/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaregistros;

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
public class PhotoList extends List implements CommandListener {
    Command ok;
    MidletPrincipal p;

    public PhotoList(MidletPrincipal mid) {
        super("Galeria", Choice.EXCLUSIVE);
        p = mid;
        ok = new Command("OK", Command.OK, 1);
        addCommand(ok);
        setCommandListener(this);
        try {
            append("Foto 0", Image.createImage("/resources/0.png"));
            append("Foto 1", Image.createImage("/resources/1.jpg"));
            append("Foto 2", Image.createImage("/resources/2.jpg"));
            append("Foto 3", Image.createImage("/resources/3.jpg"));
            append("Foto 4", Image.createImage("/resources/4.png"));
            append("Foto 5", Image.createImage("/resources/5.png"));
            append("Foto 6", Image.createImage("/resources/6.jpg"));
            append("Foto 7", Image.createImage("/resources/7.jpg"));
            append("Foto 8", Image.createImage("/resources/8.png"));
            append("Foto 9", Image.createImage("/resources/9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commandAction(Command cg, Displayable d) {
        if (cg == ok) {
            String img = "";
            int imagen = getSelectedIndex();
            switch (imagen) {
                case 1:
                    img = "/resources/1.jpg";
                    break;
                case 2:
                    img = "/resources/2.jpg";
                    break;
                case 3:
                    img = "/resources/3.jpg";
                    break;
                case 4:
                    img = "/resources/4.png";
                    break;
                case 5:
                    img = "/resources/5.png";
                    break;
                case 6:
                    img = "/resources/6.jpg";
                    break;
                case 7:
                    img = "/resources/7.jpg";
                    break;
                case 8:
                    img = "/resources/8.png";
                    break;
                case 9:
                    img = "/resources/9.png";
                    break;
                case 0:
                    img = "/resources/0.png";
                    break;
                default:
                    img = "/resources/5.png";
                    break;
            }
            p.formContact.foto = img;
            p.d.setCurrent(p.formContact);
        }
    }
}
