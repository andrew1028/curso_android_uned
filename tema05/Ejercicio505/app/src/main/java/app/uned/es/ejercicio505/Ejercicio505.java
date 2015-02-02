package app.uned.es.ejercicio505;

import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


public class Ejercicio505 extends ActionBarActivity {
    
    private TextView tvLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio505);

        tvLoc = (TextView)findViewById(R.id.tvLocalizacion);
        LocationManager lM = (LocationManager)getSystemService(LOCATION_SERVICE);
        List<String> listProviders = lM.getAllProviders();
        String listado = "";
        LocationProvider provider;
        for (int i = 0; i < listProviders.size(); i++) {
            provider = lM.getProvider(listProviders.get(i));
            listado = listado + provider.getName() + ", prec: " + provider.getAccuracy() + ", alt: "
                    + provider.supportsAltitude() + ", vel: " + provider.supportsSpeed() + "\n";
        }
        tvLoc.setText(listado);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio505, menu);
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
