package ejercicio2_11c.app.uned.es.ejercicio2_11c;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Ejercicio2_11c extends ActionBarActivity {

    EditText et1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_11c);
        et1 = (EditText)findViewById(R.id.ed1);
        registerForContextMenu(et1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio2_11c, menu);
        return true;
    }

    public void salir(View view) {
        finish();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.rojo:
                et1.setBackgroundColor(Color.rgb(255, 0, 0));
                break;
            case R.id.verde:
                et1.setBackgroundColor(Color.rgb(0, 255, 0));
                break;
            case R.id.azul:
                et1.setBackgroundColor(Color.rgb(0, 0, 255));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
