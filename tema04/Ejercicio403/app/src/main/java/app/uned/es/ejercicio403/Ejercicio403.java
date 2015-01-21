package app.uned.es.ejercicio403;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Ejercicio403 extends ActionBarActivity {

    public static final String NOTAS = "notas.txt";
    
    private EditText edNotas;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio403);
        
        edNotas = (EditText)findViewById(R.id.edNotas);

        String[] archivos = fileList();

        if (existe(archivos, NOTAS))
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput(NOTAS));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                edNotas.setText(todo);
            } catch (IOException e) {
                Toast.makeText(this, "Exception: " + e.toString(), Toast.LENGTH_LONG).show();
            }
    }

    public void guardarNota (View view){
        
        String nota = edNotas.getText().toString();
        try{
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(NOTAS, 0));
            out.write(nota);
            out.flush();
            out.close();
        }
        catch(Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

        Toast t = Toast.makeText(this, "La nota se ha guardado.", Toast.LENGTH_SHORT);
        t.show();
        finish();
    }

    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio403, menu);
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
