package f_mendez07.blogspot.com.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity {
   private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        btn = findViewById(R.id.btnConfiguracion);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Configuracion.this,btn);

                popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       Toast.makeText(getBaseContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }

        });
    }


}
