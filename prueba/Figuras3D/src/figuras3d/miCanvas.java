/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figuras3d;

import javax.microedition.lcdui.*;

public class miCanvas extends Canvas implements CommandListener {
    GirarCubo midlet;
    int centerX, centerY, maxX, maxY, minMaxXY;
    Obj obj = new Obj();
    public miCanvas(GirarCubo m) {
        midlet = m;
        centerX = maxX/2;
	centerY = maxY/2;
        try {
	    setCommandListener(this);
	    addCommand(new Command("Exit", Command.EXIT, 1));
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    } 
    
    int iX(float x){
	float i = centerX + x;
        return (int)i;
    }
    
    int iY(float y){
        float i = centerY - y;
    	return (int)i;
    }
    
    void line(Graphics g, int i, int j){
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        //g.drawArc(iX(p.x), iY(p.y), 120, 120, 0, 90);
    }
    
    void arc(Graphics g, int i, int j){
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	//g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        g.drawArc(iX(p.x), iY(p.y), 200, 200, 0, 90);
        //g.drawArc(iX(p.x), iY(p.y), 100, 100, 90, 180);
    }
    
    public void paint(Graphics g) {
        g.setColor(255,255,255);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(0,0,0);
        maxX = getWidth()-1; maxY = getHeight()-1; minMaxXY=Math.min(maxX, maxY);
	centerX = maxX/2;
	centerY = maxY/2;
	obj.d = obj.rho*minMaxXY/obj.objSize;
	obj.eyeAndScreen();
	line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
	line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores
	line(g, 0, 4); arc(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
    }
    
    protected  void keyPressed(int keyCode) {
        int arriba = getKeyCode(UP);
        int abajo = getKeyCode(DOWN);
        int izq = getKeyCode(LEFT);
        int dcha = getKeyCode(RIGHT);
        if (keyCode == arriba)     { obj.phi       = obj.phi-(float)0.1; repaint(); }
        else if (keyCode == abajo) { obj.phi       = obj.phi+(float)0.1; repaint();}
        else if (keyCode == izq  ) { obj.theta     = obj.theta-(float)0.1; repaint(); }
        else if (keyCode == dcha ) { obj.theta     = obj.theta+(float)0.1; repaint(); }
        else if (keyCode == 49) { centerX += 10; repaint(); }
        else if (keyCode == 50) { centerX -= 10; repaint(); }
        else if (keyCode == 51) { centerY += 10; repaint(); }
        else if (keyCode == 52) { centerY -= 10; repaint(); }
    }
    
    protected  void keyReleased(int keyCode) {
    }

    protected  void keyRepeated(int keyCode) {
    }
    
    protected  void pointerDragged(int x, int y) {
    }

    protected  void pointerPressed(int x, int y) {
    }

    protected  void pointerReleased(int x, int y) {
    }
    
    public void commandAction(Command command, Displayable displayable) {
    }
}

class Obj{	// Posee los datos del objeto 3D
    int vertices = 4;
    int radio = 1;
    double ang   = 2.0 * Math.PI / vertices;
    
    float rho, theta=1.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;	// coordenadas universales
    Point2D [] vScr; // coordenadas de la pantalla
    Obj(){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        
        
        // Cubo
        w	= new Point3D[8];
	vScr	= new Point2D[8];
        w[0] = new Point3D(1, -1, -1); // desde la base
	w[1] = new Point3D(1, 1, -1);
	w[2] = new Point3D(-1, 1, -1);
	w[3] = new Point3D(-1, -1, -1);
        w[4] = new Point3D(1, -1, 1);
	w[5] = new Point3D(1, 1, 1);
	w[6] = new Point3D(-1, 1, 1);
	w[7] = new Point3D(-1, -1, 1);
        
        // Piramide
        
        /*w	= new Point3D[8];
	vScr	= new Point2D[8];
        w[0] = new Point3D(1, -1, -1); // desde la base
	w[1] = new Point3D(1, 1, -1);
	w[2] = new Point3D(-1, 1, -1);
	w[3] = new Point3D(-1, -1, -1);
        w[4] = new Point3D(0, 0, 1);
	w[5] = new Point3D(0, 0, 1);
	w[6] = new Point3D(0, 0, 1);
	w[7] = new Point3D(0, 0, 1);*/
        
        // Cono
        
        // General
        /*for(int i=0; i<vertices; i++){
            w[vertices] = new Point3D(Math.floor(radio * Math.cos(i * ang)), Math.floor(radio * Math.sin(i * ang)), -1);
            System.out.println("W["+i+"]: "+ radio * Math.cos(i * ang)+", "+ radio * Math.sin(i * ang)+", "+ -1.0);
            System.out.println("W["+i+"]: "+ Math.floor(radio * Math.cos(i * ang))+", "+ Math.floor(radio * Math.sin(i * ang))+", "+ -1.0);
        }
        for(int i=4; i<vertices+4; i++){
            w[vertices] = new Point3D(Math.floor(radio * Math.cos(i * ang)), Math.floor(radio * Math.sin(i * ang)), 1);
            System.out.println("W["+i+"]: "+ radio * Math.cos(i * ang)+", "+ radio * Math.sin(i * ang)+", "+ 1.0);
            System.out.println("W["+i+"]: "+ Math.floor(radio * Math.cos(i * ang))+", "+ Math.floor(radio * Math.sin(i * ang))+", "+ 1.0);
        }*/

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
	for(int i=0; i<8; i++){
		Point3D p = w[i];
		float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
		vScr[i] = new Point2D(-d*x/z, -d*y/z);
	}
    }
}
class Point2D{
    float x, y;
    Point2D(float x, float y){
    	this.x = x;
        this.y = y;
    }
}
class Point3D{
    float x, y, z;
    Point3D(double x, double y, double z){
        this.x = (float) x;
	this.y = (float) y;
	this.z = (float) z;
    }
}

