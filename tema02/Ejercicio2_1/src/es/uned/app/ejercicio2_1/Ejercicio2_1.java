package es.uned.app.ejercicio2_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Ejercicio2_1 extends Activity {

	private EditText val1,val2; // Valor del EditText 1 y 2
	private TextView resultado; // Texview para el resultado
	private Button boton; // Botón de Calcular
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_1);
        
        //Asociamos las variables a los recursos
        val1=(EditText)findViewById(R.id.edValor1);
        val2=(EditText)findViewById(R.id.edValor2);
        resultado=(TextView)findViewById(R.id.txtResultado);
        boton =(Button)findViewById(R.id.btnCalcular);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio2_1, menu);
        return true;
    }
    
    public void sumar(View view) {
    	//Obtenemos el valor del primer operando
    	String valor1 = val1.getText().toString();
    	//Obtenemos el valor del segundo operando
    	String valor2 = val2.getText().toString();
    	//Los convertimos a entero
    	int numero1 = Integer.parseInt(valor1);
    	int numero2 = Integer.parseInt(valor2);
    	//Realizamos la suma
    	int suma = numero1+numero2;
    	//Convertimos el resultado a String y lo asignamos al recurso setText
    	resultado.setText(resultado.getText() + String.valueOf(suma));
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
