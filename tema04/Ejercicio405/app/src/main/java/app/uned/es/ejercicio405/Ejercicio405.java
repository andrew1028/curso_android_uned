package app.uned.es.ejercicio405;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
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
