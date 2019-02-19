/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agendaregistros;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 *
 * @author tona
 * Created on 17/02/2019
 */
public class Persistence {
    RecordStore rs;
    private String rsName = "persistence";
    
    public Persistence() {}
    public Persistence(String rsName){
        this.rsName = rsName;
    }
    
    public boolean open(){
        try{
            rs=RecordStore.openRecordStore(rsName, true);
            return true;
        }catch(RecordStoreException rse){
            rse.toString();
            return false;
        }
    }
    
    public boolean close(){
        try{
            rs.closeRecordStore();
            return true;
        }catch(RecordStoreException rse){
            rse.toString();
            return false;
        }
    }
    
    public boolean deletePersistence() {
        try {
            RecordStore.deleteRecordStore(rsName);
            return true;
        } catch (RecordStoreException ex) {
            ex.toString();
            return false;
        }
    }
    
    public String[] getAllRecordStores() {
        return RecordStore.listRecordStores();
    }
    
    public int getNumRecords() {
        try {
            return rs.getNumRecords();
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public int save(Person person) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream  dos = new DataOutputStream(baos);
        byte[] data = null;
        int id = -1;
        try {
            dos.writeUTF(person.getName());
            dos.writeUTF(person.getLastName());
            dos.writeUTF(person.getTelephone());
            dos.writeUTF(person.getCellPhone());
            dos.writeUTF(person.getAddress());
            dos.writeUTF(person.getPhoto());
            dos.close();
            data = baos.toByteArray();
        } catch (IOException ex) {
            ex.toString();
            return -1;
        }
        try {
            id = rs.addRecord(data, 0, data.length);
        } catch (RecordStoreException ex) {
            ex.toString();
            return -1;
        }
        return id;
    }

    public Person getElement(int recordId) {
        Person person = new Person();
        byte[] data = null;
        try {
            data = rs.getRecord(recordId);
        } catch (RecordStoreException ex) {
            //ex.printStackTrace();
            System.out.println("NO LO ENCONTRO: " + ex.toString());
            return null;
        }
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        try {
            person.setName(dis.readUTF());
            person.setLastName(dis.readUTF());
            person.setTelephone(dis.readUTF());
            person.setCellPhone(dis.readUTF());
            person.setAddress(dis.readUTF());
            person.setPhoto(dis.readUTF());
            dis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return person;
    }
    
    public boolean deleteRecord(int id) {
        try {
            rs.deleteRecord(id);
            return true;
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public int findRecord(String n, String l) {
        int resultado = -1;
        try {
            for (int i = 1; i < rs.getNextRecordID(); i++) {
                byte[] data = null;
                try {
                    data = rs.getRecord(i);
                } catch (RecordStoreException ex) {
                    System.out.println("DATA NULA continuando..." + ex.toString());
                    continue;
                }
                DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
                String nombre = dis.readUTF();
                String lastName = dis.readUTF();
                System.out.println("findRecord: " + nombre + " " + lastName);
                if (n.equals(nombre) && l.equals(lastName)) {
                    resultado = i;
                    break;
                }
            }
        } catch (RecordStoreNotOpenException ex) {
            System.out.println("TRY 1: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("TRY 3: " + ex.toString());
        } catch (RecordStoreException ex) {
            System.out.println("TRY 2: " + ex.toString());
        }
        return resultado;
    }

    void update(int id, Person person) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(person.getName());
            dos.writeUTF(person.getLastName());
            dos.writeUTF(person.getTelephone());
            dos.writeUTF(person.getCellPhone());
            dos.writeUTF(person.getAddress());
            dos.writeUTF(person.getPhoto());
            dos.close();
            byte[] data = baos.toByteArray( );
            rs.setRecord(id, data, 0, data.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }
}
