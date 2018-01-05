package cn.gl.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * 获得屏幕相关的辅助类
 * @author 花佟林雨月
 *
 */
public class ScreenUtils {
	private static ScreenUtils instance = null;

	public static ScreenUtils getInstance() {
		if(null == instance) {
			synchronized(ScreenUtils.class) {
				if(null == instance) {
					instance = new ScreenUtils();
				}
			}
		}
		return instance;
	}

	public DisplayMetrics getMetrics(Context context) {
		DisplayMetrics outMetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(
				Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(outMetrics);  
		return outMetrics;
	}

	/** 
	 * 获得屏幕高度 
	 *  
	 * @param context 
	 * @return 
	 */  
	public int getScreenWidth(Context context) {  
		return getMetrics(context).widthPixels;  
	}  

	/** 
	 * 获得屏幕宽度 
	 *  
	 * @param context 
	 * @return 
	 */  
	public int getScreenHeight(Context context) {  
		return getMetrics(context).heightPixels;  
	} 

	/** 
	 * 获取当前屏幕截图，包含状态栏 
	 *  
	 * @param activity 
	 * @return 
	 */  
	public Bitmap snapShotWithStatusBar(Activity activity) {  
		View view = activity.getWindow().getDecorView();  
		view.setDrawingCacheEnabled(true);  
		view.buildDrawingCache();  
		Bitmap bmp = view.getDrawingCache();  
		int width = getScreenWidth(activity);  
		int height = getScreenHeight(activity);  
		Bitmap bp = null;  
		bp = Bitmap.createBitmap(bmp, 0, 0, width, height);  
		view.destroyDrawingCache();  
		return bp;  

	}  

	/** 
	 * 获取当前屏幕截图，不包含状态栏 
	 *  
	 * @param activity 
	 * @return 
	 */  
	public Bitmap snapShotWithoutStatusBar(Activity activity) {  
		View view = activity.getWindow().getDecorView();  
		view.setDrawingCacheEnabled(true);  
		view.buildDrawingCache();  
		Bitmap bmp = view.getDrawingCache();  
		Rect frame = new Rect();  
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);  
		int statusBarHeight = frame.top;  

		int width = getScreenWidth(activity);  
		int height = getScreenHeight(activity);  
		Bitmap bp = null;  
		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height  
				- statusBarHeight);  
		view.destroyDrawingCache();  
		return bp;  
	} 

	/** 
	 * 获得状态栏的高度 
	 *  
	 * @param context 
	 * @return 
	 */  
	public static int getStatusHeight(Context context) {  

		int statusHeight = -1;  
		try {  
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");  
			Object object = clazz.newInstance();  
			int height = Integer.parseInt(clazz.getField("status_bar_height")  
					.get(object).toString());  
			statusHeight = context.getResources().getDimensionPixelSize(height);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return statusHeight;  
	}  

}
