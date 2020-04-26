package f_mendez07.blogspot.com.ciclodevida.db;

public final class ConstantesDB {
    public static final String DATABASE_NAME = "contactos";
    public static  final int DATABASE_VERSION = 1;

    public static  final String TABLE_CONTACS="contacto";
    public static  final String TABLE_CONTACS_ID="id";
    public static  final String TABLE_CONTACS_NOMBRE="nombre";
    public static  final String TABLE_CONTACS_TELEFONO="telefono";
    public static  final String TABLE_CONTACS_EMAIL="email";
    public static  final String TABLE_CONTACS_FOTO="foto";


    public static final String TABLE_LIKES_CONTACS = "contacto_likes";
    public static final String TABLE_LIKES_CONTACS_ID = "id";

    public static final String TABLE_LIKES_CONTACS_ID_CONTACTO ="id_contacto";
    public static final String TABLE_LIKES_CONTACS_NUMERO_LIKES = "numero_likes";
}
