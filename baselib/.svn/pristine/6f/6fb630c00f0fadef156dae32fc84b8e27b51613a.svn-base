package cn.gl.lib.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;

public class BaseFileUtils {
	
	public static boolean externalExist() {
		if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			return false;
		}
		return true;
	}
	
	public static String getFilePathName(String... args) {
		String[] param = args;
		String Str = param[0];
		for(int i=1, len=param.length; i<len; i++) {
			if(null == Str) return null;
			if(Str.endsWith(File.separator) && param[i].startsWith(File.separator)) Str = Str.substring(0, Str.length()-1) + param[i];
			else if(Str.endsWith(File.separator) || param[i].startsWith(File.separator)) Str += param[i];
			else Str += File.separator + param[i];
		}
		return Str;
	}
	
	public static boolean makeDirs(String fileDir) {
		if(null == fileDir) {
			BaseUtils.logh("BaseFileUtils", " makeDirs parameter directory is null");
			return false;
		}
        File file = new File(fileDir);
        if(!file.exists()) {
            return file.mkdirs();            
        }
        return true;
    }
	
	public static String save(String dir, String name, InputStream input) {
        return save(new File(dir, name), input);
	}
	
	public static String save(File file, InputStream input) {
        byte[] buffer = new byte[8192];
        int n = 0;
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(file);     
            while ((n = input.read(buffer)) >= 0) {                    
                output.write(buffer, 0, n);
            }                
        } catch (FileNotFoundException e) {
        	//e.printStackTrace();
        	Log.w("", e.getMessage().toString());
        } catch(IOException e) {
        	try {
        		file.delete();
        	} catch(Exception ex) {}
            //e.printStackTrace();
        	Log.w("", e.getMessage().toString());
        } finally {
            if(null != output) {
                try {
                    output.flush();
                    output.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                	Log.w("", e.getMessage().toString());
                }
            }
        }
        return file.getAbsolutePath();
	}
	/**
	 * 删除文件、文件夹
	 * @param file
	 */
	public static void deleteFile(File file) {
		if(null == file) return ;
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        }
    }
	
	/**
	 * 删除指定路径下所有文件、文件夹
	 * @param path 指定路径
	 */
	public static void deleteDir(String path) {
		if(null == path || path.isEmpty()) return ;
		File dir = new File(path);
		if (dir == null || !dir.exists() || !dir.isDirectory())
			return;
		for (File file : dir.listFiles()) {
			if (file.isFile())
				file.delete(); // 删除所有文件
			else if (file.isDirectory())
				deleteDir(file.getAbsolutePath()); // 递规的方式删除文件夹
		}
		dir.delete();// 删除目录本身
	}
	
	/**
	 *  计算文件、文件夹大小
	 * @param f
	 * @return
	 */
	public static long getFileSize(File f) {
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getFileSize(flist[i]);
			} else {
				size = size + flist[i].length();
			}
		}
		return size;
	}
	
	/**
	 * 计算图片的缩放值
	 * 
	 * @param options
	 * @param reqWidth
	 * @param reqHeight
	 * @return
	 */
	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			// Calculate ratios of height and width to requested height and
			// width
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			// Choose the smallest ratio as inSampleSize value, this will
			// guarantee
			// a final image with both dimensions larger than or equal to the
			// requested height and width.
			inSampleSize = heightRatio > widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;
	}
	
	/**
	 * 根据路径获得突破并压缩返回bitmap用于显示
	 * @param filePath 文件名称
	 * @param reqWidth 压缩宽度
	 * @param reqHeight 压缩高度
	 * @return
	 */
	public static Bitmap getSmallBitmap(String filePath, int reqWidth, int reqHeight) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;

		return BitmapFactory.decodeFile(filePath, options);
	}
	
	public static String getMediaImagePath(Context context, Uri uri) {
		String[] proj = { MediaStore.Images.Media.DATA };
		CursorLoader cursorLoader = new CursorLoader(context, uri, proj, null, null, null);
		Cursor actualimagecursor = cursorLoader.loadInBackground();
		int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		actualimagecursor.moveToFirst();
		String path = actualimagecursor.getString(actual_image_column_index);
		actualimagecursor.close();
		return path;
	}
	
	/**
	 * 机型底层相机定制，导致图片反转
	 * @param photoViewBitmap
	 * @return
	 */
	public static Bitmap getExifBitmap(Bitmap photoViewBitmap, int angle) {
		BaseUtils.logh("", "getExifBitmap angle: " + angle + " photoViewBitmap: " + photoViewBitmap.getWidth() + " x " + photoViewBitmap.getHeight());
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
//		if(angle == 90 || angle == 270) {
//			return Bitmap.createBitmap(photoViewBitmap,
//					0, 0, photoViewBitmap.getHeight(), photoViewBitmap.getWidth(), matrix, true);
//		}
		return Bitmap.createBitmap(photoViewBitmap,
				0, 0, photoViewBitmap.getWidth(), photoViewBitmap.getHeight(), matrix, true);

	}
	public static int getExifOrientation(String filepath) {
        int degree = 0;
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(filepath);
        } catch (IOException ex) {
            Log.e("test", "cannot read exif", ex);
        }
        if (exif != null) {
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, -1);
            if (orientation != -1) {
                switch (orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        degree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        degree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        degree = 270;
                        break;
                }
            }
        }
        return degree;
    }
	
}
