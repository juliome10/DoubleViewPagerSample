package com.emoiluj.doubleviewpagersample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.Window;

import com.emoiluj.doubleviewpager.DoubleViewPager;
import com.emoiluj.doubleviewpager.DoubleViewPagerAdapter;


public class MainActivity extends Activity{

	private DoubleViewPager viewpager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		loadUI();
	}

	private void loadUI() {

		ArrayList<PagerAdapter> verticalAdapters = new ArrayList<PagerAdapter>();
		generateVerticalAdapters(verticalAdapters);

		viewpager = (DoubleViewPager) findViewById(R.id.pager);
		viewpager.setAdapter(new DoubleViewPagerAdapter(getApplicationContext(), verticalAdapters));
	}

	private void generateVerticalAdapters(ArrayList<PagerAdapter> verticalAdapters) {
		//5 in horizontal
		for (int i=0; i<5; i++){
			verticalAdapters.add(new VerticalPagerAdapter(this, i));
		}
	}

}