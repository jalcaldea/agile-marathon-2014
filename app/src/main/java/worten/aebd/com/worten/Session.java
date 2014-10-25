package worten.aebd.com.worten;

/**
 * Created by jesus on 25/10/14.
 */
public class Session {

    private static boolean sesion = false;

    public static void initSesion(){
        sesion = true;
    }

    public static void closeSesion(){
        sesion = false;
    }

    public static boolean isLogin(){
        return sesion;
    }

}
