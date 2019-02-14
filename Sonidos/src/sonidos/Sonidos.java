/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sonidos;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.ToneControl;
import javax.microedition.midlet.*;

/**
 * @author tona
 * Created on 11/02/2019
 */
public class Sonidos extends MIDlet implements CommandListener {
    Display	d;
    Form	f;
    Command	c;
    Command wav, nota, secuencia;
    public Sonidos() {  
        d	= Display.getDisplay(this); 
        c	= new Command("Salir", Command.EXIT, 1); 
        wav	= new Command("Wav", Command.SCREEN, 2); 
        nota	= new Command("Nota", Command.SCREEN, 2); 
        secuencia = new Command("Secuencia", Command.SCREEN, 2); 
        f	= new Form("Reproducir."); 
        f.addCommand(c); 
        f.addCommand(wav); 
        f.addCommand(nota); 
        f.addCommand(secuencia); 
        f.setCommandListener(this); 
    }
    
    public void startApp() { 
            d.setCurrent(f); 
    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {}
    
    public void commandAction(Command co, Displayable di) { 
        if (co == c) {  
            destroyApp(false); 
            notifyDestroyed(); 
        }else{
            if (co == wav)
                playWav();
            if (co == nota)
                playNota();
            if (co == secuencia)
                try {
                    playSecuencia();
            } catch (MediaException ex) {
                ex.printStackTrace();
            }
        } 
    }
    
    public void playWav(){
        try { 
            InputStream in = getClass().getResourceAsStream("/resources/you_got_it.wav"); 
            Player p = Manager.createPlayer(in, "audio/x-wav"); 
            p.start(); 
        }catch (Exception e){
            Alert alr = new Alert("Error", "No se reproduce sonido.", null, AlertType.ERROR);
            alr.setTimeout(Alert.FOREVER); 
            d.setCurrent(alr, f); 
        } 
    } 
    public void playNota(){ 
        try {
            Manager.playTone(ToneControl.C4, 100, 80);  
        }catch (Exception e){} 
    } 
    public void playSecuencia() throws MediaException { 
        byte tempo = 30; 
        byte d = 8; 
        byte C4 = ToneControl.C4; // Nota DO
        byte D4 = (byte)(C4 + 2);
        byte E4 = (byte)(C4 + 4); 
        byte F4 = (byte)(C4 + 5); 
        byte G4 = (byte)(C4 + 7); 
        byte silencio = ToneControl.SILENCE; 
        byte[] secuencia = { 
            ToneControl.VERSION, 1, ToneControl.TEMPO, tempo, 
            ToneControl.BLOCK_START, 0, C4,d, F4,d, F4,d, C4,d, F4,d, F4,d, C4,d, F4,d, 
            ToneControl.BLOCK_END, 0,    
            ToneControl.BLOCK_START, 1, C4,d, E4,d, E4,d, C4,d, E4,d, E4,d, C4,d, E4,d, 
            ToneControl.BLOCK_END, 1,
            ToneControl.PLAY_BLOCK, 0,   
            ToneControl.PLAY_BLOCK, 1,   
            ToneControl.PLAY_BLOCK, 0,   
                };
        try{ 
            Player p = Manager.createPlayer(Manager.TONE_DEVICE_LOCATOR); 
            p.realize(); 
            ToneControl c = (ToneControl)p.getControl("ToneControl"); 
            c.setSequence(secuencia); 
            p.start(); 
        } catch (IOException ex) {}
        catch (MediaException exMedia) {}
    }
}
