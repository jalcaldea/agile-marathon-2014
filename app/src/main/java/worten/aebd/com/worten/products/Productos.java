package worten.aebd.com.worten.products;

import java.util.ArrayList;
import java.util.Iterator;

import worten.aebd.com.worten.Product;
import worten.aebd.com.worten.R;

/**
 * Created by jesus on 25/10/14.
 */
public class Productos {

    private ArrayList<Producto> lista;
    private Producto selected;

    public Productos(){

       lista = new ArrayList<Producto>();

       getLista().add(new Producto(0, R.drawable.im_mac, "MacBook Air 13,3'' APPLE MD760B 128 GB", "Intel Core i5 / Disco Duro 128 GB / RAM 4 GB / OS X Mavericks", 888, "pepe"));
       getLista().add(new Producto(1, R.drawable.im_hdd, "Disco Duro Portátil 1 TB WESTERN DIGITAL My Passport Ultra Metal Azul", "1 TB / USB 3.0", 67.99, "pepe"));
       getLista().add(new Producto(2, R.drawable.im_lavadora, "Lavadora LG F1296QDP7", "", 524, "pepe"));
       getLista().add(new Producto(3, R.drawable.im_tv, "TV OLED LG Smart TV 3D 55'' 55EA980V", "Televisor de última generación", 2499, "pepe"));


    }

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public void setSelected(Producto selected){
        this.selected = selected;
    }

    public Producto getSelected(){
        return selected;
    }


}
