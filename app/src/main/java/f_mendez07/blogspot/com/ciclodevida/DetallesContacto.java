package f_mendez07.blogspot.com.ciclodevida;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesContacto extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private ImageView imgvContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_contacto);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);



        Bundle parametros = getIntent().getExtras();
        int foto = parametros.getInt(getResources().getString(R.string.pFoto));
        String nombre = parametros.getString(getResources().getString(R.string.pNombre));
        String telefono = parametros.getString(getResources().getString(R.string.pTelefono));
        String email = parametros.getString(getResources().getString(R.string.pEmail));



        tvNombre = findViewById(R.id.tvNombre);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        imgvContacto = findViewById(R.id.imgvContacto);

        imgvContacto.setImageResource(foto);
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }


    public void llamar(View v) {
        String telefono = tvNombre.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }

    public void enviar(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,email);
        emailIntent.setDataAndType(Uri.parse("mailto"),"message/rfc");
        startActivity(Intent.createChooser(emailIntent,"email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
