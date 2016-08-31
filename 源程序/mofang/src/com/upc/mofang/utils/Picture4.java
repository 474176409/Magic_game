package com.upc.mofang.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.upc.mofang.R;

public class Picture4 extends FrameLayout {
	//每张图片的标签
	private int num;
	
	private View background = null;
	private TextView textview=null;

	// -------------构造函数------------//
	public Picture4(Context context) {
		super(context);
		LayoutParams lp = null;

		background = new View(getContext());
		// background.setBackgroundColor(0x33ffffff);
		background.setBackgroundColor(Color.BLACK);
		// -1代表LayoutParams.MATCH_PARENT，即该布局的尺寸将填满它的父控件；
		lp = new LayoutParams(-1, -1);
		lp.setMargins(1, 1, 0, 0);
		addView(background, lp);
		
		textview =new TextView(getContext());
		textview.setTextSize(35);
		textview.setGravity(Gravity.CENTER);
		addView(textview,lp);
	}
	//获取图片的标签
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		textview.setText(num+"");
		textview.setBackgroundResource(R.drawable.bule);
	}
}
