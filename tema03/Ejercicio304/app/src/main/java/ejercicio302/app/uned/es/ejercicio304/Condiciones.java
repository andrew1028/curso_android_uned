package ejercicio302.app.uned.es.ejercicio304;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Condiciones extends ActionBarActivity {

    private TextView tv1;
    private Button btnOK, btnKO;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);
        tv1 = (TextView)findViewById(R.id.tvPregunta);
        btnOK = (Button)findViewById(R.id.btnAceptado);
        btnKO = (Button)findViewById(R.id.btnRechazado);
        
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("nombre");
        tv1.setText("Hola " + s + ", ¿Aceptas las condiciones?");
    }

    public void responder(View view){
        Intent i = new Intent(this, Ejercicio304.class);
        if (view == btnOK){
            i.putExtra("resultado", "Aceptado");
        }
        else{
            i.putExtra("resultado", "Rechazado");
        }
        setResult(RESULT_OK, i);
        startActivityForResult(i,1234);
        finish();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_condiciones, menu);
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
