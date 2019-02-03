/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

/**
 * @author tona
 * Created on 1/02/2019
 */
public class Musica extends MIDlet {
   Player midiPlayer = null;

  public Musica() {
    try {
      midiPlayer = Manager.createPlayer(getClass().getResourceAsStream("/resources/back.mid"), "audio/midi");
      midiPlayer.setLoopCount(5);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public void startApp() {
    try {
      if (midiPlayer != null) {
        midiPlayer.start();
      }
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public void pauseApp() {
  }

  public void destroyApp(boolean unconditional) {
  }
}
