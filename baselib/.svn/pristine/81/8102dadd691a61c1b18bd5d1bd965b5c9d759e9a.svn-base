package cn.gl.lib.img;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import cn.gl.lib.utils.BaseFileUtils;

public class LocalMemory {

	/**
	 * 保存图像至本地
	 * @param drawable
	 * @param filename 图像名
	 */
	public void saveDrawable(BitmapDrawable drawable, String filename) {
		File image = new File(filename);
		if (!image.exists()) { //不存在则保存
			try {
				image.createNewFile();
				FileOutputStream fileOutputStream=new FileOutputStream(image);
				if(drawable.getBitmap().compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream)){
//				if(drawable.getBitmap().compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)){
				// 目前后台均存储为jpeg，无需存成png格式，增加文件大小，亦没实际意义
					fileOutputStream.flush();
				}
				fileOutputStream.close();
			} catch (IOException e) {
				Log.e("LocalMemory", "saveDrawable ===== \n" +  e.toString());
				e.printStackTrace();
			}
		}
	}
	/**
	 * 保存图像至本地
	 * @param bitmap
	 * @param filename 图像名
	 */
	public void saveBitmap(Bitmap bitmap, String filename) {
		saveBitmap(bitmap, filename, 100);
	}
	
	/**
	 * 保存图像至本地
	 * @param bitmap
	 * @param filename 图像名
	 * @param quality 图片质量
	 */
	public void saveBitmap(Bitmap bitmap, String filename, int quality) {
		File image = new File(filename);
		if (!image.exists()) { //不存在则保存
			try {
				image.createNewFile();
				FileOutputStream fileOutputStream=new FileOutputStream(image);
				if(bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream)){
//					if(bitmap.compress(Bitmap.CompressFormat.PNG, quality, fileOutputStream)){
					// 目前后台均存储为jpeg，无需存成png格式，增加文件大小，亦没实际意义
					fileOutputStream.flush();
				}
				fileOutputStream.close();
			} catch (IOException e) {
				Log.e("LocalMemory", "saveBitmap ===== \n" +  e.toString());
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 从本地取出图像
	 * @param fileName 图像名
	 * @return
	 */
	public Drawable getDrawable(String fileName, Context context, int width, int height){
		File image = new File(fileName);
		if(image.exists()){
			Bitmap bitmap = BaseFileUtils.getSmallBitmap(fileName, width, height);
			return new BitmapDrawable(context.getResources(), bitmap);
		}
		return null;
	}
	
	/**
	 * 从本地取出图像
	 * @param fileName 图像名
	 * @return
	 */
	public Drawable getDrawable(Context context, String fileName){
		if(null == fileName) {
			return null;
		}
		File image = new File(fileName);
		if(image.exists()){
			try {
				FileInputStream in = new FileInputStream(image);
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inJustDecodeBounds = true;
				BitmapFactory.decodeStream(in, null, options);
				in.close();
				int i = 0;
				Bitmap bitmap = null;
				while (true) {
					if ((options.outWidth >> i <= 1000)
							&& (options.outHeight >> i <= 1000)) {
						in = new FileInputStream(new File(fileName));
						options.inSampleSize = (int) Math.pow(2.0D, i);
						options.inJustDecodeBounds = false;
						bitmap = BitmapFactory.decodeStream(in, null, options);
						break;
					}
					i += 1;
				}
				return new BitmapDrawable(context.getResources(), bitmap);
//				FileInputStream fileInputStream = new FileInputStream(image);
////				BitmapDrawable drawable=new BitmapDrawable(fileInputStream);
//				Drawable drawable = Drawable.createFromStream(fileInputStream, fileName);
//				return drawable;
			} catch (FileNotFoundException e) {
				Log.w("LocalMemory", "getDrawable ===== \n" +  e.toString());
//				e.printStackTrace();
				return null;
			} catch(IOException e) {
				return null;
			}
		}
		return null;
	}
}
