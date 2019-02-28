/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubomidlet;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

/**
 *
 * @author jorgeenrique
 */
public class ListaFiguras extends List implements CommandListener{
    Command ok;
    GirarCubo p; 
    public ListaFiguras(GirarCubo mid) {
        super("Galeria",Choice.EXCLUSIVE);
        p = mid;
        ok = new Command("OK", Command.OK, 1); 
        addCommand(ok); 
        setCommandListener(this);
        try{
        append("Cuadrado",null);
        append("Cono",null);
        append("Esfera",null);
        append("Pentagano",null);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void commandAction(Command cg, Displayable d) {
        if(cg == ok){
            String img = "";
            int imagen = getSelectedIndex();
            
            switch(imagen){
                case 0:
                    p.d.setCurrent(p.cuadrado);
                    break;
                case 1:
                    p.d.setCurrent(p.cono);
                    break;
                case 2:
                    p.d.setCurrent(p.esfera);
                    break;
                case 3:
                    p.d.setCurrent(p.pentagono);
                    break;
                default: 
                    break;
            }
            
        }
    }
    
    
}
