package f_mendez07.blogspot.com.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("JAVIER","222222888","jgmail.com"));
        contactos.add(new Contacto("JUAN","222222111","a@gmail.com"));
        contactos.add(new Contacto("PEDRO","22222288","as@gmail.com"));
        contactos.add(new Contacto("MARIE","222222","aee@gmail.com"));
        contactos.add(new Contacto("JUANA","22225552","a22@gmail.com"));
        contactos.add(new Contacto("JOSE","222222444","aasa@gmail.com"));


        ArrayList <String> nombresContactos = new ArrayList<>();
        for (Contacto contacto : contactos){
            nombresContactos.add(contacto.getNombre());
        }

        ListView lstContactos = findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresContactos));


        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"posición: "+ position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,DetallesContacto.class);
                intent.putExtra(getResources().getString(R.string.pNombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.pTelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEmail),contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });
    }


}
