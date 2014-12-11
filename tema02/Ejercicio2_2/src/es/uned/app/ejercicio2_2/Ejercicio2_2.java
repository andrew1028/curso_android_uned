package es.uned.app.ejercicio2_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Ejercicio2_2 extends Activity {

	private EditText eT_Valor1, eT_Valor2;
	private RadioButton rB_Sumar, rB_Restar;
	private TextView tV_Resultado;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_2);
        
        eT_Valor1 = (EditText)findViewById(R.id.eTValor1);
        eT_Valor2 = (EditText)findViewById(R.id.eTValor2);
        rB_Sumar = (RadioButton)findViewById(R.id.radio0);
        rB_Restar = (RadioButton)findViewById(R.id.radio1);
        tV_Resultado = (TextView)findViewById(R.id.txtResultado);
    }

    public void calcular(View view){
    	String valor1 = eT_Valor1.getText().toString();
    	String valor2 = eT_Valor2.getText().toString();
    	int numero1 = Integer.parseInt(valor1);
    	int numero2 = Integer.parseInt(valor2);
    	int res=0;
    	
    	if (rB_Sumar.isChecked()){
    		res = numero1 + numero2;
    	}
    	else{
    		if (rB_Restar.isChecked()){
    			res = numero1 - numero2;    			
    		}    		
    	}
    	
    	tV_Resultado.setText(tV_Resultado.getText().subSequence(0, 10)+ " " + String.valueOf(res));
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio2_2, menu);
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
