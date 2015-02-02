package app.uned.es.ejercicio502;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Ejercicio502 extends ActionBarActivity {

    private MediaPlayer mp;
    private Button btnCircular;
    private int posicion;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio502);
        btnCircular = (Button)findViewById(R.id.btnCircular);
    }

    public void liberar() {
        if (mp != null)
            mp.release();
    }

    public void iniciar(View v) {
        liberar();
        mp = MediaPlayer.create(this, R.raw.roar_lion);
        mp.start();
        String op = btnCircular.getText().toString();
        if (op.equals("No reproducir en forma circular"))
            mp.setLooping(false);
        else
            mp.setLooping(true);
    }

    public void pausar(View v) {
        if (mp != null && mp.isPlaying()) {
            posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void continuar(View v) {
        if (mp != null && mp.isPlaying() == false) {
            mp.seekTo(posicion);
            mp.start();
        }
    }

    public void detener(View v) {
        if (mp != null) {
            mp.stop();
            posicion = 0;
        }
    }

    public void circular(View v) {
        detener(null);
        String op = btnCircular.getText().toString();
        if (op.equals("No reproducir en forma circular"))
            btnCircular.setText("Reproducir en forma circular");
        else
            btnCircular.setText("No reproducir en forma circular");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio502, menu);
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
