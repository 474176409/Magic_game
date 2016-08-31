package com.upc.mofang;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使全屏显示
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.welcome);
		new Handler(new Handler.Callback() {
			// 处理接受到的消息的方法
			@Override
			public boolean handleMessage(Message arg0) {
				// 实现页面跳转
				startActivity(new Intent(getApplicationContext(), Start.class));
				return false;
			}
		}).sendEmptyMessageDelayed(0, 2000);// 表示延时3秒进行任务的执行
	}
	
}
