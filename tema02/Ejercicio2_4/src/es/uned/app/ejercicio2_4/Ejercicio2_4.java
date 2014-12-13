package es.uned.app.ejercicio2_4;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class Ejercicio2_4 extends Activity {

	private TextView tvInfo;
	private ListView lvPaises;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_4);
        
        tvInfo = (TextView)findViewById(R.id.txtInfo);
        lvPaises = (ListView)findViewById(R.id.lvPais);
        
        //Creamos un listener de eventos
        OnItemClickListener listener = new OnItemClickListener() {
	        @Override
	        public void onItemClick(AdapterView<?> arg0, View arg1, int posicion, long arg3) {
		        // TODO Auto-generated method stub
		        //Obtenemos los array de String de paises y de habitantes
		        Resources res = getResources();
		        String[] arrayHabitantes = res.getStringArray(R.array.Habitantes);
		        String[] arrayPaises = res.getStringArray(R.array.Paises);
		        //Mostramos el texto correspondiente a la posición seleccionada
		        tvInfo.setText("Población de "+ arrayPaises[posicion] + " es " +
		        arrayHabitantes[posicion]);
	        }
        };
        
        lvPaises.setOnItemClickListener(listener);
             
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio2_4, menu);
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
