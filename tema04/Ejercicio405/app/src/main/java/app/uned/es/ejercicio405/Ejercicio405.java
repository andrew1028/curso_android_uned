package app.uned.es.ejercicio405;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Ejercicio405 extends ActionBarActivity {

    private EditText etDni, etNombre, etColegio, etMesa;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio405);
        
        etDni = (EditText)findViewById(R.id.edDni);
        etNombre = (EditText)findViewById(R.id.edNombre);
        etColegio = (EditText)findViewById(R.id.edColegio);
        etMesa = (EditText)findViewById(R.id.edMesa);
        
    }

    public void alta(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String dni = etDni.getText().toString();
        Integer dnInt = Integer.parseInt(dni);
        String nombre = etNombre.getText().toString();
        String colegio = etColegio.getText().toString();
        String mesa = etMesa.getText().toString();
        Integer mesaInt = Integer.parseInt(mesa);
        
        ContentValues registro = new ContentValues();
        registro.put("dni", dnInt);
        registro.put("nombre", nombre);
        registro.put("colegio", colegio);
        registro.put("mesa", mesaInt);
        db.insert("votantes", null, registro);
        db.close();
        etDni.setText(""); etNombre.setText("");
        etColegio.setText(""); etMesa.setText("");
        Toast.makeText(this, getString(R.string.toast_alta_test),
                Toast.LENGTH_LONG).show();
    }

    public void consulta(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();
        String dni = etDni.getText().toString();
        Cursor cursor = db.rawQuery("SELECT nombre, colegio, mesa FROM votantes" +
                " WHERE dni=" + dni, null);
        String nombre = new String();
        String colegio = new String();
        int mesa = 0;
        
        if (cursor.moveToFirst()) {
            nombre = cursor.getString(0);
            colegio = cursor.getString(1);
            mesa = cursor.getInt(2);
        }
        
        etNombre.setText(nombre);
        etColegio.setText(colegio);
        etMesa.setText(Integer.toString(mesa));

        Toast.makeText(this, "Datos recuperados", Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio405, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
