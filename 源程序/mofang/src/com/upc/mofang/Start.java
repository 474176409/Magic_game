package com.upc.mofang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Start extends Activity {
	private ImageButton chuangguan;
	private ImageButton quwei;
	private ImageButton bangzhu;
	private ImageButton tuichu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//  π»´∆¡œ‘ æ
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.start);
		chuangguan =(ImageButton) findViewById(R.id.chuangguan_imageButton);
		chuangguan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(Start.this,GameView.class));
			}
		});
		quwei=(ImageButton) findViewById(R.id.quwei_imageButton);
		quwei.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(Start.this,GameView2.class));	
			}
		});
		tuichu=(ImageButton) findViewById(R.id.tuichu_imageButton);
		tuichu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Start.this.finish();
			}
		});
		bangzhu=(ImageButton) findViewById(R.id.bangzhu_imageButton);
		bangzhu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Start.this,Help.class));
			}
		});
}
}
