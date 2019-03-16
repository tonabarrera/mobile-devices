package me.tonatihu.fragmentos.model;

/**
 * @author tonatihu
 * Created on 3/16/19
 */
public class Grupo {
    private String remitente;
    private String asunto;
    private String texto;

    public Grupo(String remitente, String asunto, String texto) {
        this.remitente = remitente;
        this.asunto = asunto;
        this.texto = texto;
    }

    public Grupo() {}

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "remitente='" + remitente + '\'' +
                ", asunto='" + asunto + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
