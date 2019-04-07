package me.tonatihu.sql;

/**
 * @author tonatihu
 * Created on 4/6/19
 */
public class Contacto {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contacto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Contacto() {
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
