package ejercicio302.app.uned.es.ejercicio302;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Ejercicio302 extends ActionBarActivity {

    private EditText et1;
    private String clave = new String("android");
    private String cadenaVacia = new String("");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio302);
        et1 = (EditText)findViewById(R.id.etClave);
    }
    
    public void verificar (View view) {
        String ingresada = et1.getText().toString();
        System.out.print(ingresada);
        if (ingresada.equals(clave)) {
            Intent i = new Intent(this, Bienvenida.class);
            startActivity(i);
        }
        else{
            et1.setText(cadenaVacia);
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio302, menu);
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
