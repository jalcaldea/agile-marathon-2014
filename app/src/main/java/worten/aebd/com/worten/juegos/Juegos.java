package worten.aebd.com.worten.juegos;

import java.util.ArrayList;

import worten.aebd.com.worten.R;

/**
 * Created by ASUS on 25/10/2014.
 */
public class Juegos {

    private ArrayList<Juego> lista;
    private Juego selected;

    public Juegos(){

        setLista(new ArrayList<Juego>());

        lista.add(new Juego("Super Mario", 1, R.drawable.im_mario, "Plataformas"));
        lista.add(new Juego("Rally", 2, R.drawable.im_car, "Carreras"));
        lista.add(new Juego("Tikoshi mo nu", 3, R.drawable.im_random, "RPG"));
        lista.add(new Juego("Domino", 4, R.drawable.im_dom, "Juegos de mesa"));

    }

    public ArrayList<Juego> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Juego> lista) {
        this.lista = lista;
    }

    public Juego getSelected() {
        return selected;
    }

    public void setSelected(Juego selected) {
        this.selected = selected;
    }
}
