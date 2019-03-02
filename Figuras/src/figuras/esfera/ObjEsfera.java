/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras.esfera;

import figuras.Point2D;
import figuras.Point3D;

/**
 *
 * @author USER
 */
public class ObjEsfera {	// Posee los datos del objeto 3D
    float rho, theta=0.3F, phi=1.3F, d, objSize;
    float v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;	// coordenadas universales
    Point2D [] vScr; // coordenadas de la pantalla
    public ObjEsfera(){	// CAMBIAR LAS COORDENADAS X,Y,Z CON 0,1 PARA CONSTRUIR PRISMA, CILINDRO, PIRAMIDE, CONO Y ESFERA.
        w = new Point3D[4608];
        vScr = new Point2D[4608];
        double i;
        double altura = 1;
        double y = -0.99;
        double anchura;
        for (int k = 0; k < 4608; k+=72) {
            i = 0;
            anchura =Math.sqrt(1-(y*y));
            for (int j=0; j < 36; i+=0.171, j+=1) {
                w[j+k] = new Point3D(anchura*Math.cos(i), anchura*Math.sin(i), -altura);
                w[j+36+k] = new Point3D(anchura*Math.cos(i), anchura*Math.sin(i), altura);
            }
            y+=0.015;
            altura-=0.016;
        }
        objSize = (float) Math.sqrt(12F);
        rho = 5*objSize;
    }
    
    void initPersp(){
        float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta);
        float cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
        v11 = -sinth; 
        v12 = -cosph*costh; 
        v13 = sinph*costh;
        v21 = costh; 
        v22 = -cosph*sinth; 
        v23 = sinph*sinth;
        v32 = sinph; 
        v33 = cosph; 
        v43 = -rho;
    }
    
    void eyeAndScreen(){
        initPersp();
        for(int i=0; i<4608; i++){
            Point3D p = w[i];
            float x = v11*p.x + v21*p.y;
            float y = v12*p.x + v22*p.y + v32*p.z;
            float z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D(-d*x/z, -d*y/z);
        }
    }
}