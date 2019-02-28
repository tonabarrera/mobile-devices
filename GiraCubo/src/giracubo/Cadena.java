/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giracubo;

/**
 *
 * @author DAE
 */
import java.io.*;
import java.lang.*;
import java.lang.Math;

public class Cadena{
	String cadenota;
	static String ipn = "IPN";
	public Cadena(){
            cadenota = new String();
		for(int i=0;i<100000;i++){
			cadenota = cadenota.concat(generaCadena());
		}		
	}

	public String generaCadena(){
		String pal = new String();
		char tmp;
		for(int i=0;i<3;i++){
			tmp = (char)((int)(Math.random()*26)+65);
			pal = pal + tmp;
		}
		pal = pal + " ";	
                //System.out.println(pal);
		return pal;		
	}

	public static void main(String [] args){
                long time_start, time_end;
                time_start = System.currentTimeMillis();
		Cadena cadenoto = new Cadena();
		int index = cadenoto.cadenota.indexOf(ipn);
                time_end = System.currentTimeMillis();
                System.out.println((double)( time_end - time_start )/1000 +" seg");                
		if(index==-1){
			System.out.println("No encontrado\n");
		}else{
			System.out.println("La cadena se encontro en la posicion "+index+" : ... "+cadenoto.cadenota.substring(index-4,index+7)+" ..." );
		}
	}
}
