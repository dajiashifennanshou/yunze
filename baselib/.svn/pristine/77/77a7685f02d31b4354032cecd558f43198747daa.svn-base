package cn.gl.lib.utils;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;

/**
 * 用于判断Activity或Application的各种状态。
 * @author Muyangmin
 * @create 2014-11-20
 */
public final class ActivityUtils {
	
	private static final String LOG_TAG = "ActivityUtils"; 
	
	private static final int MAXNUM_PACKAGE_LIST = 10;
	
	/**
	 * 判断当前应用是否在运行中。使用 {@link RunningTaskInfo}进行判断。
	 */
//	public static boolean isAppRunning(Context context){
//		boolean isAppRunning = false;
//		List<RunningTaskInfo> runningTasks = getRunningTasks(context);
//		for (RunningTaskInfo info : runningTasks) {
//			if (info.topActivity.getPackageName().equals(context.getPackageName())) {
//				isAppRunning = true;
//				break;
//			}
//		}
//		Utils.logh(LOG_TAG, "isAppRunning:"+isAppRunning);
//		return isAppRunning;
//	}
	
	public static boolean isSingleTaskAtivityRunning(Context context, Class<? extends Activity> ac) {
		List<RunningTaskInfo> runningTasks = getRunningTasks(context);
		for(RunningTaskInfo info : runningTasks) {
			BaseUtils.logh(LOG_TAG, "isSingleTaskAtivityRunning ==========="
					+ "\n topActivity = " + info.topActivity.getClassName()
					+ "\n baseActivity = " + info.baseActivity.getClassName()
					+ "\n ac name=" + ac.getName());
			if(info.baseActivity.getClassName().equals(ac.getName())) {
				return true;
			}
		}
		BaseUtils.logh(LOG_TAG, "isSingleTaskAtivityRunning false !!!");
		return false;
	}
	
	/**
	 * 判断指定的Activity是否正在前台运行，即正在与用户交互的Activity。
	 * @param context 上下文信息
	 * @param ac 要判断的Activity类
	 * @return 
	 */
	public static boolean isActivityFront(Context context, Class<? extends Activity> ac){
		boolean isActivityFront = false;
		List<RunningTaskInfo> runningTasks = getRunningTasks(context);
		for (RunningTaskInfo info : runningTasks) {
			BaseUtils.logh(LOG_TAG, "topActivity.name="+info.topActivity.getClassName()
					+"\n param name="+ac.getName());
			if (info.topActivity.getClassName().equals(ac.getName())) {
				isActivityFront = true;
				break;
			}
		}
		BaseUtils.logh(LOG_TAG, "isActivityFront: Activity "+ac.getName()+", "+isActivityFront);
		return isActivityFront;
	}
	
	public static String getFrontActivityClassName(Context context){
		List<RunningTaskInfo> runningTasks = getRunningTasks(context);
		for (RunningTaskInfo info : runningTasks) {
			BaseUtils.logh(LOG_TAG, "topActivity.name="+info.topActivity.getClassName());
			if ( info.topActivity.getPackageName()
					.equals(context.getPackageName()) ) {
				return info.topActivity.getClassName();
			}
		}
		return null;
	}
	
	//获得正在运行的Task列表。
	private static final List<RunningTaskInfo> getRunningTasks(Context context){
		ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> list = am.getRunningTasks(MAXNUM_PACKAGE_LIST);
		return list;
	}
	
}
