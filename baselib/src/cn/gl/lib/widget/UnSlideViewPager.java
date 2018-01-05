package cn.gl.lib.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UnSlideViewPager extends ViewPager {
	
	public UnSlideViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UnSlideViewPager(Context context) {
		super(context);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}
}
