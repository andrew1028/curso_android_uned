package ejercicio2_6.app.uned.es.ejercicio2_6;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.logging.Log;


public class Ejercicio2_6 extends ActionBarActivity {


    private EditText v1, v2;
    private CheckBox sumar, restar;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_6);

        v1 = (EditText)findViewById(R.id.etValor1);
        v2 = (EditText)findViewById(R.id.etValor2);
        sumar = (CheckBox)findViewById(R.id.cbSumar);
        restar = (CheckBox)findViewById(R.id.cbRestar);
        res = (TextView)findViewById(R.id.txtRes);

    }

    public void calcular(View view){

        Context contexto = getApplicationContext();
        CharSequence mensaje = "Marca solo una operación.";
        int duracion = Toast.LENGTH_SHORT, total;
        boolean sumando = sumar.isChecked();
        boolean restando = restar.isChecked();
        String a = v1.getText().toString();
        String b = v2.getText().toString();
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);


        if (sumando && restando){

            if (res.length() > 10){
                res.setText(res.getText().subSequence(0,10));
            }

            Toast toast = Toast.makeText(contexto, mensaje, duracion);
            toast.show();

        }else{

            if (sumando){
                total = a1 + b1;
            }else{
                total = a1 - b1;
            }
            res.setText(res.getText().subSequence(0,10) + " " + String.valueOf(total));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio2_6, menu);
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
