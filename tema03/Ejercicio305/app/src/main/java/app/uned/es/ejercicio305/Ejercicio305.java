package app.uned.es.ejercicio305;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Ejercicio305 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio305);
    }
    
    public void web(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es/"));
        startActivity(i);
    }
    public void tel(View view){
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:958112233"));
        startActivity(i);
    }
    public void maps(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.915833, -6.333333"));
        startActivity(i);
    }
    public void foto(View view){
        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }
    public void correo(View view){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Android");
        i.putExtra(Intent.EXTRA_TEXT, "probando");
        i.putExtra(Intent.EXTRA_EMAIL, new String[] {"fran.lucena@gmail.com" });
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio305, menu);
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
