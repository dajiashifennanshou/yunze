package cn.gl.lib.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

public class SafeAnimator {
	private Context context;
	
	public SafeAnimator(Context context) {
		this.context = context;
	}
	
	/**
	 * 目标View不可见（但仍存在）动画设置
	 * @param target
	 * @param animationId
	 */
	public void startInvisibleAnimator(final View target, int animationId) {
		startInvisibleAnimator(target, animationId, null);
	}
	
	public void startInvisibleAnimator(final View target, int animationId, final onAnimationEndListener listener) {
		Animation anim = AnimationUtils.loadAnimation(context, animationId);
		anim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				BaseUtils.setVisible(target);
			}
		
			@Override
			public void onAnimationEnd(Animation animation) {
				BaseUtils.setInvisible(target);
				if(null != listener) {
					listener.onAnimationEnd();
				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}
		});
		target.startAnimation(anim);
	}
	
	/**
	 * 目标View显示动画设置
	 * @param target
	 * @param animationId
	 */
	public void startVisibleAnimator(final View target, int animationId) {
		startVisibleAnimator(target, animationId, null);
	}
	
	public void startVisibleAnimator(final View target, int animationId, final onAnimationEndListener listener) {
		Animation anim = AnimationUtils.loadAnimation(context, animationId);
		anim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				BaseUtils.setVisible(target);
			}
		
			@Override
			public void onAnimationEnd(Animation animation) {
				if(null != listener) {
					listener.onAnimationEnd();
				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) { }
		});
		target.startAnimation(anim);
	}
	
	/**
	 * 目标View消失动画设置
	 * @param target
	 * @param animationId
	 */
	public void startGoneAnimator(final View target, int animationId) {
		startGoneAnimator(target, animationId, null);
	}
	
	public void startGoneAnimator(final View target, int animationId, final onAnimationEndListener listener) {
		Animation anim = AnimationUtils.loadAnimation(context, animationId);
		anim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				BaseUtils.setVisible(target);
			}
		
			@Override
			public void onAnimationEnd(Animation animation) {
				BaseUtils.setGone(target);
				if(null != listener) {
					listener.onAnimationEnd();
				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}
		});
		target.startAnimation(anim);
	}
	
	/**
	 * 动画结束监听
	 * 如果需要，可设置方法进行结束后的回调处理
	 * @author 花佟林雨月
	 *
	 */
	public interface onAnimationEndListener {
		public abstract void onAnimationEnd();
	}
}
