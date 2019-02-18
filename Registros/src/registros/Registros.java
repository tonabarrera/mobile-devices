/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registros;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author tona
 * Created on 11/02/2019
 */
public class Registros {
    RecordStore rs;

    public Registros(){
    }
	
    public boolean abrir(String zona){
        try{
            rs=RecordStore.openRecordStore(zona,true);
            return true;
        }catch(RecordStoreException rse){
            rse.toString();
            return false;
        }
    }
	
    public boolean alta(String s){
        byte[] m;
        m=s.getBytes();
        try{
            rs.addRecord(m,0,m.length);
            return true;
        }catch(RecordStoreException rse){
            rse.toString();
            return false;
        }
    }
	
    public String[] consulta(int n){
        byte[] r=new byte[100];
        ByteArrayInputStream bais;
        DataInputStream dis;
        String[] datos=new String[3];
        try{
            bais=new ByteArrayInputStream(r);
            dis=new DataInputStream(bais);
            datos[0]=dis.readUTF();
            datos[1]=dis.readUTF();
            datos[2]=dis.readUTF();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return datos;
    }
	
    public boolean fin(){
        try{
            rs.closeRecordStore();
            return true;
        }catch(RecordStoreException rse){
            return false;
        }
    }
}
