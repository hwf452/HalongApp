package com.halong.halongapp.thread;

import com.halong.halongapp.R;
import com.halong.halongapp.ui.NewsInfoActivity;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 生成该类的对象，并调用execute方法之后 首先执行的是onProExecute方法 其次执行doInBackgroup方法
 * 
 */
public class PlaneAsyncTask extends AsyncTask<Integer, Integer, String> {

	public static final int UP = 0;
	public static final int DOWN = 1;
	
	private TextView textView;
	private Button mButton;
	private Activity mContent;
	private int[] mDownPlaneArray = new int[]{R.drawable.animation4_1,R.drawable.animation4_2,R.drawable.animation4_3,R.drawable.animation4_4,R.drawable.animation4_5};
	private int mCurrent=0;

	public PlaneAsyncTask(TextView textView, Button button,Activity content) {
		super();
		this.textView = textView;
		this.mButton = button;
		this.mContent =content;
	}

	/**
	 * 这里的Integer参数对应AsyncTask中的第一个参数 这里的String返回值对应AsyncTask的第三个参数
	 * 该方法并不运行在UI线程当中，主要用于异步操作，所有在该方法中不能对UI当中的空间进行设置和修改
	 * 但是可以调用publishProgress方法触发onProgressUpdate对UI进行操作
	 */
	@Override
	protected String doInBackground(Integer... params) {
		
		for (int i = 0; i <= mDownPlaneArray.length; i ++) {
			publishProgress(i);
		}
		return mCurrent+"";
	}

	/**
	 * 这里的String参数对应AsyncTask中的第三个参数（也就是接收doInBackground的返回值）
	 * 在doInBackground方法执行结束之后在运行，并且运行在UI线程当中 可以对UI空间进行设置
	 */
	@Override
	protected void onPostExecute(String result) {
		textView.setText("异步操作执行结束" + result);
		//Intent intent = new Intent(mContent,MainActivity2.class);
		//mContent.startActivity(intent);
	}

	// 该方法运行在UI线程当中,并且运行在UI线程当中 可以对UI空间进行设置
	@Override
	protected void onPreExecute() {
		textView.setText("开始执行异步线程");
	}

	/**
	 * 这里的Intege参数对应AsyncTask中的第二个参数
	 * 在doInBackground方法当中，，每次调用publishProgress方法都会触发onProgressUpdate执行
	 * onProgressUpdate是在UI线程中执行，所有可以对UI空间进行操作
	 */
	@Override
	protected void onProgressUpdate(Integer... values) {
		int vlaue = values[0];
		
		mButton.setBackgroundResource(mDownPlaneArray[mCurrent]);
	}
}
