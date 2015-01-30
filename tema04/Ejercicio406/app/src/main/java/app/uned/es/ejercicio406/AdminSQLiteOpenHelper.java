package app.uned.es.ejercicio406;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = " empresaDB" ;
    private static CursorFactory factory = null;


    public AdminSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {

        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL( "CREATE TABLE DEPARTAMENTO(" +
                " _id INTEGER PRIMARY KEY," +
                " nombre TEXT NOT NULL " );

        db.execSQL( "CREATE UNIQUE INDEX nombre ON DEPARTAMENTO(nombre ASC)" );

        Log.i(this.getClass().toString(), "Tabla DEPARTAMENTO creada");

        db.execSQL("INSERT INTO DEPARTAMENTO(_id, nombre) VALUES(1,'Ingeniería')");
        db.execSQL("INSERT INTO DEPARTAMENTO(_id, nombre) VALUES(2,'Ventas')");
        db.execSQL("INSERT INTO DEPARTAMENTO(_id, nombre) VALUES(3,'Marketing')");
        db.execSQL("INSERT INTO DEPARTAMENTO(_id, nombre) VALUES(4,'Recursos Humanos')");
        
        Log.i(this.getClass().toString(), "Datos iniciales DEPARTAMENTO insertados");

        db.execSQL( "CREATE TABLE EMPLEADOS(" +
                " _id INTEGER PRIMARY KEY," +
                " nombre TEXT NOT NULL " +
                " salario INTEGER NOT NULL " +
                " iddepartamento INTEGER NOT NULL ");

        db.execSQL( "CREATE UNIQUE INDEX nombre ON EMPLEADOS (nombre ASC)" );

        Log.i(this.getClass().toString(), "Tabla EMPLEADOS creada");

        db.execSQL("INSERT INTO EMPLEADOS(_id, nombre, salario, iddepartamento) VALUES(1,'Alberto Puertas', 110000, 1)");
        db.execSQL("INSERT INTO EMPLEADOS(_id, nombre, salario, iddepartamento) VALUES(2,'Carlos Moreno', 120000, 2)");
        db.execSQL("INSERT INTO EMPLEADOS(_id, nombre, salario, iddepartamento) VALUES(3,'María Lucena', 130000, 3)");
        db.execSQL("INSERT INTO EMPLEADOS(_id, nombre, salario, iddepartamento) VALUES(4,'Esteban Pérez', 140000, 4)");
        db.execSQL("INSERT INTO EMPLEADOS(_id, nombre, salario, iddepartamento) VALUES(5,'Jose Gómez', 40000, 3)");
        db.execSQL("INSERT INTO EMPLEADOS(_id, nombre, salario, iddepartamento) VALUES(6,'Pedro Salmerón', 3000, 2)");

        Log.i(this.getClass().toString(), "Datos iniciales EMPLEADOS insertados");



        Log.i(this.getClass().toString(), "Base de datos creada");
        
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST DEPARTAMENTOS");
        db.execSQL("DROP TABLE IF EXIST EMPLEADOS");
    }


}

