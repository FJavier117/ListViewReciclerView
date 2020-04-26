package f_mendez07.blogspot.com.ciclodevida.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import f_mendez07.blogspot.com.ciclodevida.R;
import f_mendez07.blogspot.com.ciclodevida.pojo.Contacto;

public class ConstructorContactos {
    private static final int LIKE = 1 ;
    //clase clave que interactua con la base de datos

    private Context context;
    public ConstructorContactos(Context context) {

        this.context = context;
    }

    //este método obtendra los datos
    public ArrayList<Contacto> obtenerContactos(){
       BaseDatos db = new BaseDatos(context);
       insetarTresContactos(db);
       return db.obtenerTodosContactos();
    }

    public void insetarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_CONTACS_NOMBRE,"Javier");
        contentValues.put(ConstantesDB.TABLE_CONTACS_TELEFONO, "6666544444");
        contentValues.put(ConstantesDB.TABLE_CONTACS_EMAIL, "JAVIER@GMAIL.COM");
        contentValues.put(ConstantesDB.TABLE_CONTACS_FOTO, R.drawable.oso);
        db.insertarContactos(contentValues);

        contentValues.put(ConstantesDB.TABLE_CONTACS_NOMBRE,"Javier");
        contentValues.put(ConstantesDB.TABLE_CONTACS_TELEFONO, "6666544444");
        contentValues.put(ConstantesDB.TABLE_CONTACS_EMAIL, "JAVIER@GMAIL.COM");
        contentValues.put(ConstantesDB.TABLE_CONTACS_FOTO, R.drawable.oso);
        db.insertarContactos(contentValues);


        contentValues.put(ConstantesDB.TABLE_CONTACS_NOMBRE,"Javier");
        contentValues.put(ConstantesDB.TABLE_CONTACS_TELEFONO, "6666544444");
        contentValues.put(ConstantesDB.TABLE_CONTACS_EMAIL, "JAVIER@GMAIL.COM");
        contentValues.put(ConstantesDB.TABLE_CONTACS_FOTO, R.drawable.oso);
        db.insertarContactos(contentValues);

    }

    public void darLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_LIKES_CONTACS_ID_CONTACTO,contacto.getId());
        contentValues.put(ConstantesDB.TABLE_LIKES_CONTACS_NUMERO_LIKES,LIKE);
        db.insertarLikes(contentValues);
    }

    public int obternerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obternerLikesContacto(contacto);
    }
}
