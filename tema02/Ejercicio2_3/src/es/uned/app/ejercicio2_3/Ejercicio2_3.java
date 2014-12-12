package es.uned.app.ejercicio2_3;

import es.uned.app.ejercicio2_3.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class Ejercicio2_3 extends Activity {

	private EditText eT_Valor1, eT_Valor2;
	private Spinner sp_Ope;
	private TextView tV_Resultado;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_3);
        
        eT_Valor1 = (EditText)findViewById(R.id.edValor1);
        eT_Valor2 = (EditText)findViewById(R.id.edValor2);
        sp_Ope = (Spinner)findViewById(R.id.spinner1);
        tV_Resultado = (TextView)findViewById(R.id.txtResultado);
    }


    public void calcular(View view){
    	String valor1 = eT_Valor1.getText().toString();
    	String valor2 = eT_Valor2.getText().toString();
    	int numero1 = Integer.parseInt(valor1);
    	int numero2 = Integer.parseInt(valor2);
    	int res=0;
    	String spin = sp_Ope.getSelectedItem().toString();
    	
       if (spin.equals("Sumar"))
    	   res = numero1 + numero2;
       else
    	   if (spin.equals("Restar"))
    		   res = numero1 - numero2;
    	   else
    		   if (spin.equals("Multiplicar"))
    			   res = numero1 * numero2;
    		   else
    			   res = numero1 / numero2;
    	 
       tV_Resultado.setText(tV_Resultado.getText().subSequence(0, 10)+ " " + String.valueOf(res));
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio2_3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
