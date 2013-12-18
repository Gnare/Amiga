package br.com.jtron.amigafb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class FotoCurtiuActivity extends Activity {

	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foto_curtiu);
		
		final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		
		ImageView button1 = (ImageView)findViewById(R.id.imageView1);			
		 button1.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {		        		    	  		    	  		    	
		    	  startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);		              	              
		      }
		 });		
						
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foto_curtiu, menu);
		return true;
	}
		

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            
            //LinearLayout lfoto = (LinearLayout) findViewById(R.id.linearLayout1);
            
            Button add_btn=new Button(this);
            add_btn.setText("Continuar");            
            LinearLayout layout = (LinearLayout)findViewById(R.id.fotoButtonView);
            
            LayoutParams params = new  LayoutParams();
            params.height = LayoutParams.MATCH_PARENT;
            params.width = LayoutParams.MATCH_PARENT;                                                                   
                        
            add_btn.setLayoutParams(params);
            
            layout.addView(add_btn);
            
            Drawable verticalImage = new BitmapDrawable(getResources(),photo);
            ImageView first = (ImageView) findViewById(R.id.imageView1);            
            //first.getLayoutParams().height = lfoto.getHeight();            
            //first.getLayoutParams().width = lfoto.getWidth();
            first.setScaleType(ScaleType.FIT_XY);
            first.setImageDrawable(verticalImage);                                                
            			
	        add_btn.setOnClickListener(new View.OnClickListener() {
	   		      @Override
	   		      public void onClick(View view) {		        		    	  		    	  		    	
	   		    	Intent intent = new Intent(FotoCurtiuActivity.this, FBMainActivity.class);
			        startActivity(intent);	   		    	  
	   		      }
	   		});          
            
        } 
		
		
	}

}
