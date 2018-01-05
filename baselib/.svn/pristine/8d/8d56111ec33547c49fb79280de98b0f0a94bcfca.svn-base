package cn.gl.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ImeResizeLayout extends LinearLayout {
	public static final int BIGGER = 1;
	public static final int SMALLER = 2;
	public static final int MSG_RESIZE = 1;	
	private OnResizeListener mListener;
	private boolean mStatus;

	public interface OnResizeListener {
		void OnResize(int resize);
	}

	public void setOnResizeListener(OnResizeListener l) {
		mListener = l;
	}

	public ImeResizeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mStatus = false;
	}

	public boolean getStatus() {
		return mStatus;
	}
	
	public void setStatus(boolean status) {
		if(mStatus != status) {
			mStatus = status;
		}
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		if (mListener != null) {
			mListener.OnResize(h<oldh ? SMALLER : BIGGER);
		}
	}

}
