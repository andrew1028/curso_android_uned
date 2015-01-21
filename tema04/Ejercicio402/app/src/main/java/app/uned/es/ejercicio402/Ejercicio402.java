package app.uned.es.ejercicio402;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class Ejercicio402 extends ActionBarActivity {

    public static final String CLAVE = "puntos";
    
    private EditText num;
    private TextView puntos;
    private Integer puntosInicio;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio402);
        
        SharedPreferences settings = getPreferences(1);
        num = (EditText)findViewById(R.id.edNum);
        puntos = (TextView)findViewById(R.id.tvPuntos);
        puntosInicio = settings.getInt(CLAVE, 0);
        puntos.setText("Puntuación: " + puntosInicio.toString() + ".");
    }

    public void comprobar(View view){
        Random r = new Random();
        Integer candidato = Integer.parseInt(num.getText().toString());
        Integer aleatorio = r.nextInt(10)+1, aux;
        SharedPreferences settings = getPreferences(1);
        SharedPreferences.Editor editor;
        editor = settings.edit();
               
        if (candidato == aleatorio){
            aux = settings.getInt(CLAVE, 0);
            aux++;
            editor.putInt(CLAVE, aux);
            editor.commit();
            aux = settings.getInt(CLAVE, 0);
        }
        
        puntos.setText("Puntuación: " + settings.getInt(CLAVE,0) + ".");
        num.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio402, menu);
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
