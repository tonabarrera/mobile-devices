package figuras;

import figuras.cilindro.PerspectivaCilindro;
import figuras.cono.PerspectivaCono;
import figuras.cubo.PerspectivaCubo;
import figuras.esfera.PerspectivaEsfera;
import figuras.piramide.PerspectivaPiramide;
import figuras.prisma.PerspectivaPrisma;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;

/**
 * @author USER
 */
public class MidletPrincipal extends MIDlet implements CommandListener{
    List lista;
    Display d;
    String nombres[] = new String[]{
        "Cilindro", "Cono", "Cubo", "Esfera", "Piramide", "Prisma"
    };
    Command commandSeleccionar;
    Command commandRegresar;
    
    public MidletPrincipal() {
        d = Display.getDisplay(this);
        lista = new List("Seleciona una figura", List.EXCLUSIVE, nombres, null);
        commandSeleccionar = new Command("Seleccionar", Command.OK, 1);
        commandRegresar = new Command("Regresar", Command.OK, 2);
        
        lista.addCommand(commandSeleccionar);
        lista.setCommandListener(this);
    }

    public void startApp() {
        d.setCurrent(lista);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable dd) {
        if (c == commandSeleccionar) {
            int seleccionado = lista.getSelectedIndex();
            switch (seleccionado) {
                case 0:
                    PerspectivaCilindro cilindro = new PerspectivaCilindro();
                    cilindro.addCommand(commandRegresar);
                    cilindro.setCommandListener(this);
                    d.setCurrent(cilindro);
                    break;
                case 1:
                    PerspectivaCono cono = new PerspectivaCono();
                    cono.addCommand(commandRegresar);
                    cono.setCommandListener(this);
                    d.setCurrent(cono);
                    break;
                case 2:
                    PerspectivaCubo cubo = new PerspectivaCubo();
                    cubo.addCommand(commandRegresar);
                    cubo.setCommandListener(this);
                    d.setCurrent(cubo);
                    break;
                case 3:
                    PerspectivaEsfera esfera = new PerspectivaEsfera();
                    esfera.addCommand(commandRegresar);
                    esfera.setCommandListener(this);
                    d.setCurrent(esfera);
                    break;
                case 4:
                    PerspectivaPiramide piramide = new PerspectivaPiramide();
                    piramide.addCommand(commandRegresar);
                    piramide.setCommandListener(this);
                    d.setCurrent(piramide);
                    break;
                case 5:
                    PerspectivaPrisma prisma = new PerspectivaPrisma();
                    prisma.addCommand(commandRegresar);
                    prisma.setCommandListener(this);
                    d.setCurrent(prisma);
                    break;
                default:
                    prisma = new PerspectivaPrisma();
                    prisma.addCommand(commandRegresar);
                    prisma.setCommandListener(this);
                    d.setCurrent(prisma);
                    break;
            }
        } else if (c == commandRegresar) {
            d.setCurrent(lista);
        }
    }
}
