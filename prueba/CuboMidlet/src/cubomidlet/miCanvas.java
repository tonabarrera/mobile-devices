/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cubomidlet;
import javax.microedition.lcdui.*;
public class miCanvas extends Canvas implements CommandListener {
    GirarCubo midlet;
    int centerX, centerY, maxX, maxY, minMaxXY;
    Obj obj;
    Command salir;
    public miCanvas(GirarCubo m,int base,int altura) {
        midlet = m;
        centerX = maxX/2;
	centerY = maxY/2;
        obj = new Obj(base,altura);
        try {
	    
            salir = new Command("Lista", Command.ITEM, 1);
	    addCommand(salir);
            setCommandListener(this);
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
        //g.drawArc(iX(p.x), iY(p.y), 100, 100, 90, 180);
    }
    
    void arc(Graphics g, int i, int j){
    	Point2D p = obj.vScr[i], q = obj.vScr[j];
    	//g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
        g.drawArc(iX(p.x), iY(p.y), 100, 100, 0, 90);
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
	obj.eyeAndScreen(obj.a+obj.b);

        for(int i = 0;i<obj.b;i++){  
            if(i == (obj.b-1)){
                //line(g, obj.b-1, 0);
                arc(g, obj.b-1, 0);
                break;
            }
            //line(g, i, i+1);
            arc(g, i, i+1);
        }
        for(int i = obj.b;i<obj.b + obj.a;i++){  
            if(i == (obj.b + obj.a-1)){
                //line(g, obj.b + obj.a-1, obj.b);
                arc(g, obj.b + obj.a-1, obj.b);
                break;
            }
            //line(g, i, i+1);
            arc(g, i, i+1);
        }
        if(obj.a == 1){
            for(int i = 0;i<obj.b;i++){
                //line(g, i, obj.b);
                arc(g, i, obj.b);
            }
        }else{
            for(int i = 0;i<obj.b;i++){
                //line(g, i, i+obj.b);
                arc(g, i, i+obj.b);
            }
        }
	//line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
	//line(g, 4, 5); line(g, 5, 6); line(g, 6, 7); line(g, 7, 4); // aristas horizontales superiores
	//line(g, 0, 4); line(g, 1, 5); line(g, 2, 6); line(g, 3, 7);
        // aristas verticales
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
        
    public void commandAction(Command command, Displayable displayable) {
        if(command == salir){
            System.out.println("Comando...");
            midlet.d.setCurrent(midlet.lf);
        }
    }
}

class Obj{	// Posee los datos del objeto 3D
    float rho, theta=1.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;	// coordenadas universales
    Point2D [] vScr; // coordenadas de la pantalla
    int a,b;
    public Obj(int base,int altura){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        w	= new Point3D[altura + base];
	vScr	= new Point2D[altura + base];
        a = altura;
        b = base;
        int i=0;
        int angulo= 0;
        
        for(i = 0;i<base;i++){
            double x = Math.cos(Math.toRadians( angulo ));
            double y = Math.sin(Math.toRadians( angulo ));
            w[i] = new Point3D(Math.cos(Math.toRadians( angulo )), Math.sin(Math.toRadians( angulo )), -1); // desde la base
            angulo = 360/base + angulo;
        }
        angulo= 0;
        if(altura == 1){
            w[base] = new Point3D(0, 0, 1);
        }
        else{
            for(i =base;i<base+altura;i++){
            w[i] = new Point3D(Math.cos(Math.toRadians( angulo )), Math.sin(Math.toRadians( angulo )), 1);
            angulo = 360/base + angulo;
        }
        }
        
        

        
	objSize = (float) Math.sqrt(12F); // = sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
	rho	= 5*objSize;		// para cambiar la perspectiva
    }
    void initPersp(){
        float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
	v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
	v21 = costh; v22 = -cosph*sinth; v23 = sinph*sinth;
	v32 = sinph; v33 = cosph; v43 = -rho;
    }
    void eyeAndScreen(int points){
        initPersp();
	for(int i=0; i<points; i++){
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
