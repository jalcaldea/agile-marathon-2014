package worten.aebd.com.worten;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;


import worten.aebd.com.worten.products.ListAdapter;
import worten.aebd.com.worten.products.Producto;
import worten.aebd.com.worten.products.Productos;


public class Shop extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private ListView mListView;

    private boolean login;

    private boolean cambio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout),0);

        Bundle bundle = getIntent().getExtras();
        try {
            login = bundle.getBoolean("login");
        }catch(NullPointerException e) {
            login = false;
        }

    /*
        mListView = (ListView) findViewById(R.id.product_label);
        mListView.setAdapter(new ArrayAdapter<String>(getActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, categorias));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                String elegido = (String) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido;
                Toast toast = Toast.makeText(Shop.this, texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });*/


        mListView = (ListView) findViewById(R.id.product_label);
        mListView.setAdapter(new ListAdapter(this, R.layout.entrada, new Productos().getLista()){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Producto) entrada).get_Nombre());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Producto) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Producto) entrada).get_idImagen());

                    TextView texto_precio = (TextView) view.findViewById(R.id.textView_precio);
                    if (texto_precio != null)
                        texto_precio.setText(((Producto) entrada).getPrecio()+"€");

                }
            }
        });

        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Producto elegido = (Producto) pariente.getItemAtPosition(posicion);

               // pariente


                Intent mainIntent = new Intent();
                mainIntent = new Intent().setClass(
                        Shop.this, Product.class);
                mainIntent.putExtra("producto", elegido.getId());
                startActivity(mainIntent);

               // CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                //Toast toast = Toast.makeText(Shop.this, texto, Toast.LENGTH_LONG);
                //toast.show();
            }
        });
        
        

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        if(cambio){
            Intent mainIntent = new Intent();
            if(login){
            switch (number) {
                case 2:
                    mainIntent = new Intent().setClass(
                            Shop.this, Scaner.class);
                    mainIntent.putExtra("login",login);
                    startActivity(mainIntent);
                    break;
                case 3:
                    mainIntent = new Intent().setClass(
                            Shop.this, Games.class);
                    mainIntent.putExtra("login",login);
                    startActivity(mainIntent);
                    break;
                case 4:
                    mainIntent = new Intent().setClass(
                            Shop.this, User.class);
                    mainIntent.putExtra("login",login);
                    startActivity(mainIntent);
                    break;
            }}else{

                switch (number) {
                    case 2:
                        mainIntent = new Intent().setClass(
                                Shop.this, Login.class);
                        startActivity(mainIntent);
                        break;
                    case 3:
                        mainIntent = new Intent().setClass(
                                Shop.this, Login.class);
                        startActivity(mainIntent);
                        break;
                    case 4:
                        mainIntent = new Intent().setClass(
                                Shop.this, Login.class);
                        startActivity(mainIntent);
                        break;
                }




            }}else{
            cambio = true;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.shop, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_shop, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((Shop) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
