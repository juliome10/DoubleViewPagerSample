package com.emoiluj.doubleviewpagersample;

import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

import com.emoiluj.doubleviewpager.VerticalViewPager;

public class VerticalPagerAdapter extends PagerAdapter{

	private Context mContext;
	private int mParent;
	private int mChilds;

	public VerticalPagerAdapter(Context c, int parent, int childs){
		mContext = c;
		mParent = parent;
		mChilds = childs;
	}

	@Override
	public int getCount() {
		return mChilds;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		RelativeLayout relative = new RelativeLayout(mContext);
		LayoutParams relativelp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		relative.setLayoutParams(relativelp);
		relative.setGravity(Gravity.CENTER);

		TextView tv = new TextView(mContext);
		LayoutParams tvlp=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		tvlp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		tv.setLayoutParams(tvlp);
		tv.setText("P:"+mParent + " H:"+position);
		tv.setTextSize(70);
		setColors(relative, tv);
		relative.addView(tv);

		container.addView(relative);
		return relative;
	};

	public void destroyItem(View container, int position, Object view) {
		((VerticalViewPager) container).removeView((View) view);
	};

	public void setColors(RelativeLayout layout, TextView text){
		Random rand = new Random();
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		
		layout.setBackgroundColor(Color.rgb(r,g,b));
		if(r<30 || g<30 || b<30){
			text.setTextColor(Color.WHITE);
		}else{
			text.setTextColor(Color.BLACK);
		}
	}
}