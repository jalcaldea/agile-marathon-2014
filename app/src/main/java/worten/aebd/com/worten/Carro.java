package worten.aebd.com.worten;

import java.util.ArrayList;

import worten.aebd.com.worten.products.Producto;

/**
 * Created by ASUS on 25/10/2014.
 */
public class Carro {
    public static ArrayList<Producto> carro;

    public static void add (Producto prod){

        if(carro==null)
            carro=getCarro();

        carro.add(prod);
    }

    public static int getPrecio (){
        int i = 0;
        for (Producto pro:carro){
            i+=pro.getPrecio();
        }
        return i;
    }
    public static ArrayList<Producto> getCarro(){
        carro = (carro!=null ? carro :  new ArrayList<Producto>());
        return carro;
    }

}