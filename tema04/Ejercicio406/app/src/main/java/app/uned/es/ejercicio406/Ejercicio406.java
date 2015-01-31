package app.uned.es.ejercicio406;

import android.content.ClipData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Ejercicio406 extends ActionBarActivity {

    private ListView lvDep;
    private Spinner spEmp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio406);

        lvDep = (ListView)findViewById(R.id.lvDepartamento);
        spEmp = (Spinner)findViewById(R.id.spEmpleados);

        AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Toast.makeText(getBaseContext(), "Base de datos preparada.", Toast.LENGTH_SHORT).show();
        Cursor c1 = db.rawQuery("SELECT nombre FROM DEPARTAMENTO", null);
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nombres);
        if (c1.moveToFirst()) {
            do {
                nombres.add(c1.getString(0));
            } while (c1.moveToNext());
        }
        
        lvDep.setAdapter(arrayAdapter);
        lvDep.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String query = "SELECT nombre FROM EMPLEADO WHERE iddepartamento=" + (position+1);
                spEmp.setAdapter(datosSpinner(query));
            }
        });
        
        spEmp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombre = spEmp.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), "Has seleccionado a " + nombre + ".", Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    
    public ArrayAdapter<String> datosSpinner (String query){
        AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c2 = db.rawQuery(query, null);
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, nombres);
        if (c2.moveToFirst()) {
            do {
                nombres.add(c2.getString(0));
            } while (c2.moveToNext());
        }
        
        return arrayAdapter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio406, menu);
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
