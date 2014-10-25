package worten.aebd.com.worten;

/**
 * Created by jesus on 25/10/14.
 */
public class Productos {

    private int idImagen;
    private String nombre;
    private String desc;
    private double precio;
    private String categorias;

    public Productos (int idImagen, String nombre, String desc,double precio,String categorias) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.desc = desc;
        this.precio = precio;
        this.categorias = categorias;
    }

    public String get_Nombre() {
        return getNombre();
    }

    public String get_textoDebajo() {
        return getDesc();
    }

    public int get_idImagen() {
        return getIdImagen();
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategorias() {
        return categorias;
    }
}