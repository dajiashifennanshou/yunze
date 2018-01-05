package cn.gl.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class NoTouchSeekBar extends SeekBar {

	public NoTouchSeekBar(Context context) {
		super(context);
	}

	public NoTouchSeekBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public NoTouchSeekBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return true;
	}

}
