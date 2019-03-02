package figuras.cilindro;

import figuras.Point2D;
import figuras.Point3D;

/**
 *
 * @author USER
 */
public class ObjCilindro {
    float rho, theta=0.3F, phi=1.3F, d, objSize;
    float v11, v12, v13, v21, v22, v23, v32, v33, v43;
    Point3D [] w;
    Point2D [] vScr;
    public ObjCilindro(){
        w = new Point3D[144];
        vScr = new Point2D[144];

        double i = 0;
        for (int j=0; j < 144; i+=0.087, j+=2) {
            w[j] = new Point3D(Math.cos(i), Math.sin(i), -1);
            w[j+1] = new Point3D(Math.cos(i), Math.sin(i), 1);
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
        for(int i=0; i<144; i++){
            Point3D p = w[i];
            float x = v11*p.x + v21*p.y;
            float y = v12*p.x + v22*p.y + v32*p.z;
            float z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D(-d*x/z, -d*y/z);
        }
    }
}