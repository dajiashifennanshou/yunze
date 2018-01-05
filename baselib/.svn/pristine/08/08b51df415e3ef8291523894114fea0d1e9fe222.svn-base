package cn.gl.lib.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.protocol.HTTP;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BaseUtils {
	
	public void LogH(boolean log) {
		LOG_H = log;
	}
	
	public void LogN(boolean log) {
		LOG_N = log;
	}
	
	/**
	 * Log wrapper
	 */
	public static boolean LOG_N = true;
	public static boolean LOG_H = false;
	public static void logn(String tag, String msg) {
		if(LOG_N) Log.d(tag, msg);
	}
	public static void logh(String tag, String msg) {
		if(LOG_H) Log.d(tag, msg);
	}
	public static void logw(String tag, String msg) {
		Log.w(tag, msg);
	}
	
	/**
	 * Refresh view status
	 */
	public static void setVisibleGone(View view, View...views) {
		if(null != view && view.getVisibility() != View.VISIBLE)
			view.setVisibility(View.VISIBLE);
		setGone(views);
	}
	public static void setGone(View... views) {
		if(views != null && views.length > 0) {
			for(View view : views) {
				if(null != view && view.getVisibility() != View.GONE)
					view.setVisibility(View.GONE);
			}
		}
	}
	public static void setVisible(View... views) {
		if(views != null && views.length > 0) {
			for(View view : views) {
				if(null != view && view.getVisibility() != View.VISIBLE)
					view.setVisibility(View.VISIBLE);
			}
		}
	}
	public static void setEnable(View... views) {
		if(views != null && views.length > 0) {
			for(View view : views) {
				if(view != null && !view.isEnabled()) {
					view.setEnabled(true);
				}
			}
		}	
	}
	public static void setDisable(View... views) {
		if(views != null && views.length > 0) {
			for(View view : views) {
				if(view != null && view.isEnabled()) {
					view.setEnabled(false);
				}
			}
		}			
	}
	public static void setInvisible(View... views) {
		if(views != null && views.length > 0) {
			for(View view : views) {
				if(null != view && view.getVisibility() != View.INVISIBLE)
					view.setVisibility(View.INVISIBLE);
			}
		}	
	}

	/**
	 * Get widget text string
	 */
	public static String getEditTextString(EditText et) {
		final Editable text = et.getText();
		if(null == text || text.toString().trim().length() == 0) {
			return null;
		}
		return text.toString().trim();
	}
	public static String getTextViewString(TextView tv) {
		final String text = tv.getText().toString().trim();
		if(0 == text.length()) {
			return null;
		}
		return text;
	}
	
	/**
	 * 判别手机是否为正确手机号码；
	 * 电信中国电信手机号码开头数字
	 * 		133、153、180、181、189、177
	 * 联通中国联通手机号码开头数字
	 * 		130、131、132、145、155、156、185、186
	 * 移动中国移动手机号码开头数字
	 * 		134、135、136、137、138、139、147、
	 * 		150、151、152、157、158、159、182、183、184、187、188
	 */
	public static boolean isMobileNum(String phone) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[0,1,2,3,5,6,7,8,9])|(18[0-9]|14[57]))\\d{8}$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	/**
	 * 密码只能为6~20位的字母，数字，下划线
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		Pattern p = Pattern.compile("^\\w{5,19}$");
		Matcher m = p.matcher(password);
		return m.matches();	
	}
	
	/**
	 * 输入内容不能包含特殊字符： ^%&',;=?$\"
	 * @param content
	 * @return
	 */
	public static boolean containSpecialChar(String content) {
		Pattern p = Pattern.compile("[^%&',;=?$\\x22]+");
		Matcher m = p.matcher(content);
		return m.matches();	
	}
	
	public static String transferIs2String(InputStream is) {
		String str = null;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		try {
			while ((len = is.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			str = new String(outStream.toByteArray(), HTTP.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}