package com.emoiluj.doubleviewpagersample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

public class SplashActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		loadUI();
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				startActivity(new Intent(getApplicationContext(), MainActivity.class));
				finish();
			}
			
		}, 2000);
	}
	
	private void loadUI(){
		TextView title = (TextView) findViewById(R.id.splash_title);
		title.setTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
	}
	
}
