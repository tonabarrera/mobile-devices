package me.tonatihu.listview;

/**
 * @author tonatihu
 * Created on 3/24/19
 */
public class ListaEntrada {
    private int idim;
    private String a;
    private String d;

    public ListaEntrada() {
    }

    public ListaEntrada(int idim, String a, String d) {
        this.idim = idim;
        this.a = a;
        this.d = d;
    }

    public int getIdim() {
        return idim;
    }

    public void setIdim(int idim) {
        this.idim = idim;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "ListaEntrada{" +
                "idim=" + idim +
                ", a='" + a + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
