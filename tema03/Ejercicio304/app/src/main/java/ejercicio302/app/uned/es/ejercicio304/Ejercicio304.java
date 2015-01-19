package ejercicio302.app.uned.es.ejercicio304;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Ejercicio304 extends ActionBarActivity {

    private EditText et1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio304);
        et1 = (EditText)findViewById(R.id.etNombre);
        tv1 = (TextView)findViewById(R.id.tvResultado);
    }

    public void verificar(View view) {
        Intent i = new Intent(this, Condiciones.class);
        i.putExtra("nombre", et1.getText().toString());
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        try {
            if (requestCode == 1234 && resultCode == RESULT_OK) {
                String res = data.getExtras().getString("resultado");
                tv1.setText(tv1.getText() + res + ".");
            }
        }catch (Exception e){
            e.getMessage();
            System.out.println("Petando");            
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio304, menu);
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
