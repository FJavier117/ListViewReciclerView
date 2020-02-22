package f_mendez07.blogspot.com.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = findViewById(R.id.rvContactos);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       // GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
       // StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(linearLayoutManager);
        inicializarLista();
        inicializarAdaptador();




    }


    public void inicializarAdaptador(){
        ContactoAdapter contactoAdapter = new ContactoAdapter(contactos,this);
        listaContactos.setAdapter(contactoAdapter);
    }

    public void inicializarLista(){
        contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.androide,"JAVIER","222222888","jgmail.com"));
        contactos.add(new Contacto(R.drawable.larva_del_moscardon,"JUAN","222222111","a@gmail.com"));
        contactos.add(new Contacto(R.drawable.seta,"PEDRO","22222288","as@gmail.com"));
        contactos.add(new Contacto(R.drawable.oso,"MARIE","222222","aee@gmail.com"));
        contactos.add(new Contacto(R.drawable.seta,"JUANA","22225552","a22@gmail.com"));
        contactos.add(new Contacto(R.drawable.seta,"JOSE","222222444","aasa@gmail.com"));
    }



}
