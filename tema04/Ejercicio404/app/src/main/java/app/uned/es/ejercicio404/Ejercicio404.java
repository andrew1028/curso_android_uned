package app.uned.es.ejercicio404;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;


public class Ejercicio404 extends ActionBarActivity {

    private EditText edNombre, edContenido;  
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio404);
        
        edNombre = (EditText)findViewById(R.id.edNombre);
        edContenido = (EditText)findViewById(R.id.edContenido);
    }


    public void grabar (View view){
        String stadoSD = Environment.getExternalStorageState();
        String nombre = edNombre.getText().toString();
        if (stadoSD.equals(Environment.MEDIA_MOUNTED)){
            try {
                File myFile = new File("/sdcard/" + nombre + ".txt");
                myFile.createNewFile();
                FileOutputStream fOut = new FileOutputStream(myFile);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                myOutWriter.write(edContenido.getText().toString());
                myOutWriter.flush();
                myOutWriter.close();
                fOut.close();
            }catch (Exception e){
                Toast.makeText(this, "Exception: " + e.toString(), Toast.LENGTH_LONG).show();
            }
        }
        edNombre.setText("");
        edContenido.setText("");
    }
    
    public void recuperar(View view){
        String stadoSD = Environment.getExternalStorageState();
        String nombre = edNombre.getText().toString();
        if (stadoSD.equals(Environment.MEDIA_MOUNTED) || stadoSD.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File ("/sdcard/"+ nombre +".txt");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String linea;
                while((linea=br.readLine())!=null)
                    edContenido.setText(linea);
            }
            catch(Exception e){
                e.printStackTrace();
            }finally{
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta
                // una excepcion.
                try{
                    if( null != fr ){
                        fr.close();
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }

            Toast.makeText(this, "Archivo recuperado.", Toast.LENGTH_LONG).show();
            
        }
        
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio404, menu);
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
