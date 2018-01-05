package cn.gl.lib.utils;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.animation.LinearInterpolator;
import android.widget.RatingBar;

/**
 * 星级动画显示
 * @author 花佟林雨月
 *
 */
public class RateAnimUtils {
	protected static final String TAG = RateAnimUtils.class.getSimpleName();

	/**
	 * 星级渐进递增动画
	 * @param ratingBar {@link RatingBar}
	 * @param rating 最终显示的星级
	 * @param numStars 星级总数
	 * @see #startRateBarAnim(RatingBar, float, int, boolean, long)
	 */
	public void startRateBarAnim(RatingBar ratingBar, float rating, int numStars) {
		startRateBarAnim(ratingBar, rating, numStars, false, 1000);
	}

	/**
	 * 星级渐进动画
	 * @param ratingBar {@link RatingBar}
	 * @param rating 最终显示的星级
	 * @param numStars 星级总数
	 * @param decrease 是否递减，true：递减；false递增
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void startRateBarAnim(final RatingBar ratingBar, float rating, final int numStars, final boolean decrease, long duration) {
		if(VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ValueAnimator valueAnimator = new ValueAnimator();
			//设置 value 的变化范围
			if(decrease) {
				valueAnimator.setFloatValues((float)numStars, rating);	
			} else {
				valueAnimator.setFloatValues(0f, rating);
			}
			// 设置变化状态，线性变化
			valueAnimator.setInterpolator(new LinearInterpolator());
			// 监听值的变化，从而设置值
			valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					float value = (Float) animation.getAnimatedValue();
					int progress;
					if(decrease) {
						progress = (int) (value * 100 / numStars - 0.5f);
					} else {
						progress = (int) (value * 100  / numStars + 0.5f);
						//progress = (int) Math.floor(value * 100 / numStars + 0.5);
					}
					ratingBar.setProgress(progress);
					//BaseUtils.logh(TAG, "update ... value: " + value + " progress: " + progress);
				}

			});
			valueAnimator.setDuration(duration);
			valueAnimator.start();
		} else {
			ratingBar.setRating(rating);
		}
	}
}
