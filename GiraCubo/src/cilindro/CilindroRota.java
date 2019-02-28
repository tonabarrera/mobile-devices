
package cilindro;

import java.awt.Frame;
import java.awt.Graphics;

/**
 *
 * @author Andres
 */
public class CilindroRota extends Frame{
    public CilindroRota(){
        setTitle("Special Effects");
        setSize(450,550);
        setVisible(true);
    }
    public void paint(Graphics g){
        // to draw a cylinder
        g.drawOval(50,60,100,50);     // upper ellipse
        g.drawLine(50,80,50,200);     // left vertical line
        g.drawLine(150,80,150,200);   // right horizontal line
        g.drawOval(50,180,100,50);    // lower ellipse
        
        // to draw cube
        g.drawRect(50,275,100,100);
        g.drawLine(50,275,130,230);
        g.drawLine(150,275,210,240);
        g.drawLine(130,230,210,240);
        g.drawLine(210,240,210,340);
        g.drawLine(150,375,210,340);
        // to draw circle
        g.drawOval(50,380,100,100); 
    }
    
  public static void main(String args[]){
    new CilindroRota();
  }
}
