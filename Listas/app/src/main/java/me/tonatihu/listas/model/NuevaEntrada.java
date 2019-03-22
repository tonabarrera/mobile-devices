package me.tonatihu.listas.model;

import java.util.Date;

/**
 * @author tonatihu
 * Created on 3/21/19
 */
public class NuevaEntrada {
    private String titulo;
    private String autor;
    private Date fecha;
    private int icono;

    public NuevaEntrada() {}

    public NuevaEntrada(String titulo, String autor, Date fecha, int icono) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "NuevaEntrada{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fecha=" + fecha +
                ", icono=" + icono +
                '}';
    }
}
