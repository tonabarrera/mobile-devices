package me.tonatihu.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tonatihu
 * Created on 3/31/19
 */
public class DbmsSQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG = DbmsSQLiteHelper.class.getName();
    private static final String TABLE_CONTACTO = "contacto";

    private static final String KEY_ID = "id";
    private static final String KEY_CONTACTO_NOMBRE = "nombre";

    private static final String CREATE_TABLE_CONTACTO = "CREATE TABLE " +TABLE_CONTACTO + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_CONTACTO_NOMBRE + " TEXT)";

    private static final String DROP_TABLE_CONTACTO = "DROP TABLE IF EXISTS " + TABLE_CONTACTO;


    public DbmsSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_CONTACTO);
        onCreate(db);
    }

    public void save(Contacto contacto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, contacto.getId());
        values.put(KEY_CONTACTO_NOMBRE, contacto.getNombre());
        db.insert(TABLE_CONTACTO, null, values);
    }

    public List<Contacto> getAll() {
        List<Contacto> contactos = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_CONTACTO, null);
        if (c.moveToFirst()) {
            do {
                Contacto contacto = new Contacto();
                contacto.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                contacto.setNombre(c.getString(c.getColumnIndex(KEY_CONTACTO_NOMBRE)));
                contactos.add(contacto);
            } while (c.moveToNext());
        }
        return contactos;
    }

    public int update(Contacto contacto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, contacto.getId());
        values.put(KEY_CONTACTO_NOMBRE, contacto.getNombre());

        // updating row
        return db.update(TABLE_CONTACTO, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contacto.getId()) });
    }

    public Contacto getContactoById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  id, nombre FROM " + TABLE_CONTACTO + " WHERE " + KEY_ID + " = " + id;

        Cursor c = db.rawQuery(selectQuery, null);
        Contacto contacto = new Contacto();

        if (c.moveToFirst()) {
            contacto.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            contacto.setNombre(c.getString(c.getColumnIndex(KEY_CONTACTO_NOMBRE)));
        }

        return contacto;
    }

    public void deleteById(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTO, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
    }
}
