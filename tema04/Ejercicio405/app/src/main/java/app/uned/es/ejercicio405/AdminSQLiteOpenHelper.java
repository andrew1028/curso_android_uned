package app.uned.es.ejercicio405;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by franlu on 28/01/15.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL("create table votantes(dni integer primary key,"
                + " nombre text, colegio text, mesa integer)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists votantes");
        db.execSQL("create table votantes(dni integer primary key,"
                + " nombre text, colegio text, mesa integer)");
    }


}
