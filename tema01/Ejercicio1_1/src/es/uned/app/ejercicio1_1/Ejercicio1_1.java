package es.uned.app.ejercicio1_1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Ejercicio1_1 extends Activity {

	private Button bt1,bt2,bt3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_1);
        findViewById: bt1 = (Button)findViewById(R.id.btnAndroid);
        findViewById: bt2 = (Button)findViewById(R.id.btnJava);
        findViewById: bt3 = (Button)findViewById(R.id.btnJavaEE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio1_1, menu);
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
    
    public void responder (View view){
    	
    	switch (view.getId()){
	    	case R.id.btnAndroid:
	    		bt1.setText("Prefiero Android");
	    		bt1.setTextColor(Color.GREEN);
	    		break;
	    	case R.id.btnJava:
	    		bt2.setText("Prefiero Java");
	    		bt2.setBackgroundColor(Color.YELLOW);
	    		break;
	    	case R.id.btnJavaEE:
	    		bt3.setText("Prefiero Java EE");
	    		bt3.setTextColor(Color.BLUE);
	    		bt3.setBackgroundColor(Color.CYAN);
	    		break;
    	}
    }
}
