package app.uned.es.ejercicio503;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;


public class Ejercicio503 extends ActionBarActivity implements MediaPlayer.OnCompletionListener {

    private TextView tvEstado;
    private MediaRecorder recorder;
    private MediaPlayer player;
    private File archivo;
    private Button btnGrabar, btnDetener, btnReproducir ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio503);
        
        tvEstado = (TextView)findViewById(R.id.tvEstado);
        btnGrabar = (Button)findViewById(R.id.btnGrabar);
        btnDetener = (Button)findViewById(R.id.btnDetener);
        btnReproducir = (Button)findViewById(R.id.btnReproducir);
    }


    public void grabar(View view) {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File path = new File(Environment.getExternalStorageDirectory().getPath());
        try {
            archivo = File.createTempFile("temporal", ".3gp", path);
        } catch (IOException e) {
        }
        recorder.setOutputFile(archivo.getAbsolutePath());
        try {
            recorder.prepare();
        } catch (IOException e) {
        }
        recorder.start();
        tvEstado.setText("Grabando");
        btnReproducir.setEnabled(false);
        btnDetener.setEnabled(true);
    }

    public void detener(View view) {
        recorder.stop();
        recorder.release();
        player = new MediaPlayer();
        player.setOnCompletionListener(this);
        try {
            player.setDataSource(archivo.getAbsolutePath());
        } catch (IOException e) {
        }
        try {
            player.prepare();
        } catch (IOException e) {
        }
        btnGrabar.setEnabled(true);
        btnDetener.setEnabled(false);
        btnReproducir.setEnabled(true);
        tvEstado.setText("Listo para reproducir");
    }

    public void reproducir(View v) {
        player.start();
        btnGrabar.setEnabled(false);
        btnDetener.setEnabled(false);
        btnReproducir.setEnabled(false);
        tvEstado.setText("Reproduciendo");
    }

    public void onCompletion(MediaPlayer mp) {
        btnGrabar.setEnabled(true);
        btnDetener.setEnabled(true);
        btnReproducir.setEnabled(true);
        tvEstado.setText("Listo");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio503, menu);
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
