package br.com.jtron.amigafb;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FotoCurtiuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foto_curtiu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foto_curtiu, menu);
		return true;
	}

}
