/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author tona
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Math.toRadians(180));
        System.out.println(Math.PI);
        System.out.println(obtenerX(0));
    }
    
    public static double obtenerX(int x) {
        double aux = 4d/240;
        System.out.println(aux);
        return (aux*x - 2) * Math.PI;
    }
    
}
