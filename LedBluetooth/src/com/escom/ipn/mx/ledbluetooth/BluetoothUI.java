package com.escom.ipn.mx.ledbluetooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.bluetooth.*;
import javax.bluetooth.DiscoveryListener;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author Vaibhav
 */
public class BluetoothUI extends MIDlet implements CommandListener, DiscoveryListener {

    private final List listaDispositivos;
    private final Command commandSalir, commandBuscar;
    private Command commandSeleccionar, commandEnviar;
    private List listaOpciones;

    private String value = "" + 0;
    private Display d;
    private Form f;
    private Vector v;

    private String deviceName;
    private DiscoveryAgent agent;
    private Alert dialog;

    private StreamConnection con;
    private OutputStream outs;
    private InputStream ins;

    public BluetoothUI() {
        listaDispositivos = new List("Lista de dispositivos", List.IMPLICIT);
       

        commandSalir = new Command("Salir", Command.EXIT, 0);
        commandBuscar = new Command("Volver a buscar", Command.SCREEN, 1);
        
        commandSeleccionar = new Command("Seleccionar Dispositivo", Command.SCREEN, 1);
        commandEnviar = new Command("Enviar", Command.OK, 1);

        listaDispositivos.addCommand(commandSalir);
        listaDispositivos.addCommand(commandBuscar);
        listaDispositivos.addCommand(commandSeleccionar);
        listaDispositivos.setCommandListener(this);

        v = new Vector();
      
        d = Display.getDisplay(this);
    }

    public void startApp() {
        d.setCurrent(listaDispositivos);

        try {
            listaDispositivos.deleteAll();
            LocalDevice local = LocalDevice.getLocalDevice();
            local.setDiscoverable(DiscoveryAgent.GIAC);
            deviceName = local.getFriendlyName();
            agent = local.getDiscoveryAgent();
        } catch (BluetoothStateException ex) {
            ex.printStackTrace();
        }
        try {
            agent.startInquiry(DiscoveryAgent.GIAC, this);
        } catch (BluetoothStateException ex) {
            ex.printStackTrace();
        }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        try {
            this.outs.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == commandSalir) {
            this.destroyApp(true);
            notifyDestroyed();
        } else if (c == commandBuscar) {
            this.startApp();
        } else if (c == commandSeleccionar) {
            try {
                RemoteDevice rd = (RemoteDevice) v.elementAt(listaDispositivos.getSelectedIndex());
                //f = new Form("Conectado a: " + rd.getFriendlyName(true));
                listaOpciones = new List("Selecciona una opcion", List.IMPLICIT);
                listaOpciones.insert(0, "Encender LED", null);
                listaOpciones.insert(1, "Apagar LED", null);
                listaOpciones.addCommand(commandEnviar);
                listaOpciones.setCommandListener(this);
                //f.addCommand(commandEnviar);
                //f.setCommandListener(this);

                String URL = "btspp://" + rd.getBluetoothAddress() + ":1;authenticate=false;encrypt=false;master=false";

                //this.d.setCurrent(f);
                this.d.setCurrent(listaOpciones);

                this.con = ((StreamConnection) Connector.open(URL));
                this.outs = this.con.openOutputStream();
                this.ins = this.con.openInputStream();

            } catch (IOException ex) {
                this.d.setCurrent(new Alert("No, wey", "La neta no jaló, wey", null, AlertType.WARNING));
            }
            this.d.setCurrent(listaOpciones);
        } else if (c == commandEnviar) {
            try {
                if (this.listaOpciones.getSelectedIndex() == 0) {
                    this.outs.write('1');
                } else {
                    this.outs.write('0');
                }
//                if (value == "0") {
//                    value = "" + 1;
//                    f.append(value);
//                    this.outs.write('1');
//                } else {
//                    value = "" + 0;
//                    f.append(value);
//                    outs.write('0');
//                }
                this.outs.flush();
            } catch (IOException ex) {
                //f.append(ex.toString());
                ex.printStackTrace();
            }
        }
    }

    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
        String deviceaddress = null;
        try {
            deviceaddress = btDevice.getBluetoothAddress();//btDevice.getFriendlyName(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        v.addElement(btDevice);
        listaDispositivos.insert(0, deviceaddress, null);
    }

    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void serviceSearchCompleted(int transID, int respCode) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inquiryCompleted(int discType) {
        Alert dialog = null;
        if (discType != DiscoveryListener.INQUIRY_COMPLETED) {
            dialog = new Alert("Bluetooth Error", "The inquiry failed to complete normally", null, AlertType.ERROR);
        } else {
            dialog = new Alert("Inquiry Completed", "The inquiry completed normally", null, AlertType.INFO);
        }
        dialog.setTimeout(500);
        d.setCurrent(dialog);
    }
}
