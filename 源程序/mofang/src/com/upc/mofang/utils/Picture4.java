package com.upc.mofang.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.upc.mofang.R;

public class Picture4 extends FrameLayout {
	//ÿ��ͼƬ�ı�ǩ
	private int num;
	
	private View background = null;
	private TextView textview=null;

	// -------------���캯��------------//
	public Picture4(Context context) {
		super(context);
		LayoutParams lp = null;

		background = new View(getContext());
		// background.setBackgroundColor(0x33ffffff);
		background.setBackgroundColor(Color.BLACK);
		// -1����LayoutParams.MATCH_PARENT�����ò��ֵĳߴ罫�������ĸ��ؼ���
		lp = new LayoutParams(-1, -1);
		lp.setMargins(1, 1, 0, 0);
		addView(background, lp);
		
		textview =new TextView(getContext());
		textview.setTextSize(35);
		textview.setGravity(Gravity.CENTER);
		addView(textview,lp);
	}
	//��ȡͼƬ�ı�ǩ
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		textview.setText(num+"");
		textview.setBackgroundResource(R.drawable.bule);
	}
}
