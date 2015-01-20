package app.uned.es.ejercicio401;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Ejercicio401 extends ActionBarActivity {

    public static Integer total = 0;
    
    private String cad,aux, ultimo = new String("ultimo");
    private EditText ed1;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio401);
        SharedPreferences settings = getPreferences(1);
        ed1 = (EditText)findViewById(R.id.etCorreo);
        ed1.setText(settings.getString(ultimo, ""));
        
    }

    public void confirmar (View view){
        SharedPreferences settings = getPreferences(1);
        SharedPreferences.Editor editor;
        cad = ed1.getText().toString() ;
        editor = settings.edit();
        if (settings.contains(ultimo)){
            aux = settings.getString(ultimo,"");
            total++;
            editor.putString("email" + total.toString(),aux);
        }
        editor.putString("ultimo", cad);
        editor.commit();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio401, menu);
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
