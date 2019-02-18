/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cubos;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 17/02/2019
 */
public class MidletCono extends MIDlet implements CommandListener{

    private Display d;
    Canvas ca;
    private Command cs;

    public MidletCono(){
        d = Display.getDisplay(this); 

        ca = new Canvas(){
            int centerX, centerY, maxX, maxY, minMaxXY;
            ObjCono obj = new ObjCono();
            int x=0, y=0;
            public void paint(Graphics g){             
                g.setColor(0x5B98FF);
                g.fillRect(0, 0, getWidth(), getHeight());
                maxX = getWidth()-1; maxY = getHeight()-1; minMaxXY=Math.min(maxX, maxY);
                centerX = maxX/2;
                centerY = maxY/2;
                obj.d = obj.rho*minMaxXY/obj.objSize;
                obj.eyeAndScreen();
                line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 4); line(g, 4, 5); line(g, 5, 6); //base
                line(g, 6, 7); line(g, 7, 0); //base
                line(g, 0, 8); line(g, 1, 8); line(g, 2, 8); line(g, 3, 8); line(g, 4, 8); line(g, 5, 8);
                line(g, 6, 8); line(g, 7, 8); //punta                
            }
            void line(Graphics g, int i, int j){
                Point2D p = obj.vScr[i], q = obj.vScr[j];
                System.out.println(((int)p.x+centerX));
                g.setColor(255,255,255);
                g.drawLine(centerX+(int)p.x ,centerY-(int)p.y, centerX+(int)q.x, centerY-(int)q.y);
            }
            void arc(Graphics g, int i, int j){
                Point2D p = obj.vScr[i], q = obj.vScr[j];
                System.out.println(((int)p.x+centerX));
                g.setColor(255,255,255);
                g.drawArc(centerX+(int)p.x ,centerY-(int)p.y, 100, 100,180,90);
            }
            public void keyPressed(int keyCode){
            switch (getGameAction(keyCode)) {
                case Canvas.DOWN: {
                    y = y + 1;
                    break;
                }
                case Canvas.LEFT: {
                    x = x - 1;
                    break;
                }
                case Canvas.UP: {
                    y = y - 1;
                    break;
                }
                case Canvas.RIGHT: {
                    x = x + 1;
                    break;
                }
                default:
                    x=x;
                    y=y;
            }
            obj.theta   = (float) getWidth()/x;
            obj.phi     = (float) getHeight()/y;
            obj.rho     = (obj.phi/obj.theta)*getHeight();
            centerX     = x;
            centerY     = y;
            repaint();
        }
        };
        cs = new Command("Salir",Command.EXIT, 3);
        ca.addCommand(cs);
        ca.setCommandListener(this);
    }
    public void startApp(){
 	d.setCurrent(ca);       
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void commandAction(Command co, Displayable di) {
        if (co == cs) {
                destroyApp(true);
                notifyDestroyed();
        } else d.setCurrent(new Alert("", "Otro comando digitado...", null, AlertType.ERROR));
    } 
}

class ObjCono{	// Posee los datos del objeto 3D
    float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;	// coordenadas universales
    Point2D [] vScr; // coordenadas de la pantalla
    ObjCono(){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        w	= new Point3D[9];
	vScr	= new Point2D[9];
        
        //base
        w[0]	= new Point3D(1, -1, -1); //0
        w[1]	= new Point3D(1.5, 0, -1);//2
	w[2]	= new Point3D(1, 1, -1); //1
        w[3]	= new Point3D(0, 1.5, -1);//3
	w[4]	= new Point3D(-1, 1, -1);//4
        w[5]	= new Point3D(-1.5, 0, -1);//5
	w[6]	= new Point3D(-1, -1, -1);//6
	w[7]	= new Point3D(0, -1.5, -1);//7
        w[8]	= new Point3D(0, 0, 2);//8
    
	objSize = (float) Math.sqrt(12F); // = sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
	rho	= 5*objSize;		// para cambiar la perspectiva
    }
    void initPersp(){
        float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
	v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
	v21 = costh; v22 = -cosph*sinth; v23 = sinph*sinth;
	v32 = sinph; v33 = cosph; v43 = -rho;
    }
    void eyeAndScreen(){
        initPersp();
	for(int i=0; i<9; i++){
            Point3D p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D(-d*x/z, -d*y/z);
	}
    }
}
