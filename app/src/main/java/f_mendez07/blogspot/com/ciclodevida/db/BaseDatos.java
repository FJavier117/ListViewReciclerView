package f_mendez07.blogspot.com.ciclodevida.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import f_mendez07.blogspot.com.ciclodevida.pojo.Contacto;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesDB.DATABASE_NAME, null, ConstantesDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesDB.TABLE_CONTACS + "("+
                ConstantesDB.TABLE_CONTACS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_CONTACS_NOMBRE   + " TEXT, " +
                ConstantesDB.TABLE_CONTACS_TELEFONO + " TEXT, " +
                ConstantesDB.TABLE_CONTACS_EMAIL    + " TEXT, " +
                ConstantesDB.TABLE_CONTACS_FOTO     + " INTEGER " +
                ")";

        String queryCrearTablaLikesContacto ="CREATE TABLE " + ConstantesDB.TABLE_LIKES_CONTACS + "("+
                 ConstantesDB.TABLE_LIKES_CONTACS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_LIKES_CONTACS_ID_CONTACTO + " INTEGER,  "+
                ConstantesDB.TABLE_LIKES_CONTACS_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesDB.TABLE_LIKES_CONTACS_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesDB.TABLE_CONTACS + "(" + ConstantesDB.TABLE_CONTACS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDB.TABLE_CONTACS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDB.TABLE_LIKES_CONTACS);
        onCreate(db);
    }

    public ArrayList<Contacto> obtenerTodosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesDB.TABLE_CONTACS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
           Contacto contactoActual =  new Contacto();
           contactoActual.setId(registros.getInt(0));
           contactoActual.setNombre(registros.getString(1));
           contactoActual.setTelefono(registros.getString(2));
           contactoActual.setEmail(registros.getString(3));
           contactoActual.setFoto(registros.getInt(4));
           String queryLikes = "SELECT COUNT("+ConstantesDB.TABLE_LIKES_CONTACS_NUMERO_LIKES+") as likes " +
                   " FROM " + ConstantesDB.TABLE_LIKES_CONTACS +
                   " WHERE " + ConstantesDB.TABLE_LIKES_CONTACS_ID_CONTACTO + "=" + contactoActual.getId();
           Cursor registroLikes = db.rawQuery(queryLikes,null);
           if (registroLikes.moveToNext()){
               contactoActual.setLikes(registroLikes.getInt(0));
           }else{
               contactoActual.setLikes(0);
           }
           contactos.add(contactoActual);
        }
        db.close();
        registros.close();
        return  contactos;
    }

    public void insertarContactos(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_CONTACS,null, contentValues);
        db.close();
    }

    public void insertarLikes(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_LIKES_CONTACS,null,contentValues);
        db.close();
    }

    public int obternerLikesContacto(Contacto contacto){
        int likes =0;
        String query = "SELECT COUNT(" + ConstantesDB.TABLE_LIKES_CONTACS_NUMERO_LIKES+ ")" +
                " FROM " + ConstantesDB.TABLE_LIKES_CONTACS +
                " WHERE " + ConstantesDB.TABLE_LIKES_CONTACS_ID_CONTACTO + "=" + contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        registros.close();
        db.close();
        return likes;

    }

}
