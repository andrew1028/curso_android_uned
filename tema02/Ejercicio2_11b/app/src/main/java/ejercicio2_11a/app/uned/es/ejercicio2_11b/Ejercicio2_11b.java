package ejercicio2_11a.app.uned.es.ejercicio2_11b;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Ejercicio2_11b extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_11b);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio2_11b, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i;
        switch (id) {
            case R.id.salir:
                finish();
                break;
            case R.id.google:
                i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.es"));
                startActivity(i);
                break;
            case R.id.github:
                i = new Intent("android.intent.action.VIEW", Uri.parse("http://github.com"));
                startActivity(i);
                break;
            case R.id.endomondo:
                i = new Intent("android.intent.action.VIEW", Uri.parse("http://www.endomondo.com"));
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
