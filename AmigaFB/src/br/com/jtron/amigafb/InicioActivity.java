package br.com.jtron.amigafb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseAnalytics;

public class InicioActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Parse.initialize(this, "PnvUeafy8qMTnbBh0ROzYmvgxm3yowGLU8UcWKTs", "rHzbYYocRVbuHyalCPE6Wm2jgJu7FnGIs3SesJF9");
		ParseAnalytics.trackAppOpened(getIntent());
		
		setContentView(R.layout.activity_inicio);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		
		Button button1 = (Button)findViewById(R.id.btnCurtiu);			
		 button1.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(InicioActivity.this, FotoCurtiuActivity.class);
		        startActivity(intent);
		      }
		 });
		
		return true;
	}

}
