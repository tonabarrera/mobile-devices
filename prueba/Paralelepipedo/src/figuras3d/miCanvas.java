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
    private Font font;
    Obj obj = new Obj();
    public miCanvas(GirarCubo m) {
        midlet = m;
        centerX = maxX/2;
	centerY = maxY/2;
        font = Font.getFont(Font.FACE_PROPORTIONAL, 
        Font.STYLE_PLAIN, Font.SIZE_LARGE);
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
        g.setColor(0,0,0);
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        //System.out.println("(" + p.x + "," + p.y + ")   " + "(" + q.x + "," + q.y + ")");
        //System.out.println("float: " + p.x + ", " + p.y + "int: " + (int)p.x + ", " + (int)p.y);
        
        //String coordenada = "0, 0, 0";
        int x = (int) p.x;
        int y = (int) p.y;
        String coordenada = "(" + x + "," + y + ")";

        g.setFont(font);
        g.drawString(coordenada, iX(q.x), iY(q.y), Graphics.TOP | Graphics.LEFT);
        
    }
    
    void colorLineX(Graphics g, int i, int j){
        g.setColor(255,0,0);
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        
        String coordenada = "X";
        g.setFont(font);
        g.drawString(coordenada, iX(q.x), iY(q.y), Graphics.TOP | Graphics.LEFT);
    }
    
    void colorLineY(Graphics g, int i, int j){
        g.setColor(40,22,255);
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        
        String coordenada = "Y";
        g.setFont(font);
        g.drawString(coordenada, iX(q.x), iY(q.y), Graphics.TOP | Graphics.LEFT);
    }
    
    void colorLineZ(Graphics g, int i, int j){
        g.setColor(40,255,58);
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        
        int x = (int) q.x;
        int y = (int) q.y;
        String coordenada = "Z";
        g.setFont(font);
        g.drawString(coordenada, iX(q.x), iY(q.y), Graphics.TOP | Graphics.LEFT);
        
    }
    
    public void paint(Graphics g) {
        g.setColor(255,255,255);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(0,0,0);
        
        double volumen = obj.totalVol;
        String sandeep = "VOLUMEN: " + volumen ;
        int w = font.stringWidth(sandeep);
        int h = font.getHeight();
        int x = ((getWidth() - w) / 2);
        int y = (getHeight() / 2) + 130;

        g.setFont(font);
        g.drawString(sandeep, x, y, Graphics.TOP | Graphics.LEFT);
        g.drawRect(x, y, w, h);
    
        
        maxX = getWidth()-1; maxY = getHeight()-1; minMaxXY=Math.min(maxX, maxY);
	centerX = maxX/2;
	centerY = maxY/2;
	obj.d = obj.rho*minMaxXY/obj.objSize;
	obj.eyeAndScreen();
	line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
	line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores
	line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7); // aristas verticales
        colorLineX(g, 8, 9); colorLineY(g, 8, 10); colorLineZ(g, 8, 11); 
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
    double t1 = 0.0;
    double t2 = 0.0;
    double t3 = 0.0;
    double totalVol = 0.0;
    double ang   = 2.0 * Math.PI / vertices;
    
    float rho, theta=1.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;	// coordenadas universales
    Point2D [] vScr; // coordenadas de la pantalla
    Obj(){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        
        
    // Paralelepipedo
    w = new Point3D[12];
    vScr = new Point2D[12];
    w[0] = new Point3D(1, -1, -1); // desde la base //
    w[1] = new Point3D(1, 1, -1);
    w[2] = new Point3D(-1, 1, -1); //
    w[3] = new Point3D(-1, -1, -1);
    // Tapa
    w[4] = new Point3D(2, -1, 1); //
    w[5] = new Point3D(2, 1, 1);
    w[6] = new Point3D(0, 1, 1);
    w[7] = new Point3D(0, -1, 1);
    
    // Ejes
    w[8] = new Point3D(0, 0, 0);
    w[9] = new Point3D(4, 0, 0);
    w[10] = new Point3D(0, 4, 0);
    w[11] = new Point3D(0, 0, 4);
    
    /*w[0] = new Point3D(0.5, -0.5, -0.5); // desde la base //
    w[1] = new Point3D(0.5, 0.5, -0.5);
    w[2] = new Point3D(-0.5, 0.5, -0.5); //
    w[3] = new Point3D(-0.5, -0.5, -0.5);
    // Tapa
    w[4] = new Point3D(1, -0.5, 0.5); //
    w[5] = new Point3D(1, 0.5, 0.5);
    w[6] = new Point3D(0, 0.5, 0.5);
    w[7] = new Point3D(0, -0.5, 0.5);
    
    // Ejes
    w[8] = new Point3D(0, 0, 0);
    w[9] = new Point3D(2, 0, 0);
    w[10] = new Point3D(0, 2, 0);
    w[11] = new Point3D(0, 0, 2);*/
    
    // DETERMINANTE 
    double a00 = w[3].x;
    double a01 = w[3].y;
    double a02 = w[3].z;
    
    double a10 = w[1].x;
    double a11 = w[1].y;
    double a12 = w[1].z;
    
    double a20 = w[4].x;
    double a21 = w[4].y;
    double a22 = w[4].z;
    
    totalVol = a00*a11*a22 + a10*a21*a02 +a20*a01*a12;
    totalVol = totalVol+(a02*a11*a20)*-1 + (a12*a21*a00)*-1 + (a22*a01*a10)*-1;

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
	for(int i=0; i<12; i++){
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


