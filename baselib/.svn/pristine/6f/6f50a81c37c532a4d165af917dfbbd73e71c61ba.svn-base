package cn.gl.lib.img;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/**
 * 异步图像保存
 *
 */
public class AsyncImageSaver {
	private ExecutorService executorService = Executors.newSingleThreadExecutor();
	
	private static AsyncImageSaver asyncImageSaver;
	public static AsyncImageSaver getInstance(){
		if(null == asyncImageSaver) {
			synchronized(AsyncImageSaver.class) {
				if(null == asyncImageSaver) {
					asyncImageSaver = new AsyncImageSaver();
				}
			}
		}
		return asyncImageSaver;
	}
	
	/* Constructor that should not be called directly */
	private AsyncImageSaver() {}
	
	public void saveImage(final BitmapDrawable drawable,final String fileName){
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				new LocalMemory().saveDrawable(drawable, fileName);
			}
		});
	}
	
	public void saveImage(final Bitmap bitmap,final String fileName){
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				new LocalMemory().saveBitmap(bitmap, fileName);
			}
		});
	}
}
