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
		//ʹȫ����ʾ
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.welcome);
		new Handler(new Handler.Callback() {
			// ������ܵ�����Ϣ�ķ���
			@Override
			public boolean handleMessage(Message arg0) {
				// ʵ��ҳ����ת
				startActivity(new Intent(getApplicationContext(), Start.class));
				return false;
			}
		}).sendEmptyMessageDelayed(0, 2000);// ��ʾ��ʱ3����������ִ��
	}
	
}
