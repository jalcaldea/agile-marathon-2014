package worten.aebd.com.worten.juegos;

/**
 * Created by ASUS on 25/10/2014.
 */
public class Juego {

    private String nombre;
    private int id;
    private int idImagen;
    private String genero;

    public Juego (String nombre, int id, int idImagen, String genero){
        this.setNombre(nombre);
        this.setId(id);
        this.setIdImagen(idImagen);
        this.setGenero(genero);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
