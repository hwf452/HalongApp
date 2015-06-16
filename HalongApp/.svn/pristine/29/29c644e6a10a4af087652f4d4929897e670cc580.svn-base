package com.halong.halongapp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.halong.halongapp.R;
import com.halong.halongapp.adapter.ActionAdapter;
import com.halong.halongapp.adapter.AdPagerAdapter;
import com.halong.halongapp.util.MyActivity;

public class MainActivity extends MyActivity implements OnClickListener,
		OnPageChangeListener {

	/**
	 * 广告viewpaper集合
	 */
	private List<View> mAdViewList;
	/**
	 * 存储广告图片的R.drawable.XXX的List
	 */
	private List<Integer> mImageViewIntegerList;
	/**
	 * viewpaper下的小点
	 */
	private int[] mPointIntegerArray = { R.drawable.picture006,
			R.drawable.picture007 };
	/**
	 * viewpager的当前pager
	 */
	private int mCurrentPager;
	/**
	 * 确定退出
	 */
	private static Boolean isExit = false;

	private ViewPager mViewPager;
	private LinearLayout mPointLinearLayout;
	private GridView mGridView;

	private FrameLayout mTopFrameLayout, mBodyFrameLayout;
	private TextView mFootHaLongTextView;
	
	private Button mBackButton;
	private float mAnimWidth, mAnimHeight;
	private float mPlaneBig;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initId();
		initData1();
		bindData();
		myStartAnimation();
	}

	/**
	 * 重写父类方法，加载动画效果
	 */
	@Override
	public void myStartAnimation() {
		mTopFrameLayout = (FrameLayout) findViewById(R.id.topFrameLayout);
		mBodyFrameLayout = (FrameLayout) findViewById(R.id.bodyFrameLayout);
		mFootHaLongTextView = (TextView) findViewById(R.id.footHaLongTextView);
		// 头部动画
		Animation animation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(500);
		mTopFrameLayout.startAnimation(animation);
		// viewpaper动画
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(500);
		mBodyFrameLayout.startAnimation(animation);
		// 低textview
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(800);
		mFootHaLongTextView.startAnimation(animation);

	}

	/**
	 * 初始化viewpaper数据
	 */
	private void initData1() {
		// TODO Auto-generated method stub
		mImageViewIntegerList = new ArrayList<Integer>();
		mAdViewList = new ArrayList<View>();
		mViewPager = (ViewPager) findViewById(R.id.adViewPager);

		mCurrentPager = 0;

		mImageViewIntegerList.add(R.drawable.picture003);
		mImageViewIntegerList.add(R.drawable.picture004);
		mImageViewIntegerList.add(R.drawable.picture005);
		// mAdViewList绑定view数据
		for (int i = 0; i < mImageViewIntegerList.size(); i++) {
			ImageView imageView = new ImageView(getApplicationContext());
			imageView.setScaleType(ScaleType.FIT_XY);
			imageView.setClickable(true);
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
					mImageViewIntegerList.get(i));
			int width = ((Activity) MainActivity.this).getWindowManager()
					.getDefaultDisplay().getWidth();
			bitmap = getBitmap(bitmap, width);
			imageView.setImageBitmap(bitmap);
			mAdViewList.add(imageView);
		}

		intiPoint();
	}

	/**
	 * 初始化viewpaper标记
	 */
	private void intiPoint() {
		// TODO Auto-generated method stub
		for (int i = 0; i < mAdViewList.size(); i++) {
			ImageView imageView = new ImageView(this);
			imageView.setId(0);
			if (mCurrentPager == i) {
				imageView.setBackgroundResource(mPointIntegerArray[0]);
				imageView.setClickable(false);
			} else {
				imageView.setBackgroundResource(mPointIntegerArray[1]);
				imageView.setClickable(true);
			}
			imageView.setOnClickListener(this);
			imageView.setTag(i);
			// 根据图片数量加载point
			mPointLinearLayout.addView(imageView);
		}
	}

	Bitmap getBitmap(Bitmap bitmap, int width) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		System.out.println("w--->" + w + " h--->" + h);
		Matrix matrix = new Matrix();
		float scale = (float) width / w;
		// 保证图片不变形.
		matrix.postScale(scale, scale);
		// w,h是原图的属性.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}

	/**
	 * mViewPager和mGridView数据和监听的绑定
	 */
	private void bindData() {
		// TODO Auto-generated method stub
		mViewPager.setAdapter(new AdPagerAdapter(mAdViewList));
		mViewPager.setOnPageChangeListener(this);

		mGridView.setAdapter(new ActionAdapter(this));
		mGridView.setLayoutAnimation(getLayoutAnimationController());
		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					planeDown(CompanyInfoActivity.class);
					break;
				case 1:
					planeDown(NewsListActivity.class);
					break;
				case 2:
					planeDown(CompanyManagerActivity.class);
					break;
				case 3:
					planeDown(PartnerActivity.class);
					break;
				case 4:
					planeDown(ProductSlidingFragmentActivity.class);
					break;
				case 5:
					planeDown(DevelopFragmentActivity.class);
					break;
				case 6:
					planeDown(InviteFragmentActivity.class);
					break;
				case 7:
					planeDown(ContactActivity.class);
					break;
				case 8:
					planeDown(MoreActivity.class);
					break;
				default:
					break;
				}
			}
		});
	}
	
	/**
	 * 触发小飞机向下滑，完成跳转动作
	 * @param clazz
	 */
	private void planeDown(final Class<?> clazz){
		mBackButton = (Button) findViewById(R.id.backButton);
		Display display = getWindowManager().getDefaultDisplay();
		mAnimWidth = display.getWidth();
		mAnimHeight = display.getHeight();
		mAnimHeight -= getStatusBarHeight(this);
		mPlaneBig = getResources().getDimension(R.dimen.plane_big);
		mAnimWidth -= mPlaneBig;
		mAnimHeight -= mPlaneBig;
		
		mBackButton.setBackgroundResource(R.drawable.animation4_3_2);
		
		AnimationSet setAnimation = new AnimationSet(true);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.plane_rotate);
		animation.setStartOffset(700);
		setAnimation.addAnimation(animation);
		
		animation = new TranslateAnimation(0, mAnimWidth , 0,
				mAnimHeight );
		animation.setDuration(1000);
		
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				mBackButton.setBackgroundResource(R.drawable.picture002);
				toOrderActivity(getApplication(), clazz);
			}
		});
		
		setAnimation.addAnimation(animation);
		
		mBackButton.startAnimation(setAnimation);
	}

	/**
	 * 获取动画LayoutAnimationController
	 * 
	 * @return
	 */
	private LayoutAnimationController getLayoutAnimationController() {
		AnimationSet set = new AnimationSet(true);
		Animation animation;
		animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(300);
		set.addAnimation(animation);
		// Animation.RELATIVE_TO_SELF相对于自身，-1.0f自身百分比
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(300);
		set.addAnimation(animation);
		LayoutAnimationController controller = new LayoutAnimationController(
				set, 0.5f);
		return controller;
	}

	private void initId() {
		// TODO Auto-generated method stub
		mPointLinearLayout = (LinearLayout) findViewById(R.id.pointLinearLayout);
		mGridView = (GridView) findViewById(R.id.mainGridView);
	}

	/**
	 * 菜单、返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (!isExit) {
				exitBy2Click(); // 调用双击退出函数
			} else {
				return super.onKeyDown(keyCode, event);
			}
		}
		return false;
	}

	@Override
	public void backButton(View view) {
		// TODO Auto-generated method stub
		if (!isExit) {
			exitBy2Click(); // 调用双击退出函数
		} else {
			super.backButton(view);
		}

	}

	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // 准备退出
			Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

		}
	}

	/**
	 * 当新的页面Page被选中时调用
	 */
	@Override
	public void onPageSelected(int position) {
		if (position != mCurrentPager) {
			setCurrentPoint(position);
		}
	}

	/**
	 * 设置当前页的标记
	 * 
	 * @param position
	 *            移动到的位置
	 */
	private void setCurrentPoint(int position) {
		ImageView imageView = (ImageView) mPointLinearLayout
				.getChildAt(position);
		imageView.setBackgroundResource(mPointIntegerArray[0]);
		imageView.setClickable(false);

		ImageView imageView1 = (ImageView) mPointLinearLayout
				.getChildAt(mCurrentPager);
		imageView1.setBackgroundResource(mPointIntegerArray[1]);
		imageView1.setClickable(true);

		mCurrentPager = position;
		mViewPager.setCurrentItem(position);
	}

	/**
	 * pager状态改变
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.v("lihua", v.getId() + "");
		Log.v("lihua", v.toString());
		switch (v.getId()) {
		case 0:
			// 0是point的标记ID
			setCurrentPoint((Integer) v.getTag());
			break;
		default:
			break;
		}
	}

	
}
