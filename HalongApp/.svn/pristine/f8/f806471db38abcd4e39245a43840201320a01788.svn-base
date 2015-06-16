package com.halong.halongapp.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

import com.halong.halongapp.R;
import com.halong.halongapp.adapter.ListViewNewsAdapter;
import com.halong.halongapp.util.MyActivity;

public class NewsListActivity extends MyActivity implements OnClickListener {

	private ListView mListView;
	private ImageView mTenImageView, mSignImageView;
	private Button mNewButton, mCultureButton, mBusinessButton,
			mKnowledgeButton, mAllnewsButton;

	private PopupWindow mPopupWindow;

	/**
	 * 十字旋转时间
	 */
	private int mTenTime = 450;

	/**
	 * 主要接受子线程发送的数据, 并用此数据配合主线程更新UI.
	 */
	private Handler mHandler;
	/**
	 * 动画线程
	 */
	private Runnable mAnimRunnable;

	/**
	 * 帧动画
	 */
	private AnimationDrawable mAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_list);
		mHandler = new Handler();
		initId();
		initData();
		initAnim();
		initListener();
		myStartAnimation();
	}

	/**
	 * 绑定监听
	 */
	private void initListener() {
		// TODO Auto-generated method stub

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				toOrderActivity(getApplication(), NewsInfoActivity.class);
			}
		});

		mListView.setLayoutAnimation(getListAnim());

		mTenImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				myStartTen();
				if (mPopupWindow != null && mPopupWindow.isShowing()) {
					mPopupWindow.dismiss();
				} else {
					showPopupWindow();
				}
			}
		});
	}

	/**
	 * 获取动画LayoutAnimationController
	 * 
	 * @return
	 */
	private LayoutAnimationController getListAnim() {
		AnimationSet set = new AnimationSet(true);
		Animation animation;
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

	/**
	 * 显示PopupWindow，添加按钮监听
	 */
	private void showPopupWindow() {
		mSignImageView.setVisibility(View.VISIBLE);

		View view = getLayoutInflater()
				.inflate(R.layout.popupwindow_news, null);

		mNewButton = (Button) view.findViewById(R.id.newButton);
		mCultureButton = (Button) view.findViewById(R.id.cultureButton);
		mBusinessButton = (Button) view.findViewById(R.id.businessButton);
		mKnowledgeButton = (Button) view.findViewById(R.id.knowledgeButton);
		mAllnewsButton = (Button) view.findViewById(R.id.allnewsButton);

		mNewButton.setOnClickListener(this);
		mCultureButton.setOnClickListener(this);
		mBusinessButton.setOnClickListener(this);
		mKnowledgeButton.setOnClickListener(this);
		mAllnewsButton.setOnClickListener(this);

		mPopupWindow = new PopupWindow(view,
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.WRAP_CONTENT, true);

		// 设置可以获取焦点，否则弹出菜单中的EditText是无法获取输入的
		mPopupWindow.setFocusable(true);
		// popWindow.setAnimationStyle(R.style.popwin_anim_style);
		// 这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
		mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 防止虚拟软键盘被弹出菜单遮住
		mPopupWindow
				.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

		//mPopupWindow.setAnimationStyle(R.style.PopupwindowAnimStyle);

		// 在底部显示
		// popWindow.showAtLocation(view1,Gravity.CENTER_HORIZONTAL, 30, 30);
		// popWindow.showAsDropDown(mActive);
		// 计算x轴方向的偏移量，使得PopupWindow在Title的正下方显示，此处的单位是pixels
		int devWidth = this.getWindow().getWindowManager().getDefaultDisplay()
				.getWidth() / 2;
		int popupWid = Dp2Px(this, 120) / 2;
		int result = -(devWidth - popupWid);
		mPopupWindow.showAsDropDown(mSignImageView);
		mPopupWindow.update();

		mPopupWindow.setOnDismissListener(new OnDismissListener() {

			@Override
			public void onDismiss() {
				// TODO Auto-generated method stub
				myStartTen();
			}
		});
	}

	public int Dp2Px(Context context, double dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	private void initData() {
		// TODO Auto-generated method stub
		mListView.setAdapter(new ListViewNewsAdapter(this));
	}

	/**
	 * 十字图片初始化且旋转
	 */
	private void myStartTen() {
		mAnimation = (AnimationDrawable) mTenImageView.getBackground();
		mAnimation.start();
		mHandler.postDelayed(mAnimRunnable, mTenTime);
	}

	/**
	 * 初始化动画线程
	 */
	private void initAnim() {
		mAnimRunnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mAnimation.stop();
				mTenImageView.setBackgroundResource(R.anim.anim_ten);
			}
		};
	}

	/**
	 * 获取控件
	 */
	private void initId() {
		// TODO Auto-generated method stub
		mListView = (ListView) findViewById(R.id.newsListView);
		mTenImageView = (ImageView) findViewById(R.id.topTenImageView);
		mSignImageView = (ImageView) findViewById(R.id.signImageView);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.newButton:
			mListView.setAdapter(new ListViewNewsAdapter(this));
			mPopupWindow.dismiss();
			break;
		case R.id.cultureButton:
			mListView.setAdapter(new ListViewNewsAdapter(this));
			mPopupWindow.dismiss();
			break;
		case R.id.businessButton:
			mListView.setAdapter(new ListViewNewsAdapter(this));
			mPopupWindow.dismiss();
			break;
		case R.id.knowledgeButton:
			mListView.setAdapter(new ListViewNewsAdapter(this));
			mPopupWindow.dismiss();
			break;
		case R.id.allnewsButton:
			mListView.setAdapter(new ListViewNewsAdapter(this));
			mPopupWindow.dismiss();
			break;
		default:
			break;
		}
	}
}
